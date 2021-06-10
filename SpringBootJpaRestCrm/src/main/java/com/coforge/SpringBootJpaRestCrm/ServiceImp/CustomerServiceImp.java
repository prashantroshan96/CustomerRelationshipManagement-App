package com.coforge.SpringBootJpaRestCrm.ServiceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coforge.SpringBootJpaRestCrm.Bean.Customer;
import com.coforge.SpringBootJpaRestCrm.Repositary.CustomerRepositary;
import com.coforge.SpringBootJpaRestCrm.Service.CustomerService;


@SuppressWarnings("unused")
@Service
@Transactional
public class CustomerServiceImp implements  CustomerService{

	
	@Autowired 
	private	CustomerRepositary customerRepositary;
	
	
	@Override
	public Customer addCustomer(Customer customer) {
		return customerRepositary.save(customer);	
	}

	@Override
	public Optional<Customer> findById(long id) {
		return customerRepositary.findById(id);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
      return customerRepositary.save(customer);
	}

	@Override
	public void deleteCustomer(Customer customer) {
		
	customerRepositary.delete(customer);
	
	}

	@Override
	public List<Customer> getAll() {
		return customerRepositary.findAll();
	}

}
