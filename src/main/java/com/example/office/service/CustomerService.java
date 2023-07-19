package com.example.office.service;

import com.example.office.domain.Customer;
import com.example.office.domain.CustomerDTO;
import com.example.office.domain.Office;
import com.example.office.exception.NotFoundException;
import com.example.office.repo.CustomerRepo;
import com.example.office.repo.OfficeRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {
    final CustomerRepo customerRepo;
    private final OfficeRepo officeRepo;

    public List<Customer> retrieveAllCustomers(){
       return customerRepo.findAll();
    }
    public Customer retrieveCustomerById(Long cid){
        return customerRepo.findById(cid).orElseThrow(
                () -> new NotFoundException(
                        "NO USER PRESENT WITH ID = " + cid));
    }
    public Customer createCustomer (CustomerDTO customerDTO){
        Office office=officeRepo.findById(customerDTO.getOfficeID()).orElseThrow(
                ()->new NotFoundException("Office Not Found"));
        return customerRepo.save(Customer.createCustomer(customerDTO, office));
    }
    public Customer updateCustomer (Long cid, CustomerDTO customerDTO){
        Customer customer = customerRepo.findById(cid).orElseThrow(
                () -> new NotFoundException(
                "NO USER PRESENT WITH ID = " + cid));
        Office office=officeRepo.findById(customerDTO.getOfficeID()).orElseThrow(
                ()->new NotFoundException("Office Not Found"));
        Customer newcustomer =  Customer.updateCustomer(customerDTO, customer, office );
        return customerRepo.save(newcustomer);
    }
    public void deleteCustomer (Long cid){
        customerRepo.deleteById(cid);
    }
    public void deleteAllCustomers() {
        customerRepo.deleteAll();
    }
}
