package com.example.contractmanagementsystem.solveAjax;

import com.alibaba.fastjson.JSONObject;
import com.example.contractmanagementsystem.pojo.Right;
import com.example.contractmanagementsystem.pojo.Role;
import com.example.contractmanagementsystem.pojo.User;
import com.example.contractmanagementsystem.service.RightServiceImpl;
import com.example.contractmanagementsystem.service.RoleServiceImpl;
import com.example.contractmanagementsystem.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RestController
public class solveSearUser {
    @Autowired
    UserServiceImpl userService;

    @Autowired
    RoleServiceImpl roleService;

    @Autowired
    RightServiceImpl rightService;

    @PostMapping("/sear_userInit")
    @ResponseBody
    public JSONObject sear_user_init()
    {
        JSONObject jsonObject = new JSONObject();
        for (User user:userService.getAllUser()){
            JSONObject jsonObject0 = new JSONObject();
            jsonObject0.put("name",user.getName());
            jsonObject.put("list0",jsonObject0);
        }
        return jsonObject;
    }

    @PostMapping("/s_username")
    @ResponseBody
    public JSONObject s_username()
    {

//        int count = 1;
//        sqlSet sq = new sqlSet();
//        //查权限表
//        sqlOperatef sqlOperatef = new sqlOperatef();
//        sqlOperatef.getConnection();
//        ResultSet resultSet1 = sqlOperatef.queryDataAll("user");
//        ResultSet resultSet2 = sqlOperatef.queryDataAll("role");
//        ResultSet resultSet3 = sqlOperatef.queryDataAll("right");


        JSONObject object = new JSONObject();
        List<User> userList = userService.getAllUser();
        for(int i = 0; i < userList.size(); i++){
            JSONObject object0 = new JSONObject();
            object0.put("uid",userList.get(i).getUid());
            String name = userList.get(i).getName();
            object0.put("name",name);
            if(rightService.queryRight(name) != null){
                object0.put("role",rightService.queryRight(name).getRoleName());
            }else {
                object0.put("role","未授权");
            }
            String key = "key" + i;
            object.put(key,object0);
        }
        return object;



//        List<Role> roleList = roleService.getAllRole();
//        List<Right> rightList = rightService.getAllRight();
//
//
//
//        System.out.println("查询数据成功");
//        try {
//            while(resultSet1.next())
//            {
//                if(count == 1)
//                {
//                    sq.setInitUser_name(resultSet1.getString("name"));
////                    sq.setInitUser_permission(resultSet2.getString("name"));
////                    sq.setInitUser_nameRight(resultSet3.getString("userName"));
////                    sq.setInitUser_permissionRight(resultSet3.getString("roleName"));
//                    count ++;
//                }else {
//                    sq.setUser_name(resultSet1.getString("name"));
////                    sq.setUser_permission(resultSet2.getString("name"));
////                    sq.setUser_nameRight(resultSet3.getString("userName"));
////                    sq.setUser_permissionRight(resultSet3.getString("roleName"));
//                }
//            }
//            count = 1;
//            while(resultSet2.next())
//            {
//                if(count == 1)
//                {
////                    sq.setInitUser_name(resultSet1.getString("name"));
//                    sq.setInitUser_permission(resultSet2.getString("name"));
////                    sq.setInitUser_nameRight(resultSet3.getString("userName"));
////                    sq.setInitUser_permissionRight(resultSet3.getString("roleName"));
//                    count ++;
//                }else {
////                    sq.setUser_name(resultSet1.getString("name"));
//                    sq.setUser_permission(resultSet2.getString("name"));
//                    System.out.println("resultSet2.getString(name) = " + resultSet2.getString("name"));
////                    sq.setUser_nameRight(resultSet3.getString("userName"));
////                    sq.setUser_permissionRight(resultSet3.getString("roleName"));
//                }
//            }
//            count = 1;
//            while(resultSet3.next())
//            {
//                if(count == 1)
//                {
////                    sq.setInitUser_name(resultSet1.getString("name"));
////                    sq.setInitUser_permission(resultSet2.getString("name"));
//                    sq.setInitUser_nameRight(resultSet3.getString("userName"));
//                    System.out.println("resultSet3.getString(userName) = " + resultSet3.getString("userName"));
//                    sq.setInitUser_permissionRight(resultSet3.getString("roleName"));
//                    System.out.println("resultSet3.getString(userName) = " + resultSet3.getString("roleName"));
//                    count ++;
//                }else {
////                    sq.setUser_name(resultSet1.getString("name"));
////                    sq.setUser_permission(resultSet2.getString("name"));
//                    sq.setUser_nameRight(resultSet3.getString("userName"));
//                    System.out.println("resultSet3.getString(userName) = " + resultSet3.getString("userName"));
//                    sq.setUser_permissionRight(resultSet3.getString("roleName"));
//                    System.out.println("resultSet3.getString(userName) = " + resultSet3.getString("roleName"));
//                }
//            }
//            System.out.println(sq.getUser_permissionRight() + "||||||");
//            resultSet1.close();
//            resultSet2.close();
//            resultSet3.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return sq;
    }

    @PostMapping("/sear_userAjax")
    @ResponseBody
    public int sear_user(String USERNAME,String PERMISSION)
    {
//        //接受到前端传来的数据并添加到数据库中
//        //连接数据库
//        try{
//            sqlOperatef sqlOperatef = new sqlOperatef();
//            sqlOperatef.getConnection();
////        sqlOperatef.addData("user_login","user_name,user_password","'" + USERNAME  +"'"+ "," +"'" + PERMISSION + "'");;
////        sqlOperatef.updateDateCons("role ","functions","'" + PERMISSION + "' ", " name = " + "'" + USERNAME + "'");
////            将传过来的数据作为约束条件，查询right中是否存在，修改，若不存在，添加
//            ResultSet set =  sqlOperatef.queryDataCons("right","userName = " + USERNAME);
//            System.out.println("1111");
//            if(set.next())
//            {
//                sqlOperatef.updateDateCons("right","roleName",PERMISSION,"userName =" + USERNAME);
//                System.out.println("2222");
//            }else
//            {
//                sqlOperatef.addData("right ","userName,roleName ","'" + USERNAME + "'" + "," + "'" + PERMISSION + "'");
//                System.out.println("3333");
//            }
//            set.close();
//        }catch (Exception e)
//        {
//            e.printStackTrace();
//        }

//        String username = request.getParameter("");
//        String permission = request.getParameter("");

//        System.out.println(USERNAME + "   |   " + PERMISSION);
//
//        User user = new User();
//        user.setUsername(USERNAME);
//        user.setPassword(PERMISSION);
//        System.out.println("username" + USERNAME + "password" + PERMISSION);
//        System.out.println(user.getUsername());
        int i = rightService.addRight(USERNAME,PERMISSION,"del");
        if(i == 0){
            int j = rightService.updateRight(USERNAME,PERMISSION,"del");
            return j;
        }
        return 1;
    }

}
