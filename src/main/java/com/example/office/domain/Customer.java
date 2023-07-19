package com.example.office.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
    @JoinColumn(name = "office_ID")
    private Office officeID;
    @OneToMany(mappedBy = "customerID", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Loan> loans;
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

