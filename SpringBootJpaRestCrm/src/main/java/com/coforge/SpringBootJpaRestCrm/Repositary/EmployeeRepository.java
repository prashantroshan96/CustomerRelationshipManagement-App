package com.coforge.SpringBootJpaRestCrm.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coforge.SpringBootJpaRestCrm.Bean.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{


	
}
