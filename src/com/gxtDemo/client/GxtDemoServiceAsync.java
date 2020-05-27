package com.gxtDemo.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.gxtDemo.client.dto.*;
import com.gxtDemo.client.model.Customer;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;

import java.util.List;

public interface GxtDemoServiceAsync {
    void saveCustomer(SaveCustomer request, AsyncCallback<SaveCustomerDTO> async);
    void deleteCustomer(DeleteCustomer request, AsyncCallback<String> async);
    void updateCustomer(UpdateCustomer request, AsyncCallback<String> async);
    void listCustomer(QueryCustomer request, AsyncCallback<List<QueryCustomerDTO>> async);
//    void getCustomer(PagingLoadConfig config,QueryCustomer request, AsyncCallback<PagingLoadResult<Customer>> async);
}
