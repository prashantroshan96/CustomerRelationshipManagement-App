package com.coforge.SpringBootJpaRestCrm.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.SpringBootJpaRestCrm.Bean.Employee;
import com.coforge.SpringBootJpaRestCrm.Bean.Store;
import com.coforge.SpringBootJpaRestCrm.Exception.ResourceNotFoundException;
import com.coforge.SpringBootJpaRestCrm.Service.EmployeeService;
import com.coforge.SpringBootJpaRestCrm.Service.StoreService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private StoreService storeService;

	
	@GetMapping("/employee")
	public List<Employee> getAllemployees()
	{
		return employeeService.getAll();
		
	}
	
	
	@GetMapping(path="/employee/{id}",produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Employee> getemployeeById(@PathVariable(value = "id") Long employeeId)
	   throws ResourceNotFoundException
	{
		
		Employee employee = employeeService.findById(employeeId)
		.orElseThrow(() -> new ResourceNotFoundException("employee not found for this id :: "+employeeId));
		
		return ResponseEntity.ok().body(employee);
		
		
	}
	
	@PostMapping(path="/employee",produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
			consumes= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Employee> save(@Valid @RequestBody Employee employee)
	{
		
		
Store store=storeService.findById(employee.getStore().getId()).orElseThrow(null);
		
		employee.setStore(store);
		
		
		final Employee createemployee = employeeService.addEmployee(employee);
		
		return ResponseEntity.ok(createemployee);
		
		
	}
	
	
	@PutMapping("/employee/{id}")
	public ResponseEntity<Employee> updateemployee(@PathVariable(value = "id") Long employeeId,
			@Valid @RequestBody Employee employeeDetails) 
	   throws ResourceNotFoundException
	{
		
		Employee employee = employeeService.findById(employeeId)
		.orElseThrow(() -> new ResourceNotFoundException("employee not found for this id :: "+employeeId));
	
Store store=storeService.findById(employeeDetails.getStore().getId()).orElseThrow(null);
		
	 employee.setEmployeeName(employeeDetails.getEmployeeName());
	 employee.setEmployeeeCountry(employeeDetails.getEmployeeeCountry());
	 employee.setEmployeeDob(employeeDetails.getEmployeeDob());
	 employee.setEmployeeMob(employeeDetails.getEmployeeMob());

	 employee.setEmployeeCity(employeeDetails.getEmployeeCity());
	 employee.setEmployeePincode(employeeDetails.getEmployeePincode());
	 employee.setStore(store);

		
		final Employee updateemployee = employeeService.updateEmployee(employee);
		return ResponseEntity.ok(updateemployee);
	
	}
	
	
	@DeleteMapping("/employee/{id}")
	public Map<String,Boolean> deleteemployee(@PathVariable(value = "id") Long employeeId)		
	   throws ResourceNotFoundException
	{
		
		Employee employee = employeeService.findById(employeeId)
		.orElseThrow(() -> new ResourceNotFoundException("employee not found for this id :: "+employeeId));
		
		employeeService.deleteEmployee(employee);
       Map<String, Boolean> response = new HashMap<>();
       response.put("deleted", Boolean.TRUE);
		
		return response;
		
		
	}
	
	
	
}
