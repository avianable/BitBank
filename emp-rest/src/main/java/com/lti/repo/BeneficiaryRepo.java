package com.lti.repo;

import java.util.List;


import com.lti.entity.Beneficiary;

public interface BeneficiaryRepo {
	
	void save(Beneficiary benficiary);
	
	Beneficiary fetchBeneficiaryByAccNumber(int benefAccNumber);
	
	List<Beneficiary> fetchAllBeneficiaries();

	void updateBenefeciary(Beneficiary beneficiary);
	
	void deleteBeneficiary(int benefAccNumber);
	
	Boolean checkBeneficiaryAccountNumber(int benefAccNumber);
	
	Boolean checkBankName(int benefAccNumber);
	

}
