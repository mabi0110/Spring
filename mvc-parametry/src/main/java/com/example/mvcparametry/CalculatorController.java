package com.example.mvcparametry;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CalculatorController {

    @GetMapping("/add")
    @ResponseBody
    String add(HttpServletRequest request) {
        String a = request.getParameter("a");
        String b = request.getParameter("b");
        double aValue = Double.parseDouble(a);
        double bValue = Double.parseDouble(b);
        double sum = aValue + bValue;
        return String.format("%.2f + %.2f = %.2f", aValue, bValue, sum);
    }
}
