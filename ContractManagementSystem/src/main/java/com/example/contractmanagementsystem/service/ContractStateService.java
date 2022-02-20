package com.example.contractmanagementsystem.service;

import com.example.contractmanagementsystem.pojo.ContractState;

import java.util.Date;
import java.util.List;

public interface ContractStateService {

    int addContractState(String conName, int type, Date time);

    int updateContractState(String conName, int type, Date time);

    ContractState queryContractStateByConName(String conName);

    List<ContractState> getAllContractState();

    int deleteContractState(String conName);

}
