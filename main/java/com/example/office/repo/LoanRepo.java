package com.example.office.repo;

import com.example.office.domain.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepo extends JpaRepository<Loan, Long> {
    @Modifying
    @Query("UPDATE Loan l SET l.statusID = :newStatusID WHERE l.id = LoanId")
    void updateLoanStatus(@Param("LoanId") Long loanId, @Param("newStatusID") Long newStatusID);
}
