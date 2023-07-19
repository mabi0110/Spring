package com.example.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class CompanyApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(CompanyApplication.class, args);
        EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);
        Employee employee1 = new Employee("Jan", "Nowak", 3000.0);
        Employee employee2 = new Employee("Ela", "Nowak", 4500.0);
        employeeRepository.save(employee1);
        employeeRepository.save(employee2);
        new Scanner(System.in).nextLine();


    }

}
