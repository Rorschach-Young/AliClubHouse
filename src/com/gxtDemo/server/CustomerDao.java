package com.gxtDemo.server;

import com.gxtDemo.server.model.Customer;

import java.util.List;

public interface CustomerDao {
    Customer save(Customer customer);
    void deleteByPrimarykey(List<Integer> ids);
    void updateByPrimaryKey(Customer customer);
    List<Customer> listByCustomerOr(Customer customer);
}
