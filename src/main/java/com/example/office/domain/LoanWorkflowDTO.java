package com.example.office.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoanWorkflowDTO {
    @NotBlank(message = "Must provide comment.")
    private String comments;
    @NotNull(message = "Must provide Loan ID")
    private Long loanID;
}
