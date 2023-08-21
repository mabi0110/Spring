package com.example.mvcparametry;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {

    @GetMapping("/hello")
    @ResponseBody
    String hello(HttpServletRequest request) {
        String name = request.getParameter("name");
        return "Hello " + name;
    }
}
