package com.coforge.SpringBootJpaRestCrm.Bean;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long  id;
	
	@Column
	private String  custName;
	
	@Column
	private long giftVoucher;
	

	
	@Column
	private long  custMob;
	
	@Column
	private String  custCountary;
	
	@Column
	private String  custcity;
	
	@Column
	private long     custpincode;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public long getGiftVoucher() {
		return giftVoucher;
	}

	public void setGiftVoucher(long giftVoucher) {
		this.giftVoucher = giftVoucher;
	}

	public long getCustMob() {
		return custMob;
	}

	public void setCustMob(long custMob) {
		this.custMob = custMob;
	}

	public String getCustCountary() {
		return custCountary;
	}

	public void setCustCountary(String custCountary) {
		this.custCountary = custCountary;
	}

	public String getCustcity() {
		return custcity;
	}

	public void setCustcity(String custcity) {
		this.custcity = custcity;
	}

	public long getCustpincode() {
		return custpincode;
	}

	public void setCustpincode(long custpincode) {
		this.custpincode = custpincode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", custName=" + custName + ", giftVoucher=" + giftVoucher + ", custMob=" + custMob
				+ ", custCountary=" + custCountary + ", custcity=" + custcity + ", custpincode=" + custpincode + "]";
	}
	
	



	

	



	
	
}
