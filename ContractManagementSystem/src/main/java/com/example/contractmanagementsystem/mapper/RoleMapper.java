package com.example.contractmanagementsystem.mapper;

import com.example.contractmanagementsystem.pojo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface RoleMapper {

    int addRole(String name, String functions, String del);

    Role queryRole(String name);

    List<Role> getAllRole();

    int updateRole(String name, String functions, String del);

    int deleteRole(String name);

}
