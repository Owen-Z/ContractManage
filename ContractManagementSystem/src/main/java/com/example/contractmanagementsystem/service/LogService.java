package com.example.contractmanagementsystem.service;

import com.example.contractmanagementsystem.pojo.Log;

import java.util.Date;
import java.util.List;

public interface LogService {
    int addLog(String userName, String content, Date time);

    Log queryLogById(int lid);

    List<Log> getAllLog();

    int updateLog(int lid, String userName, String content, Date time);

    int deleteLog(int lid);
}
