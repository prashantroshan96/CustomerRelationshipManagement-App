package com.coforge.SpringBootJpaRestCrm.Repositary;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coforge.SpringBootJpaRestCrm.Bean.Store;



@Repository
public interface StoreRepository extends JpaRepository<Store,Long> {
	

}
