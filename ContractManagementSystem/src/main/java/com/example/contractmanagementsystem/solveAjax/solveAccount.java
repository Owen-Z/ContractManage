package com.example.contractmanagementsystem.solveAjax;

import com.example.contractmanagementsystem.pojo.Customer;
import com.example.contractmanagementsystem.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RestController
public class solveAccount {
    @Autowired
    CustomerServiceImpl customerService;

    public solveAccount(){}
    @PostMapping("/search_accountInit")
    @ResponseBody
    public List<Customer> search_accountInit()
    {
        List<Customer> customerList = customerService.getAllCustomer();
        return customerList;
    }

    @PostMapping("/authorize/find")
    @ResponseBody
    public int search_accountInit(String name, HttpSession session)
    {
        session.setAttribute("conN",name);
        return 1;
    }

}
