package com.example.context.exeption;

public class InvalidDecoratorException extends RuntimeException {

    public InvalidDecoratorException(String message) {
        super(message);
    }
}
