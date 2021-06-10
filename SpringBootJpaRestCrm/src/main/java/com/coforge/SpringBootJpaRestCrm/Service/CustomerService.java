package com.coforge.SpringBootJpaRestCrm.Service;

import java.util.List;
import java.util.Optional;

import com.coforge.SpringBootJpaRestCrm.Bean.Customer;

public interface CustomerService {

	
	public Customer addCustomer(Customer customer);
	public Optional<Customer> findById(long id);
	public Customer updateCustomer(Customer customer);
	public void deleteCustomer(Customer customer);
	public List<Customer> getAll();
}
