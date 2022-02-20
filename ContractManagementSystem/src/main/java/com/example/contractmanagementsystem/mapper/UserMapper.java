package com.example.contractmanagementsystem.mapper;

import com.example.contractmanagementsystem.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {

    User queryUserByName(String name);

    int addUser(String name,String password);

    List<User> getAllUser();

    int updateUser(String name, String password);

    int deleteUser(String name);

    List<User> getAllUserByRight(int i);

}
