package com.example.contractmanagementsystem.controller;

import com.example.contractmanagementsystem.pojo.User;
import com.example.contractmanagementsystem.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    UserServiceImpl userService;



    @RequestMapping("/login/check")
    public String login(@RequestParam("UserName") String name,
                        @RequestParam("Password") String password,
                        Model model, HttpSession session){
        User user = userService.queryUserByName(name);
        if(user == null){
            model.addAttribute("msg","用户不存在");
            return "login";
        }
        if(password.equals(user.getPassword())){
            session.setAttribute("LoginUser",name);
            return "index";
        }
        model.addAttribute("msg","密码错误");
        return "login";
    }

}
