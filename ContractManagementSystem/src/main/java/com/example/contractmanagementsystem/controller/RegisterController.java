package com.example.contractmanagementsystem.controller;

import com.example.contractmanagementsystem.pojo.User;
import com.example.contractmanagementsystem.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping("/register/check")
    public String register(@RequestParam("UserName") String name,
                           @RequestParam("Password0") String password0,
                           @RequestParam("Password1") String password1,
                           Model model){
        User user = userService.queryUserByName(name);
        if(user != null){
            model.addAttribute("msg","用户已存在");
            return "register";
        }
        if(!password0.equals(password1)){
            model.addAttribute("msg","密码不一致");
            return "register";
        }

        if(name == "" || name == null || password0 == "" || password0 == null){
            model.addAttribute("msg","用户名或者密码为空");
            return "register";
        }

        int i = userService.addUser(name,password0);
        if(i == 1){
            model.addAttribute("msg","用户注册成功");
            return "login";
        }else {
            model.addAttribute("msg","用户注册失败");
            return "register";
        }
    }

    @RequestMapping("/register/add")
    public String addUser(@RequestParam("UserName") String name,
                           @RequestParam("Password0") String password0,
                           @RequestParam("Password1") String password1,
                           Model model){
        User user = userService.queryUserByName(name);
        if(user != null){
            model.addAttribute("msg","用户已存在");
            return "addUser";
        }
        if(!password0.equals(password1)){
            model.addAttribute("msg","密码不一致");
            return "addUser";
        }

        if(name == "" || name == null || password0 == "" || password0 == null){
            model.addAttribute("msg","用户名或者密码为空");
            return "addUser";
        }

        int i = userService.addUser(name,password0);
        if(i == 1){
            model.addAttribute("msg","用户注册成功");
        }else {
            model.addAttribute("msg","用户注册失败");
        }
        return "addUser";
    }

}
