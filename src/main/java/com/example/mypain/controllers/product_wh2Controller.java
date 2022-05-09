package com.example.mypain.controllers;


import com.example.mypain.models.product_tp;
import com.example.mypain.models.product_wh;
import com.example.mypain.models.users;
import com.example.mypain.repositories.product_tpRepository;
import com.example.mypain.repositories.product_whRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.List;

@Controller
@RequestMapping("/products2")
public class product_wh2Controller {

    @Autowired
    private product_tpRepository product_tpRepository;

    @Autowired
    private product_whRepository product_whRepository;


    @GetMapping
    private String main(Model model, @AuthenticationPrincipal users user)
    {
        List<product_tp> product_tps = (List<product_tp>) product_tpRepository.findAll();

        HashSet<String> types = new HashSet<>();
        for(int i=0; i<product_tps.size(); i++)
        {
            types.add(product_tps.get(i).getProducttptype());
        }


        model.addAttribute("types", types);
        model.addAttribute("user", user);

        return "products2";
    }

    @GetMapping("/details")
    public String productDetails(@RequestParam String types,
                                 Model model, @AuthenticationPrincipal users user)
    {
        List<product_tp> productDescrp = product_tpRepository.findByProducttptype(types);


        model.addAttribute("productDescrp", productDescrp);
        model.addAttribute("product_type", types);
        model.addAttribute("user", user);


        return "product2Details";
    }

    @GetMapping("/remaining")
    public String remain(@RequestParam String product_type,
                         @RequestParam String productDescrp,
                         @AuthenticationPrincipal users user,
                         Model model)
    {


        model.addAttribute("product_type", product_type);
        model.addAttribute("productDescrp", productDescrp);
        model.addAttribute("user", user);



        return "product2Submit";
    }


    @PostMapping("/submit")
    public String submit( @AuthenticationPrincipal users user,
                          @RequestParam String product_type,
                          @RequestParam String productnumber,
                          @RequestParam String product_count)
    {

        int productnumberT = Integer.parseInt(productnumber);
        int productcountT = Integer.parseInt(product_count);

        List<product_tp> product_tps = product_tpRepository.findByProducttptype(product_type);

        product_tp product_tp =product_tps.get(0);

        product_wh prod_wh = new product_wh(productnumberT, productcountT, user, product_tp);

        product_whRepository.save(prod_wh);

        return "product2Success";
    }









}
