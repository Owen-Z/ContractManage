package com.example.contractmanagementsystem.service;

import com.example.contractmanagementsystem.mapper.RoleMapper;
import com.example.contractmanagementsystem.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("RoleService")
public class RoleServiceImpl implements RoleService{
    @Autowired
    RoleMapper roleMapper;

    @Override
    public int addRole(String name, String functions, String del) {
        try {
            roleMapper.addRole(name, functions, del);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    @Override
    public Role queryRole(String name) {
        return roleMapper.queryRole(name);
    }

    @Override
    public List<Role> getAllRole() {
        return roleMapper.getAllRole();
    }

    @Override
    public int updateRole(String name, String functions, String del) {
        try {
            roleMapper.updateRole(name, functions, del);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    @Override
    public int deleteRole(String name) {
        try {
            roleMapper.deleteRole(name);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }
}
