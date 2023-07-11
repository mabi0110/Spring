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

}
