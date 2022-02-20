package com.example.contractmanagementsystem.mapper;

import com.example.contractmanagementsystem.pojo.ContractProcess;
import com.example.contractmanagementsystem.pojo.ContractState;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@Mapper
public interface ContractStateMapper {


    ContractState getFinish(String conName);
    ContractState getApprove(String conName);
    ContractState getFinal(String conName);
    ContractState getSign(String conName);

    int addContractState(String conName, int type, Date time);

    int updateContractState(String conName, int type, Date time);

    ContractState queryContractStateByConName(String conName);

    List<ContractState> getAllContractState();

    int deleteContractState(String conName);

}
