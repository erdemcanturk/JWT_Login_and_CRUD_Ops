package com.sha.springbootmicroservice3gateway.service;


import com.google.gson.JsonElement;
import com.sha.springbootmicroservice3gateway.model.Customer;
import com.sha.springbootmicroservice3gateway.repository.ICustomerRepository;
import com.sha.springbootmicroservice3gateway.request.ICustomerServiceRequest;
import com.sha.springbootmicroservice3gateway.util.RetrofitUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;
    @Autowired
     private     ICustomerServiceRequest customerServiceRequest;

  /* @Override
    public Customer saveCustomer(Customer customer){
        customer.setFirstName(customer.getFirstName());
        customer.setLastName(customer.getLastName());
        customer.setPhoneNum(customer.getPhoneNum());
        customer.setCustMail(customer.getCustMail());
        customer.setStreet(customer.getStreet());

        return customerRepository.save(customer);
    }*/

    public JsonElement saveCustomer(JsonElement requestBody) {
        return RetrofitUtils.executeInBlock(customerServiceRequest.saveCustomer(requestBody));
    }


    @Override
    public Customer saveCustomer(Customer customer) {
        customer.setFirstName(customer.getFirstName());
        customer.setLastName(customer.getLastName());
        customer.setPhoneNum(customer.getPhoneNum());
        customer.setCustMail(customer.getCustMail());
        customer.setStreet(customer.getStreet());

        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id){
        RetrofitUtils.executeInBlock(customerServiceRequest.deleteById(id));
    }
@Override
    public List<JsonElement> findAllCustomer(){
        return   RetrofitUtils.executeInBlock(customerServiceRequest.findAllCustomer());
    }

    @Override
    public Optional<Customer> findById(Long id) {return customerRepository.findById(id);}

    public List<JsonElement> updateCustomer() {
       return RetrofitUtils.executeInBlock(customerServiceRequest.updateCustomer());
    }



}
