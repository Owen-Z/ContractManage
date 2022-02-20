package com.example.contractmanagementsystem.service;

import com.example.contractmanagementsystem.mapper.ContractStateMapper;
import com.example.contractmanagementsystem.pojo.ContractState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("ContractStateService")
public class ContractStateServiceImpl implements ContractStateService{
    @Autowired
    ContractStateMapper contractStateMapper;

    @Override
    public int addContractState(String conName, int type, Date time) {
        try {
            contractStateMapper.addContractState(conName, type, time);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public int updateContractState(String conName, int type, Date time) {
        try {
            contractStateMapper.updateContractState(conName, type, time);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    @Override
    public ContractState queryContractStateByConName(String conName) {
        return contractStateMapper.queryContractStateByConName(conName);
    }

    @Override
    public List<ContractState> getAllContractState() {
        return contractStateMapper.getAllContractState();
    }

    @Override
    public int deleteContractState(String conName) {
        try {
            contractStateMapper.deleteContractState(conName);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

}
