package com.example.bikerent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BikerentApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(BikerentApplication.class, args);
        BikeRepository bikeRepository = context.getBean(BikeRepository.class);
        Bike bike1 = new Bike(1L, "Kross", "KRS12345", 30, 100);
        bikeRepository.save(bike1);
        Bike bike2 = new Bike(2L, "Trek", "TRK12345", 25, 80);
        bikeRepository.save(bike2);

        bikeRepository.findById(1L).ifPresent(System.out::println);
        bikeRepository.deleteById(2L);
        bikeRepository.findById(2L).ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Brak roweru o wskazanym id"));
    }

}
