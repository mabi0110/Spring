package com.example.bikerent;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Bike {

    @Id
    private Long id;
    private String model;
    private String numberNo;
    private double hourPrice;
    private double dayPrice;
    private String borrowerId;

    private LocalDateTime dateOfReturn;

    public Bike(){}

    public Bike(Long id, String model, String numberNo, double hourPrice, double dayPrice) {
        this.id = id;
        this.model = model;
        this.numberNo = numberNo;
        this.hourPrice = hourPrice;
        this.dayPrice = dayPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumberNo() {
        return numberNo;
    }

    public void setNumberNo(String numberNo) {
        this.numberNo = numberNo;
    }

    public double getHourPrice() {
        return hourPrice;
    }

    public void setHourPrice(double hourPrice) {
        this.hourPrice = hourPrice;
    }

    public double getDayPrice() {
        return dayPrice;
    }

    public void setDayPrice(double dayPrice) {
        this.dayPrice = dayPrice;
    }

    public String getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(String borrowerId) {
        this.borrowerId = borrowerId;
    }

    public LocalDateTime getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(LocalDateTime dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }

    @Override
    public String toString() {
        return "Bike{"
                + "id=" + id
                + ", model='" + model + '\''
                + ", numberNo='" + numberNo + '\''
                + ", hourPrice=" + hourPrice
                + ", dayPrice=" + dayPrice
                + ", borrowerId='" + borrowerId + '\''
                + ", dateOfReturn=" + dateOfReturn + '}';
    }
}
