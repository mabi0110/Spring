package com.example.bikerent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BikerentApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BikerentApplication.class, args);
        BikeService bikeService = context.getBean(BikeService.class);
        BikeDto bikeDto1 = new BikeDto(1L, "Kross", "KRS12345", 30, 100);
        bikeService.add(bikeDto1);
        double payment = bikeService.rentForHours(1L, 5, "ABC");
        System.out.println("Kwota za wypozyczenie: " + payment);
        bikeService.returnBike(1L);

    }
}
