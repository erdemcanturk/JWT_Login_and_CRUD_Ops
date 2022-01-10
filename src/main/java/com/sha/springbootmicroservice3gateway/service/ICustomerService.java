package com.sha.springbootmicroservice3gateway.service;


import com.google.gson.JsonElement;
import com.sha.springbootmicroservice3gateway.model.Customer;

import java.util.List;
import java.util.Optional;


public interface ICustomerService  {


    Customer saveCustomer(Customer customer);

    void deleteCustomer(Long id);


   // List<Customer> findAllCustomer(Long id);

    List<JsonElement> findAllCustomer();

    Optional<Customer> findById(Long id);
}
