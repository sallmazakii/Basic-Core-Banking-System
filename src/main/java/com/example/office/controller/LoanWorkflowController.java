package com.example.office.controller;

import com.example.office.service.LoanWorkflowService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Validated
public class LoanWorkflowController {
    private final LoanWorkflowService loanWorkflowService;
}
