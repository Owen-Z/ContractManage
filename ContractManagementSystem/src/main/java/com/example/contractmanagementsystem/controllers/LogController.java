package com.example.contractmanagementsystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogController {
    @GetMapping("search_log")
    public String sear_log()
    {
        return "search_log";
    }
}
