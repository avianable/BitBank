package com.lti.servicegladiator;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lti.entitygladiator.Customer;
import com.lti.entitygladiator.CustomerDetail;

@Service
public interface CustomerService {
	void addCustomer(Customer customers);

	CustomerDetail fetchCustomerdetails(int accountNumber);

	List<Customer> fetchAllCustomers();

	void updateCustomerCredentials(Customer cust);

	public void updateStatus(int accNumber, String status);

	Customer fecthCustomerbyAccountNumber(int accountNumber);

	List<Customer> loadPendingCustomers();

	List<Customer> loadActiveCustomers();

	void deleteCustomer(int accountNumber);

	List<Customer> loadCustomersByStatus(String status);
}
