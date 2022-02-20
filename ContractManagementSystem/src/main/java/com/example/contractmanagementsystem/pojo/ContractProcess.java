package com.example.contractmanagementsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContractProcess {
    private int conNum;
    private int type;
    private int state;
    private String userName;
    private String content;
    private Date time;
}
