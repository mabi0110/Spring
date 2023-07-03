package com.example.di;

import com.example.di.formatter.TextFormatter;
import org.springframework.stereotype.Service;

@Service
public class ConsoleOutputPrinter {

    private final TextFormatter textFormatter;

    public ConsoleOutputPrinter(TextFormatter textFormatter) {
        this.textFormatter = textFormatter;
    }

    public void printText(String text){
        String formattedText = textFormatter.format(text);
        System.out.println(formattedText);
    }

}
