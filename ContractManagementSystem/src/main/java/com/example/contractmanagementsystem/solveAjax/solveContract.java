package com.example.contractmanagementsystem.solveAjax;

import com.alibaba.fastjson.JSONObject;
import com.example.contractmanagementsystem.pojo.Contract;
import com.example.contractmanagementsystem.pojo.ContractProcess;
import com.example.contractmanagementsystem.pojo.ContractState;
import com.example.contractmanagementsystem.service.ContractProcessServiceImpl;
import com.example.contractmanagementsystem.service.ContractServiceImpl;
import com.example.contractmanagementsystem.service.ContractStateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class solveContract {
    @Autowired
    ContractServiceImpl contractService;

    @Autowired
    ContractStateServiceImpl contractStateService;

    @Autowired
    ContractProcessServiceImpl contractProcessService;

    public solveContract(){}
    @PostMapping("/search_conctactInit")
    @ResponseBody
    public JSONObject search_Contract()
    {
        JSONObject object = new JSONObject();
        List<ContractState> contractStateList =
                contractStateService.getAllContractState();
        for(int i = 0; i < contractStateList.size();i++){
            JSONObject object0 = new JSONObject();
            String name = contractStateList.get(i).getConName();
            Contract contract = contractService.queryContractByName(name);
            object0.put("num",contract.getNum());
            object0.put("name",contract.getName());
            object0.put("time",contractStateList.get(i).getTime());
            if(contractStateList.get(i).getType() == 1){
                object0.put("type","起草");
            }else if(contractStateList.get(i).getType() == 2){
                object0.put("type","会签完成");
            }else if(contractStateList.get(i).getType() == 3){
                object0.put("type","定稿完成");
            }else if(contractStateList.get(i).getType() == 4){
                object0.put("type","审批完成");
            }else if(contractStateList.get(i).getType() == 5){
                object0.put("type","签订完成");
            }
            String key = "key" + i;
            object.put(key,object0);
        }
        return object;
    }
}
