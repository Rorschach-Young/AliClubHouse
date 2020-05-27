package com.gxtDemo.server;

import com.gxtDemo.client.dto.*;
import com.gxtDemo.server.model.Customer;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Transactional
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;


    @Override
    public SaveCustomerDTO saveCustomer(SaveCustomer request) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(request, customer);
        SaveCustomerDTO response = new SaveCustomerDTO();
        BeanUtils.copyProperties(customerDao.save(customer), response);
        return response;
    }

    @Override
    public String deleteCustomer(DeleteCustomer request) {
        List<Integer> ids = request.getIds();
        customerDao.deleteByPrimarykey(ids);
        return "success";
    }

    @Override
    public String updateCustomer(UpdateCustomer request) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(request, customer);
        customerDao.updateByPrimaryKey(customer);
        return "success";
    }

    @Override
    public List<QueryCustomerDTO> listCustomer(QueryCustomer request) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(request, customer);
        List<QueryCustomerDTO> response = new ArrayList<>();
        List<Customer> customerList = customerDao.listByCustomerOr(customer);
        if (customerList != null && !customerList.isEmpty()){
            for (Customer cus : customerList){
                QueryCustomerDTO customerQueryDTO = new QueryCustomerDTO();
                BeanUtils.copyProperties(cus, customerQueryDTO);
                response.add(customerQueryDTO);
            }
            return response;
        } else {
            return null;
        }
    }

//    @Override
//    public List<Customer> getCustomer(PagingLoadConfig loadConfig, QueryCustomer request) {
//        Customer customer = new Customer();
//        BeanUtils.copyProperties(request, customer);
//        List<Customer> response = new ArrayList<>();
//        List<Customer> customerList = customerDao.listByCustomerOr(customer);
//        if (customerList != null && !customerList.isEmpty()){
//            for (Customer cus : customerList){
//                response.add(cus);
//            }
//            return response;
//        } else {
//            return null;
//        }
//    }
}