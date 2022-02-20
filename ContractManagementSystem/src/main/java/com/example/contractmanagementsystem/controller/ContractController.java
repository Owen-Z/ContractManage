package com.example.contractmanagementsystem.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.contractmanagementsystem.pojo.Contract;
import com.example.contractmanagementsystem.service.ContractProcessServiceImpl;
import com.example.contractmanagementsystem.service.ContractServiceImpl;
import com.example.contractmanagementsystem.service.ContractStateServiceImpl;
import com.example.contractmanagementsystem.service.LogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class ContractController {
    @Autowired
    ContractServiceImpl contractService;

    @Autowired
    LogServiceImpl logService;

    @Autowired
    ContractProcessServiceImpl contractProcessService;

    @Autowired
    ContractStateServiceImpl contractStateService;





    @RequestMapping("/contract/getAll")
    public String getAllContract(Model model){
        model.addAttribute("msg","没有权限");
        return "contract";
    }


    @GetMapping(value = "/contract/querySign")
    public JSONObject getSignList(@RequestParam("page") int page, @RequestParam("limit") int limit,HttpSession session){
        return contractService.getSign(page, limit, (String)session.getAttribute("LoginUser"));
    }

    @PostMapping("sign/middle")
    @ResponseBody
    public int signMiddle(String contractNum, HttpSession session){
        Contract contract = contractService.queryContractByNum(Integer.parseInt(contractNum));
        session.setAttribute("contract", contract);
        return 1;
    }

    @RequestMapping("/sign/add")
    public String addSign(@RequestParam("Sign") String suggestion, HttpSession session){
        java.util.Date date = new java.util.Date();
        logService.addLog((String) session.getAttribute("LoginUser"),suggestion,date);
        contractProcessService.updateContractProcess(((Contract)session.getAttribute("contract")).getNum(),1 ,1,
                (String) session.getAttribute("LoginUser"),suggestion,date);

        if(contractProcessService.getUnChange(((Contract)session.getAttribute("contract")).getNum(), 0, 1).size() == 0){
            contractStateService.updateContractState(((Contract)session.getAttribute("contract")).getName(), 2, date);
        }
        logService.addLog((String) session.getAttribute("LoginUser"),"会签意见："+suggestion,date);
        return "index";
    }

    @RequestMapping("/final/add")
    public String addFianl(@RequestParam("Sign") String suggestion, HttpSession session){
        java.util.Date date = new java.util.Date();
        logService.addLog((String) session.getAttribute("LoginUser"),"定稿意见："+suggestion,date);
        contractStateService.updateContractState(((Contract)session.getAttribute("contract")).getName(), 3, date);
        return "index";
    }

    @RequestMapping("/approve/add")
    public String addApprove(@RequestParam("Sign") String suggestion, HttpSession session){
        java.util.Date date = new java.util.Date();
        logService.addLog((String) session.getAttribute("LoginUser"),"审批意见"+suggestion,date);
        contractProcessService.updateContractProcess(((Contract)session.getAttribute("contract")).getNum(),2 ,1,
                (String) session.getAttribute("LoginUser"),suggestion,date);
        if(contractProcessService.getUnChange(((Contract)session.getAttribute("contract")).getNum(), 0, 2).size() == 0){
            contractStateService.updateContractState(((Contract)session.getAttribute("contract")).getName(), 4, date);
        }
        return "index";
    }

    @RequestMapping("/finish/add")
    public String addFinish(@RequestParam("Sign") String suggestion, HttpSession session){
        java.util.Date date = new java.util.Date();
        logService.addLog((String) session.getAttribute("LoginUser"),"签订意见："+suggestion,date);
        contractProcessService.updateContractProcess(((Contract)session.getAttribute("contract")).getNum(),3 ,1,
                (String) session.getAttribute("LoginUser"),suggestion,date);

        if(contractProcessService.getUnChange(((Contract)session.getAttribute("contract")).getNum(), 0, 3).size() == 0){
            contractStateService.updateContractState(((Contract)session.getAttribute("contract")).getName(), 5, date);
        }
        return "index";
    }

    @RequestMapping("/contract/add")
    public String addContract(@RequestParam("name") String name,
                              @RequestParam("customer") String customer,
                              @RequestParam("beginTime") Date beginTime,
                              @RequestParam("endTime") Date endTime,
                              @RequestParam("content") String content,
                              Model model, HttpSession session){

        String userName = (String) session.getAttribute("LoginUser");
        String del = "test";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d1_temp = java.sql.Date.valueOf(beginTime.toString());
        Date d2_temp = java.sql.Date.valueOf(endTime.toString());
        if(d2_temp.before(d1_temp)){
            model.addAttribute("msg","日期选择错误");
            return "draft";
        }
        int i = contractService.addContract(name, customer, beginTime,
                endTime, content, userName, del);

        if(i == 0){
            model.addAttribute("msg","合同起草失败");
            return "draft";
        }
        model.addAttribute("msg","合同起草成功");
        java.util.Date date = new java.util.Date();
        logService.addLog("userName","起草合同:"+content,date);
        contractStateService.addContractState(name,1,date);
        return "draft";
    }

    @RequestMapping("/contract/delete")
    public String deleteContract(@RequestParam("name") String name,
                                 Model model){
        int i = contractService.deleteContract(name);
        if(i == 1){
            model.addAttribute("msg","删除成功");
        }else {
            model.addAttribute("msg","删除失败");
        }
        return "contract";
    }

    @RequestMapping("/contract/update")
    public String updateContract(@RequestParam("name") String name,
                                 @RequestParam("customer") String customer,
                                 @RequestParam("beginTime") Date beginTime,
                                 @RequestParam("endTime") Date endTime,
                                 @RequestParam("content") String content,
                                 @RequestParam("userName") String userName,
                                 @RequestParam("del") String del,
                                 Model model){
        int i = contractService.updateContract(name, customer, beginTime,
                endTime, content, userName, del);
        if(i == 1){
            model.addAttribute("msg","更新成功");
        }else {
            model.addAttribute("msg","更新失败");
        }
        return "contract";
    }


}
