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

import com.coforge.SpringBootJpaRestCrm.Bean.Card;
import com.coforge.SpringBootJpaRestCrm.Bean.Customer;
import com.coforge.SpringBootJpaRestCrm.Exception.ResourceNotFoundException;
import com.coforge.SpringBootJpaRestCrm.Service.CardService;
import com.coforge.SpringBootJpaRestCrm.Service.CustomerService;

@RestController
public class CardController {
	
	@Autowired
	private CardService cardService;
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/card")
	public List<Card> getAllcards()
	{
		return cardService.getAll();
		
	}
	
	
	@GetMapping(path="/card/{id}",produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Card> getcardById(@PathVariable(value = "id") Long cardId)
	   throws ResourceNotFoundException
	{
		
		Card card = cardService.findById(cardId)
		.orElseThrow(() -> new ResourceNotFoundException("card not found for this id :: "+cardId));
		
		return ResponseEntity.ok().body(card);
		
		
	}
	
	@PostMapping(path="/card",produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
			consumes= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Card> save(@Valid @RequestBody Card card)
	{
		
	Customer customer=customerService.findById(card.getCustomer().getId()).orElseThrow(null);	
	card.setCustomer(customer);
	
		final Card createcard = cardService.addcard(card);
		
		return ResponseEntity.ok(createcard);
		
		
	}
	
	
	@PutMapping("/card/{id}")
	public ResponseEntity<Card> updatecard(@PathVariable(value = "id") Long cardId,
			@Valid @RequestBody Card cardDetails) 
	   throws ResourceNotFoundException
	{
		
		Card card = cardService.findById(cardId)
		.orElseThrow(() -> new ResourceNotFoundException("card not found for this id :: "+cardId));
		
		Customer customer=customerService.findById(cardDetails.getCustomer().getId()).orElseThrow(null);	
	 
	 card.setCardType(cardDetails.getCardType());
	 card.setCustomer(customer);		
		
		final Card updatecard = cardService.updatecard(card);
		return ResponseEntity.ok(updatecard);
	
	}
	
	
	@DeleteMapping("/card/{id}")
	public Map<String,Boolean> deletecard(@PathVariable(value = "id") Long cardId)		
	   throws ResourceNotFoundException
	{
		
		Card card = cardService.findById(cardId)
		.orElseThrow(() -> new ResourceNotFoundException("card not found for this id :: "+cardId));
		
		cardService.deletecard(card);
       Map<String, Boolean> response = new HashMap<>();
       response.put("deleted", Boolean.TRUE);
		
		return response;
		
		
	}
	

}
