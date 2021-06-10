package com.coforge.SpringBootJpaRestCrm.Service;

import java.util.List;
import java.util.Optional;


import com.coforge.SpringBootJpaRestCrm.Bean.Store;




public interface StoreService {
	
	public Store addStore(Store store);
	public Optional<Store> findById(long id);
	public Store updateStore(Store store);
	public void deleteStore(Store store);
	public List<Store> getAll();

}
