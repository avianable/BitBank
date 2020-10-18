package com.lti.repogladiator;

/**
 * 
 * @author Mitshu
 * 
 * This is an repoimpl for Customer.
 * 
 * version 1.0
 * 
 *
 */
import java.util.List;

import com.lti.entitygladiator.Customer;

public interface CustomerRepo {

	void save(Customer customers);

	Customer fetchCustomers(int accountNumber);

	List<Customer> fetchAllCustomers();

	void update(Customer cust);
	public void updateStatus(int accNumber,String status);

	void deleteCustomer(int accountNumber); 

	
	  Double getAccountBalance(int accNumber);
	 
	  Boolean checkValidAccountNumber(int accNumber);
	  
	  Boolean checkAccountStatus(int accNumber);
	  
	  void updateAccountBalance(int accNumber, Double money);
	   List<Customer> fetchAllActiveCustomers();
	   List<Customer> fetchAllPendingCusotmers();
	   List<Customer> fetchCustomersByStatus(String status);
	 

}
