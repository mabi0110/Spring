package com.example.bikerent;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Bike {

    @Id
    private Long id;
    private String model;
    private String numberNo;
    private double hourPrice;
    private double dayPrice;
    private String borrowerId;
    public Bike(){}

    public Bike(Long id, String model, String numberNo, double hourPrice, double dayPrice) {
        this.id = id;
        this.model = model;
        this.numberNo = numberNo;
        this.hourPrice = hourPrice;
        this.dayPrice = dayPrice;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", numberNo='" + numberNo + '\'' +
                ", hourPrice=" + hourPrice +
                ", dayPrice=" + dayPrice +
                ", borrowerId='" + borrowerId + '\'' +
                '}';
    }
}
