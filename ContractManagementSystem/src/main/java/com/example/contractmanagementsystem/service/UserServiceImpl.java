package com.example.contractmanagementsystem.service;

import com.example.contractmanagementsystem.mapper.RightMapper;
import com.example.contractmanagementsystem.mapper.RoleMapper;
import com.example.contractmanagementsystem.mapper.UserMapper;
import com.example.contractmanagementsystem.pojo.Right;
import com.example.contractmanagementsystem.pojo.Role;
import com.example.contractmanagementsystem.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;
    @Autowired
    RightMapper rightMapper;
    @Autowired
    RoleMapper roleMapper;

    @Override
    public User queryUserByName(String name) {
        return userMapper.queryUserByName(name);
    }

    @Override
    public int addUser(String name, String password) {
        try {
            userMapper.addUser(name,password);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public int updateUser(String name, String password) {
        try {
            userMapper.updateUser(name,password);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    @Override
    public int deleteUser(String name) {
        try {
            userMapper.deleteUser(name);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    @Override
    public List<User> getAllUserByRight(int i) {
        List<User> users = new ArrayList<>();
        List<Right> list  = rightMapper.getAllRight();
        for (Right right: list){
            String name = right.getRoleName();
            Role role = roleMapper.queryRole(name);
            String functions = role.getFunctions();
            if(isRole(i,functions)){
                users.add(userMapper.queryUserByName(right.getUserName()));
            }
        }
        return users;
    }

    public boolean isRole(int i, String functions){
        String[] fun = functions.split(",");
        for (String s:fun){
            int j = Integer.parseInt(s);
            if(j == i)
                return true;
            if(j > i)
                return false;
        }
        return false;
    }

}
