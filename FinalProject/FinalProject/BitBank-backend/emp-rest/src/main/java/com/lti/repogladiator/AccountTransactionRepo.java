package com.lti.repogladiator;

import java.util.List;

import com.lti.entitygladiator.AccountTransaction;
import com.lti.entitygladiator.Beneficiary;
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

	
	
}
