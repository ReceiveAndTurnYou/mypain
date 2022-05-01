package com.example.mypain.controllers;

import com.example.mypain.models.delivery_company;
import com.example.mypain.models.users;
import com.example.mypain.repositories.delivery_companyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class delivery_companyController {

    @Autowired
    private delivery_companyRepository delivery_companyRepository;

    @GetMapping("/companies")
    public String allCompanies(Model model)
    {

        Iterable<delivery_company> delivery_companies = delivery_companyRepository.findAll();
        model.addAttribute("companies", delivery_companies);

        return "companies";
    }

    @GetMapping("/addnewcompany")
    public String addCompany()
    {
        return "addnewcompany";
    }

    @GetMapping("/companysuccess")
    public String companysuccess()
    {
        return "companysuccess";
    }

    @PostMapping("/addnewcompany")
    public String newCompany(@RequestParam String company_name, @RequestParam String company_description, @RequestParam int trust_factor,
                             @AuthenticationPrincipal users user)
    {

        delivery_company deliveryCom = new delivery_company(company_name, company_description, trust_factor, user);

        delivery_companyRepository.save(deliveryCom);


        return "redirect:/companysuccess";
    }

}
