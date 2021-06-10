package com.coforge.SpringBootJpaRestCrm.Bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Product  implements Serializable{

	
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long     id;
	
	
	@Column
	private String     producttype;
	
	@Column
	private long     productQuantity;
	
	
	@Column
	private double     productMRP;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getProducttype() {
		return producttype;
	}


	public void setProducttype(String producttype) {
		this.producttype = producttype;
	}


	public long getProductQuantity() {
		return productQuantity;
	}


	public void setProductQuantity(long productQuantity) {
		this.productQuantity = productQuantity;
	}


	public double getProductMRP() {
		return productMRP;
	}


	public void setProductMRP(double productMRP) {
		this.productMRP = productMRP;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", producttype=" + producttype + ", productQuantity=" + productQuantity
				+ ", productMRP=" + productMRP + "]";
	}
	
	

	 



  
	
	
}
