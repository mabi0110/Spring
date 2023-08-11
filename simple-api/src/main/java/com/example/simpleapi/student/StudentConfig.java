package com.example.simpleapi.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student jan = new Student("Jan", LocalDate.of(2000, 3, 1), "jan@example.com");
            Student ula = new Student("Ula", LocalDate.of(2001, 10, 12), "ula@example.com");
            studentRepository.saveAll(List.of(jan, ula));
        };
    }
}
