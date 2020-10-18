package com.lti.service;

import java.util.List;

import com.lti.entity.Customer;
import com.lti.entity.CustomerDetail;

/**
 * 
 * @author Abhinav Anand
 *
 */
public interface CustomerService {

	void addCustomer(Customer customer);
	
	CustomerDetail fetchCustomerdetails(int accountNumber);
	
	List<Customer> fetchAllCustomers();
	
	void updateCustomerCredentials(Customer cust);
	
	public void updateStatus(int accNumber,String status);

	Customer fecthCustomerbyAccountNumber(int accountNumber);

	List<Customer> loadPendingCustomers();
	
	List<Customer> loadActiveCustomers();
	
	void deleteCustomer(int accountNumber);
}
