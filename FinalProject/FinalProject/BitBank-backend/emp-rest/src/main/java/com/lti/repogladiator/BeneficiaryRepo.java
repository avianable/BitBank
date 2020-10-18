package com.lti.repogladiator;

import java.util.List;

import com.lti.entitygladiator.Beneficiary;

public interface BeneficiaryRepo {
	
	void save(Beneficiary benficiary);
	
	List<Beneficiary> fetchBeneficiaryByAccountNumber(int accountNo);
	
	Beneficiary fetchBeneficiaryById(int benefId);
	
	List<Beneficiary> fetchAllBeneficiaries();
 
	void updateBenefeciary(Beneficiary beneficiary);
	
	void deleteBeneficiary(int benefId);
    Boolean checkBankName(int benefAccNumber);	
	
//	void deleteBeneficiaryByAccountNumber(int accountNo);  
}