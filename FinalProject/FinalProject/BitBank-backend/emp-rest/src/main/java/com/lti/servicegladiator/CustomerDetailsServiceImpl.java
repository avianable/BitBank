package com.lti.servicegladiator;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entitygladiator.CustomerDetail;
import com.lti.repogladiator.CustomerDetailRepo;

@Service
public class CustomerDetailsServiceImpl implements CustomerDetailsService {

	@Autowired
	private CustomerDetailRepo custRepo;
	
	@Transactional(value = TxType.REQUIRED)
	public void addCustomer(CustomerDetail customerDetail) {
		
          custRepo.saveCustomerDetail(customerDetail);
	}

	public CustomerDetail fetchCustomerdetails(long accountNumber) {
		
		return null;
	}

	public List<CustomerDetail> fetchAllCustomerDetails() {
	
		return custRepo.fetchAll();
	}

	@Transactional(value = TxType.REQUIRED)
	public void updatecustomerDetails(long aadharNo) {
		

	}

}
