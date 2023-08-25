package com.example.walidajcawbudowaneograniczenia;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;
import java.util.Set;

@SpringBootApplication
public class ValidationApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(ValidationApplication.class, args);
        Validator validator = context.getBean(Validator.class);
        Person person = new Person(
                "Jan",
                null,
                "87041277815",
                LocalDate.of(2023, 12, 12),
                "jan@email.com",
                "pass",
                "https://jannowak.pl"
        );

        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);
        if (!constraintViolations.isEmpty()){
            System.out.println("Dane osoby są niepoprawne");
            System.out.println("Złamano ograniczenia");
            constraintViolations.forEach(
                    err -> System.out.printf("> %s %s (%s)\n",
                            err.getPropertyPath(),
                            err.getMessage(),
                            err.getInvalidValue())
            );
        } else {
            System.out.println("Dane osoby są poprawne");
        }

    }

}
