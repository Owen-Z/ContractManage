package com.example.contractmanagementsystem.mapper;

import com.example.contractmanagementsystem.pojo.Contract;
import com.example.contractmanagementsystem.pojo.ContractProcess;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@Mapper
public interface ContractProcessMapper {

    List<ContractProcess> getUnChange(int conNum,int state, int type);

    List<ContractProcess> getFinish(String userName);
    List<ContractProcess> getApprove(String userName);
    List<ContractProcess> getFinal(String userName);
    List<ContractProcess> getSign(String userName);

    int addContractProcess(int conNum, int type, int state, String userName,
                           String content, Date time);

    List<ContractProcess> getAllContractProcess();

    ContractProcess queryContractProcess(int conNum, String userName);

    int updateContractProcess(int conNum, int type, int state, String userName,
                              String content, Date time);

    int deleteContractProcess(int conNum, String userName);



}
