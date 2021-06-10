package com.coforge.SpringBootJpaRestCrm.Service;

import java.util.List;
import java.util.Optional;

import com.coforge.SpringBootJpaRestCrm.Bean.Bill;

public interface BillService {

	public Bill addBill(Bill bill);
	public Optional<Bill> findById(long id);
	public Bill updateBill(Bill bill);
	public void deleteBill(Bill bill);
	public List<Bill> getAll();
}
