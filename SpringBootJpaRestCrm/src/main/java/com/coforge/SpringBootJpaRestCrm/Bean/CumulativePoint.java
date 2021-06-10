package com.coforge.SpringBootJpaRestCrm.Bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class CumulativePoint implements Serializable {

	
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	 @Column
	 private double cumulativeTotal;
	
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	Payment payment;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    Customer customer;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getCumulativeTotal() {
		return cumulativeTotal;
	}

	public void setCumulativeTotal(double cumulativeTotal) {
		this.cumulativeTotal = cumulativeTotal;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
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
		return "CumulativePoint [id=" + id + ", cumulativeTotal=" + cumulativeTotal + ", payment=" + payment
				+ ", customer=" + customer + "]";
	}
	
	
	
	
	
	
	
}
