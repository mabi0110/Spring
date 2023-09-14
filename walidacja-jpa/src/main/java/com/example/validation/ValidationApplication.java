package com.example.validation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.dao.DataIntegrityViolationException;

@SpringBootApplication
public class ValidationApplication {
    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(ValidationApplication.class, args);
        ClientService clientService = context.getBean(ClientService.class);
        Client client = new Client("Jan", "Kowalski", "kowaljan@abc.com", 10);
        try {
            clientService.register(client);
            System.out.println("Rejestracja powiodła się: " + client);
        } catch(DataIntegrityViolationException e) {
            System.out.printf("Rejestracja nie powiodła się %s\n", client);
            System.out.println(e.getMessage());
        }
    }

}
