package com.example.contractmanagementsystem.solveAjax;

import com.example.contractmanagementsystem.pojo.Log;
import com.example.contractmanagementsystem.service.LogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class solveLog {
    @Autowired
    LogServiceImpl logService;
    public solveLog(){}
    @PostMapping("/sear_logInit")
    @ResponseBody
    public List<Log> sear_log_init()
    {
        return logService.getAllLog();
    }
}
