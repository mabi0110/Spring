package com.example.dto;

import org.springframework.stereotype.Service;

@Service
public class VatService {

    double calculateBrutto(double netto, String category){
        return netto + calculateVat(netto, category);
    }


    double calculateVat(double netto, String category){
        double vatRate = switch (category) {
            case "service" -> 0.23;
            case "food" -> 0.08;
            default -> 0.15;
        };
        return netto * vatRate;
    }
}
