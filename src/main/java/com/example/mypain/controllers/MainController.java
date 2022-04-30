package com.example.mypain.controllers;

import com.example.mypain.models.product_wh;
import com.example.mypain.models.users;
import com.example.mypain.repositories.product_whRepository;
import com.example.mypain.repositories.usersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    usersRepository userRepository;

    @Autowired
    product_whRepository productWhRepository;

    @GetMapping("/")
    public String welcome() {
        return "welcome-page";
    }

    @GetMapping("/home")
    public String test(Model model)
    {
        Iterable<users> user = userRepository.findAll();

        model.addAttribute("users", user);

        return "home";
    }
}



