package com.example.contractmanagementsystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RolesController {
    public RolesController(){}
    @GetMapping("/search_role")
    public String searchRole()
    {
        return "search_role";
    }
}
