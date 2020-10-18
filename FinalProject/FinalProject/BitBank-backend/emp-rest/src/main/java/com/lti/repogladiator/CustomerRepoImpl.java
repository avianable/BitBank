package com.lti.repogladiator;

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
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.lti.entitygladiator.Customer;

@Repository
public class CustomerRepoImpl implements CustomerRepo {

	@PersistenceContext
	private EntityManager em;

	@Transactional(value = TxType.REQUIRED)
	public void save(Customer cust) {
		em.persist(cust);

	}

	public Customer fetchCustomers(int accountNumber) {
		Customer c1 = em.find(Customer.class, accountNumber);
		return c1;
	}

	public List<Customer> fetchAllCustomers() {
		return em.createQuery("from Customer").getResultList();

	}

	@Transactional(value = TxType.REQUIRED)
	public void update(Customer cust) {
		em.merge(cust);
	}

	@Transactional(value = TxType.REQUIRED)
	public void deleteCustomer(int accountNumber) {
		em.remove(em.find(Customer.class, accountNumber));
	}

	@Transactional
	public Double getAccountBalance(int accNumber) {
		Customer customer = em.find(Customer.class, accNumber);
		return customer.getAccountBalance();
	}

	@Transactional
	public Boolean checkValidAccountNumber(int accNumber) {
		if (em.find(Customer.class, accNumber) == null) {
			return false;
		}
		return true;
	}

	@Transactional(value = TxType.REQUIRED)
	public Boolean checkAccountStatus(int accNumber) {
		Customer customer = em.find(Customer.class, accNumber);

		if (customer.getStatus().equalsIgnoreCase("Active")) {
			return true;
		}
		return false;
	}

	@Transactional(value = TxType.REQUIRED)
	public void updateAccountBalance(int accNumber, Double updatedBalance) {
		Customer customer = em.find(Customer.class, accNumber);
		customer.setAccountBalance(updatedBalance);

		em.merge(customer);
	}

	@Transactional(value = TxType.REQUIRED)
	public void updateStatus(int accNumber, String status) {
		Customer customer = em.find(Customer.class, accNumber);
		customer.setStatus(status);

		em.merge(customer);
	}

	public List<Customer> fetchAllActiveCustomers() {
		return em.createQuery("from Customer where status='active'").getResultList();
	}

	public List<Customer> fetchAllPendingCusotmers() {
		return em.createQuery("from Customer where status='pending'").getResultList();
	}

	
	public List<Customer> fetchCustomersByStatus(String status) {
		String myQuery = "from Customer where status =:theStatus";
		Query ListCustomerByStatus = em.createQuery(myQuery);
		ListCustomerByStatus.setParameter("theStatus",status);
		return ListCustomerByStatus.getResultList(); 
	}
}
