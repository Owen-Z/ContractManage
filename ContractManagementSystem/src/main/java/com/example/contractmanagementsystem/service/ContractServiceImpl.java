package com.example.contractmanagementsystem.service;

import com.alibaba.fastjson.JSONObject;
import com.example.contractmanagementsystem.mapper.ContractMapper;
import com.example.contractmanagementsystem.mapper.ContractProcessMapper;
import com.example.contractmanagementsystem.mapper.ContractStateMapper;
import com.example.contractmanagementsystem.mapper.CustomerMapper;
import com.example.contractmanagementsystem.pojo.Contract;
import com.example.contractmanagementsystem.pojo.ContractProcess;
import com.example.contractmanagementsystem.pojo.ContractState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service("ContractService")
public class ContractServiceImpl implements ContractService{

    @Autowired
    ContractMapper contractMapper;

    @Autowired
    ContractProcessMapper contractProcessMapper;

    @Autowired
    ContractStateMapper contractStateMapper;

    @Override
    public Contract queryContractByNum(int num) {
        return contractMapper.queryContractByNum(num);
    }


    @Override
    public JSONObject getFinish(int pageNum, int pageSize, String userName) {
        JSONObject result = new JSONObject();
        try {
            List<Contract> signList = new ArrayList<Contract>();
            List<ContractProcess> signProcessList = new ArrayList<>();
            signProcessList = contractProcessMapper.getFinish(userName);
            for(int i = (pageNum - 1)*pageSize; i < pageNum * pageSize; i++){
                signList.add(contractMapper.queryContractByNum(signProcessList.get(i).getConNum()));
            }

            result.put("code", "0");
            result.put("msg", "操作成功！");
            result.put("data", signList);
            result.put("count", signProcessList.size());
        } catch (Exception e) {
            result.put("code", "500");
            result.put("msg", "查询异常！");
        }
        return result;
    }

    @Override
    public JSONObject getApprove(int pageNum, int pageSize, String userName) {
        JSONObject result = new JSONObject();
        try {
            List<Contract> signList = new ArrayList<Contract>();
            List<ContractProcess> signProcessList = new ArrayList<>();
            signProcessList = contractProcessMapper.getApprove(userName);
            for(int i = (pageNum - 1)*pageSize; i < pageNum * pageSize; i++){
                signList.add(contractMapper.queryContractByNum(signProcessList.get(i).getConNum()));
            }

            result.put("code", "0");
            result.put("msg", "操作成功！");
            result.put("data", signList);
            result.put("count", signProcessList.size());
        } catch (Exception e) {
            result.put("code", "500");
            result.put("msg", "查询异常！");
        }
        return result;
    }

    @Override
    public JSONObject getFinal(int pageNum, int pageSize, String userName) {
        JSONObject result = new JSONObject();
        try {
            List<Contract> signList = new ArrayList<Contract>();
            List<Contract> curList = new ArrayList<Contract>();
            List<ContractState> signProcessList = new ArrayList<>();
            curList = contractMapper.getApprove(userName);
            for(int i = 0; i < curList.size();i++){
                if(contractStateMapper.getFinal(curList.get(i).getName()) != null)
                    signProcessList.add(contractStateMapper.getFinal(curList.get(i).getName()));
            }
            for (ContractState contractState:signProcessList){
                signList.add(contractMapper.queryContractByName(contractState.getConName()));
            }
            result.put("code", "0");
            result.put("msg", "操作成功！");
            result.put("data", signList);
            result.put("count", signProcessList.size());
        } catch (Exception e) {
            result.put("code", "500");
            result.put("msg", "查询异常！");
        }
        return result;
    }


    @Override
    public int addContract(String name, String customer, Date beginTime,
                           Date endTime, String content, String userName, String del){
        try {
            contractMapper.addContract(name, customer, beginTime, endTime, content, userName, del);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    @Override
    public List<Contract> getAllContract() {
        return contractMapper.getAllContract();
    }

    @Override
    public Contract queryContractByName(String name) {
        return contractMapper.queryContractByName(name);
    }

    @Override
    public int updateContract(String name, String customer, Date beginTime, Date endTime, String content, String userName, String del) {
        try {
            contractMapper.updateContract(name, customer, beginTime, endTime, content, userName, del);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    @Override
    public int deleteContract(String name) {
        try {
            contractMapper.deleteContract(name);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    @Override
    public JSONObject getSign(int pageNum, int pageSize, String userName) {
        JSONObject result = new JSONObject();
        try {
            List<Contract> signList = new ArrayList<Contract>();
            List<ContractProcess> signProcessList = new ArrayList<>();
            signProcessList = contractProcessMapper.getSign(userName);
            for(int i = (pageNum - 1)*pageSize; i < pageNum * pageSize; i++){
                signList.add(contractMapper.queryContractByNum(signProcessList.get(i).getConNum()));
            }

            result.put("code", "0");
            result.put("msg", "操作成功！");
            result.put("data", signList);
            result.put("count", signProcessList.size());
        } catch (Exception e) {
            result.put("code", "500");
            result.put("msg", "查询异常！");
        }
        return result;
    }

}
