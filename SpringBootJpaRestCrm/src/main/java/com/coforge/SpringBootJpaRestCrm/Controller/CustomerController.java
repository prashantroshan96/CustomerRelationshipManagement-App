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

import com.coforge.SpringBootJpaRestCrm.Bean.Customer;
import com.coforge.SpringBootJpaRestCrm.Bean.Product;
import com.coforge.SpringBootJpaRestCrm.Exception.ResourceNotFoundException;
import com.coforge.SpringBootJpaRestCrm.Repositary.BillRepositary;
import com.coforge.SpringBootJpaRestCrm.Repositary.CustomerRepositary;
import com.coforge.SpringBootJpaRestCrm.Service.CustomerService;
import com.coforge.SpringBootJpaRestCrm.Service.ProductService;

@RestController
public class CustomerController {

	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customer")
	public List<Customer> getAllcustomers()
	{
		return customerService.getAll();
		
	}
	
	
	@GetMapping(path="/customer/{id}",produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Customer> getcustomerById(@PathVariable(value = "id") Long customerId)
	   throws ResourceNotFoundException
	{
		
		Customer customer = customerService.findById(customerId)
		.orElseThrow(() -> new ResourceNotFoundException("customer not found for this id :: "+customerId));
		
		return ResponseEntity.ok().body(customer);
		
		
	}
	
	@PostMapping(path="/customer",produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
			consumes= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Customer> save(@Valid @RequestBody Customer customer
			)
	{
      

	      customerService.addCustomer(customer);
		
	 	final Customer createcustomer = customerService.addCustomer(customer);
	
		return ResponseEntity.ok(createcustomer);
		
		
	}
	
	
	@PutMapping("/customer/{id}")
	public ResponseEntity<Customer> updatecustomer(@PathVariable(value = "id") Long customerId,
			@Valid @RequestBody Customer customerDetails) 
	   throws ResourceNotFoundException
	{
		
		Customer customer = customerService.findById(customerId)
		.orElseThrow(() -> new ResourceNotFoundException("customer not found for this id :: "+customerId));
		
		customer.setCustName(customerDetails.getCustName());
		customer.setGiftVoucher(customerDetails.getGiftVoucher());
		customer.setCustCountary(customerDetails.getCustCountary());
		customer.setCustcity(customerDetails.getCustcity());
		customer.setCustpincode(customerDetails.getCustpincode());
		customer.setCustMob(customerDetails.getCustMob());
		
		
		final Customer updatecustomer = customerService.updateCustomer(customer);
		
		return ResponseEntity.ok(updatecustomer);
		
		
	}
	
	
	@DeleteMapping("/customer/{id}")
	public Map<String,Boolean> deletecustomer(@PathVariable(value = "id") Long customerId)		
	   throws ResourceNotFoundException
	{
		
		Customer customer = customerService.findById(customerId)
		.orElseThrow(() -> new ResourceNotFoundException("customer not found for this id :: "+customerId));
		
		customerService.deleteCustomer(customer);
      Map<String, Boolean> response = new HashMap<>();
      response.put("deleted", Boolean.TRUE);
		
		return response;
		
		
	}
	
	
}
