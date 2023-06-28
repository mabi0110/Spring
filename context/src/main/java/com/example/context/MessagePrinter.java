package com.example.context;

public class MessagePrinter {
    private final MessageProducer messageProducer;

    public MessagePrinter(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    void printMessage(){
        String message = messageProducer.getMessage();
        System.out.println(message);
    }
}
