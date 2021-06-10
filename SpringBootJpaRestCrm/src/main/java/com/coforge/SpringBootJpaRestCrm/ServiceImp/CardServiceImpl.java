package com.coforge.SpringBootJpaRestCrm.ServiceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coforge.SpringBootJpaRestCrm.Bean.Card;
import com.coforge.SpringBootJpaRestCrm.Repositary.CardRepository;
import com.coforge.SpringBootJpaRestCrm.Service.CardService;


@SuppressWarnings("unused")
@Service
@Transactional
public class CardServiceImpl implements CardService{
	@Autowired
	private CardRepository cardRepository;

	@Override
	public Card addcard(Card card) {
		return cardRepository.save(card);
	}

	@Override
	public Optional<Card> findById(long id) {
		return cardRepository.findById(id);
	}

	@Override
	public Card updatecard(Card card) {
		return cardRepository.save(card);	}

	@Override
	public void deletecard(Card card) {
		cardRepository.delete(card);
	}

	@Override
	public List<Card> getAll() {
		return cardRepository.findAll();
	}
	
	



}
