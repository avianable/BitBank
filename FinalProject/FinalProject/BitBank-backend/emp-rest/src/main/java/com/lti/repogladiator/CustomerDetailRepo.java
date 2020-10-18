package com.lti.repogladiator;

import java.util.List;

import com.lti.entitygladiator.CustomerDetail;



public interface CustomerDetailRepo {

	void saveCustomerDetail(CustomerDetail customerDetail); 
	
	void updateCustomerDetail(CustomerDetail customerDetail);
	
	void deleteCustomerDetail(String aadharNo); 

	CustomerDetail fetch(String aadharNo); 
	
	List<CustomerDetail> fetchAll();
}