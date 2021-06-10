package com.coforge.SpringBootJpaRestCrm.ServiceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coforge.SpringBootJpaRestCrm.Bean.Store;
import com.coforge.SpringBootJpaRestCrm.Repositary.StoreRepository;
import com.coforge.SpringBootJpaRestCrm.Service.StoreService;



@SuppressWarnings("unused")
@Service
@Transactional
public class StoreServiceImpl implements StoreService {


		@Autowired
		private StoreRepository storeRepository;

		@Override
		public Store addStore(Store store) {
			return storeRepository.save(store);
		}

		@Override
		public Optional<Store> findById(long id) {
			return storeRepository.findById(id);
		}

		@Override
		public Store updateStore(Store store) {
			return storeRepository.save(store);
		}

		@Override
		public void deleteStore(Store store) {
			storeRepository.delete(store);			
		}

		@Override
		public List<Store> getAll() {
			return storeRepository.findAll();
		}
	

	
	
	

}
