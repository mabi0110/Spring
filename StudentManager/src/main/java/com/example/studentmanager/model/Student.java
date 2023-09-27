package com.example.studentmanager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Name must be specified")
    private String name;

    @Min(value = 0, message = "Age can not be smaller than 0")
    @Max(value = 120, message = "Age can not be greater than 120")
    @NotNull(message = "Age must be specified")
    private int age;

    @Min(value = 0, message = "Zip code can not be smaller than 0")
    @Max(value = 99999, message = "Zip code can not be greater than 99999")
    @NotNull(message = "Zip code must be specified")
    @Digits(integer = 5, fraction = 0, message = "Zip code is a 5 digit number")
    private int zipCode;
    @NotEmpty(message = "Country must be specified")
    private String country;

    @ManyToOne
    @JoinColumn
    private Status status;

    public Student(){}

    public Student(String name, int age, int zipCode, String country, Status status) {
        this.name = name;
        this.age = age;
        this.zipCode = zipCode;
        this.country = country;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


}
