package com.coforge.SpringBootJpaRestCrm.ServiceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coforge.SpringBootJpaRestCrm.Bean.Product;
import com.coforge.SpringBootJpaRestCrm.Repositary.ProductRepositary;
import com.coforge.SpringBootJpaRestCrm.Service.ProductService;

@SuppressWarnings("unused")
@Service
@Transactional
public class ProductServiceImp implements ProductService {

	
	
	@Autowired
	private ProductRepositary  productRepositary;
	
	@Override
	public Product addProduct(Product product) {
		return productRepositary.save(product);		
	}

	@Override
	public Optional<Product> findById(long id) {
		return productRepositary.findById(id);
	}

	@Override
	public Product updateProduct(Product product) {
		return productRepositary.save(product);		
		
	}

	@Override
	public void deleteProduct(Product product) {
		productRepositary.delete(product);		
	}

	@Override
	public List<Product> getAll() {
		return productRepositary.findAll();
	}

}
