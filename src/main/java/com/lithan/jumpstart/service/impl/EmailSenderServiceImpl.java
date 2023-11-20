package com.lithan.jumpstart.service.impl;

import com.lithan.jumpstart.constraint.ERole;
import com.lithan.jumpstart.entity.User;
import com.lithan.jumpstart.exception.RefusedActionException;
import com.lithan.jumpstart.payload.request.SendMailRequest;
import com.lithan.jumpstart.repository.UserRepository;
import com.lithan.jumpstart.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EmailSenderServiceImpl implements EmailSenderService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private UserRepository userRepository;

    @Override
    @Async
    public void sendMail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("jumpstartecommerce.lithan@gmail.com");
        message.setTo(to);
        message.setSubject(subject + " | Jumpstart E-commerce");
        message.setText(text);

        javaMailSender.send(message);
    }

    @Override
    @Async
    public void sendMailToUsers(SendMailRequest sendMailRequest, String username) {
        String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        boolean isAdmin = userRepository.existsByEmailAndRole(userEmail, ERole.ROLE_ADMIN);
        if (!isAdmin) {
            throw new RefusedActionException("Forbidden");
        }

        String[] userIds = sendMailRequest.getUserIds();
        List<Long> ids = new ArrayList<>();
        for (String id : userIds) {
            ids.add(Long.parseLong(id));
        }
        List<User> users = userRepository.findAllById(ids);

        for (User user : users) {
            sendMail(
                    user.getEmail(),
                    sendMailRequest.getSubject(),
                    sendMailRequest.getText()
            );
        }
    }
}
