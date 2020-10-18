package com.lti.repo;
/**
 * 
 * @author Mitshu
 * 
 * This is an repo for Customer.
 * 
 * version 1.0
 * 
 *
 */
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.lti.entity.Customer;

@Repository
public class CustomerRepoImpl implements CustomerRepo {

	@PersistenceContext
	private EntityManager em;
	
	@Transactional(value = TxType.REQUIRED)
	public void save(Customer customer) {
		em.persist(customer);
	}

	@Transactional(value = TxType.REQUIRED)
	public Customer fetchCustomerByAccNumber(int accNumber) {
		Customer customer=em.find(Customer.class, accNumber) ;
		return customer;
	}


	@Transactional
	public List<Customer> fetchAllCustomers() {
		return 	em.createQuery("from Customer").getResultList();
		
	}
	
	@Transactional(value = TxType.REQUIRED)
	public void update(Customer customer) {
		em.merge(customer);
		
	}

	@Transactional(value = TxType.REQUIRED)
	public void deleteByAccNo(int accNumber) {
		em.remove(em.find(Customer.class, accNumber));
	}

	
	@Transactional
	public double getAccountBalance(int accNumber) {
		Customer customer = em.find(Customer.class, accNumber);
		return customer.getAccountBalance();
	}

	@Transactional
	public Boolean checkValidAccountNumber(int accNumber) {
		if( em.find(Customer.class, accNumber) == null) {
			return false;
		}
		return true;
	}
	
	@Transactional(value = TxType.REQUIRED)
	public Boolean checkAccountStatus(int accNumber) {
		Customer customer = em.find(Customer.class, accNumber);
		
		if(customer.getStatus().equalsIgnoreCase("Active")) {
			return true;
		}
		return false;
	}
	
	@Transactional(value = TxType.REQUIRED)
	public void updateAccountBalance(int accNumber, double updatedBalance) {
		Customer customer = em.find(Customer.class, accNumber);
		customer.setAccountBalance(updatedBalance);
		
		em.merge(customer);
	}

	@Transactional(value = TxType.REQUIRED)
	public void updateStatus(int accNumber, String status) {
		Customer customer=em.find(Customer.class,accNumber);
		 customer.setStatus(status);
		
	}

	public List<Customer> fetchAllActiveCustomers() {
		return em.createQuery("from Customer where status='active'").getResultList();
	}

	public List<Customer> fetchAllPendingCusotmers() {
		return em.createQuery("from Customer where status='pending'").getResultList();
	}




	
} 








