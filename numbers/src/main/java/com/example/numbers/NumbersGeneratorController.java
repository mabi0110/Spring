package com.example.numbers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NumbersGeneratorController {
    private final NumbersService numbersService;
    private static final int DEFAULT_LOWER_BOUND = 0;
    private static final int DEFAULT_UPPER_BOUND = 1000;
    private static final int DEFAULT_BOUND_DIFF = 100;
    private static final String INCORRECT_PARAMS_MESSAGE =
            "Dolne ograniczenie musi być mniejsze, bądź równe górnemu ograniczeniu";

    public NumbersGeneratorController(NumbersService numbersService) {
        this.numbersService = numbersService;
    }

    @GetMapping("/random")
    @ResponseBody
    String getRandomNumber(@RequestParam(required = false) Integer from,
                           @RequestParam(required = false) Integer to) {
        if (incorrectParams(from, to)) {
            return INCORRECT_PARAMS_MESSAGE;
        }
        int lowerBound = getLowerBound(from, to);
        int upperBound = getUpperBound(from, to);
        String randomNumber = Integer.toString(numbersService.getRandomNumberFromRange(lowerBound, upperBound));
        return String.format("Losowa liczba z przedziału [%d; %d]: %s: ", lowerBound, upperBound, randomNumber);
    }



    private int getUpperBound(Integer from, Integer to) {
        if (to != null) {
            return to;
        } else if (from == null) {
            return DEFAULT_UPPER_BOUND;
        } else {
            return from + DEFAULT_BOUND_DIFF;
        }
    }

    private int getLowerBound(Integer from, Integer to) {
        if (from != null) {
            return from;
        } else if (to == null) {
            return DEFAULT_LOWER_BOUND;
        } else {
            return to - DEFAULT_BOUND_DIFF;
        }
    }

    private boolean incorrectParams(Integer from, Integer to) {
        return from != null && to != null && from > to;
    }

    @GetMapping("/even-numbers")
    @ResponseBody
    String getEvenNumbers(@RequestParam(required = false) Integer from,
                          @RequestParam(required = false) Integer to) {
        if (incorrectParams(from, to)) {
            return INCORRECT_PARAMS_MESSAGE;
        }
        int lowerBound = getLowerBound(from, to);
        int upperBound = getUpperBound(from, to);
        String numbers = numbersService.getEvenNumbersFromRange(lowerBound, upperBound).toString();
        return String.format("Liczby parzyste z przedziału [%d; %d]: %s", lowerBound, upperBound, numbers);
    }

    @GetMapping("/odd-numbers")
    @ResponseBody
    String getOddNumbers(@RequestParam(required = false) Integer from,
                         @RequestParam(required = false) Integer to) {
        if (incorrectParams(from, to)) {
            return INCORRECT_PARAMS_MESSAGE;
        }
        int lowerBound = getLowerBound(from, to);
        int upperBound = getUpperBound(from, to);
        String numbers = numbersService.getOddNumbersFromRange(lowerBound, upperBound).toString();
        return String.format("Liczby nieparzyste z przedziału [%d; %d]: %s", lowerBound, upperBound, numbers);
    }

}
