package com.example.office.repo;

import com.example.office.domain.LoanWorkflow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanWorkflowRepo extends JpaRepository<LoanWorkflow, Long>{
}
