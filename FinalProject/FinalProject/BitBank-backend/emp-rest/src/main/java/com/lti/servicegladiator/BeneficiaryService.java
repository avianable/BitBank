package com.lti.servicegladiator;

import java.util.List;

import com.lti.entitygladiator.Beneficiary;

public interface BeneficiaryService {

	void addBeneficiary(Beneficiary beneficiary);
	List<Beneficiary> FetchByAccountNumber(int accountNo);
	List<Beneficiary> fetchAll();
	void removeByAccountNumber(int accountNo);
	void remove(int benefId);
}