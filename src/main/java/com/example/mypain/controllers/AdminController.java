/*
package com.example.mypain.controllers;

import com.example.mypain.service.usersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    @Autowired
    usersService userService;

    @GetMapping("/admin")
    public String userList(Model model)
    {
        model.addAttribute("allUsers", userService.allUsers());
        return "admin";
    }

    @PostMapping("/admin")
    public String deleteUser(@RequestParam(required = true, defaultValue = "" ) Long users_id,
                             @RequestParam(required = true, defaultValue = "" ) String action,
                             Model model)
    {
        if(action.equals("delete"))
        {
            userService.deleteUser(users_id);
        }

        return "redirect:/admin";

    }


    @GetMapping("/admin/gt/{users_id}")
    public String gtUser(@PathVariable("users_id") Long users_id, Model model)
    {
        model.addAttribute("allUsers", userService.usergtList(users_id));
        return "admin";
    }















}
*/
