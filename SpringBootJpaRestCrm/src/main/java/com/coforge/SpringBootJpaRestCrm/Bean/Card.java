package com.coforge.SpringBootJpaRestCrm.Bean;


import java.io.Serializable;


import javax.persistence.*;




@Entity
public class Card implements Serializable {
	
	private static final long serialVersionUID = -1235258543771348038L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long	id;

	@Column
    private String cardType;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	Customer customer;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", cardType=" + cardType + ", customer=" + customer + "]";
	}
	
	
	
	
	
	
}
