package com.example.context;

import com.example.context.exeption.InvalidDecoratorException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class MessagePrinterConfig {

    private final String decorator;

    public MessagePrinterConfig(@Value("${app.message.decorator}") String decorator) {
        this.decorator = decorator;
    }


    Function<String, String> getDecorated(){
        if (("UPPERCASE").equals(decorator)){
            return String::toUpperCase;
        } else if (("LOWERCASE").equals(decorator)){
            return String::toLowerCase;
        }
        throw new InvalidDecoratorException("No decorator found for " + decorator);
    }
}
