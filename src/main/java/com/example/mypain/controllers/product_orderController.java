package com.example.mypain.controllers;

import com.example.mypain.models.delivery_company;
import com.example.mypain.models.product_order;
import com.example.mypain.models.product_tp;
import com.example.mypain.models.users;
import com.example.mypain.repositories.delivery_companyRepository;
import com.example.mypain.repositories.product_orderRepository;
import com.example.mypain.repositories.product_tpRepository;
import com.example.mypain.service.OrderChequeService;
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
@RequestMapping("/order")
public class product_orderController {

    @Autowired
    private product_orderRepository product_orderRepository;

    @Autowired
    private product_tpRepository product_tpRepository;

    @Autowired
    private delivery_companyRepository delivery_companyRepository;

    @Autowired
    private OrderChequeService orderChequeService;

    @GetMapping
    public String main(Model model, @AuthenticationPrincipal users user)
    {
        List<product_tp> product_tps = (List<product_tp>) product_tpRepository.findAll();

        HashSet<String> types = new HashSet<>();
        for(int i=0; i<product_tps.size(); i++)
        {
            types.add(product_tps.get(i).getProducttptype());
        }


        model.addAttribute("types", types);
        model.addAttribute("user", user);

        return "orders";
    }


    @GetMapping("/orders")
    public String showOrders(@AuthenticationPrincipal users user,
                             Model model)
    {
        List<product_order> orders = product_orderRepository.findByClient(user);
        model.addAttribute("orders", orders);

        return "orderUserList";
    }

    @GetMapping("/details")
    public String detail(@RequestParam String types,
                         Model model, @AuthenticationPrincipal users user)
    {
        List<product_tp> productDescrp = product_tpRepository.findByProducttptype(types);


        model.addAttribute("productDescrp", productDescrp);
        model.addAttribute("product_type", types);
        model.addAttribute("user", user);

        return "orderDetails";
    }

    @GetMapping("/chooseCompany")
    public String chooseCompany(@RequestParam String product_type,
                                @RequestParam String productDescrp,
                                @RequestParam String date,
                                @AuthenticationPrincipal users user,
                                Model model)
    {

        List<delivery_company>  delivery_companies = (List<delivery_company>) delivery_companyRepository.findAll();


        model.addAttribute("companies", delivery_companies);
        model.addAttribute("date", date);
        model.addAttribute("product_type", product_type);
        model.addAttribute("productDescrp", productDescrp);
        model.addAttribute("user", user);

        return "orderSubmit";
    }

    @PostMapping("/submit")
    public String submit(
                        @AuthenticationPrincipal users user,
                        @RequestParam String product_type,
                        @RequestParam String productDescrp,
                        @RequestParam String date,
                        @RequestParam String company
    )
    {

        List<product_tp> product_tps = product_tpRepository.findByProducttptype(product_type);

        product_tp product_tp =product_tps.get(0);

        List<delivery_company> delivery_companies = delivery_companyRepository.findByCompanyname(company);

        delivery_company delivery_company = delivery_companies.get(0);

        product_order product_order = new product_order(user, product_tp, delivery_company, date);

        String chequeText = orderChequeService.chequeMessageGenerate(user, product_order);


        product_orderRepository.save(product_order);

        orderChequeService.saveCheque(chequeText, product_order.getIdproduct_order());


        return "orderSuccess";
    }

}
