package com.example.mypain.controllers;


import com.example.mypain.models.Role;
import com.example.mypain.models.users;
import com.example.mypain.repositories.usersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {


    @Autowired
    private usersRepository userRepository;

    @GetMapping("/registration")
    public String regstr()
    {
        return "registration";
    }


    @PostMapping("/registration")
    public String addUser(users user, Map<String, Object> model)
    {
        users userFromDb = userRepository.findByusername(user.getUsername());

        if(userFromDb!= null)
        {
            model.put("message", "user exits");
            return "registration";
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
