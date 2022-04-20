package com.example.mypain.controllers;

import com.example.mypain.repositories.product_tpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class product_tpController {

    @Autowired
    private product_tpRepository product_tpRepository;



}
