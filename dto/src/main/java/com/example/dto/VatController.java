package com.example.dto;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VatController {

    private final VatService vatService;

    public VatController(VatService vatService) {
        this.vatService = vatService;
    }

    @PostMapping("/calculate")
    String calculate(@RequestParam double netto, @RequestParam String category, Model model){
        VatDto vatDto = vatService.calculate(netto, category);
        model.addAttribute("vatDto", vatDto);
        return "result";
    }


}
