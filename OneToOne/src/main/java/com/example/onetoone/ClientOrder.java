package com.example.onetoone;


import jakarta.persistence.*;
@Entity
class ClientOrder {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String product;
    private String details;
    private Double price;

    public ClientOrder() {
    }

    public ClientOrder(String product, String details, Double price) {
        this.product = product;
        this.details = details;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ClientOrder{" +
                "id=" + id +
                ", product='" + product + '\'' +
                ", details='" + details + '\'' +
                ", price=" + price +
                '}';
    }
}
