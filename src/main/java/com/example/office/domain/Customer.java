package com.example.office.domain;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Builder
@Table(name= "s_Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cid;
    @Column
    private String name;
    @Column
    private Long nationalID;
    @ManyToOne
    @JoinColumn(name = "office_id")
    private Office officeID;
    public static Customer createCustomer (CustomerDTO customerDTO ,Office office){
        return Customer.builder()
                .name(customerDTO.getName())
                .nationalID(customerDTO.getNationalID())
                .officeID(office)
                .build();
    }
    public static Customer updateCustomer (CustomerDTO customerDTO, Customer customer , Office office) {
        customer.setName(customerDTO.getName());
        customer.setNationalID(customerDTO.getNationalID());
        customer.setOfficeID(office);
        return customer;
    }
}

