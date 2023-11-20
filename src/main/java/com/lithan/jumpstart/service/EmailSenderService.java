package com.lithan.jumpstart.service;

import com.lithan.jumpstart.payload.request.SendMailRequest;


public interface EmailSenderService {
    void sendMail(String to, String subject, String body);
    void sendMailToUsers(SendMailRequest sendMailRequest, String username);
}

