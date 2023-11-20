package com.lithan.jumpstart.utils;

import com.lithan.jumpstart.constraint.ERole;
import com.lithan.jumpstart.entity.User;
import com.lithan.jumpstart.repository.CartRepository;
import com.lithan.jumpstart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class ServiceUtils {
    @Autowired
    protected UserRepository userRepository;

    protected boolean isAdmin(String email) {
        return userRepository.existsByEmailAndRole(email, ERole.ROLE_ADMIN);
    }

    protected User getCurrentUser() {
        String currentUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        userRepository.findByEmail(currentUserEmail);
        return userRepository.findByEmail(currentUserEmail).orElseThrow(() -> new UsernameNotFoundException("current user not found"));
    }
}
