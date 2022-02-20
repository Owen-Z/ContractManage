package com.example.contractmanagementsystem.service;

import com.example.contractmanagementsystem.mapper.LogMapper;
import com.example.contractmanagementsystem.pojo.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("LogService")
public class LogServiceImpl implements LogService{

    @Autowired
    LogMapper logMapper;

    @Override
    public int addLog(String userName, String content, Date time) {
        try{
            logMapper.addLog(userName, content, time);
        }catch (Exception e){
            return 0;
        }
        return 1;
    }

    @Override
    public Log queryLogById(int lid) {
        return logMapper.queryLogById(lid);
    }

    @Override
    public List<Log> getAllLog() {
        return logMapper.getAllLog();
    }

    @Override
    public int updateLog(int lid, String userName, String content, Date time) {
        try{
            logMapper.updateLog(lid, userName, content, time);
        }catch (Exception e){
            return 0;
        }
        return 1;
    }

    @Override
    public int deleteLog(int lid) {
        try{
            logMapper.deleteLog(lid);
        }catch (Exception e){
            return 0;
        }
        return 1;
    }

}
