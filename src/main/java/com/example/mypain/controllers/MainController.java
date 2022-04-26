package com.example.mypain.controllers;

import com.example.mypain.models.users;
import com.example.mypain.repositories.usersRepository;
import com.example.mypain.service.usersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MainController {

    @Autowired
    usersService userService;

    @Autowired
    usersRepository userRepository;


    @GetMapping("/")
    public String welcome(Model model) {
        model.addAttribute("title", "Главная страница");
        return "welcome-page";
    }

    @GetMapping("/test")
    public String test(Model model)
    {
        Iterable<users> user = userRepository.findAll();

        model.addAttribute("users", user);
        model.addAttribute("title", "О нас");
        return "test";
    }
}



