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
import com.coforge.SpringBootJpaRestCrm.Bean.Payment;
import com.coforge.SpringBootJpaRestCrm.Exception.ResourceNotFoundException;
import com.coforge.SpringBootJpaRestCrm.Service.BillService;
import com.coforge.SpringBootJpaRestCrm.Service.PaymentService;


@RestController
public class PaymentController {
	@Autowired
	private BillService billService;
	
	@Autowired
	private PaymentService paymentService;
	
	@GetMapping("/payment")
	public List<Payment> getAllpayments()
	{
		return paymentService.getAll();
		
	}
	
	
	@GetMapping(path="/payment/{id}",produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Payment> getpaymentById(@PathVariable(value = "id") Long paymentId)
	   throws ResourceNotFoundException
	{
		
		Payment payment = paymentService.findById(paymentId)
		.orElseThrow(() -> new ResourceNotFoundException("payment not found for this id :: "+paymentId));
		
		return ResponseEntity.ok().body(payment);
		
		
	}
	
	@PostMapping(path="/payment",produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
			consumes= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Payment> save(@Valid @RequestBody Payment payment)
	{
	
		Bill bill=billService.findById(payment.getBill().getId()).orElseThrow(null);
		payment.setBill(bill);
		
		
		final Payment createpayment = paymentService.addPayment(payment);
		return ResponseEntity.ok(createpayment);
		
		
	}
	
	
	@PutMapping("/payment/{id}")
	public ResponseEntity<Payment> updatepayment(@PathVariable(value = "id") Long paymentId,
			@Valid @RequestBody Payment paymentDetails) 
	   throws ResourceNotFoundException
	{
		
		Payment payment = paymentService.findById(paymentId)
		.orElseThrow(() -> new ResourceNotFoundException("payment not found for this id :: "+paymentId));
	
	Bill bill=billService.findById(paymentDetails.getBill().getId()).orElseThrow(null);
		
		
	 payment.setModeOfPay(paymentDetails.getModeOfPay());
	 payment.setBill(bill);


		
		final Payment updatepayment = paymentService.updatePayment(payment);
		return ResponseEntity.ok(updatepayment);
	
	}
	
	
	@DeleteMapping("/payment/{id}")
	public Map<String,Boolean> deletepayment(@PathVariable(value = "id") Long paymentId)		
	   throws ResourceNotFoundException
	{
		
		Payment payment = paymentService.findById(paymentId)
		.orElseThrow(() -> new ResourceNotFoundException("payment not found for this id :: "+paymentId));
		
		paymentService.deletePayment(payment);
       Map<String, Boolean> response = new HashMap<>();
       response.put("deleted", Boolean.TRUE);
		
		return response;
		
		
	}
	
	
}
