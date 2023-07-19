package com.example.office.domain;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Builder
@Table(name= "s_LoanWorkFlow")
public class LoanWorkflow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String comments;
    @ManyToOne
    @JoinColumn(name = "loan_id")
    private Loan loanID;
    public static LoanWorkflow createLoanWorkflow (LoanWorkflowDTO loanWorkflowDTO, Loan loan){
        return LoanWorkflow.builder()
                .comments(loanWorkflowDTO.getComments())
                .loanID(loan)
                .build();
    }

}
