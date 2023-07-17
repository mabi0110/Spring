package com.example.todo.controller;

public enum Option {
    ADD(1, "Dodaj nowe zadanie"),
    PRINT_SINGLE(2, "Wyświetl zadanie"),
    PRINT_NOT_STARTED_TASKS(3, "Wyświetl nierozpoczęte zadania"),
    PRINT_COMPLETED_TASKS(4, "Wyświetl zakończone zadania"),
    START_TASK(5, "Wystartuj zadanie"),
    END_TASK(6, "Zakończ zadanie"),
    EXIT(7, "Koniec programu");

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
