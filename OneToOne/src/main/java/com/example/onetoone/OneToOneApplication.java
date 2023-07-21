package com.example.onetoone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class OneToOneApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(OneToOneApplication.class, args);
        ClientOrder order1 = new ClientOrder("Szafa modułowa", "Szafa modułowa BigBox z drzwiami przesuwnymi, 160x240cm", 1900.0);
        ClientOrder order2 = new ClientOrder("Łóżko", "Łóżko 160x200 z podnoszonym stelażem i skrzynią", 3200.0);
        ClientOrderRepository clientOrderRepository = context.getBean(ClientOrderRepository.class);
        clientOrderRepository.save(order1);
        clientOrderRepository.save(order2);
        Client client = new Client("Jan", "Kowalski", "Wysoka 40, 12-345 Chałupkowo");
        client.addOrder(order1);
        client.addOrder(order2);
        ClientRepository clientRepository = context.getBean(ClientRepository.class);
        clientRepository.save(client);
    }

}
