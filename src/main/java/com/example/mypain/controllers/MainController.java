package com.example.mypain.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String welcome(Model model) {
        model.addAttribute("title", "Главная страница");
        return "welcome-page";
    }

    @GetMapping("/test")
    public String test(Model model)
    {
        model.addAttribute("title", "О нас");
        return "test";
    }
}



