package com.example.contractmanagementsystem.mapper;


import com.example.contractmanagementsystem.pojo.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@Mapper
public interface CustomerMapper {

    Customer queryCustomerByName(String name);

    int addCustomer(String name, String address, String tel, String fax,
                    String code, String bank, String account, String del);

    List<Customer> getAllCustomer();

    int updateCustomer(String name, String address, String tel, String fax,
                       String code, String bank, String account, String del);

    int deleteCustomer(String name);

}
