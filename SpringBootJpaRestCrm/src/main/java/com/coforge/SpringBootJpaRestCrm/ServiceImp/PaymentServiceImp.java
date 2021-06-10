package com.coforge.SpringBootJpaRestCrm.ServiceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coforge.SpringBootJpaRestCrm.Bean.Payment;
import com.coforge.SpringBootJpaRestCrm.Repositary.PaymentRepositary;
import com.coforge.SpringBootJpaRestCrm.Service.PaymentService;

@SuppressWarnings("unused")
@Service
@Transactional
public class PaymentServiceImp implements PaymentService{

	
	@Autowired
	private PaymentRepositary paymentRepositary;
	
	@Override
	public Payment addPayment(Payment payment) {
		return paymentRepositary.save(payment);		
	}

	@Override
	public Optional<Payment> findById(long id) {
		return paymentRepositary.findById(id);
	}

	@Override
	public Payment updatePayment(Payment payment) {
		return paymentRepositary.save(payment);		
		
	}

	@Override
	public void deletePayment(Payment payment) {
		paymentRepositary.delete(payment);		
	}

	@Override
	public List<Payment> getAll() {
		return paymentRepositary.findAll();
	}

}
