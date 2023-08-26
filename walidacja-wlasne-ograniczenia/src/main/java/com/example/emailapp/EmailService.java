package com.example.emailapp;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class EmailService {


    private Validator validator;

    public EmailService(Validator validator) {
        this.validator = validator;
    }

    public void sendMessage(EmailMessage email){
        System.out.println("Sending email...");
        Set<ConstraintViolation<EmailMessage>> violations = validator.validate(email);
        if(violations.isEmpty()){
            System.out.println("Email has been sent successfully");
        } else {
            violations.forEach(err -> System.out.printf("%s : %s",
                    err.getPropertyPath(),
                    err.getMessage())
            );
        }
    }
}
