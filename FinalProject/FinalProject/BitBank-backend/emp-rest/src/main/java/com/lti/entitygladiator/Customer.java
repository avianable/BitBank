package com.lti.entitygladiator;

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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "customers")
@NamedQuery(name = "loginvalidate", query = "FROM Customer WHERE user_name=:uname AND password=:pwd")
@NamedQuery(name = "register", query = "FROM Customer where email=:email")
@SequenceGenerator(name = "acc_seq", sequenceName = "seq_acc", initialValue = 123598765, allocationSize = 1)
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
	private double accountBalance = 3000;

	@Column(name = "email", length = 30)
	private String email;

	@Column(name = "first_name", length = 25)
	private String firstName;

	@Column(name = "last_name", length = 25)
	private String lastName;

	@Column(name = "status", length = 25)
	private String status = "pending";

	@OneToOne(mappedBy = "cust", cascade = { CascadeType.ALL })
	@JsonManagedReference
	private CustomerDetail custDetails;

	@OneToMany(mappedBy = "cust", cascade = { CascadeType.ALL })
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonManagedReference
	List<Beneficiary> beneficiariesList = new ArrayList<Beneficiary>();

	@OneToMany(mappedBy = "cust", cascade = { CascadeType.ALL })
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonManagedReference
	List<AccountTransaction> txnList = new ArrayList<AccountTransaction>();

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
		return beneficiariesList;
	}

	public void setBeneficiariesList(List<Beneficiary> beneficiariesList) {
		this.beneficiariesList = beneficiariesList;
	}

	public List<AccountTransaction> getTxnList() {
		return txnList;
	}

	public void setTxnList(List<AccountTransaction> txnList) {
		this.txnList = txnList;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}