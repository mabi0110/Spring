package com.example.bikerent;

public class BikeDto {
    private Long id;
    private String model;
    private String numberNo;
    private double hourPrice;
    private double dayPrice;

    public BikeDto(Long id, String model, String numberNo, double hourPrice, double dayPrice) {
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
}
