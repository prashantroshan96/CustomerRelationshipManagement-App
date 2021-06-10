package com.coforge.SpringBootJpaRestCrm.Service;

import java.util.List;
import java.util.Optional;

import com.coforge.SpringBootJpaRestCrm.Bean.Employee;




public interface EmployeeService {
	
	public Employee addEmployee(Employee employee);
	public Optional<Employee> findById(long id);
	public Employee updateEmployee(Employee employee);
	public void deleteEmployee(Employee employee);
	public List<Employee> getAll();
}


