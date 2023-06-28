package com.example.context;

public class Main {
    public static void main(String[] args) {
        SimpleMessageProducer messageProducer = new SimpleMessageProducer();
        MessagePrinter messagePrinter = new MessagePrinter(messageProducer);
        messagePrinter.printMessage();
        messagePrinter.printMessage();
        messagePrinter.printMessage();

    }
}
