package com.sha.springbootmicroservice3gateway.service;


import com.sha.springbootmicroservice3gateway.model.Customer;

import java.util.List;
import java.util.Optional;


public interface ICustomerService  {


    Customer saveCustomer(Customer customer);

    void deleteCustomer(Long id);


    List<Customer> findAllCustomer(Long id);

    Optional<Customer> findById(Long id);
}
