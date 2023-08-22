package com.example.formularze;

import org.springframework.stereotype.Service;

public class CalculatorService {

    public static double calculate(double a, double b, String operator){
        return switch (operator){
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> throw new IllegalArgumentException("Nieobsługiwany operator matematyczny");
        };
    }



}
