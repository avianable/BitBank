package com.lti.servicegladiator;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entitygladiator.AccountTransaction;
import com.lti.entitygladiator.Beneficiary;
import com.lti.entitygladiator.Customer;
import com.lti.repogladiator.AccountTransactionRepo;
import com.lti.repogladiator.CustomerRepo;
import com.lti.repogladiator.RegisterRepo;

/**
 * 
 * @author Abhinav Anand
 * 
 * @version 1.0.0
 * 
 *          Implementation of Account transaction services
 *
 */

@Service
public class AccountTransactionServiceImpl implements AccounTransactionService {

	@Autowired
	private AccountTransactionRepo accTxnRepo;

	@Autowired
	private CustomerRepo custRepo;

	@Autowired
	private RegisterRepo regRepo;

	@Transactional
	public List<AccountTransaction> fetchAllTransactions() {
		return accTxnRepo.fetchAllTransactions();
	}

	@Transactional
	public List<AccountTransaction> fetchTransactionByAccNumber(int accNumber) {
		return accTxnRepo.fetchAllTransactionsByAccNumber(accNumber);
	}

	@Transactional(value = TxType.REQUIRED)
	public void credit(String senderName, int accNumber, double money) {

		Customer receiver = custRepo.fetchCustomers(accNumber);

		double balanceBeforeCredit = receiver.getAccountBalance();
		double balanceAfterCredit = balanceBeforeCredit + money;
		custRepo.updateAccountBalance(accNumber, balanceAfterCredit);

		AccountTransaction accTxn = new AccountTransaction();

		java.util.Date date = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String strDate = sdf.format(date);

		accTxn.setDetail(senderName + "/BitBank/CR/" + money);
		accTxn.setTxnAmount(money);
		accTxn.setTransactionType("Credit");
		accTxn.setBalance(balanceBeforeCredit);

		accTxn.setTransactionDate(strDate);
		accTxn.setCust(receiver);

		accTxnRepo.saveTransaction(accTxn);
	}

	@Transactional(value = TxType.REQUIRED)
	public boolean debitSuccess(int accNumber, double money) throws Exception {

		double accBalance = custRepo.getAccountBalance(accNumber);
		// System.out.println(accBalance);

		if (accBalance < money) {
			throw new Exception("Insufficient funds !!");
		}

		else if (money <= 0) {
			throw new Exception("Transfer amount must be greater than 0");
		}

		else {
			double updatedBalance = accBalance - money;

			custRepo.updateAccountBalance(accNumber, updatedBalance);

			return true;
		}

	}

	@Transactional(value = TxType.REQUIRED)
	public void transferFundsToAccount(int senderAccountNumber, int receiverAccountNumber, double money)
			throws Exception {

		boolean isSenderValid = custRepo.checkValidAccountNumber(senderAccountNumber);

		if (!isSenderValid || (senderAccountNumber == receiverAccountNumber)) { // check if sender account number is
																				// valid and not same as receiver

			throw new Exception("Please enter a valid account number");

		}

		else {
			double balanceBeforeDebit = custRepo.getAccountBalance(senderAccountNumber);

			boolean isDebitSuccessful = debitSuccess(senderAccountNumber, money);

			if (isDebitSuccessful) {

				Customer sender = custRepo.fetchCustomers(senderAccountNumber);

				AccountTransaction accTxn = new AccountTransaction();

//				long millis = System.currentTimeMillis();
//				java.sql.Date date = new java.sql.Date(millis);

				java.util.Date date = new java.util.Date();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				String strDate = sdf.format(date);

				accTxn.setDetail(receiverAccountNumber + "/DR/" + money);
				accTxn.setTxnAmount(money);
				accTxn.setTransactionType("Debit");
				accTxn.setBalance(balanceBeforeDebit);

				accTxn.setTransactionDate(strDate);
				accTxn.setCust(sender);

				String senderMobileNumber = sender.getCustDetails().getMobileNumber();

				String senderAccNumberString = Integer.toString(senderAccountNumber);
				String senderMessage = "BitBank \n\n Your account number XXXXX" + senderAccNumberString.substring(2)
						+ " has been debited with" + " Rs " + money + ".";

				regRepo.sendMail(sender.getEmail(), senderMessage);

				regRepo.sendOTP(senderMessage, senderMobileNumber);

				System.out.println(senderMessage);

				boolean isReceiverOfSameBank = custRepo.checkValidAccountNumber(receiverAccountNumber); // Check if
																										// reciever is
																										// of same bank

				if (isReceiverOfSameBank) {

					Customer receiver = custRepo.fetchCustomers(receiverAccountNumber);

					credit(sender.getFirstName(), receiverAccountNumber, money);
					accTxn.setDetail(receiver.getFirstName() + "/DR/" + money);
					accTxn.setCust(sender);

					String receiverMobileNumber = receiver.getCustDetails().getMobileNumber();

					String recieverAccNumberString = Integer.toString(receiverAccountNumber);

					String receiverMessage = "BitBank \n\n Your account number XXXXX"
							+ recieverAccNumberString.substring(2) + " has been credited with" + " Rs " + money + ".";

					regRepo.sendMail(receiver.getEmail(), receiverMessage);

					regRepo.sendOTP(receiverMessage, receiverMobileNumber);

					System.out.println(receiverMessage);

				}

				accTxnRepo.saveTransaction(accTxn);
			}
		}

	}

	@Transactional(value = TxType.REQUIRED)
	public void transferFundsToBeneficiary(int senderAccountNumber, Beneficiary beneficiary, double money)
			throws Exception {

		transferFundsToAccount(senderAccountNumber, beneficiary.getBenefAccountNumber(), money);

	}
}