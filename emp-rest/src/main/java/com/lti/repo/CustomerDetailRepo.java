package com.lti.repo;

import java.util.List;

import com.lti.entity.CustomerDetail;

public interface CustomerDetailRepo {

	void saveCustomerDetail(CustomerDetail customerDetail);

	CustomerDetail fetchByAadharNo(String aadharNo);
	
	List<CustomerDetail> fetchAll();
	
	void updateCustomerDetail(CustomerDetail customerDetail);
	
	void deleteCustomerDetail(long aadharNo); 
}
