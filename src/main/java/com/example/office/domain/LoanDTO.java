package com.example.office.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoanDTO {
    @NotNull(message = "Must provide Repayment Number.")
    private Long repayment;
    @NotNull(message = "Must provide Principle Number.")
    private Long principle;
    @NotNull(message = "Must provide Customer ID.")
    private Long customerID;
    @NotNull(message = "Must provide Product ID.")
    private Long productID;
    @NotNull(message = "Must provide Status ID.")
    private Long statusID;

}
