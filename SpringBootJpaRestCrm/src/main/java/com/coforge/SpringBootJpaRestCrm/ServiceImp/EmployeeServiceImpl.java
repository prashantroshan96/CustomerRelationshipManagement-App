package com.coforge.SpringBootJpaRestCrm.ServiceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coforge.SpringBootJpaRestCrm.Bean.Employee;
import com.coforge.SpringBootJpaRestCrm.Repositary.EmployeeRepository;
import com.coforge.SpringBootJpaRestCrm.Service.EmployeeService;




@SuppressWarnings("unused")
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepositary;

	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepositary.save(employee);
	}

	@Override
	public Optional<Employee> findById(long id) {
		return employeeRepositary.findById(id);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepositary.save(employee);
	}

	@Override
	public void deleteEmployee(Employee employee) {
		employeeRepositary.delete(employee);		
	}

	@Override
	public List<Employee> getAll() {
		return employeeRepositary.findAll();
	}
	
	
	
	

	


	

}
