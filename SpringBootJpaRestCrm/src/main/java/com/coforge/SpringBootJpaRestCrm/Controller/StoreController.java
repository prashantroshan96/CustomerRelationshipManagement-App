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

import com.coforge.SpringBootJpaRestCrm.Bean.Store;
import com.coforge.SpringBootJpaRestCrm.Exception.ResourceNotFoundException;
import com.coforge.SpringBootJpaRestCrm.Service.StoreService;

@RestController
public class StoreController {

	
	@Autowired
	private StoreService storeService;
	

	
	@GetMapping("/store")
	public List<Store> getAllstores()
	{
		return storeService.getAll();
		
	}
	
	
	@GetMapping(path="/store/{id}",produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Store> getstoreById(@PathVariable(value = "id") Long storeId)
	   throws ResourceNotFoundException
	{
		
		Store store = storeService.findById(storeId)
		.orElseThrow(() -> new ResourceNotFoundException("store not found for this id :: "+storeId));
		
		return ResponseEntity.ok().body(store);
		
		
	}
	
	@PostMapping(path="/store",produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
			consumes= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Store> save(@Valid @RequestBody Store store)
	{
		
		final Store createstore = storeService.addStore(store);
		
		return ResponseEntity.ok(createstore);
		
		
	}
	
	
	@PutMapping("/store/{id}")
	public ResponseEntity<Store> updatestore(@PathVariable(value = "id") Long storeId,
			@Valid @RequestBody Store storeDetails) 
	   throws ResourceNotFoundException
	{
		
		Store store = storeService.findById(storeId)
		.orElseThrow(() -> new ResourceNotFoundException("store not found for this id :: "+storeId));
		
	 store.setStoreName(storeDetails.getStoreName());
	 store.setStoreCountry(storeDetails.getStoreCountry());
	 store.setStoreCity(storeDetails.getStoreCity());
	 store.setStorePinCode(storeDetails.getStorePinCode());

		
		final Store updatestore = storeService.updateStore(store);
		return ResponseEntity.ok(updatestore);
	
	}
	
	
	@DeleteMapping("/store/{id}")
	public Map<String,Boolean> deletestore(@PathVariable(value = "id") Long storeId)		
	   throws ResourceNotFoundException
	{
		
		Store store = storeService.findById(storeId)
		.orElseThrow(() -> new ResourceNotFoundException("store not found for this id :: "+storeId));
		
		storeService.deleteStore(store);
       Map<String, Boolean> response = new HashMap<>();
       response.put("deleted", Boolean.TRUE);
		
		return response;
		
		
	}
	
	
	
	
}
