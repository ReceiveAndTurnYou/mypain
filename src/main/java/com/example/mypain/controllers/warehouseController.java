package com.example.mypain.controllers;


import com.example.mypain.models.product_order;
import com.example.mypain.models.users;
import com.example.mypain.repositories.product_orderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/warehouse")
public class warehouseController {

    @Autowired
    private product_orderRepository product_orderRepository;


    @GetMapping()
    public String main(@AuthenticationPrincipal users user,
                       Model model)
    {
        List<product_order> orders = product_orderRepository.findByClient(user);
        model.addAttribute("orders", orders);

        return "warehouse";
    }


}
