package com.gordon.doc_repo.service.Impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.gordon.doc_repo.exception.ApiException;
import com.gordon.doc_repo.service.EmailService;
import com.gordon.doc_repo.utils.EmailUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmailServiceImpl implements EmailService {
    private static final String NEW_USER_ACCOUNT_VERIFICATION = "New User Account Verification";
    private static final String ACCOUNT_PASSWORD_RESET = "Password Reset Request";

    private final JavaMailSender sender;

    // Injected values from application properties or hardcoded values
    @Value("${spring.mail.verify.host:smtp.gmail.com}")
    private String host;

    @Value("${spring.mail.username:otienogordon95@gmail.com}")
    private String fromEmail;

    // Constructor with only JavaMailSender
    public EmailServiceImpl(JavaMailSender sender) {
        this.sender = sender;
    }

    @Override
    @Async
    public void sendNewAccountEmail(String name, String email, String token) {
        try {
            var message = new SimpleMailMessage();
            message.setSubject(NEW_USER_ACCOUNT_VERIFICATION);
           // message.setFrom(fromEmail);
            message.setTo(email);
            message.setText(EmailUtils.getEmailMessage(name, host, token));
            sender.send(message);

        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ApiException("Unable to send Mail");
        }
    }

    @Override
    @Async
    public void sendPasswordResetMail(String name, String email, String token) {
        try {
            var message = new SimpleMailMessage();
            message.setSubject(ACCOUNT_PASSWORD_RESET);
            message.setFrom(fromEmail);
            message.setTo(email);
            message.setText(EmailUtils.getResetPasswordMessage(name, host, token));
            sender.send(message);

        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ApiException("Unable to send Mail");
        }
    }
}
