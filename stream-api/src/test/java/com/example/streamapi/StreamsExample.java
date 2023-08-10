package com.example.streamapi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Watchable;
import java.util.ArrayList;
import java.util.List;

public class StreamsExample {
    List<Employee> employees = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        Employee employee1 = new Employee("Jan", "Nowak", 25, List.of("Java", "Python"));
        Employee employee2 = new Employee("Ala", "Nowak", 25, List.of("Java", "C++"));
        Employee employee3 = new Employee("Ela", "Nowak", 25, List.of("Java", "C#"));
        Employee employee4 = new Employee("Ula", "Nowak", 25, List.of("Java"));
        Employee employee5 = new Employee("Piotr", "Nowak", 25, List.of("Java", "Golang"));
        Employee employee6 = new Employee("Adam", "Nowak", 25, List.of("Java", "Rust"));
        Employee employee7 = new Employee("Ewa", "Nowak", 25, List.of("Java", "Scala"));
        Employee employee8 = new Employee("Ola", "Nowak", 25, List.of("Java", "Kotlin"));

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);
        employees.add(employee6);
        employees.add(employee7);
        employees.add(employee8);

    }

    @Test
    public void firstStream(){
        employees.stream().forEach(employee -> System.out.println(employee));
    }
}
