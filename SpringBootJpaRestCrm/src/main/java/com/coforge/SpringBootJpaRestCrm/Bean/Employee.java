package com.coforge.SpringBootJpaRestCrm.Bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private	long id;
	
	@Column
	private	String employeeName;
	
	@Column
	private	long employeeMob;
	
	@Column
	private	Date employeeDob;
	
	@Column
	private	String employeeeCountry;
	
	@Column
	private	String employeeCity;
	
	@Column
	private	long employeePincode;
	
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	Store store;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public long getEmployeeMob() {
		return employeeMob;
	}

	public void setEmployeeMob(long employeeMob) {
		this.employeeMob = employeeMob;
	}

	public Date getEmployeeDob() {
		return employeeDob;
	}

	public void setEmployeeDob(Date employeeDob) {
		this.employeeDob = employeeDob;
	}

	public String getEmployeeeCountry() {
		return employeeeCountry;
	}

	public void setEmployeeeCountry(String employeeeCountry) {
		this.employeeeCountry = employeeeCountry;
	}

	public String getEmployeeCity() {
		return employeeCity;
	}

	public void setEmployeeCity(String employeeCity) {
		this.employeeCity = employeeCity;
	}

	public long getEmployeePincode() {
		return employeePincode;
	}

	public void setEmployeePincode(long employeePincode) {
		this.employeePincode = employeePincode;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", employeeName=" + employeeName + ", employeeMob=" + employeeMob
				+ ", employeeDob=" + employeeDob + ", employeeeCountry=" + employeeeCountry + ", employeeCity="
				+ employeeCity + ", employeePincode=" + employeePincode + ", store=" + store + "]";
	}

	
	
	
	
}	