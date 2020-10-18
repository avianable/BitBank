package com.lti.servicegladiator;

import com.lti.entitygladiator.Customer;
import com.lti.pojogladiator.OTP;

public interface RegisterService {

	void saveCustomer(Customer customer);

	Customer fetchCustomerByEmail(String email);

	Customer fetchCustomerByUsernameAndPassword(String username, String password);

	Customer fetchCustomerByAccNumber(int tempAccNumber);

	void updateCustomer(Customer customer);

	void sendMail(String email, String message);

	OTP sendOTP(String message, String number);
}