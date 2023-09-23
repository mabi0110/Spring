package com.example.thymeleafform;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PromotionController {

    private final PromotionRepository promotionRepository;


    public PromotionController(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    @GetMapping("/add")
    String addForm(Model model){
        model.addAttribute("promotion", new Promotion());
        return "add-form";
    }

    @PostMapping("/save")
    String savePromotion(Promotion promotion){
        promotionRepository.add(promotion);
        return "redirect:/";
    }

    @GetMapping("/")
    String promotionsList(Model model){
        List<Promotion> promotions = promotionRepository.findAll();
        model.addAttribute("promotions", promotions);
        return "list";
    }


}
