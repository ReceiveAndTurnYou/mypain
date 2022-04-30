package com.example.mypain.controllers;

import com.example.mypain.models.product_wh;
import com.example.mypain.models.users;
import com.example.mypain.repositories.product_whRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class product_whController {

    @Autowired
    private product_whRepository product_whRepository;

    @GetMapping("/products")
    public String productsList(Model model)
    {
        Iterable<product_wh> prods = product_whRepository.findAll();
        model.addAttribute("products", prods);

        return "products";
    }

    @GetMapping("/addnewsupply")
    public String addNewSupply()
    {
        return "addnewsupply";
    }

    @GetMapping("/supplysuccess")
    public String addedsupply()
    {
        return "supplysuccess";
    }


    @PostMapping("/addnewsupply")
    public String NewSupply(@RequestParam String product_number, @RequestParam String product_type, @RequestParam String product_density, @RequestParam String product_conditions, @RequestParam String product_count,
                            @AuthenticationPrincipal users user)
    {
        product_wh prod_wh = new product_wh(product_number, product_type, product_density, product_count, product_density, user);

        product_whRepository.save(prod_wh);

        return "redirect:/supplysuccess";
    }


}
