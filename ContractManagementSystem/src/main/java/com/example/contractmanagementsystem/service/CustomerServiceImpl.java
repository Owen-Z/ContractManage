package com.example.contractmanagementsystem.service;

import com.example.contractmanagementsystem.mapper.CustomerMapper;
import com.example.contractmanagementsystem.pojo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerMapper customerMapper;

    @Override
    public Customer queryCustomerByName(String name) {
        return customerMapper.queryCustomerByName(name);
    }

    @Override
    public int addCustomer(String name, String address, String tel, String fax, String code, String bank, String account, String del) {
        try {
            customerMapper.addCustomer(name,address,tel,fax,code,bank,account,del);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerMapper.getAllCustomer();
    }

    @Override
    public int updateCustomer(String name, String address, String tel, String fax, String code, String bank, String account, String del) {
        try {
            customerMapper.updateCustomer(name, address, tel, fax, code, bank, account, del);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    @Override
    public int deleteCustomer(String name) {
        try {
            customerMapper.deleteCustomer(name);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }


}
