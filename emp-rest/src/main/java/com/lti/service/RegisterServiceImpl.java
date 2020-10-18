package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.Customer;
import com.lti.pojo.OTP;
import com.lti.repo.RegisterRepo;

@Service
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private RegisterRepo repo;
	
	public void saveCustomer(Customer customer) {
		repo.saveCustomer(customer);

	}

	public Customer fetchCustomerByEmail(String email) {
		return repo.fetchCustomerByEmail(email);
	}

	public Customer fetchCustomerByUsernameAndPassword(String username, String password) {
		return repo.fetchCustomerByUsernameAndPassword(username, password);
	}

	public Customer fetchCustomerByAccNumber(int accNumber) {
		return repo.fetchCustomerByAccNumber(accNumber);
		
	}

	public void updateCustomer(Customer customer) {
		repo.updateCustomer(customer);
	}

	public void sendMail(String email, String message) {
		repo.sendMail(email, message);
		
	}

	public OTP sendOTP(String message, String number) {
		return repo.sendOTP(message, number);
	}

	

}
