package com.example.contractmanagementsystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserFController {
    @GetMapping("/search_user")
    public String searchRole()
    {
        return "search_user";
    }
}
