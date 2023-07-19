package com.example.office.controller;

import com.example.office.domain.*;
import com.example.office.service.LoanService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Validated
public class LoanController {
    private final LoanService loanService;
    @GetMapping("/retrieveAllLoans")
    public List<Loan> retrieveAllLoans() {
        return loanService.retrieveAllLoans();
    }
    @GetMapping("/retrieveLoanById/{id}")
    public Loan retrieveLoanById(@PathVariable("id") Long id){
        return loanService.retrieveLoanById(id);
    }
    @PostMapping("/createLoan")
    public Loan createLoan(@Valid @RequestBody LoanDTO loanDTO){
        return loanService.createLoan(loanDTO);
    }
    @PutMapping("/updateLoan")
    public Loan updateLoan(@RequestParam Long id, @RequestBody LoanDTO loanDTO){
        return loanService.updateLoan(id, loanDTO);
    }
    @DeleteMapping("/deleteLoan/{id}")
    public void deleteLoan(@PathVariable("id") Long id) {
        loanService.deleteLoan(id);
    }
}
