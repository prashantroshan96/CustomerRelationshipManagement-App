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
public class Payment implements Serializable {

 
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long	     id;
	
	@Column
	private double	  amount;
	
	@Column
	private String	  modeOfPay;	
	
	@Column
	private double   discount;
	
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	Bill bill;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public String getModeOfPay() {
		return modeOfPay;
	}


	public void setModeOfPay(String modeOfPay) {
		this.modeOfPay = modeOfPay;
	}


	public double getDiscount() {
		return discount;
	}


	public void setDiscount(double discount) {
		this.discount = discount;
	}


	public Bill getBill() {
		return bill;
	}


	public void setBill(Bill bill) {
		this.bill = bill;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Payment [id=" + id + ", amount=" + amount + ", modeOfPay=" + modeOfPay + ", discount=" + discount
				+ ", bill=" + bill + "]";
	}


	
	
	
	
}
