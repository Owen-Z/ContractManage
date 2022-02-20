package com.example.contractmanagementsystem.service;

import com.example.contractmanagementsystem.mapper.RightMapper;
import com.example.contractmanagementsystem.pojo.Right;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("RightService")
public class RightServiceImpl implements RightService{

    @Autowired
    RightMapper rightMapper;

    @Override
    public int addRight(String userName, String roleName, String del) {
        try {
            rightMapper.addRight(userName, roleName, del);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    @Override
    public Right queryRight(String userName) {
        return rightMapper.queryRight(userName);
    }

    @Override
    public List<Right> getAllRight() {
        return rightMapper.getAllRight();
    }

    @Override
    public int updateRight(String userName, String roleName, String del) {
        try {
            rightMapper.updateRight(userName, roleName, del);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    @Override
    public int deleteRight(String userName) {
        try {
            rightMapper.deleteRight(userName);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }
}
