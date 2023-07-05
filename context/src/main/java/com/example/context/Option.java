package com.example.context;

import java.util.Optional;

public enum Option {
    EXIT(0, "Wyjście"),
    NEXT_MESSAGE(1, "Wczytaj kolejny komunikat");

    private final int number;
    private final String description;

    Option(int number, String description) {
        this.number = number;
        this.description = description;
    }

    static Optional<Option> fromInt(int number){
        Option[] options = Option.values();
        if (number >= 0 && number < options.length){
            return Optional.of(options[number]);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public String toString() {
        return number + " - " + description;
    }
}
