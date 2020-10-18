/**
 * 
 * @author Arnab. @version 1.0.0
 * 
 * This is an entity for beneficiary details in an account.
 * 
 * It is having ManyToOne relationship with Customer and
 * 
 * OneToOne relationship with AccountTransaction
 * 
 * 
 * 
 * Update:
 * 
 *  @author Avnv version 1.0.1
 *
 *	Relationships are mapped and accountNumber column name is assigned
 */

package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "beneficiaries")
public class Beneficiary {

	@Id
	@Column(name = "benef_acc_no")
	private int benefAccountNumber;

	@Column(name = "first_name", length = 30)
	private String firstName;

	@Column(name = "last_name", length = 30)
	private String lastName;

	@Column(name = "bank", length = 30)
	private String bank;

	@Column(name = "branch", length = 30)
	private String branch;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "acc_no")
    @JsonBackReference
	private Customer cust;

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	public int getBenefAccountNumber() {
		return benefAccountNumber;
	}

	public void setBenefAccountNumber(int benefAccountNumber) {
		this.benefAccountNumber = benefAccountNumber;
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

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}


}