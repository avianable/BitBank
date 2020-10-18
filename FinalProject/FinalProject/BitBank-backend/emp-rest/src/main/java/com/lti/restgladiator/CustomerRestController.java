package com.lti.restgladiator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.User;
import com.lti.entitygladiator.Customer;
import com.lti.entitygladiator.CustomerDetail;
import com.lti.servicegladiator.CustomerService;
import com.lti.servicegladiator.RegisterService;

import oracle.jdbc.proxy.annotation.Post;

@CrossOrigin
@RestController
public class CustomerRestController {
  @Autowired
  private CustomerService custService;
  @Autowired
  private RegisterService regservice;
  
  
  @PostMapping(value = "/cust/add", consumes = "application/json")
	public String addCustomer(@RequestBody Customer cust) {
		custService.addCustomer(cust);
		return "Customer added successfully";
	}
  @GetMapping(value="cust/fetchall",produces="application/json")
  public List <Customer> fetchallcustomers()
  {
	  List <Customer> custs = custService.fetchAllCustomers();
	  for(Customer cust:custs)
	  {
		  System.out.println(cust.getAccountBalance()+"/t"+cust.getAccountNumber()+"/t"+cust.getFirstName());
	  }
	  
	  return custs;
	  
  }
  @GetMapping(value = "/cust/list/all", produces = "application/json")
	public List<Customer> listAllCustomer() {
		return custService.fetchAllCustomers();
	}

	@GetMapping(value = "/cust/list/{status}", produces = "application/json")
	public List<Customer> listCustomersByStatus(@PathVariable(value = "status") String theStatus) {
		return custService.loadCustomersByStatus(theStatus); 
	}
  
  @GetMapping(value = "/cust/listactive", produces = "application/json")
	public List<Customer> listActiveCustomers(){
		return custService.loadActiveCustomers();
	}
	
	@GetMapping(value = "/cust/listpending", produces = "application/json")
	public List<Customer> listPendinCustomers(){
		return custService.loadPendingCustomers();
	}
  
  @GetMapping(value="cust/fetch/{accNo}",produces = "application/json")
  public Customer getcustomerbyaccountNo(@PathVariable(value = "accNo") int  accNo)
  {
	  return custService.fecthCustomerbyAccountNumber(accNo);
  }
  
  @GetMapping(value="cust/fetchdetails/{accNo}",produces = "application/json")
  public CustomerDetail getcustomerDetails(@PathVariable(value = "accNo") int accNo)
  {
	  return custService.fetchCustomerdetails(accNo);
  }
  
  
  @PutMapping(value = "/update/{accno}")
  public String updateCustomer(@PathVariable(value = "accno") int accountNo,
		   @RequestBody Customer customer){
	    
	    Customer c1=custService.fecthCustomerbyAccountNumber(accountNo);
	    if(c1==null)
	    {
	    	return "Account doesn't exist";
	    }
	    customer.setAccountNumber(accountNo); 
	    custService.updateCustomerCredentials(customer);
	    
	    return "Update Succesfull";
  }
  
  @DeleteMapping(value = "/cust/delete/{accNo}")
  public String deleteCustomer(@PathVariable(value="accNo") int accountNo)
  {
	  if(custService.fecthCustomerbyAccountNumber(accountNo)==null)
		  return "Account doesn't Exist";
	  custService.deleteCustomer(accountNo);
	  return "Custoemr deleted"; 
  }
  
  
  @PutMapping(value = "/updatestatus/{accNo}/{status}")
  public String updatestatus(@PathVariable(value="accNo") int accountNo,@PathVariable(value="status") String status)
  {
	  Customer c1=custService.fecthCustomerbyAccountNumber(accountNo);
	    if(c1==null)
	    {
	    	return "Account doesn't exist";
	    }
	    
	    custService.updateStatus(accountNo, status);
	    System.out.println("customer status "+ c1.getStatus());
	    
	    if(c1.getStatus().equalsIgnoreCase("pending"))
	    {
	       String message="Welcome to Bitbank.. Your application has been approved. Your Account Number is "+ accountNo +" .\n \n Please visit our website to "
	    		+ "register for net banking. Thank you for choosing us !!";	
	      regservice.sendMail(c1.getEmail(), message);
	    
	      regservice.sendOTP(message, c1.getCustDetails().getMobileNumber());
	    }
	    return "Status updated";
  }
  
  
  
}
  
