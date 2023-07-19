package com.example.office.service;

import com.example.office.domain.*;
import com.example.office.exception.GlobalException;
import com.example.office.exception.NotFoundException;
import com.example.office.repo.CustomerRepo;
import com.example.office.repo.LoanRepo;
import com.example.office.repo.OfficeRepo;
import com.example.office.repo.ProductRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class LoanService {
    final LoanRepo loanRepo;
    private final CustomerRepo customerRepo;
    private final ProductRepo productRepo;

    public List<Loan> retrieveAllLoans() {
        return loanRepo.findAll();
    }
    public Loan retrieveLoanById(Long id) {
        return loanRepo.findById(id).orElseThrow(
                () -> new NotFoundException(
                        "NO USER PRESENT WITH ID = " + id));
    }
    public Loan createLoan(LoanDTO loanDTO) {
        Product product = productRepo.findById(loanDTO.getProductID()).orElseThrow(
                () -> new NotFoundException("Product Not Found"));
        Customer customer = customerRepo.findById(loanDTO.getCustomerID()).orElseThrow(
                () -> new NotFoundException("Customer Not Found"));
        if ((loanDTO.getRepayment() > product.getNoRepaymentMin() && loanDTO.getRepayment() < product.getNoRepaymentMax())
                && (loanDTO.getPrinciple() > product.getPrincipalMin() && loanDTO.getPrinciple() < product.getPrincipalMax())) {
            return loanRepo.save(Loan.createLoan(loanDTO, customer, product));
        }
        else throw new GlobalException("Loan out of bounds");
    }
    public Loan updateLoan (Long id, LoanDTO loanDTO) {
        Loan loan = loanRepo.findById(id).orElseThrow(
                () -> new NotFoundException(
                        "NO LOAN PRESENT WITH ID = " + id));
        Product product = productRepo.findById(loanDTO.getProductID()).orElseThrow(
                () -> new NotFoundException("Product Not Found"));
        Customer customer = customerRepo.findById(loanDTO.getCustomerID()).orElseThrow(
                () -> new NotFoundException("Customer Not Found"));
        if ((loanDTO.getRepayment() > product.getNoRepaymentMin() && loanDTO.getRepayment() < product.getNoRepaymentMax())
                && (loanDTO.getPrinciple() > product.getPrincipalMin() && loanDTO.getPrinciple() < product.getPrincipalMax())) {
            return loanRepo.save(Loan.updateLoan(loanDTO, loan, customer, product));
        }
        else throw new GlobalException("Loan out of bounds");
    }
    public void deleteLoan (Long id){
        loanRepo.deleteById(id);
    }
}
