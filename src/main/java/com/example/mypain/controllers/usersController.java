package com.example.mypain.controllers;


import com.example.mypain.models.Role;
import com.example.mypain.models.users;
import com.example.mypain.repositories.usersRepository;
import com.example.mypain.service.usersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
public class usersController {

    @Autowired
    usersRepository userRepository;

    @Autowired
    usersService usersService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public String userList(Model model)
    {

        model.addAttribute("users", userRepository.findAll());

        return "userList";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("{user}/edit")
    public String userEditForm(@PathVariable users user, Model model)
    {

        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());


        return "userEdit";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("{user}/delete")
    public String userDeleteForm(@PathVariable users user, Model model)
    {

        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());


        return "userDelete";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/edit")
    public String userSave(@RequestParam String user_name, @RequestParam Map<String, String> form,
                           @RequestParam("users_id") users user)
    {
        user.setUsername(user_name);

        Set<String> roles = Arrays.stream(Role.values()).map(Role::name).collect(Collectors.toSet());

        user.getRoles().clear();

        for(String key : form.keySet())
        {
            if(roles.contains(key))
            {
                user.getRoles().add(Role.valueOf(key));
            }
        }

        userRepository.save(user);

        return "redirect:/user";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/delete")
    public String userDelete(@RequestParam("users_id") users user)
    {
        userRepository.deleteById(user.getUsers_id());

        return "redirect:/user";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/search")
    public String search(@RequestParam String search, Model model)
    {
        List<users> user;

        if(search!=null && !search.isEmpty())
        {
            user = userRepository.findByLogin(search);
        }
        else
        {
            user = userRepository.findAll();
        }

        model.addAttribute("users", user);

        return "userList";
    }


}
