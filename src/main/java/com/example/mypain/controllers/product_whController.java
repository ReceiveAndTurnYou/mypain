package com.example.mypain.controllers;

import com.example.mypain.repositories.product_whRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class product_whController {

    @Autowired
    private product_whRepository product_whRepository;
}
