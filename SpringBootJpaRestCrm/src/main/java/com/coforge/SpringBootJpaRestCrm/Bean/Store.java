package com.coforge.SpringBootJpaRestCrm.Bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Store  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private	long id;
	
	@Column
	private	String storeName;
	
	@Column
	private String storeCountry ;
	
	@Column
	private	String  storeCity;
	
	@Column
	private    long	storePinCode;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreCountry() {
		return storeCountry;
	}

	public void setStoreCountry(String storeCountry) {
		this.storeCountry = storeCountry;
	}

	public String getStoreCity() {
		return storeCity;
	}

	public void setStoreCity(String storeCity) {
		this.storeCity = storeCity;
	}

	public long getStorePinCode() {
		return storePinCode;
	}

	public void setStorePinCode(long storePinCode) {
		this.storePinCode = storePinCode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Store [id=" + id + ", storeName=" + storeName + ", storeCountry=" + storeCountry + ", storeCity="
				+ storeCity + ", storePinCode=" + storePinCode + "]";
	}
     
     
   
   
}