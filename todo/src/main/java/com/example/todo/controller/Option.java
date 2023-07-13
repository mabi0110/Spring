package com.example.todo.controller;

public enum Option {
    ADD(1, "Dodaj nowe zadanie"),
    PRINT_SINGLE(2, "Wyświetl zadanie"),
    START_TASK(3, "Wystartuj zadanie"),
    END_TASK(4, "Zakończ zadanie"),
    EXIT(5, "Koniec programu");


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
