package com.sha.springbootmicroservice3gateway.controller;

import com.sha.springbootmicroservice3gateway.excepiton.ResourceNotFoundException;
import com.sha.springbootmicroservice3gateway.model.Customer;
import com.sha.springbootmicroservice3gateway.repository.ICustomerRepository;
import com.sha.springbootmicroservice3gateway.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("api/v1/customers") // pre-path`imiz
public class CustomerController {

    private static Logger logger = Logger.getLogger((CustomerController.class).getName());


    @Autowired
    private ICustomerRepository customerRepository;
    @Autowired
    private ICustomerService customerService;

    @GetMapping
    public List<Customer> getAllCustomersA() {
        logger.log(Level.WARNING, "Musteri listesi cagirildi");
        return customerRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> saveCustomer(@RequestBody Customer customer) {
        logger.log(Level.FINE, "Musteri kaydi basarili");
        return new ResponseEntity<>(customerService.saveCustomer(customer), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        logger.log(Level.FINE, "Musteri silme islemi yapildi");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Customer> findById(@PathVariable long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Musteri Bulunamadi" + id));
        logger.log(Level.WARNING, "Musteri aramasi basarili");
        return ResponseEntity.ok(customer);
    }

    @PutMapping("{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customerDetail) {
        Customer updateCustomer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Musteri bulunamadi: " + id));
        updateCustomer.setFirstName(customerDetail.getFirstName());
        updateCustomer.setLastName(customerDetail.getLastName());
        updateCustomer.setPhoneNum(customerDetail.getPhoneNum());
        updateCustomer.setCustMail(customerDetail.getCustMail());
        updateCustomer.setStreet(customerDetail.getStreet());

        customerRepository.save(updateCustomer);
        logger.log(Level.WARNING, "Musteri detaylari duzenlendi");

        return ResponseEntity.ok(updateCustomer);
    }
}
