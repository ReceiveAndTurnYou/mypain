package com.example.mypain.controllers;


import com.example.mypain.models.users;
import com.example.mypain.repositories.usersRepository;
import com.example.mypain.service.usersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {

    @Autowired
    private usersService userService;

    @Autowired
    private usersRepository userRepository;

    @GetMapping("/registration")
    public String regstr(Model model)
    {
        model.addAttribute("title", "Страница регистрации");
        return "registration";
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

    @PostMapping("/registration")
    public String addUser(@RequestParam String user_name, @RequestParam String surname, @RequestParam String login,
    @RequestParam String password, @RequestParam String country, @RequestParam String email)
    {
        users user =new users(user_name, surname, login, password, country, email);

        userRepository.save(user);

        return "redirect:/";
    }






}
