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

        Iterable<product_wh> prods = productWhRepository.findAll();

        model.addAttribute("prods", prods);
        return "test";
    }

    @GetMapping("/addnewsupply")
    public String addNewSupply()
    {
        return "addnewsupply";
    }

    @PostMapping("/addnewsupply")
    public String NewSupply(@RequestParam String product_number, @RequestParam String product_type, @RequestParam String product_density, @RequestParam String product_conditions, @RequestParam String product_count,
    @AuthenticationPrincipal users user)
    {
        product_wh prod_wh = new product_wh(product_number, product_type, product_density, product_count, product_density, user);

        productWhRepository.save(prod_wh);

        return "redirect:/test";
    }
}



