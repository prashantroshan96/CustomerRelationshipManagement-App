package com.coforge.SpringBootJpaRestCrm.Bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Bill implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long  id;

	@Column
	private long  billAmount;
	
	@Column
	private Date  billDate;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	Customer customer;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	Product product;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(long billAmount) {
		this.billAmount = billAmount;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", billAmount=" + billAmount + ", billDate=" + billDate + ", customer=" + customer
				+ ", product=" + product + "]";
	}
		
}
