package com.example.contractmanagementsystem;

import com.example.contractmanagementsystem.mapper.ContractMapper;
import com.example.contractmanagementsystem.mapper.RightMapper;
import com.example.contractmanagementsystem.mapper.RoleMapper;
import com.example.contractmanagementsystem.pojo.Contract;
import com.example.contractmanagementsystem.pojo.ContractState;
import com.example.contractmanagementsystem.pojo.Customer;
import com.example.contractmanagementsystem.pojo.Log;
import com.example.contractmanagementsystem.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class ContractManagementSystemApplicationTests {


    @Autowired
    CustomerServiceImpl customerService;

    @Autowired
    UserServiceImpl userService;

    @Autowired
    ContractServiceImpl contractService;

    @Autowired
    RoleServiceImpl roleService;

    @Autowired
    RightServiceImpl rightService;

    @Autowired
    ContractStateServiceImpl contractStateService;

    @Autowired
    LogServiceImpl logService;

    @Test
    void contextLoads() throws ParseException {
//        Date date = null;
//        String sDate = "2008-04-21";
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        date = sdf.parse(sDate);
//        System.out.println(logService.addLog("11","23",date));
//        Date date = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        System.out.println(sdf.format(contractService.getAllContract().get(0).getBeginTime()));

//        System.out.println(contractService.queryContractByName("123"));

//        Contract contract = contractService.queryContractByName("123");
//        System.out.println(contract);
//        System.out.println(contractService.updateContract(contract.getName(),contract.getCustomer(),contract.getBeginTime()
//                ,contract.getEndTime(),"121313",contract.getUserName(),"314124"));

//        ContractState contractState =  contractStateService.queryContractStateByConName("123");
//        System.out.println(contractStateService.updateContractState(contractState.getConName()
//        ,3,contractState.getTime()));

//        Customer customer = customerService.queryCustomerByName("customer3");
//        System.out.println(customerService.deleteCustomer("customer3"));

//        Log log = logService.queryLogById(1);
//        System.out.println(logService.addLog("test1","1313",log.getTime()));
//        System.out.println(logService.updateLog(2,"test","1241",log.getTime()));
//        System.out.println(rightService.deleteRight("test"));

//        System.out.println(roleService.deleteRole("qw"));

//        System.out.println(userService.deleteUser("12"));


    }

}
