package com.example.shop;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.server.RemoteRef;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    List<Product> getProducts(@RequestParam(required = false) String name) {
        if (name == null) {
            return productRepository.findAll();
        } else {
            return productRepository.findAllByName(name);
        }
    }

    @GetMapping("/{id}")
    ResponseEntity<Product> getProductById(@PathVariable Integer id) {
        return  productRepository.findById(id)
                //.map(product -> ResponseEntity.ok(product))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/producer")
    ResponseEntity<Producer> getProducerByProductId(@PathVariable Integer id) {
       return  productRepository.findById(id)
               .map(Product::getProducer)
               .map(ResponseEntity::ok)
               .orElse(ResponseEntity.notFound().build());

    }
    @GetMapping("/example")
    @ResponseStatus(HttpStatus.CREATED)
    void example() {

    }
}
