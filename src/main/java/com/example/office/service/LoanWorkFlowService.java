package com.example.office.service;

import com.example.office.domain.*;
import com.example.office.exception.GlobalException;
import com.example.office.exception.NotFoundException;
import com.example.office.repo.LoanRepo;
import com.example.office.repo.LoanWorkflowRepo;
import com.example.office.repo.PaymentScheduleRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class LoanWorkFlowService {
    final LoanWorkflowRepo loanWorkflowRepo;
    final LoanRepo loanRepo;
    final PaymentScheduleRepo paymentScheduleRepo;
    @Transactional
    public void firstApprove (LoanWorkflowDTO workflowDTO) {
        Loan loan = loanRepo.findById(workflowDTO.getLoanID())
                .orElseThrow(() -> new NotFoundException("Loan Not Found"));
        if (!(LoanStatus.CREATED.getValue().equals(loan.getStatusID()))){
            throw new GlobalException("Loan status is not eligible for first approval");
        }
        else {
            loanRepo.updateLoanStatus(loan.getId(), LoanStatus.FIRSTAPPROVE.getValue());
            LoanWorkflow loanWorkflow = LoanWorkflow.createLoanWorkflow(workflowDTO, loan);
            loanWorkflow.setComments(loanWorkflow.getComments());
            loanWorkflowRepo.save(loanWorkflow);
        }
    }
    @Transactional
    public void secondApprove(LoanWorkflowDTO workflowDTO) {
        Loan loan = loanRepo.findById(workflowDTO.getLoanID())
                .orElseThrow(() -> new NotFoundException("Loan Not Found"));
        if (!(LoanStatus.FIRSTAPPROVE.getValue().equals(loan.getStatusID()))) {
            throw new GlobalException("Loan status is not eligible for second approval");
        }
        else{
            loanRepo.updateLoanStatus(loan.getId(), LoanStatus.SECONDAPPROVE.getValue());
            LoanWorkflow loanWorkflow = LoanWorkflow.createLoanWorkflow(workflowDTO, loan);
            loanWorkflow.setComments(loanWorkflow.getComments());
            loanWorkflowRepo.save(loanWorkflow);
        }
    }
    @Transactional
    public void thirdApprove(LoanWorkflowDTO workflowDTO) {
        Loan loan = loanRepo.findById(workflowDTO.getLoanID())
                .orElseThrow(() -> new NotFoundException("Loan Not Found"));
        if (!(LoanStatus.SECONDAPPROVE.getValue().equals(loan.getStatusID()))){
            throw new GlobalException("Loan status is not eligible for third approval");
        }
        else {
            loanRepo.updateLoanStatus(loan.getId(), LoanStatus.THIRDAPPROVE.getValue());
            LoanWorkflow loanWorkflow = LoanWorkflow.createLoanWorkflow(workflowDTO, loan);
            loanWorkflow.setComments(loanWorkflow.getComments());
            loanWorkflowRepo.save(loanWorkflow);
        }
    }
    @Transactional
    public void secondReject(LoanWorkflowDTO workflowDTO) {
        Loan loan = loanRepo.findById(workflowDTO.getLoanID())
                .orElseThrow(() -> new NotFoundException("Loan Not Found"));
        if (!(LoanStatus.FIRSTAPPROVE.getValue().equals(loan.getStatusID()))) {
            throw new GlobalException("Loan status is not eligible for second approval");
        }
        else{
            loanRepo.updateLoanStatus(loan.getId(), LoanStatus.CREATED.getValue());
            LoanWorkflow loanWorkflow = LoanWorkflow.createLoanWorkflow(workflowDTO, loan);
            loanWorkflow.setComments(loanWorkflow.getComments());
            loanWorkflowRepo.save(loanWorkflow);
        }
    }
    @Transactional
    public void thirdReject(LoanWorkflowDTO workflowDTO) {
        Loan loan = loanRepo.findById(workflowDTO.getLoanID())
                .orElseThrow(() -> new NotFoundException("Loan Not Found"));
        if (!(LoanStatus.SECONDAPPROVE.getValue().equals(loan.getStatusID()))){
            throw new GlobalException("Loan status is not eligible for third approval");
        }
        else {
            loanRepo.updateLoanStatus(loan.getId(), LoanStatus.SECONDAPPROVE.getValue());
            LoanWorkflow loanWorkflow = LoanWorkflow.createLoanWorkflow(workflowDTO, loan);
            loanWorkflow.setComments(loanWorkflow.getComments());
            loanWorkflowRepo.save(loanWorkflow);
        }
    }
    @Transactional
    public  List< PaymentSchedule> issuance (Long loanID){
        Loan loan = loanRepo.findById(loanID)
                .orElseThrow(() -> new NotFoundException("Loan Not Found"));
        if (!(LoanStatus.THIRDAPPROVE.getValue().equals(loan.getStatusID()))){
            throw new GlobalException("Loan status is not eligible for third approval");
        }
        else {
            loanRepo.updateLoanStatus(loan.getId(), LoanStatus.ISSUANCE.getValue());
            Long numOfRepayment = loan.getRepayment();
            Double installmentAmount = (double) (loan.getPrinciple()/numOfRepayment);
            List< PaymentSchedule> paymentScheduleList = new ArrayList<>();
            for (int i = 0; i < numOfRepayment ; i++) {
                PaymentSchedule paymentSchedule = PaymentSchedule.createPaymentSchedule(installmentAmount, i, loan);
                paymentScheduleList.add(paymentSchedule);
            }
           return paymentScheduleRepo.saveAll(paymentScheduleList);

        }
    }
}






