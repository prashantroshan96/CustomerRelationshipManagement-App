package com.coforge.SpringBootJpaRestCrm.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coforge.SpringBootJpaRestCrm.Bean.Product;

@Repository
public interface ProductRepositary extends JpaRepository<Product,Long> {

}
