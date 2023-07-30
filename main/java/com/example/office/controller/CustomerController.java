package com.example.office.controller;

import com.example.office.domain.*;
import com.example.office.service.CustomerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.naming.Name;
import java.util.List;

@RestController
@AllArgsConstructor
@Validated
public class CustomerController {
   private final CustomerService customerService;
    @GetMapping("/retrieveAllCustomers")
    public List<Customer> retrieveAllCustomers() {
       return customerService.retrieveAllCustomers();
    }
    @GetMapping("/retrieveCustomerById/{id}")
    public Customer retrieveCustomerById(@PathVariable("id") Long id){
        return customerService.retrieveCustomerById(id);
    }
    @PutMapping("/updateCustomer")
    public Customer updateCustomer(@RequestParam Long id, @RequestBody CustomerDTO customerDTO){
        return customerService.updateCustomer(id, customerDTO);
    }
    @DeleteMapping("/deleteCustomer/{id}")
    public void deleteCustomer(@PathVariable("id") Long id) {
        customerService.deleteCustomer(id);
    }
    @PostMapping("/createCustomer")
    public Customer createCustomer(@Valid @RequestBody CustomerDTO customerDTO){
        return customerService.createCustomer(customerDTO);
    }
    @DeleteMapping("/deleteAllCustomers")
    public void deleteAllCustomers(){
        customerService.deleteAllCustomers();
    }
}
