package com.lti.restgladiator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entitygladiator.CustomerDetail;
import com.lti.servicegladiator.CustomerDetailsService;

@CrossOrigin
@RestController
public class CustomerrDetailRestController {
	
	@Autowired
	CustomerDetailsService custDetailservice;
	@PostMapping(value = "/addcustdetails",consumes ="application/json")
	public String addCustomerDetail(@RequestBody CustomerDetail custDetail) {
		custDetailservice.addCustomer(custDetail);
		return "CustomerDetail added successfully";
	}
	
	 @GetMapping(value =  "/allcustdetails",produces = "application/json")
	 public List <CustomerDetail> getAllDetails()
	 {
		 return custDetailservice.fetchAllCustomerDetails();
	 }
}
