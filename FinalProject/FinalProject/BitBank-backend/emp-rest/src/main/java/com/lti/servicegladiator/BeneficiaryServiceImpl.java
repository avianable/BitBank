package com.lti.servicegladiator;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entitygladiator.Beneficiary;
import com.lti.repogladiator.BeneficiaryRepo; 

@Service
public class BeneficiaryServiceImpl implements BeneficiaryService{

	@Autowired 
	private BeneficiaryRepo repo;       

	@Transactional(value = TxType.REQUIRED) 
	public void addBeneficiary(Beneficiary beneficiary) { 
		repo.save(beneficiary);
	} 

	public List<Beneficiary> FetchByAccountNumber(int accountNo) { 
		return repo.fetchBeneficiaryByAccountNumber(accountNo); 
	}

	public List<Beneficiary> fetchAll() {
		return repo.fetchAllBeneficiaries();
	} 

	@Transactional(value = TxType.REQUIRED)
	public void remove(int benefId) {
		repo.deleteBeneficiary(benefId);
	}
    
	
	  @Transactional(value = TxType.REQUIRED) 
	  public void removeByAccountNumber(int accountNo) 
	  { }
	 

}