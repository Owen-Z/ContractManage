package com.example.contractmanagementsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private int num;
    private String name;
    private String address;
    private String tel;
    private String fax;
    private String code;
    private String bank;
    private String account;
    private String del;
}
