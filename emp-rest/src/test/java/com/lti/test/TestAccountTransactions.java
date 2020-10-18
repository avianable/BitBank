package com.lti.test;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lti.entity.AccountTransaction;
import com.lti.entity.Beneficiary;
import com.lti.entity.Customer;
import com.lti.repo.AccountTransactionRepo;
import com.lti.repo.BeneficiaryRepo;
import com.lti.repo.CustomerRepo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:appctx.xml")
public class TestAccountTransactions {

	@Autowired
	private CustomerRepo custRepo;
	
	@Autowired
	private AccountTransactionRepo accTxnRepo;
	
	@Autowired
	private BeneficiaryRepo benefRepo;
	
	@Test
	public void testTransferToBeneficiary() {
		AccountTransaction acTxn1 = new AccountTransaction();
		
		Customer c1 = custRepo.fetchCustomerByAccNumber(12347);
		
		if(c1.getAccountBalance() < acTxn1.getTxnAmount()) {
			System.out.println("Nahi hai bhai itte paise");
		}
		else {
			
			double bal = c1.getAccountBalance() - acTxn1.getTxnAmount();
			c1.setAccountBalance(bal);
			acTxn1.setDetail("aish ke liye");
//			acTxn1.setTransactionDate(new Date());
//			acTxn1.setCust(c1);
			
			Beneficiary b1 = benefRepo.fetchBeneficiaryByAccNumber(65457);
//			acTxn1.setBenef(b1);
			
			custRepo.update(c1);
			accTxnRepo.saveTransaction(acTxn1);;
		}		
		
	}
	
	@Test
	public void testFetchAllTransactions() {
		List<AccountTransaction> txnList = accTxnRepo.fetchAllTransactions();
		for (AccountTransaction accountTransaction : txnList) {
			System.out.println(accountTransaction.getTransactionId() + "\t" + accountTransaction.getTransactionDate());
		}
	}
	
	@Test
	public void testFetchTransactionById() {
		AccountTransaction acTxn = accTxnRepo.fetchTransactionById(987654);
		System.out.println(acTxn.getBalance() + "\t" + acTxn.getTransactionDate());
	}
	
}
