package com.example.fragmenty;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/")
    String home(Model model){
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "index";
    }


    @GetMapping("/product")
    String getProduct(@RequestParam Long id, Model model){
        Optional<Product> product = productRepository.findById(id);
        product.ifPresent(value -> model.addAttribute("product", value));
        return "product";
    }
}
