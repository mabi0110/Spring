package com.example.context;

import org.springframework.stereotype.Controller;

import java.util.Optional;
import java.util.Scanner;

@Controller
public class MessageController {
    
    private final Scanner scanner;
    private final MessagePrinter messagePrinter;

    public MessageController(Scanner scanner, MessagePrinter messagePrinter) {
        this.scanner = scanner;
        this.messagePrinter = messagePrinter;
    }

    public void mainLoop() {
        Option option;
        do {
            option = chooseOption();
            executeOption(option);
        } while (option != Option.EXIT);
    }

    private Option chooseOption() {
        int number;
        Optional<Option> option;
        do {
            printOptions();
            System.out.println("Wybierz numer: ");
            number = scanner.nextInt();
            scanner.nextLine();
            option = Option.fromInt(number);
        } while (option.isEmpty());
        return option.get();
    }

    private void printOptions() {
        Option[] options = Option.values();
        System.out.println("Opcje:");
        for (Option option : options) {
            System.out.println(option);
        }
    }

    private void executeOption(Option option) {
        switch (option){
            case EXIT -> exit();
            case NEXT_MESSAGE -> printMessage();
        }
    }

    private void printMessage() {
        messagePrinter.printMessage();
    }

    private void exit() {
        System.out.println("Koniec programu");
    }
}
