package com.example.contractmanagementsystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContractsController {
    @GetMapping("/search_contract")
    public String search_cont()
    {
        return "search_contract";
    }
}
