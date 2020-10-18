package com.lti.repogladiator;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.entitygladiator.AccountTransaction;
import com.lti.entitygladiator.Beneficiary;
import com.lti.entitygladiator.Customer;
/**
 * 
 * @author Avnv
 *
 */
@Repository
public class AccountTransactionRepoImpl implements AccountTransactionRepo {

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private CustomerRepo custRepo;
	
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

	
	public List<AccountTransaction> fetchAllTransactionsByAccNumber(int accNumber) {			// To be resolved
		Customer c1=em.find(Customer.class,accNumber);
		Query query = em.createQuery("SELECT txn FROM AccountTransaction txn INNER JOIN txn.cust c WHERE c.accountNumber=:accNumber");
		query.setParameter("accNumber",accNumber);
		List<AccountTransaction> txnList=query.getResultList();
		return txnList;
		/*
		 * Query q1 = em.createQuery(jpql); q1.setParameter("accNumber", accNumber);
		 * List<AccountTransaction> txnList = q1.getResultList(); return txnList;
		 */

	}



}
