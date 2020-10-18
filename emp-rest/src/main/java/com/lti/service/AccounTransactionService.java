package com.lti.service;

import java.util.Date;
import java.util.List;

import com.lti.entity.AccountTransaction;
import com.lti.entity.Beneficiary;
/**
 * 
 * @author Abhinav Anand	
 * 
 * 	@version 1.0.0
 * 
 * Service for transferring funds and fetching transactional details
 * 
 */

public interface AccounTransactionService {

	List<AccountTransaction> fetchAllTransactions();	// Only for Admin
	
	List<AccountTransaction> fetchTransactionsBetweenDates(int accNumber,String fromDate, String toDate);
	
	List<AccountTransaction> fetchTransactionByAccNumber(int accNumber);
	
	void credit(String senderName, int accNumber, double money);
	
	boolean debitSuccess(int accNumber, double money) throws Exception;
	
	void transferFundsToBeneficiary(int senderAccountNumber, Beneficiary beneficiary, double money) throws Exception;
	
	void transferFundsToAccount(int senderAccountNumber, int receiverAccountNumber, double money) throws Exception;
	
}
