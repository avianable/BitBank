package com.lti.servicegladiator;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lti.entitygladiator.CustomerDetail;

@Service
public interface CustomerDetailsService {
	void addCustomer(CustomerDetail customerDetail);

	CustomerDetail fetchCustomerdetails(long aadharNo);

	List<CustomerDetail> fetchAllCustomerDetails();
	
	
	void updatecustomerDetails(long aadharNo);
}
