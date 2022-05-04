package com.example.mypain.controllers;

import com.example.mypain.models.product_wh;
import com.example.mypain.models.users;
import com.example.mypain.repositories.product_whRepository;
import com.example.mypain.repositories.usersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Controller
public class MainController {

    @Autowired
    usersRepository userRepository;

    @Autowired
    product_whRepository productWhRepository;

    @GetMapping("/")
    public String welcome() {
        return "welcome-page";
    }

    @GetMapping("/home")
    public String home(Model model)
    {
        Iterable<users> user = userRepository.findAll();

        model.addAttribute("users", user);

        return "home";
    }

    @GetMapping("/about")
    public String about()
    {
        return "about";
    }

    @PostMapping("/about")
    public String review(@RequestParam String review, @AuthenticationPrincipal users user)
    {
        File directory = new File("C:/Users/Goope/Desktop/mypain/reviews/");
        String path = directory.getPath();

        String newreview = "Отзыв: " +  review + "\n" + "=========================" + "\n" + "Кто оставил: " + user.getUsername();

        int randomNum = ThreadLocalRandom.current().nextInt(1, 999 + 1);

        String chequePathName = path + "/review" + randomNum  + ".txt";
        File chequeFile = new File(chequePathName);

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(chequeFile));
            writer.write(newreview);
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return "redirect:/about";
    }
}



