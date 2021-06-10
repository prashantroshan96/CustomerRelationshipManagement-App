package com.coforge.SpringBootJpaRestCrm.Service;

import java.util.List;
import java.util.Optional;

import com.coforge.SpringBootJpaRestCrm.Bean.Payment;

public interface PaymentService {

	
	public Payment addPayment(Payment payment);
	public Optional<Payment> findById(long id);
	public Payment updatePayment(Payment payment);
	public void deletePayment(Payment payment);
	public List<Payment> getAll();
}
