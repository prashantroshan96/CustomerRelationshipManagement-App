package com.coforge.SpringBootJpaRestCrm.Service;

import java.util.List;
import java.util.Optional;

import com.coforge.SpringBootJpaRestCrm.Bean.Card;


public interface CardService {

	public Card addcard(Card card);
	public Optional<Card> findById(long id);
	public Card updatecard(Card card);
	public void deletecard(Card card);
	public List<Card> getAll();
}
