package com.example.di.formatter;

import org.springframework.stereotype.Service;

@Service
public class UpperCaseTextFormatter implements TextFormatter{
    @Override
    public String format(String text) {
        return text.toUpperCase();
    }
}
