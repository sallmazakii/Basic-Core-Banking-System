package com.example.office.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Calendar;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Builder
@Table(name= "s_PaymentSchedule")
public class PaymentSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column
    Double amount;
    @Column
    Integer installments;
    @Column
    Date installmentdate;
    @ManyToOne
    @JoinColumn(name = "loan_id")
    @JsonIgnore
    private Loan loanID;
    public static PaymentSchedule createPaymentSchedule (Double amount, Integer installments, Loan loan){
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        cal.add(Calendar.MONTH, installments+1);
        Date installmentDate = cal.getTime();
        return PaymentSchedule.builder()
                .amount(amount)
                .installments(installments+1)
                .installmentdate(installmentDate)
                .loanID(loan)
                .build();

    }
}
