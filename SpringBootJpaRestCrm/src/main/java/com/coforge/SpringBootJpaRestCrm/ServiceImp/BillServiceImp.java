package com.coforge.SpringBootJpaRestCrm.ServiceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coforge.SpringBootJpaRestCrm.Bean.Bill;
import com.coforge.SpringBootJpaRestCrm.Repositary.BillRepositary;
import com.coforge.SpringBootJpaRestCrm.Service.BillService;

@SuppressWarnings("unused")
@Service
@Transactional
public class BillServiceImp implements BillService {

	
	@Autowired
	private BillRepositary billRepositary;
	
	
	@Override
	public Bill addBill(Bill bill) {
		return billRepositary.save(bill);		
	}

	@Override
	public Optional<Bill> findById(long id) {
		return billRepositary.findById(id);
	}

	@Override
	public Bill updateBill(Bill bill) {
		return billRepositary.save(bill);		
		
	}

	@Override
	public void deleteBill(Bill bill) {
		billRepositary.delete(bill);		
	}

	@Override
	public List<Bill> getAll() {
		return billRepositary.findAll();
	}

}
