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

import com.lti.entity.Customer;

public interface CustomerRepo {

	void save(Customer cust);

	Customer fetchCustomerByAccNumber(int accNumber);

	List<Customer> fetchAllCustomers();
	
	void update(Customer customer);
	
	void deleteByAccNo(int accNumber);
	
	double getAccountBalance(int accNumber);
	
	Boolean checkValidAccountNumber(int accNumber);
	
	Boolean checkAccountStatus(int accNumber);
	
	void updateAccountBalance(int accNumber, double money);
	
	void updateStatus(int accNumber,String status);
	
	List<Customer> fetchAllActiveCustomers();

	List<Customer> fetchAllPendingCusotmers();
}
