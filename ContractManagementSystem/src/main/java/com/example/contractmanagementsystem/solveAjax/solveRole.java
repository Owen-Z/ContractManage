package com.example.contractmanagementsystem.solveAjax;

import com.example.contractmanagementsystem.pojo.Role;
import com.example.contractmanagementsystem.service.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class solveRole {

    @Autowired
    RoleServiceImpl roleService;

    @PostMapping("/sear_roleInit")
    @ResponseBody
    public List<Role> sear_role_init()
    {
        System.out.println(roleService.getAllRole());
        return roleService.getAllRole();
    }
}
