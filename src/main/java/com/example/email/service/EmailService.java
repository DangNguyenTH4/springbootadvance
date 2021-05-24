package com.example.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;
    public String sendEmail(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("thedangbka@gmail.com");
        message.setTo("thedangbka@gmaio.com", "nguyen.dang.tlu@gmail.com");
        message.setSubject("SendMail Spring Boot");
        message.setText("<h1>Hello spring boot mail here</h1>");
        javaMailSender.send(message);
        return "Success";
    }
    public String sendEmailWithAttach() throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true);
        mimeMessageHelper.setFrom("thedangbka@gmail.com");
        mimeMessageHelper.setTo("nguyen.dang.tlu@gmail.com");
        mimeMessageHelper.setSubject("SendMail Spring Boot");
        mimeMessageHelper.setText("<h1>Hello spring boot mail here</h1>");
        File file = new File("E:\\100DaysExercise\\21DayPost\\2019.PNG");
        mimeMessageHelper.addAttachment(file.getName(), file);
        javaMailSender.send(message);
        return "Success";
    }
}
