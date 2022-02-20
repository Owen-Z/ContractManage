package com.example.contractmanagementsystem.config;

import com.example.contractmanagementsystem.mapper.RightMapper;
import com.example.contractmanagementsystem.mapper.RoleMapper;
import com.example.contractmanagementsystem.mapper.UserMapper;
import com.example.contractmanagementsystem.pojo.Right;
import com.example.contractmanagementsystem.pojo.Role;
import com.example.contractmanagementsystem.pojo.User;
import com.example.contractmanagementsystem.service.RightServiceImpl;
import com.example.contractmanagementsystem.service.RoleServiceImpl;
import com.example.contractmanagementsystem.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object Handler) throws Exception{
        Object loginUser = request.getSession().getAttribute("LoginUser");
        if(loginUser == null){
            request.setAttribute("msg","没有权限，请登录");
            request.getRequestDispatcher("/").forward(request,response);
            return false;
        }
        return true;
    }

}
