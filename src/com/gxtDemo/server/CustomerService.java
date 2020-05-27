package com.gxtDemo.server;

import com.gxtDemo.client.dto.*;
import com.gxtDemo.server.model.Customer;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;

import java.util.List;

public interface CustomerService {
    SaveCustomerDTO saveCustomer(SaveCustomer request);
    String deleteCustomer(DeleteCustomer request);
    String updateCustomer(UpdateCustomer customer);
    List<QueryCustomerDTO> listCustomer(QueryCustomer request);
//    List<Customer> getCustomer(PagingLoadConfig loadConfig, QueryCustomer request);
}
