package com.example.office.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO {
    @NotBlank(message = "Must provide name.")
    private String name;
    @NotNull(message = "Must provide National ID Number.")
    private Long nationalID;
    @NotNull(message = "Must provide Office ID.")
    private Long officeID;

}
