package com.example.office.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OfficeDTO {
    @NotBlank(message = "Must provide name.")
    private String name;
}
