package com.example.contractmanagementsystem.service;

import com.example.contractmanagementsystem.pojo.Right;

import java.util.List;

public interface RightService {

    int addRight(String userName, String roleName, String del);

    Right queryRight(String userName);

    List<Right> getAllRight();

    int updateRight(String userName, String roleName, String del);

    int deleteRight(String userName);

}
