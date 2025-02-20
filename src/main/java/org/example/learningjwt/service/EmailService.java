package org.example.learningjwt.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendVerificationEmail(String to, String token)  {
        String subject = "Verify Your Email";
        String verificationUrl = "http://localhost:8080/auth/verify?token=" + token;
        String body = "<p>Click the link below to verify your email:</p>"
                + "<a href=\"" + verificationUrl + "\">Verify Email</a>";

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(message, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body, true);

        } catch (MessagingException e) {
            throw new RuntimeException(e.getMessage());
        }
        mailSender.send(message);
    }
}
