package com.example.simpleapi;

import com.example.simpleapi.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class SimpleApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleApiApplication.class, args);
    }




}
