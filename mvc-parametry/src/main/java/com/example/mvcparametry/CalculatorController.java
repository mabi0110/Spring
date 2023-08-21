package com.example.mvcparametry;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CalculatorController {

    @GetMapping("/add")
    @ResponseBody
    String add(@RequestParam ("a") double a, @RequestParam("b") double b) {
        double sum = a + b;
        return String.format("%.2f + %.2f = %.2f", a, b, sum);
    }
}
