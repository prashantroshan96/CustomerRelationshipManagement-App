package com.coforge.SpringBootJpaRestCrm.Service;

import java.util.List;
import java.util.Optional;

import com.coforge.SpringBootJpaRestCrm.Bean.CumulativePoint;

public interface CumulativePointService {

	
	
	public CumulativePoint addCumulativePoint(CumulativePoint cumulativePoint);
	public Optional<CumulativePoint> findById(long id);
	public CumulativePoint updateCumulativePoint(CumulativePoint cumulativePoint);
	public void deleteCumulativePoint(CumulativePoint cumulativePoint);
	public List<CumulativePoint> getAll();
}
