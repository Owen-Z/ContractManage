package com.example.contractmanagementsystem.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.contractmanagementsystem.service.ContractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/goods")
public class testController {
    @Autowired
    ContractServiceImpl contractService;

    @RequestMapping(value = "/querySign", method = RequestMethod.GET)
    public JSONObject getSignList(@RequestParam("page") int pageNum, @RequestParam("limit") int pageSize, HttpSession session){
        return contractService.getSign(pageNum, pageSize, (String)session.getAttribute("LoginUser"));
    }

    @RequestMapping(value = "/queryFinal", method = RequestMethod.GET)
    public JSONObject getFinalList(@RequestParam("page") int pageNum, @RequestParam("limit") int pageSize, HttpSession session){
        return contractService.getFinal(pageNum, pageSize, (String)session.getAttribute("LoginUser"));
    }

    @RequestMapping(value = "/queryApprove", method = RequestMethod.GET)
    public JSONObject getApproveList(@RequestParam("page") int pageNum, @RequestParam("limit") int pageSize, HttpSession session){
        return contractService.getApprove(pageNum, pageSize, (String)session.getAttribute("LoginUser"));
    }

    @RequestMapping(value = "/queryFinish", method = RequestMethod.GET)
    public JSONObject getFinishList(@RequestParam("page") int pageNum, @RequestParam("limit") int pageSize, HttpSession session){
        return contractService.getFinish(pageNum, pageSize, (String)session.getAttribute("LoginUser"));
    }
}
