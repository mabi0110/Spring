package com.example.context;


import com.example.context.producer.MessageProducer;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class MessagePrinter {
    private final MessageProducer messageProducer;
    private final MessagePrinterConfig messagePrinterConfig;

    public MessagePrinter(MessageProducer messageProducer, MessagePrinterConfig messagePrinterConfig) {
        this.messageProducer = messageProducer;
        this.messagePrinterConfig = messagePrinterConfig;
    }

    void printMessage(){
        String message = messageProducer.getMessage();
        Function<String, String> decorator = messagePrinterConfig.getDecorated();
        String decoratedMessage = decorator.apply(message);
        System.out.println(decoratedMessage);
    }
}
