package com.example.emailapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class EmailApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(EmailApplication.class, args);
        EmailMessage emailMessage = new EmailMessage(
                "jan@example.com",
                "ala@example.com",
                "co tam u Ciebie słychać wariacie");
        EmailService emailService = context.getBean(EmailService.class);
        emailService.sendMessage(emailMessage);
    }

}
