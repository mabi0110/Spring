package com.example.time;


import org.springframework.boot.autoconfigure.web.format.DateTimeFormatters;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class TimeController {


    @RequestMapping("/current-time")
    @ResponseBody
    public String currentTime() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(dateTimeFormatter);
    }

    @RequestMapping("/current-year")
    @ResponseBody
    public String currentYear() {
        return Integer.toString(LocalDateTime.now().getYear());
    }

}
