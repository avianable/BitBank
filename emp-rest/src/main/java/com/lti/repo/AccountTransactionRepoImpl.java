package com.lti.repo;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.lti.entity.AccountTransaction;
import com.lti.entity.Customer;
/**
 * 
 * @author Avnv
 *
 */
@Repository
public class AccountTransactionRepoImpl implements AccountTransactionRepo {

	@PersistenceContext
	private EntityManager em;
	
	
	@Transactional(value = TxType.REQUIRED)
	public void saveTransaction(AccountTransaction accTxn) {
		em.persist(accTxn);

	}
	

	public AccountTransaction fetchTransactionById(int accTransactionId) {
		return em.find(AccountTransaction.class, accTransactionId);
	}

	
	public List<AccountTransaction> fetchAllTransactions() {
		return em.createQuery("from AccountTransaction").getResultList();
	}

	
	
	public List<AccountTransaction> fetchAllTransactionsByAccNumber(int accNumber) {	
		
		Customer customer = em.find(Customer.class, accNumber);
		return customer.getTxnList();

	}


	public List<AccountTransaction> fetchTransactionsBetweenDates(int accNumber, String fromDate, String toDate) {
		
//		java.util.Date date = new java.util.Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//		String strFromDate = sdf.format(fromDate);
//		String strToDate = sdf.format(toDate);

		List<AccountTransaction> acctxnList = null;
		
		try {
			Query query = em.createNamedQuery("txnlistbetweendates");
			query.setParameter("from", fromDate);
			query.setParameter("to", toDate);
			query.setParameter("accno", accNumber);

			
			 acctxnList = query.getResultList();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		
		return acctxnList;
	}



}
