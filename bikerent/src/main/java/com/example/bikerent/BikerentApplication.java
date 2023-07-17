package com.example.bikerent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class BikerentApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BikerentApplication.class, args);
        BikeService bikeService = context.getBean(BikeService.class);
        BikeDto bike1 = new BikeDto(1L, "Kross", "KRS12345", 30, 100);
        BikeDto bike2 = new BikeDto(2L, "Kross", "KRS12346", 50, 150);
        BikeDto bike3 = new BikeDto(3L, "Kross", "KRS12347", 40, 120);
        bikeService.add(bike1);
        bikeService.add(bike2);
        bikeService.add(bike3);
        double payment = bikeService.rentForDay("KRS12345", "ABC1234");
        System.out.println("Kwota do zapłaty: " + payment);

        int borrowedBikes = bikeService.countBorrowedBikes();
        System.out.println("Liczba wypożyczonych rowerów: " + borrowedBikes);

        System.out.println("Dostępne rowery (cena rosnąco): ");
        bikeService.findAllAvailableBikes().forEach(System.out::println);
    }
}
