package com.example.shop;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private final List<Product> products = new ArrayList<>();

    public ProductRepository() {
        products.add(
                new Product(1, "mleko", 3.8, new Producer("Mlekpol", new Address("Warszawa", "20-022", "Wysoka 20")))
        );
        products.add(
                new Product(2, "czekolada", 4.5, new Producer("Wedel", new Address("Warszawa", "02-154", "Aleje Jerozolimskie 150")))
        );
        products.add(
                new Product(3, "kawa", 18.00, new Producer("Nescafe", new Address("Warszawa", "01-022", "Barcicka 12")))
        );
    }


    // /products
    List<Product> findAll() {
        return products;
    }

    // /products?name=mleko
    List<Product> findAllByName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if(product.getName().equalsIgnoreCase(name)){
                result.add(product);
            }
        }
        return result;
    }




}
