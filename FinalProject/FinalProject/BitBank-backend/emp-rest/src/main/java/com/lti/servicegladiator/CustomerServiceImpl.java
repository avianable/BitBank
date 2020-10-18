package com.lti.servicegladiator;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entitygladiator.Customer;
import com.lti.entitygladiator.CustomerDetail;

import com.lti.repogladiator.CustomerDetailRepo;
import com.lti.repogladiator.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepo custRepo;

	@Autowired
	private CustomerDetailRepo custDetailRepo;

	@Transactional(value = TxType.REQUIRED)
	public void addCustomer(Customer customer) {

		custRepo.save(customer);
	}

	public CustomerDetail fetchCustomerdetails(int accountNumber) {
		Customer c1 = custRepo.fetchCustomers(accountNumber);
		CustomerDetail custDetail = c1.getCustDetails();
		String aadharNo = custDetail.getAadharNumber();
		return custDetailRepo.fetch(aadharNo);
	}

	public List<Customer> fetchAllCustomers() {
		return custRepo.fetchAllCustomers();

	}

	@Transactional(value = TxType.REQUIRED)
	public void updateCustomerCredentials(Customer cust) {
		custRepo.update(cust);
	}

	public Customer fecthCustomerbyAccountNumber(int accountNumber) {

		return custRepo.fetchCustomers(accountNumber);

	}

	@Transactional(value = TxType.REQUIRED)
	public void deleteCustomer(int accountNumber) {
		custRepo.deleteCustomer(accountNumber);

	}

	public List<Customer> loadActiveCustomers() {
		// TODO Auto-generated method stub
		return custRepo.fetchAllActiveCustomers();
	}

	public List<Customer> loadPendingCustomers() {
		// TODO Auto-generated method stub
		return custRepo.fetchAllPendingCusotmers();
	}

	public void updateStatus(int accNumber, String status) {
		custRepo.updateStatus(accNumber, status);
	}

	public List<Customer> loadCustomersByStatus(String status) {
		return custRepo.fetchCustomersByStatus(status);
	}

}
