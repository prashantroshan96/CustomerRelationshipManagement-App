package com.coforge.SpringBootJpaRestCrm.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.SpringBootJpaRestCrm.Bean.Product;
import com.coforge.SpringBootJpaRestCrm.Exception.ResourceNotFoundException;
import com.coforge.SpringBootJpaRestCrm.Repositary.ProductRepositary;
import com.coforge.SpringBootJpaRestCrm.Service.ProductService;

@RestController
public class ProductController {
	
	
	@Autowired
	private ProductService productService;
	

	
	@GetMapping("/product")
	public List<Product> getAllproducts()
	{
		return productService.getAll();
		
	}
	
	
	@GetMapping(path="/product/{id}",produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Product> getproductById(@PathVariable(value = "id") Long productId)
	   throws ResourceNotFoundException
	{
		
		Product product = productService.findById(productId)
		.orElseThrow(() -> new ResourceNotFoundException("product not found for this id :: "+productId));
		
		return ResponseEntity.ok().body(product);
		
		
	}
	
	@PostMapping(path="/product",produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
			consumes= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Product> save(@Valid @RequestBody Product product)
	{
       

		final Product createproduct = productService.addProduct(product);
		
		
		return ResponseEntity.ok(createproduct);
		
		
	}
	 
	 
	
	@PutMapping("/product/{id}")
	public ResponseEntity<Product> updateproduct(@PathVariable(value = "id") Long productId,
			@Valid @RequestBody Product productDetails) 
	   throws ResourceNotFoundException
	{
		
		Product product = productService.findById(productId)
		.orElseThrow(() -> new ResourceNotFoundException("product not found for this id :: "+productId));

		product.setProductQuantity(productDetails.getProductQuantity());
		product.setProducttype(productDetails.getProducttype());
		product.setProductMRP(productDetails.getProductMRP());

		final Product updateproduct = productService.addProduct(product);
		
		return ResponseEntity.ok(updateproduct);
		
		
	}
	
	
	@DeleteMapping("/product/{id}")
	public Map<String,Boolean> deleteproduct(@PathVariable(value = "id") Long productId)		
	   throws ResourceNotFoundException
	{
		
		Product product = productService.findById(productId)
		.orElseThrow(() -> new ResourceNotFoundException("product not found for this id :: "+productId));
		
		productService.deleteProduct(product);
        Map<String, Boolean> response = new HashMap<>();
         response.put("deleted", Boolean.TRUE);
		
		return response;
		
		
	}
	
}
