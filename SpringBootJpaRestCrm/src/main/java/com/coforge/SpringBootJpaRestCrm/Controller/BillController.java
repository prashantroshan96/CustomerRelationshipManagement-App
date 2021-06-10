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

import com.coforge.SpringBootJpaRestCrm.Bean.Bill;
import com.coforge.SpringBootJpaRestCrm.Bean.Customer;
import com.coforge.SpringBootJpaRestCrm.Bean.Product;
import com.coforge.SpringBootJpaRestCrm.Exception.ResourceNotFoundException;
import com.coforge.SpringBootJpaRestCrm.Repositary.BillRepositary;
import com.coforge.SpringBootJpaRestCrm.Service.BillService;
import com.coforge.SpringBootJpaRestCrm.Service.CustomerService;
import com.coforge.SpringBootJpaRestCrm.Service.ProductService;

@RestController
public class BillController {

	@Autowired
	private BillService billService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ProductService productService;
	

	
	@GetMapping("/bill")
	public List<Bill> getAllbills()
	{
		return billService.getAll();
		
	}
	
	
	@GetMapping(path="/bill/{id}",produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Bill> getbillById(@PathVariable(value = "id") Long billId)
	   throws ResourceNotFoundException
	{
		
		Bill bill = billService.findById(billId)
		.orElseThrow(() -> new ResourceNotFoundException("bill not found for this id :: "+billId));
		
		return ResponseEntity.ok().body(bill);
		
		
	}
	
	@PostMapping(path="/bill",produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
			consumes= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Bill> save(@Valid @RequestBody Bill bill)
	{
		
		Customer customer=customerService.findById(bill.getCustomer().getId()).orElseThrow(null);
		Product product=productService.findById(bill.getProduct().getId()).orElseThrow(null);
				
		bill.setCustomer(customer);
		bill.setProduct(product);

      final Bill addbill = billService.addBill(bill);
      return ResponseEntity.ok(addbill);
		
		
	}
	
	
	@PutMapping("/bill/{id}")
	public ResponseEntity<Bill> updatebill(@PathVariable(value = "id") Long billId,
			@Valid @RequestBody Bill billDetails) 
	   throws ResourceNotFoundException
	{
		
		Bill bill = billService.findById(billId)
		.orElseThrow(() -> new ResourceNotFoundException("bill not found for this id :: "+billId));
		
		Customer customer=customerService.findById(billDetails.getCustomer().getId()).orElseThrow(null);
		Product product=productService.findById(billDetails.getProduct().getId()).orElseThrow(null);
	
	
	 bill.setBillAmount(billDetails.getBillAmount());
	 bill.setBillDate(billDetails.getBillDate());
	      bill.setCustomer(customer);
	 	 bill.setProduct(product);

		
		final Bill updatebill = billService.updateBill(bill);
		return ResponseEntity.ok(updatebill);
	
	}
	
	
	@DeleteMapping("/bill/{id}")
	public Map<String,Boolean> deletebill(@PathVariable(value = "id") Long billId)		
	   throws ResourceNotFoundException
	{
		
		Bill bill = billService.findById(billId)
		.orElseThrow(() -> new ResourceNotFoundException("bill not found for this id :: "+billId));
		
		billService.deleteBill(bill);
       Map<String, Boolean> response = new HashMap<>();
       response.put("deleted", Boolean.TRUE);
		
		return response;
		
		
	}
	
	
	
}
