package com.example.contractmanagementsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contract {
    private int num;
    private String name;
    private String customer;
    private Date beginTime;
    private Date endTime;
    private String content;
    private String userName;
    private String del;
}
