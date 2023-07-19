package com.example.office.service;

import com.example.office.domain.Loan;
import com.example.office.domain.LoanStatus;
import com.example.office.domain.LoanWorkflow;
import com.example.office.domain.LoanWorkflowDTO;
import com.example.office.exception.GlobalException;
import com.example.office.exception.NotFoundException;
import com.example.office.repo.CustomerRepo;
import com.example.office.repo.LoanRepo;
import com.example.office.repo.LoanWorkflowRepo;
import com.example.office.repo.ProductRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class LoanWorkflowService {
    final LoanWorkflowRepo loanWorkflowRepo;
    private final LoanRepo loanRepo;
    @Transactional
    public void firstApprove(LoanWorkflowDTO workflowDTO) {
        Loan loan = loanRepo.findById(workflowDTO.getLoanID())
                .orElseThrow(() -> new NotFoundException("Loan Not Found"));

        if (!Objects.equals(loan.getStatusID(), LoanStatus.FIRSTAPPROVE.getValue())) {
            throw new GlobalException("Loan status is not eligible for first approval");
        }
        else {
            loanRepo.updateLoanStatus(loan.getId(), LoanStatus.SECONDAPPROVE.getValue());
            LoanWorkflow loanWorkflow = LoanWorkflow.createLoanWorkflow(workflowDTO, loan);
            loanWorkflow.setComments(loanWorkflow.getComments());
            loanWorkflowRepo.save(loanWorkflow);
        }
    }
    @Transactional
    public void secondApprove(LoanWorkflowDTO workflowDTO) {
        Loan loan = loanRepo.findById(workflowDTO.getLoanID())
                .orElseThrow(() -> new NotFoundException("Loan Not Found"));
        if (!Objects.equals(loan.getStatusID(), LoanStatus.SECONDAPPROVE.getValue())) {
            throw new GlobalException("Loan status is not eligible for second approval");
        }
        else{
            loanRepo.updateLoanStatus(loan.getId(), LoanStatus.THIRDAPPROVE.getValue());
            LoanWorkflow loanWorkflow = LoanWorkflow.createLoanWorkflow(workflowDTO, loan);
            loanWorkflow.setComments(loanWorkflow.getComments());
            loanWorkflowRepo.save(loanWorkflow);
        }
    }
    @Transactional
    public void thirdApprove(LoanWorkflowDTO workflowDTO) {
        Loan loan = loanRepo.findById(workflowDTO.getLoanID())
                .orElseThrow(() -> new NotFoundException("Loan Not Found"));

        if (!Objects.equals(loan.getStatusID(), LoanStatus.THIRDAPPROVE.getValue())) {
            throw new GlobalException("Loan status is not eligible for third approval");
        }
        else {
            LoanWorkflow loanWorkflow = LoanWorkflow.createLoanWorkflow(workflowDTO, loan);
            loanWorkflow.setComments(loanWorkflow.getComments());
            loanWorkflowRepo.save(loanWorkflow);
        }
    }
}
