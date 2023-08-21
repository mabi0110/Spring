package com.example.mvcparametry;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {

    @GetMapping("/hello")
    @ResponseBody
    String hello(@RequestParam(value = "name", required = false) String name) {
        if (name != null){
            return "Hello " + name;
        } else {
            return "Hello stranger";
        }

    }
}
