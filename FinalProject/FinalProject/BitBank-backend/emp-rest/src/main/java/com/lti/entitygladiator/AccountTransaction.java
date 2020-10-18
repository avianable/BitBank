package com.lti.entitygladiator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * 
 * @author Avnv
 * 
 *         This is an entity for account transactions.
 * 
 *         It is having ManyToOne relationship with Customer and
 * 
 *         OneToOne relationship with Beneficiary
 * 
 *
 */

@Entity
@Table(name = "acc_transactions")
@SequenceGenerator(name = "txnseq", sequenceName = "seq_txn", initialValue = 987654, allocationSize = 1)
public class AccountTransaction {

	@Column(name = "txn_date")
	private String transactionDate;

	@Id
	@GeneratedValue(generator = "txnseq", strategy = GenerationType.SEQUENCE)
	@Column(name = "txn_id")
	private int transactionId;

	@Column(name = "details", length = 30)
	private String detail;

	@Column(name = "txn_type")
	private String transactionType;

	@Column(name = "txn_amount")
	private double txnAmount;

	@Column(name = "balance")
	private double balance;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cust_acc_number")
	@JsonBackReference
	private Customer cust;

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public double getTxnAmount() {
		return txnAmount;
	}

	public void setTxnAmount(double txnAmount) {
		this.txnAmount = txnAmount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}