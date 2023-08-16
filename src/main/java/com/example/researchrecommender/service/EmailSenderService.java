package com.example.researchrecommender.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;
import static com.example.researchrecommender.constants.Constants.DEFAULT_EMAIL;

@Service
@Slf4j
public class EmailSenderService {
    @Autowired JavaMailSender mailSender;

    public void sendEmail(String toEmail, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(DEFAULT_EMAIL);
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);

        log.info("Mail sent successfully to user {} .", toEmail);
    }
}
