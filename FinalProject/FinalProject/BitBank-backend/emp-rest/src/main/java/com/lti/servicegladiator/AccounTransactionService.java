
package com.lti.servicegladiator;

import java.util.List;

import com.lti.entitygladiator.AccountTransaction;
import com.lti.entitygladiator.Beneficiary;

/**
 * 
 * @author Abhinav Anand
 * 
 * @version 1.0.0
 * 
 *          Service for transferring funds and fetching transactional details
 * 
 */

public interface AccounTransactionService {

	List<AccountTransaction> fetchAllTransactions(); // Only for Admin

	List<AccountTransaction> fetchTransactionByAccNumber(int accNumber);

	void credit(String senderName, int accNumber, double money);

	boolean debitSuccess(int accNumber, double money) throws Exception;

	void transferFundsToBeneficiary(int senderAccountNumber, Beneficiary beneficiary, double money) throws Exception;

	void transferFundsToAccount(int senderAccountNumber, int receiverAccountNumber, double money) throws Exception;
}
