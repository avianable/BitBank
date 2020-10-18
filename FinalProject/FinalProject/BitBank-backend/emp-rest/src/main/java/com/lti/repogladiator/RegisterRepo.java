package com.lti.repogladiator;

import com.lti.entitygladiator.Customer;
import com.lti.pojogladiator.OTP;

public interface RegisterRepo {
void saveCustomer(Customer customer);
	
	Customer fetchCustomerByEmail(String email);
	
	Customer fetchCustomerByUsernameAndPassword(String username, String password);

	Customer fetchCustomerByAccNumber(int accNumber);

	void updateCustomer(Customer customer);
	
	void sendMail(String email, String message);

	OTP sendOTP(String message, String number);
}
