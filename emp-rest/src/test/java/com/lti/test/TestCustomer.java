package com.lti.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lti.entity.Customer;
import com.lti.entity.CustomerDetail;
import com.lti.repo.CustomerRepo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:appctx.xml")
public class TestCustomer {

	@Autowired
	private CustomerRepo custRepo;
//	
//	@Autowired
//	private CustomerDetailRepo custDetailRepo;
//	
//	@Autowired
//	private AccountTransactionRepo accTransactionRepo;
//	
//	@Autowired
//	private BeneficiaryRepo benefRepo;
	
	@Test
	public void testAddCustomer() {
		
		Customer c1 = new Customer();
		c1.setFirstName("Jon");
		c1.setLastName("Snow");
		c1.setUserName("targarean");
		c1.setPassword("Daenerys");
		c1.setAccountBalance(20000);
//		c1.setStatus("active");
		
		CustomerDetail c1Detail = new CustomerDetail();
		c1Detail.setAadharNumber("784512481515");
		c1Detail.setPanNumber("GREATWAALL");
		c1Detail.setAge(36);	
//		c1Detail.setEmail("imrealking@whitewalker.com");
		c1Detail.setMobileNumber("9562518462");
		c1Detail.setStreet("King's Street");
		c1Detail.setCity("Winterfell");	
		c1Detail.setState("King's Landing");
		c1Detail.setPincode(124598);
		
		c1.setCustDetails(c1Detail);
//		c1Detail.setCustomer(c1);
		
		custRepo.save(c1);
		
	}
	
	@Test
	public void testFetchAll() {
		List<Customer> customers = custRepo.fetchAllCustomers();
		for (Customer customer : customers) {
			System.out.println(customer.getFirstName());
		}
	}
	
	@Test
	public void testFetchById() {
		Customer c1 = custRepo.fetchCustomerByAccNumber(12345);
		
		System.out.println(c1.getFirstName() + "\t" + c1.getAccountBalance());
	}
	
	@Test
	public void testUpdate() {
		Customer c1 = custRepo.fetchCustomerByAccNumber(12347);
		c1.setAccountBalance(12000);
		c1.setLastName("Targareayan");
		c1.setPassword("Yigreete");
		c1.setUserName("wokenFromDead");
		c1.setStatus("Pending");
		custRepo.update(c1);	
	}
	
	@Test
	public void testDeleteCustomer() {
		//Customer c1= custRepo.fetchCustomerByAccNumber(1235987663L);
		custRepo.deleteByAccNo(12346);
	}
	
	@Test
	public void testFetchBalanceByAccountNumber() {
		Double balance = custRepo.getAccountBalance(12346);
		System.out.println(balance);
	}
	
	@Test
	public void testAccountStatus() {
		if(custRepo.checkAccountStatus(12347))
			System.out.println("Active hai");
		else {
			System.out.println("Pending hai");
		}
	}
	
	@Test
	public void checkValidAccountNumber() {
		if(custRepo.checkValidAccountNumber(12346)) {
			System.out.println("valid !");
		}
		else {
			System.out.println("invalid !!");
		}
	}
		
}
	
