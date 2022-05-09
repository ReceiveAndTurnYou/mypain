package com.example.mypain.controllers;


import com.example.mypain.models.Role;
import com.example.mypain.models.users;
import com.example.mypain.repositories.usersRepository;
import com.example.mypain.service.usersService;
import org.h2.engine.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;

@Controller
public class RegistrationController {

    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    private usersRepository userRepository;

    @Autowired
    private usersService usersService;

    @GetMapping("/registration")
    public String regstr()
    {
        return "registration";
    }


    @PostMapping("/registration")
    public String addUser(users user, Map<String, Object> model, @RequestParam("file") MultipartFile file) throws IOException {

        if(!usersService.addUserS(user, file))
        {
            model.put("message", "user exits");
            return "registration";
        }

       /* if(!file.isEmpty())
        {
            File uploadDir = new File(uploadPath);

            if(!uploadDir.exists())
            {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFileName));

            user.setFilename(resultFileName);
        }*/


        /*user.setRoles(Collections.singleton(Role.USER));
        user.setActive(true);
        userRepository.save(user);*/


        return "redirect:/login";
    }


    @GetMapping("/activate/{code}")
    public String activate(Model model, @PathVariable String code)
    {
        boolean isActivated = usersService.activateUser(code);

        if(isActivated)
        {
            model.addAttribute("message", "Аккаунт активирован!");
        }
        else
        {
            model.addAttribute("message", "Не найден код активации");
        }

        return "login";
    }





















}
