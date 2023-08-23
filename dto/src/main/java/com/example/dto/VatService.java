package com.example.dto;

import org.springframework.stereotype.Service;

@Service
public class VatService {

    VatDto calculate(double netto, String category){
        double vat = calculateVat(netto, category);
        double brutto = netto + vat;
        return new VatDto(netto, vat, brutto);
    }


    private double calculateVat(double netto, String category){
        double vatRate = switch (category) {
            case "service" -> 0.23;
            case "food" -> 0.08;
            default -> 0.15;
        };
        return netto * vatRate;
    }
}
