package com.coforge.SpringBootJpaRestCrm.Service;

import java.util.List;
import java.util.Optional;

import com.coforge.SpringBootJpaRestCrm.Bean.Product;

public interface ProductService {

	
	
	public Product addProduct(Product product);
	public Optional<Product> findById(long id);
	public Product updateProduct(Product product);
	public void deleteProduct(Product product);
	public List<Product> getAll();
}
