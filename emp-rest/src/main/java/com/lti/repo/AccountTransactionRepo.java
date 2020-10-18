package com.lti.repo;

import java.util.*;

import com.lti.entity.AccountTransaction;
/**
 * 
 * @author Avnv
 *
 */

public interface AccountTransactionRepo {

	void saveTransaction(AccountTransaction accTxn);
	
	AccountTransaction fetchTransactionById(int accTransactionId);
	
	List<AccountTransaction> fetchAllTransactions();

	List<AccountTransaction> fetchAllTransactionsByAccNumber(int accNumber);

	List<AccountTransaction> fetchTransactionsBetweenDates(int accNumber, String fromDate, String toDate);

	
	
}
