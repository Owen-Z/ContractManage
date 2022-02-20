package com.example.contractmanagementsystem.service;

import com.example.contractmanagementsystem.pojo.Contract;
import com.example.contractmanagementsystem.pojo.ContractProcess;

import java.util.Date;
import java.util.List;

public interface ContractProcessService {
    int addContractProcess(int conNum, int type, int state, String userName,
                           String content, Date time);

    List<ContractProcess> getAllContractProcess();

    ContractProcess queryContractProcess(int conNum, String userName);

    int updateContractProcess(int conNum, int type, int state, String userName,
                              String content, Date time);

    int deleteContractProcess(int conNum, String userName);

    List<ContractProcess> getUnChange(int conNum,int state, int type);

}
