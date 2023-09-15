package com.example.loops;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ExampleController {

    @GetMapping("/")
    String example(Model model) {
        List<Person> people = List.of(
                new Person("Jan", "Nowak"),
                new Person("Ala", "Nowak"),
                new Person("Ula", "Nowak"),
                new Person("Ola", "Nowak")
        );
        model.addAttribute("people", people);
        return "example";
    }
}
