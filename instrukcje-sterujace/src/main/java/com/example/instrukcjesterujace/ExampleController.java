package com.example.instrukcjesterujace;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExampleController {

    @GetMapping
    String example(Model model){
        model.addAttribute("person", new Person("Jan", "Nowak", 17));
        return "example";
    }
}
