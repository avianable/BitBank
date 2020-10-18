package com.lti.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Customer;
import com.lti.entity.CustomerDetail;
import com.lti.service.CustomerService;

@CrossOrigin
@RestController
public class CustomerController {

	@Autowired
	private CustomerService custService;

	@PostMapping(value = "/cust/add", consumes = "application/json")
	public String addCustomer(@RequestBody Customer cust) {
		custService.addCustomer(cust);
		return "Customer added successfully";
	}

	
	@GetMapping(value = "/cust/fetchall", produces = "application/json")
	public List<Customer> fetchallcustomers() {
		List<Customer> custList = custService.fetchAllCustomers();
//		for (Customer cust : custList) {
//			System.out.println(cust.getAccountBalance() + "/t" + cust.getAccountNumber() + "/t" + cust.getFirstName());
//		}

		return custList;

	}

	@GetMapping(value = "/cust/listactive", produces = "application/json")
	public List<Customer> listActiveCustomers() {
		return custService.loadActiveCustomers();
	}

	@GetMapping(value = "/cust/listpending", produces = "application/json")
	public List<Customer> listPendinCustomers() {
		return custService.loadPendingCustomers();
	}

	@GetMapping(value = "/cust/fetch/{accNo}", produces = "application/json")
	public Customer getcustomerbyaccountNo(@PathVariable(value = "accNo") int accNo) {
		return custService.fecthCustomerbyAccountNumber(accNo);
	}

	@GetMapping(value = "/cust/fetchdetails/{accNo}", produces = "application/json")
	public CustomerDetail getcustomerDetails(@PathVariable(value = "accNo") int accNo) {
		return custService.fetchCustomerdetails(accNo);
	}

	@PutMapping(value = "/update/{accno}")
	public String updateCustomer(@PathVariable(value = "accno") int accountNo, @RequestBody Customer customer) {

		Customer c1 = custService.fecthCustomerbyAccountNumber(accountNo);
		if (c1 == null) {
			return "Account doesn't exist";
		}
		customer.setAccountNumber(accountNo);
		custService.updateCustomerCredentials(customer);

		return "Update Succesfull";
	}

	@DeleteMapping(value = "/cust/delete/{accNo}")
	public String deleteCustomer(@PathVariable(value = "accNo") int accountNo) {
		if (custService.fecthCustomerbyAccountNumber(accountNo) == null)
			return "Account doesn't Exist";
		custService.deleteCustomer(accountNo);
		return "Custoemr deleted";
	}

	@PutMapping(value = "/updatestatus/{accNo}/{status}")
	public String updatestatus(@PathVariable(value = "accNo") int accountNo,
			@PathVariable(value = "status") String status) {
		Customer c1 = custService.fecthCustomerbyAccountNumber(accountNo);
		if (c1 == null) {
			return "Account doesn't exist";
		}

		custService.updateStatus(accountNo, status);
		return "Status updated";
	}

}
