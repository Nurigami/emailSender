package demo.email.sender.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private Environment environment;

    public void sendEmail(String subject, String messageText, String toEmail) {

        final SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject(subject);
        message.setText(messageText);
        message.setTo(toEmail);
        message.setFrom(environment.getProperty("spring.mail.username"));

        javaMailSender.send(message);
    }
}
