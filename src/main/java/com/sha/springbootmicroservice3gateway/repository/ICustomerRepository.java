package com.sha.springbootmicroservice3gateway.repository;


import com.sha.springbootmicroservice3gateway.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //jpa repo implementasyonu
public interface ICustomerRepository extends JpaRepository<Customer, Long> {

    //all CRUD database methods
    List<Customer> findAllById(Long id);




}
