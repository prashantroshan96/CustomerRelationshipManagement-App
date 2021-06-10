package com.coforge.SpringBootJpaRestCrm.ServiceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coforge.SpringBootJpaRestCrm.Bean.Card;
import com.coforge.SpringBootJpaRestCrm.Bean.CumulativePoint;
import com.coforge.SpringBootJpaRestCrm.Repositary.CumulativePointRepositary;
import com.coforge.SpringBootJpaRestCrm.Service.CardService;
import com.coforge.SpringBootJpaRestCrm.Service.CumulativePointService;

@SuppressWarnings("unused")
@Service
@Transactional
public class CumulativePointServiceImp implements CumulativePointService {

	
	
	@Autowired
	private CumulativePointRepositary cumulativePointRepositary;

	@Override
	public CumulativePoint addCumulativePoint(CumulativePoint cumulativePoint) {
		return cumulativePointRepositary.save(cumulativePoint);	
	}

	@Override
	public Optional<CumulativePoint> findById(long id) {
		return cumulativePointRepositary.findById(id);
	}

	@Override
	public CumulativePoint updateCumulativePoint(CumulativePoint cumulativePoint) {
		return cumulativePointRepositary.save(cumulativePoint);	
		
	}

	@Override
	public void deleteCumulativePoint(CumulativePoint cumulativePoint) {
		cumulativePointRepositary.delete(cumulativePoint);		
	}

	@Override
	public List<CumulativePoint> getAll() {
		return cumulativePointRepositary.findAll();
	}
	


}