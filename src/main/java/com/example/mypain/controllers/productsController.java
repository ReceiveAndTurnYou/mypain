package com.example.mypain.controllers;

import com.example.mypain.models.Role;
import com.example.mypain.models.product_wh;
import com.example.mypain.models.users;
import com.example.mypain.repositories.product_whRepository;
import com.example.mypain.repositories.usersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/products")
@PreAuthorize("hasAuthority('ADMIN')")
public class productsController {
    @Autowired
    product_whRepository productWhRepository;

    @GetMapping
    public String ProductList(Model model)
    {

        model.addAttribute("products", productWhRepository.findAll());

        return "products";
    }

    @GetMapping("{prods}/edit")
    public String productEditForm(@PathVariable product_wh prods, Model model)
    {

        model.addAttribute("prods", prods);

        return "productEdit";
    }

    @GetMapping("{prods}/delete")
    public String productDeleteForm(@PathVariable product_wh prods, Model model)
    {

        model.addAttribute("prods", prods);

        return "productDelete";
    }


    @PostMapping("/edit")
    public String userSave(@RequestParam int product_number, @RequestParam String product_type,
                           @RequestParam String product_density, @RequestParam String product_conditions,
                           @RequestParam int product_count,
                           @RequestParam("idproduct_wh") product_wh prod)
    {

        prod.setProduct_number(product_number);
        prod.setProduct_type(product_type);
        prod.setProduct_density(product_density);
        prod.setProduct_conditions(product_conditions);
        prod.setProduct_count(product_count);

        productWhRepository.save(prod);

        return "redirect:/products";
    }

    @PostMapping("/delete")
    public String userDelete(@RequestParam("idproduct_wh") product_wh prods)
    {
        productWhRepository.deleteById(prods.getIdproduct_wh());

        return "redirect:/products";
    }
}
