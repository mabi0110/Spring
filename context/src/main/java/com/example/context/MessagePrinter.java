package com.example.context;

public class MessagePrinter {

    private final SimpleMessageProducer messageProducer;


    public MessagePrinter(SimpleMessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    void printMessage(){
        String message = messageProducer.getMessage();
        System.out.println(message);
    }
}
