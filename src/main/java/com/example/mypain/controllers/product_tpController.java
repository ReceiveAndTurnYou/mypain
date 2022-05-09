package com.example.mypain.controllers;

import com.example.mypain.models.product_tp;
import com.example.mypain.repositories.product_tpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class product_tpController {

    @Autowired
    private product_tpRepository product_tpRepository;

    @GetMapping("/typeproducts")
    public String listTypeProducts(Model model)
    {

        List<product_tp> prods = (List<product_tp>) product_tpRepository.findAll();

        model.addAttribute("prods", prods);

        return "typeproducts";
    }


    @GetMapping("/addtypeproduct")
    public String addTypeProduct()
    {
        return "addtypeproduct";
    }

    @PostMapping("/addtypeproduct")
    public String addTypeProd(
                    @RequestParam String producttptype,
                    @RequestParam String product_tp_description,
                    @RequestParam String product_density,
                    @RequestParam String product_conditions
    )
    {

        product_tp prod = new product_tp(producttptype, product_tp_description, product_density, product_conditions);

        product_tpRepository.save(prod);

        return "redirect:/typeproducts";
    }


}
