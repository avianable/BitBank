package com.lti.test;

import java.util.List;

import javax.xml.transform.Source;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lti.entity.Beneficiary;
import com.lti.entity.Customer;
import com.lti.repo.BeneficiaryRepo;
import com.lti.repo.CustomerRepo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:appctx.xml")
public class TestBeneficiary {

	@Autowired
	private CustomerRepo custRepo;
//	
//	@Autowired
//	private CustomerDetailRepo custDetailRepo;
//	
//	@Autowired
//	private AccountTransactionRepo accTransactionRepo;
//	
	@Autowired
	private BeneficiaryRepo benefRepo;
	
	
	@Test
	public void testAddBeneficiary() {
		
		Beneficiary b1 = new Beneficiary();
		b1.setBenefAccountNumber(12388);
		b1.setFirstName("Animesh");
		b1.setLastName("Gaurav");
		b1.setBank("BitBank");
		b1.setBranch("New Town Street");
		
		b1.setCust(custRepo.fetchCustomerByAccNumber(12387));
		
		benefRepo.save(b1);
	}
	
	@Test
	public void testFetchAllBeneficiaries() {
		
		List<Beneficiary> beneficiaries = benefRepo.fetchAllBeneficiaries();
		
		for (Beneficiary beneficiary : beneficiaries) {
			System.out.println(beneficiary.getFirstName() + "\t" + beneficiary.getBank() + "\t" + beneficiary.getBranch());
		}
	}
	
	@Test
	public void testFetchById() {
		Beneficiary b1 = benefRepo.fetchBeneficiaryByAccNumber(65457);
		
		System.out.println(b1.getBenefAccountNumber() + "\t" + b1.getFirstName());
	}
	
	@Test
	public void testUpdateBeneficiary() {
		Beneficiary b1 = benefRepo.fetchBeneficiaryByAccNumber(65457);
		b1.setFirstName("Jim");
		b1.setLastName("Moriarity");
		
		benefRepo.updateBenefeciary(b1);		
		
	}
	
	@Test
	public void testDeleteBeneficiary() {
		benefRepo.deleteBeneficiary(17);
	}
	
	@Test
	public void testValidBeneficiary() {
		if(benefRepo.checkBeneficiaryAccountNumber(65457)) {		// yet to resolve for existing Benefeciary
			System.out.println("Benefeciary exists");
		}
		else {
			System.out.println("Invalid Beneficiary");
		}
	}
	
	@Test
	public void testBeneficiaryBank() {
		if(benefRepo.checkBankName(65457)) {
			System.out.println("Bitbank ka hai");
		}
		else {
			System.out.println("Nope");
		}
	}
		
}
