package com.example.email.controller;

import com.example.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
@RequestMapping("email")
public class EmailController {
    @Autowired
    private EmailService emailService;
    @GetMapping("/send")
    public void sendMail(){
        String result = emailService.sendEmail();
        System.out.println(result);
    }
    @GetMapping("/sendWithAttach")
    public void sendWithAttach() throws MessagingException {
        String result = emailService.sendEmailWithAttach();
        System.out.println(result);
    }
}
