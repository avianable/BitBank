package com.lti.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.Customer;
import com.lti.entity.CustomerDetail;
import com.lti.repo.CustomerDetailRepo;
import com.lti.repo.CustomerRepo;
/**
 * 
 * @author Avnv
 *
 */
@Service
public class CustomerServiveImpl implements CustomerService {

	@Autowired
	private CustomerRepo custRepo;
	
	@Autowired
	private CustomerDetailRepo custDetailRepo;
	
	@Transactional(value = TxType.REQUIRED)
	public void addCustomer(Customer customer) {
		
		custRepo.save(customer);
	}

	public CustomerDetail fetchCustomerdetails(int accountNumber) {
		Customer c1=custRepo.fetchCustomerByAccNumber(accountNumber);
		CustomerDetail custDetail= c1.getCustDetails();
		String aadharNo=custDetail.getAadharNumber();
		return custDetailRepo.fetchByAadharNo(aadharNo);
	}



	public List<Customer> fetchAllCustomers() {
		return custRepo.fetchAllCustomers();
		
	}

	
	  @Transactional(value = TxType.REQUIRED)
	  public void updateCustomerCredentials(Customer cust) 
	  { 
		  custRepo.update(cust);
	  }
	 

	public Customer fecthCustomerbyAccountNumber(int accountNumber) {
		
		return custRepo.fetchCustomerByAccNumber(accountNumber);
		
	}

	@Transactional(value = TxType.REQUIRED)
	public void deleteCustomer(int accountNumber) {
		 custRepo.deleteByAccNo(accountNumber); 
		
	}
		
	public List<Customer> loadActiveCustomers() {
		return custRepo.fetchAllActiveCustomers();
	}

	public List<Customer> loadPendingCustomers() {
		return custRepo.fetchAllPendingCusotmers();
	}
	
	
	public void updateStatus(int accNumber,String status) {
	   custRepo.updateStatus(accNumber, status);
	}

}
