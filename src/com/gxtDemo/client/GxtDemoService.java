package com.gxtDemo.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.gxtDemo.client.dto.*;
import com.gxtDemo.client.model.Customer;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;

import java.util.List;

@RemoteServiceRelativePath("GxtDemoService")
public interface GxtDemoService extends RemoteService {
    SaveCustomerDTO saveCustomer(SaveCustomer request);
    String deleteCustomer(DeleteCustomer request);
    String updateCustomer(UpdateCustomer request);
    List<QueryCustomerDTO> listCustomer(QueryCustomer request);
//    PagingLoadResult<Customer> getCustomer(PagingLoadConfig config,QueryCustomerDTO request);

    /**
     * Utility/Convenience class.
     * Use GxtDemoService.App.getInstance() to access static instance of GxtDemoServiceAsync
     */
    public static class App {
        private static GxtDemoServiceAsync ourInstance = GWT.create(GxtDemoService.class);
        public static synchronized GxtDemoServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
