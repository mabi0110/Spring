package com.example.dynamicstyle;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Repository
public class EmployeeRepository {

    private final List<Employee> employees = List.of(
            new Employee(1L, "Jan", "Nowak", new BigDecimal("4500")),
            new Employee(2L, "Ala", "Nowak", new BigDecimal("5500")),
            new Employee(3L, "Ela", "Nowak", new BigDecimal("3500")),
            new Employee(4L, "Ola", "Nowak", new BigDecimal("2900")),
            new Employee(5L, "Ula", "Nowak", new BigDecimal("6500")),
            new Employee(6L, "Adam", "Nowak", new BigDecimal("7500"))
    );

    List<Employee> findAll(){
        return employees;
    }

    BigDecimal getAvgSalary(){
        BigDecimal salarySum = employees.stream()
                .map(Employee::getSalary)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return salarySum.divide(BigDecimal.valueOf(employees.size()), RoundingMode.CEILING);
    }
}
