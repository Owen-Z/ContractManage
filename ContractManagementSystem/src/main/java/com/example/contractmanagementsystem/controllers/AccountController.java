package com.example.contractmanagementsystem.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {
    @GetMapping("/sear_account")
    public String sear_ACCOUNT()
    {
        return "search_account";
    }
}
