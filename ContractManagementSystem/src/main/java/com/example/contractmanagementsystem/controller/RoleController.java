package com.example.contractmanagementsystem.controller;

import com.example.contractmanagementsystem.service.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RoleController {
    @Autowired
    RoleServiceImpl roleService;

    @PostMapping("/addRole/add")
    @ResponseBody
    public int add(String name,
                  String functions,
                  String del){
        if(name == "" || name == null){
            return 2;
        }
        int i = roleService.addRole(name, functions, del);
        return i;
    }

}
