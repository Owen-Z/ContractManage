package com.example.contractmanagementsystem.controller;

import com.example.contractmanagementsystem.pojo.Customer;
import com.example.contractmanagementsystem.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController {

    @Autowired
    CustomerServiceImpl customerService;

    @RequestMapping("/addCustomer/add")
    public String test(@RequestParam("name") String name,
                       @RequestParam("address") String address,
                       @RequestParam("tel") String tel,
                       @RequestParam("fax") String fax,
                       @RequestParam("code") String code,
                       @RequestParam("bank") String bank,
                       @RequestParam("account") String account,
                       @RequestParam("del") String del,
                       Model model){
        Customer customer = customerService.queryCustomerByName(name);
        if(customer != null){
            model.addAttribute("msg","用户已存在");
            return "addCustomer";
        }
        if (name == "" || name == null){
            model.addAttribute("msg","客户名不能为空");
            return "addCustomer";
        }
        if (address == "" || address == null){
            model.addAttribute("msg","地址不能为空");
            return "addCustomer";
        }
        if (tel == "" || tel == null){
            model.addAttribute("msg","电话不能为空");
            return "addCustomer";
        }
        int i = customerService.addCustomer(name, address, tel, fax, code, bank, account, del);
        if(i == 0) {
            model.addAttribute("msg", "增加用户失败");
        }else {
            model.addAttribute("msg", "增加用户成功");
        }
        return "addCustomer";
    }

}
