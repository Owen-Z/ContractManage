package com.example.contractmanagementsystem.controller;

import com.example.contractmanagementsystem.pojo.User;
import com.example.contractmanagementsystem.service.ContractProcessServiceImpl;
import com.example.contractmanagementsystem.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class ContractProcessController {
    @Autowired
    ContractProcessServiceImpl contractProcessService;

    @Autowired
    UserServiceImpl userService;


    @RequestMapping("/authorize/getAll")
    public String Count(Model model){
        try {
            List<User> users0 = userService.getAllUserByRight(4);
            List<User> users1 = userService.getAllUserByRight(5);
            List<User> users2 = userService.getAllUserByRight(6);
            model.addAttribute("users0",users0);
            model.addAttribute("users1",users1);
            model.addAttribute("users2",users2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "authorize";
    }

    @PostMapping("/authorize/add0")
    @ResponseBody
    public int getUsers0(String user0, HttpSession session){
        String[] users = user0.split(",");
        if(users.length == 0)
            return 0;
        Date date = new Date();
        for (String s: users){
            int j = contractProcessService.addContractProcess(
                    Integer.parseInt((String)session.getAttribute("conN")),
                    1,0,s,"",date);
        }
        return 1;
    }

    @PostMapping("/authorize/add1")
    @ResponseBody
    public int getUsers1(String user1,HttpSession session){
        String[] users = user1.split(",");
        if(users.length == 0)
            return 0;
        Date date = new Date();
        for (String s: users){
            int j = contractProcessService.addContractProcess(
                    Integer.parseInt((String)session.getAttribute("conN")),
                    2,0,s,"",date);
        }
        return 1;
    }

    @PostMapping("/authorize/add2")
    @ResponseBody
    public int getUsers2(String user2,HttpSession session){
        String[] users = user2.split(",");
        if(users.length == 0)
            return 0;
        Date date = new Date();
        for (String s: users){
            int j = contractProcessService.addContractProcess(
                    Integer.parseInt((String)session.getAttribute("conN")),
                    3,0,s,"",date);
        }
        return 1;
    }




}
