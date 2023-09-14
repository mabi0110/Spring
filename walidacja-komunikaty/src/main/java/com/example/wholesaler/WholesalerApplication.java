package com.example.wholesaler;

import com.example.wholesaler.model.Equipment;
import com.example.wholesaler.model.Product;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Set;


@SpringBootApplication
public class WholesalerApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(WholesalerApplication.class, args);
        Validator validator = context.getBean(Validator.class);
        Product product1 = new Product("Dell XPS15", "Laptop 15 cali", "PLL12345");
        Set<ConstraintViolation<Product>> productConstraintViolations = validator.validate(product1);
        if(!productConstraintViolations.isEmpty()){
            System.out.println("Nieprawidłowy produkt, złamane ograniczenia");
            productConstraintViolations.stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
        }


        Equipment equipment1 = new Equipment("iPhone13", "20345", "EQ798");
        Set<ConstraintViolation<Equipment>> equipmentConstraintViolations = validator.validate(equipment1);
        if (!equipmentConstraintViolations.isEmpty()){
            System.out.println("Nieprawidłowe wyposażenie, złąmane ograniczenia");
            equipmentConstraintViolations.stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
        }


    }

}
