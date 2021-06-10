package com.coforge.SpringBootJpaRestCrm.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coforge.SpringBootJpaRestCrm.Bean.Card;



@Repository
public interface CardRepository extends JpaRepository<Card,Long>{

}
