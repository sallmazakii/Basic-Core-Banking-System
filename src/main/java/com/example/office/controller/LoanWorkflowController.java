package com.example.office.controller;


import com.example.office.domain.LoanWorkflowDTO;
import com.example.office.domain.PaymentSchedule;
import com.example.office.service.LoanWorkFlowService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class LoanWorkflowController {
    private final LoanWorkFlowService loanWorkFlowService;
    @PostMapping("/firstApprove")
    public void firstApprove(@RequestBody @Valid LoanWorkflowDTO workflowDTO) {
        loanWorkFlowService.firstApprove(workflowDTO);
    }
    @PostMapping("/secondApprove")
    public void secondApprove(@RequestBody @Valid LoanWorkflowDTO workflowDTO) {
        loanWorkFlowService.secondApprove(workflowDTO);
    }
    @PostMapping("/thirdApprove")
    public void thirdApprove(@RequestBody @Valid LoanWorkflowDTO workflowDTO) {
        loanWorkFlowService.thirdApprove(workflowDTO);
    }
    @PostMapping("/issuance")
    public List<PaymentSchedule> issuance(@RequestParam Long LoanID){
        return loanWorkFlowService.issuance(LoanID);
    }

}
