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

import com.coforge.SpringBootJpaRestCrm.Bean.CumulativePoint;
import com.coforge.SpringBootJpaRestCrm.Bean.Customer;
import com.coforge.SpringBootJpaRestCrm.Bean.Payment;
import com.coforge.SpringBootJpaRestCrm.Exception.ResourceNotFoundException;
import com.coforge.SpringBootJpaRestCrm.Service.CumulativePointService;
import com.coforge.SpringBootJpaRestCrm.Service.CustomerService;
import com.coforge.SpringBootJpaRestCrm.Service.PaymentService;

@RestController
public class CumulativeController {
	
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CumulativePointService cumulativePointService;
	

	
	@GetMapping("/cumulativePoint")
	public List<CumulativePoint> getAllcumulativePoints()
	{
		return cumulativePointService.getAll();
		
	}
	
	
	@GetMapping(path="/cumulativePoint/{id}",produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<CumulativePoint> getcumulativePointById(@PathVariable(value = "id") Long cumulativePointId)
	   throws ResourceNotFoundException
	{
		
		CumulativePoint cumulativePoint = cumulativePointService.findById(cumulativePointId)
		.orElseThrow(() -> new ResourceNotFoundException("cumulativePoint not found for this id :: "+cumulativePointId));
		
		return ResponseEntity.ok().body(cumulativePoint);
		
		
	}
	
	@PostMapping(path="/cumulativePoint",produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
			consumes= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<CumulativePoint> save(@Valid @RequestBody CumulativePoint cumulativePoint)
	{
	
		
Customer customer=customerService.findById(cumulativePoint.getCustomer().getId()).orElseThrow(null);
Payment payment=paymentService.findById(cumulativePoint.getPayment().getId()).orElseThrow(null);
	
		
		cumulativePoint.setCustomer(customer);
		cumulativePoint.setPayment(payment);

		final CumulativePoint createcumulativePoint = cumulativePointService.addCumulativePoint(cumulativePoint);
		
		return ResponseEntity.ok(createcumulativePoint);
		
		
	}
	
	
	@PutMapping("/cumulativePoint/{id}")
	public ResponseEntity<CumulativePoint> updatecumulativePoint(@PathVariable(value = "id") Long cumulativePointId,
			@Valid @RequestBody CumulativePoint cumulativePointDetails) 
	   throws ResourceNotFoundException
	{
		
		CumulativePoint cumulativePoint = cumulativePointService.findById(cumulativePointId)
		.orElseThrow(() -> new ResourceNotFoundException("cumulativePoint not found for this id :: "+cumulativePointId));
	
		
		
		
Customer customer=customerService.findById(cumulativePointDetails.getCustomer().getId()).orElseThrow(null);
Payment payment=paymentService.findById(cumulativePointDetails.getPayment().getId()).orElseThrow(null);
	
		

	 cumulativePoint.setCumulativeTotal(cumulativePointDetails.getCumulativeTotal());
	 cumulativePoint.setCustomer(customer);
	 cumulativePoint.setPayment(payment);

		
		final CumulativePoint updatecumulativePoint = cumulativePointService.updateCumulativePoint(cumulativePoint);
		return ResponseEntity.ok(updatecumulativePoint);
	
	}
	
	
	@DeleteMapping("/cumulativePoint/{id}")
	public Map<String,Boolean> deletecumulativePoint(@PathVariable(value = "id") Long cumulativePointId)		
	   throws ResourceNotFoundException
	{
		
		CumulativePoint cumulativePoint = cumulativePointService.findById(cumulativePointId)
		.orElseThrow(() -> new ResourceNotFoundException("cumulativePoint not found for this id :: "+cumulativePointId));
		
		cumulativePointService.deleteCumulativePoint(cumulativePoint);
       Map<String, Boolean> response = new HashMap<>();
       response.put("deleted", Boolean.TRUE);
		
		return response;
		
		
	}
	
	
}
