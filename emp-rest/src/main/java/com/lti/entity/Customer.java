package com.lti.entity;

/**
 * 
 * @author Mitshu
 * 
 * This is an entity for Customer.
 * 
 * It is having OnetoOne relationship with CustomerDetails and
 * 
 * OneToMany relationship with Beneficiary
 * 
 * OnetoMany relationship with Transaction
 * 
 *
 */

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "customers")
@NamedQuery(name = "register",query =  "FROM Customer where email=:email")
@NamedQuery(name = "login",query =  "FROM Customer where userName=:uname AND password=:pwd")
@SequenceGenerator(name = "acc_seq", sequenceName = "seq_acc", initialValue = 12345, allocationSize = 1)
public class Customer {

	@Id
	@GeneratedValue(generator = "acc_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "acc_no", length = 20)
	private int accountNumber;

	@Column(name = "user_name", length = 25)
	private String userName;

	@Column(name = "password", length = 30)
	private String password;

	@Column(name = "acc_balance")
	private double accountBalance =3000;

	@Column(name = "first_name", length = 25)
	private String firstName;

	@Column(name = "last_name", length = 25)
	private String lastName;
	
	@Column(name = "email", length = 60)
	private String email;

	@Column(name = "acc_status")
	private String status ="pending";

	@OneToOne(mappedBy = "cust", cascade = { CascadeType.ALL }, orphanRemoval = true)
	 @JsonManagedReference 
	private CustomerDetail custDetails;

	@OneToMany(mappedBy = "cust", cascade = { CascadeType.ALL }, orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonManagedReference 
	List<Beneficiary> beneficiaryList = new ArrayList<Beneficiary>();

	@OneToMany(mappedBy = "cust", cascade = { CascadeType.ALL }, orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonManagedReference
	List<AccountTransaction> txnList = new ArrayList<AccountTransaction>();

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Beneficiary> getBeneficiaryList() {
		return beneficiaryList;
	}

	public void setBeneficiaryList(List<Beneficiary> beneficiaryList) {
		this.beneficiaryList = beneficiaryList;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public CustomerDetail getCustDetails() {
		return custDetails;
	}

	public void setCustDetails(CustomerDetail custDetails) {
		this.custDetails = custDetails;
	}

	public List<Beneficiary> getBeneficiariesList() {
		return beneficiaryList;
	}

	public void setBeneficiariesList(List<Beneficiary> beneficiariesList) {
		this.beneficiaryList = beneficiariesList;
	}

	public List<AccountTransaction> getTxnList() {
		return txnList;
	}

	public void setTxnList(List<AccountTransaction> txnList) {
		this.txnList = txnList;
	}

}