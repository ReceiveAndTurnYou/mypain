package com.example.mypain.controllers;

import com.example.mypain.repositories.product_orderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class product_orderController {

    @Autowired
    private product_orderRepository product_orderRepository;


}
