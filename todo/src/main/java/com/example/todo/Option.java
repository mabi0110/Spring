package com.example.todo;

import java.util.Optional;

public enum Option {
    ADD(1, "Dodaj nowe zadanie"),
    PRINT_SINGLE(2, "Wyświetl zadanie"),
    EXIT(3, "Koniec programu");


    private final int number;
    private final String name;


    Option(int number, String name) {
        this.number = number;
        this.name = name;
    }

    static Option fromInt(int option){
        return values()[option - 1];
    }

    @Override
    public String toString() {
        return number + " - " + name;
    }
}
