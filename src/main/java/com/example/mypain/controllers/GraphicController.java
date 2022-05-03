package com.example.mypain.controllers;


import com.example.mypain.models.product_order;
import com.example.mypain.repositories.product_orderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/graphic")
@PreAuthorize("hasAuthority('ADMIN')")
public class GraphicController {

    @Autowired
    private product_orderRepository product_orderRepository;

    @GetMapping("/statistic")
    public String stats(Model model)
    {
        List<product_order> product_orders = (List<product_order>) product_orderRepository.findAll();

        Map<String, Integer> WeSee =new HashMap<String, Integer>();

        for(int i=0; i<product_orders.size(); i++)
        {
            WeSee.put(product_orders.get(i).getProductTypeName().getProducttptype(),
                    product_orderRepository.countAllByProductTypeName(product_orders.get(i).getProductTypeName()));
        }

        model.addAttribute("map", WeSee);

        return "statistic";
    }




}
