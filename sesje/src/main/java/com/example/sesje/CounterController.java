package com.example.sesje;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CounterController {

    private static final String COUNTER_NAME = "counter";

    @GetMapping("/")
    String counter(HttpSession session){
        Integer counter = (Integer) session.getAttribute(COUNTER_NAME);
        if (counter != null){
            counter++;
        } else {
            counter = 1;
        }
        session.setAttribute(COUNTER_NAME, counter);
        return "index";
    }

}
