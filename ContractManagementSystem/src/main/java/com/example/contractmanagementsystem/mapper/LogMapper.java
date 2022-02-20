package com.example.contractmanagementsystem.mapper;

import com.example.contractmanagementsystem.pojo.Log;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@Mapper
public interface LogMapper {

    int addLog(String userName, String content, Date time);

    Log queryLogById(int lid);

    List<Log> getAllLog();

    int updateLog(int lid, String userName, String content, Date time);

    int deleteLog(int lid);


}
