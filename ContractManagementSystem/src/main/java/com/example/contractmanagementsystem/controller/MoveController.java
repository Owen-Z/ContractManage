package com.example.contractmanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MoveController {
    @GetMapping("/move/sign")
    public String move_sign(Model model,HttpSession session)
    {
        System.out.println(session.getAttribute("contract"));
        model.addAttribute("contract",session.getAttribute("contract"));
        return "realSign";
    }

    @GetMapping("/move/finalize")
    public String move_finalize(Model model,HttpSession session)
    {
        System.out.println(session.getAttribute("contract"));
        model.addAttribute("contract",session.getAttribute("contract"));
        return "realFinal";
    }

    @GetMapping("/move/approve")
    public String move_approve(Model model,HttpSession session)
    {
        System.out.println(session.getAttribute("contract"));
        model.addAttribute("contract",session.getAttribute("contract"));
        return "realApprove";
    }

    @GetMapping("/move/finish")
    public String move_finish(Model model,HttpSession session)
    {
        System.out.println(session.getAttribute("contract"));
        model.addAttribute("contract",session.getAttribute("contract"));
        return "realFinish";
    }
}
