package com.example.context;

import java.util.Scanner;

public class ConsoleMessageProducer implements MessageProducer{
    @Override
    public String getMessage() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text to print: ");
        return scanner.nextLine();
    }
}
