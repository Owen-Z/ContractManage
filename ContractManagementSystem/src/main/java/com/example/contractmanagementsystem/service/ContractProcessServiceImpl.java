package com.example.contractmanagementsystem.service;

import com.example.contractmanagementsystem.mapper.ContractProcessMapper;
import com.example.contractmanagementsystem.pojo.ContractProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("ContractProcessService")
public class ContractProcessServiceImpl implements ContractProcessService{

    @Autowired
    ContractProcessMapper contractProcessMapper;

    @Override
    public List<ContractProcess> getUnChange(int conNum, int state, int type) {
        return contractProcessMapper.getUnChange(conNum,state,type);
    }

    @Override
    public int addContractProcess(int conNum, int type, int state, String userName, String content, Date time) {
        try{
            System.out.println(userName);
            contractProcessMapper.addContractProcess(conNum, type, state, userName, content, time);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    @Override
    public List<ContractProcess> getAllContractProcess() {
        return contractProcessMapper.getAllContractProcess();
    }

    @Override
    public ContractProcess queryContractProcess(int conNum, String userName) {
        return contractProcessMapper.queryContractProcess(conNum, userName);
    }

    @Override
    public int updateContractProcess(int conNum, int type, int state, String userName, String content, Date time) {
        try{
            contractProcessMapper.updateContractProcess(conNum, type, state, userName, content, time);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    @Override
    public int deleteContractProcess(int conNum, String userName) {
        try{
            contractProcessMapper.deleteContractProcess(conNum, userName);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

}
