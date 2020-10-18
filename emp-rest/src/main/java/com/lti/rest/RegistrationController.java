package com.lti.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Customer;
import com.lti.pojo.OTP;
import com.lti.service.RegisterService;

/*
 *  @author Abhinav Anand
 */

@CrossOrigin
@RestController
public class RegistrationController {

	@Autowired
	private RegisterService service;

	@PostMapping(value = "/register/savingsacc", consumes = "application/json")
	public Customer registerCustomerForSavingsAccount(@RequestBody Customer customer) throws Exception {

		String tempEmail = customer.getEmail();
		if (tempEmail != null && !"".equals(tempEmail)) {
			Customer customerObj = service.fetchCustomerByEmail(tempEmail);

			if (customerObj != null) {
				throw new Exception("customer already exists !!");
			}
		}

		service.saveCustomer(customer);
		
		String mobileNumber = customer.getCustDetails().getMobileNumber();
		
		String message = "Welcome to BitBank.. You have successfully registered with us."
				+ "Your reference number is " + customer.getAccountNumber()
				+ ". Your application is yet to approve. Kindly wait for 3 working days. Thank you..";
		
		service.sendMail(customer.getEmail(), message);
		
		service.sendOTP("  BitBank - Thank you for registering with us."
				+ "Your reference number is "+ customer.getAccountNumber(), mobileNumber);
		
		return customer;
	}

	@PostMapping(value = "/login", consumes = "application/json")
	public Customer loginCustomer(@RequestBody Customer customer) throws Exception {

		String tempUsername = customer.getUserName();
		String tempPassword = customer.getPassword();

		Customer customerObj = null;
		if (tempUsername != null && tempPassword != null) {
			customerObj = service.fetchCustomerByUsernameAndPassword(tempUsername, tempPassword);
		}

		if (customerObj == null) {
			throw new Exception("Invalid username and password");
		}

		return customerObj;

	}

	@PutMapping(value = "/register/netbanking/{accno}", consumes = "application/json")		
	public Customer registerCustomerForNetBanking(@PathVariable(value = "accno") int accountNo,
			@RequestBody Customer customer) throws Exception {

		Customer customerObj = service.fetchCustomerByAccNumber(accountNo);

		if (customerObj.getStatus().equalsIgnoreCase("pending")) {
			throw new Exception("Account approval in process. Contact Branch");
		}

		if (customerObj != null && customerObj.getStatus().equalsIgnoreCase("active")
				&& customerObj.getUserName() != null && customerObj.getPassword() != null) {	
			throw new Exception("Already using net banking !! Please login..");
		}

		customerObj.setUserName(customer.getUserName());
		customerObj.setPassword(customer.getPassword());

		service.updateCustomer(customerObj);
		String message = "Hello " + customerObj.getFirstName() + ".. Welcome to BitBank.. You have successfully registered for netbanking."
				+ "Your username is " + customerObj.getUserName() + " and password is " + customerObj.getPassword() + " . Login with"
						+ " the following credentials. Thank you for choosing us..";
		service.sendMail(customerObj.getEmail(), message);
		return customerObj;
	}
	
	@PostMapping(value = "/otp-forget-id-pass/{accNumber}", consumes="application/json")		// sending OTP to validate for update user request
	public OTP forgetIdPasswordOTP(@PathVariable(value = "accNumber") int accNumber) throws Exception {
		
		Customer customerObj = service.fetchCustomerByAccNumber(accNumber);
		
		if(customerObj == null) {
			throw new Exception("Invalid account number");
		}
		String number = customerObj.getCustDetails().getMobileNumber();
		
		OTP otp = new OTP();
		otp.setOtpMessage(otp.generateOTP(6));
		
		service.sendOTP("  BitBank - Your OTP for updating username or password is "+ otp.getOtpMessage(), number);
		return otp;

	}
	
	@PutMapping(value = "/update-uname-pwd/{accNumber}", consumes = "application/json")				// update username and password
	public Customer updateUsernamePassword(@PathVariable(value = "accNumber") int accNumber,
			@RequestBody Customer customer) {

		Customer customerObj = service.fetchCustomerByAccNumber(accNumber);		

		customerObj.setUserName(customer.getUserName());
		customerObj.setPassword(customer.getPassword());

		service.updateCustomer(customerObj);
		return customerObj;
	}

}
