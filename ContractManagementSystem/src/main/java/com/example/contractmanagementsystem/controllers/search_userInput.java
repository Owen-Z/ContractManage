package com.example.contractmanagementsystem.controllers;

import com.example.contractmanagementsystem.pojo.Role;
import com.example.contractmanagementsystem.service.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class search_userInput {
    @Autowired
    RoleServiceImpl roleService;

    @RequestMapping("/search")
    public String search(Model model)
    {
        List<Role> roles = roleService.getAllRole();
        System.out.println(roles.size());
        model.addAttribute("roles",roles);
        return "search_user";
    }
}
