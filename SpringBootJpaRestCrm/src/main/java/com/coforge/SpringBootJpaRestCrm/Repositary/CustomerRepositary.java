package com.coforge.SpringBootJpaRestCrm.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coforge.SpringBootJpaRestCrm.Bean.Customer;


@Repository
public interface CustomerRepositary extends JpaRepository<Customer,Long> {

}
