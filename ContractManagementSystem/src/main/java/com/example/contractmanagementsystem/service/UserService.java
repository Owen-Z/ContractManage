package com.example.contractmanagementsystem.service;


import com.example.contractmanagementsystem.pojo.User;

import java.util.List;

public interface UserService {
    User queryUserByName(String name);

    int addUser(String name,String password);

    List<User> getAllUser();

    int updateUser(String name, String password);

    int deleteUser(String name);

    List<User> getAllUserByRight(int i);

}
