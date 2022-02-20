package com.example.contractmanagementsystem.service;

import com.example.contractmanagementsystem.pojo.Customer;

import java.util.List;

public interface CustomerService {

    Customer queryCustomerByName(String name);

    int addCustomer(String name, String address, String tel,
                           String fax, String code, String bank, String account, String del);

    List<Customer> getAllCustomer();

    int updateCustomer(String name, String address, String tel, String fax,
                       String code, String bank, String account, String del);

    int deleteCustomer(String name);


}
