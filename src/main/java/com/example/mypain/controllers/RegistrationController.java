package com.example.mypain.controllers;


import com.example.mypain.models.Role;
import com.example.mypain.models.users;
import com.example.mypain.repositories.usersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @GetMapping("/registration")
    public String regstr()
    {
        return "registration";
    }


    @PostMapping("/registration")
    public String addUser(users user, Map<String, Object> model, @RequestParam("file") MultipartFile file) throws IOException {
        users userFromDb = userRepository.findByusername(user.getUsername());

        if(userFromDb!= null)
        {
            model.put("message", "user exits");
            return "registration";
        }

        if(!file.isEmpty())
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
        }

        user.setRoles(Collections.singleton(Role.USER));
        user.setActive(true);
        userRepository.save(user);


        return "redirect:/login";
    }




/*@PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm") users userForm, BindingResult bindingResult, Model model)
    {
        if(bindingResult.hasErrors())
        {
            return "registration";
        }

        if(!userForm.getPassword().equals(userForm.getPasswordConfirm()))
        {
            model.addAttribute("passwordError","Пароли не совпадают");
            return "registration";
        }

        if(!userService.saveUser(userForm))
        {
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "registration";
        }

        return "redirect:/";
    }*/


}
