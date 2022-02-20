package com.example.contractmanagementsystem.mapper;

import com.example.contractmanagementsystem.pojo.Log;
import com.example.contractmanagementsystem.pojo.Right;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@Mapper
public interface RightMapper {

    int addRight(String userName, String roleName, String del);

    Right queryRight(String userName);

    List<Right> getAllRight();

    int updateRight(String userName, String roleName, String del);

    int deleteRight(String userName);

}
