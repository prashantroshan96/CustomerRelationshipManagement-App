package com.coforge.SpringBootJpaRestCrm.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coforge.SpringBootJpaRestCrm.Bean.Payment;


@Repository
public interface PaymentRepositary extends JpaRepository<Payment,Long>{

}
