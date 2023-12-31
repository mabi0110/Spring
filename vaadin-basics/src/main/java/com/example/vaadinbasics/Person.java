package com.example.vaadinbasics;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class Person {

    @NotEmpty
    private String name;

    @NotEmpty
    @Email
    private String email;

    // age is optional
    private int age;

    public Person(){}

    public Person(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return name + " - " + age + " - " + email;
    }
}
