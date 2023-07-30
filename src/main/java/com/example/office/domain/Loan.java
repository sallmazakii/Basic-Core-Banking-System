package com.example.office.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Builder
@Table(name= "s_Loan")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    @NotNull
    private Long repayment;
    @Column
    private Long principle;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customerID;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product productID;
    @Column
    private Long statusID;
    @OneToMany(mappedBy = "loanID", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<LoanWorkflow> flow;
    @OneToMany(mappedBy = "loanID", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<PaymentSchedule> schedule;

    public static Loan createLoan (LoanDTO loanDTO ,Customer customer, Product product){
        return Loan.builder()
                .repayment(loanDTO.getRepayment())
                .principle(loanDTO.getPrinciple())
                .customerID(customer)
                .productID(product)
                .statusID(100L)
                .build();
    }
    public static Loan updateLoan (LoanDTO loanDTO, Loan loan, Customer customer , Product product) {
        loan.setRepayment(loanDTO.getRepayment());
        loan.setPrinciple(loanDTO.getPrinciple());
        loan.setCustomerID(customer);
        loan.setProductID(product);
        loan.setStatusID(loanDTO.getStatusID());
        return loan;
    }

}
