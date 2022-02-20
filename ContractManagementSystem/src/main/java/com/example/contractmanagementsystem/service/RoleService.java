package com.example.contractmanagementsystem.service;

import com.example.contractmanagementsystem.pojo.Role;

import java.util.List;

public interface RoleService {
    int addRole(String name, String functions, String del);

    Role queryRole(String name);

    List<Role> getAllRole();

    int updateRole(String name, String functions, String del);

    int deleteRole(String name);
}
