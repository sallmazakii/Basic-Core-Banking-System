package com.example.office.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO {
    @NotBlank(message = "Must provide name.")
    private String name;
    @NotNull(message = "Must provide min repayment.")
    private Long noRepaymentMin;
    @NotNull(message = "Must provide max repayment.")
    private Long noRepaymentMax;
    @NotNull(message = "Must provide min principal.")
    private Long principalMin;
    @NotNull(message = "Must provide max principal.")
    private Long principalMax;
    @NotNull(message = "Must provide commission.")
    private Long commission;
    @NotNull(message = "Must provide fees.")
    private Long fees;
}
