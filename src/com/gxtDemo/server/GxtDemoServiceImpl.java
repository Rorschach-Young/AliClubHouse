package com.gxtDemo.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.gxtDemo.client.GxtDemoService;
import com.gxtDemo.client.dto.*;
import com.gxtDemo.client.model.Customer;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import java.util.List;


public class GxtDemoServiceImpl extends RemoteServiceServlet implements GxtDemoService {
    private ApplicationContext applicationContext;
    private CustomerService customerService;

    @Override
    public void init(ServletConfig Config) throws ServletException {
        super.init(Config);
        applicationContext = new FileSystemXmlApplicationContext("WEB-INF/spring/applicationContext.xml");
        if (applicationContext == null) {
            throw new RuntimeException("Check Your Web.Xml Setting, No Spring Context Configured");
        } else {
            customerService = applicationContext.getBean(CustomerService.class);
        }
    }


    @Override
    public SaveCustomerDTO saveCustomer(SaveCustomer request) {
        return customerService.saveCustomer(request);
    }

    @Override
    public String deleteCustomer(DeleteCustomer request) { customerService.deleteCustomer(request);return "success"; }

    @Override
    public String updateCustomer(UpdateCustomer request) {
        return customerService.updateCustomer(request);
    }

    @Override
    public List<QueryCustomerDTO> listCustomer(QueryCustomer request) {
        return customerService.listCustomer(request);
    }


//    @Override
//    public PagingLoadResult<Customer> getCustomer(PagingLoadConfig loadConfig,QueryCustomer request) {
//
//        return new PagingLoadResult<Customer>() {
//            @Override
//            public int getOffset() {
//                return loadConfig.getOffset();
//            }
//
//            @Override
//            public int getTotalLength() {
//                return 0;
//            }
//
//            @Override
//            public void setOffset(int offset) {
//
//            }
//
//            @Override
//            public void setTotalLength(int totalLength) {
//
//            }
//
//            @Override
//            public List<Customer> getData() {
//                return null;
//            }
//        };
//    }
}