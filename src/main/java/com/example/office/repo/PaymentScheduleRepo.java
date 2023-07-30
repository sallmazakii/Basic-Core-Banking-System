package com.example.office.repo;
import com.example.office.domain.Loan;
import com.example.office.domain.PaymentSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
 @Repository
public interface PaymentScheduleRepo extends JpaRepository<PaymentSchedule,Long> {

}
