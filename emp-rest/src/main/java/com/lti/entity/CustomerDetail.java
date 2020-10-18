package com.lti.entity;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="customer_details")
public class CustomerDetail {
	
	@Id
	@Column(length=12, name = "aadhar_no")
	private String aadharNumber;
	
	@Column(length=10, name = "pan_no")
	private String panNumber;
	
	@Column(length=10, name = "mob_no")
	private String mobileNumber;		
	
	@Column(length = 3)
	private int age; 
	
	@Column(length=30)
	private String street;
	
	@Column(length=20)
	private String city;
	
	@Column(length=20)
	private String state;
	
	@Column(length=6)
	private int pincode;
	
	@OneToOne
	@JoinColumn(name = "acc_no")
	@JsonBackReference
	private Customer cust;

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	
	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	

	
	
}
