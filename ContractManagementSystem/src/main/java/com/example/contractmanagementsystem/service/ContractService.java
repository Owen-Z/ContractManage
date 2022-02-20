package com.example.contractmanagementsystem.service;


import com.alibaba.fastjson.JSONObject;
import com.example.contractmanagementsystem.pojo.Contract;

import java.util.Date;
import java.util.List;

public interface ContractService {

    JSONObject getFinish(int pageNum, int pageSize, String userName);

    JSONObject getApprove(int pageNum, int pageSize, String userName);

    JSONObject getFinal(int pageNum, int pageSize, String userName);

    JSONObject getSign(int pageNum, int pageSize, String userName);

    int addContract(String name, String customer, Date beginTime,
                           Date endTime, String content, String userName, String del);

    List<Contract> getAllContract();

    Contract queryContractByName(String name);

    int updateContract(String name, String customer, Date beginTime,
                       Date endTime, String content, String userName, String del);

    int deleteContract(String name);

    Contract queryContractByNum(int num);


}
