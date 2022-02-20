package com.example.contractmanagementsystem.mapper;

import com.example.contractmanagementsystem.pojo.Contract;
import com.example.contractmanagementsystem.pojo.ContractProcess;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
@Mapper
public interface ContractMapper {

    int addContract( String name, String customer, Date beginTime,
                     Date endTime, String content, String userName, String del);

    List<Contract> getAllContract();

    Contract queryContractByName(String name);

    Contract queryContractByNum(int num);

    int updateContract(String name, String customer, Date beginTime,
                       Date endTime, String content, String userName, String del);

    int deleteContract(String name);

    Contract getSignList(String name);


    List<Contract> getFinish(String userName);
    List<Contract> getApprove(String userName);
    List<Contract> getFinal(String userName);
    List<Contract> getSign(String userName);

}
