package com.lti.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.lti.entity.Beneficiary;

@Repository
public class BenficiaryRepoImpl implements BeneficiaryRepo {
	
	@PersistenceContext
	private EntityManager em;

	@Transactional(value = TxType.REQUIRED)
	public void save(Beneficiary benficiary) {
		em.persist(benficiary);
		
	}

	public Beneficiary fetchBeneficiaryByAccNumber(int benefAccNumber) {
		Beneficiary beneficiary =em.find(Beneficiary.class,benefAccNumber);
		return beneficiary;
	}

	@Transactional(value = TxType.REQUIRED)
	public List<Beneficiary> fetchAllBeneficiaries() {
	return 	em.createQuery("from Beneficiary").getResultList();
		
	}

	@Transactional(value = TxType.REQUIRED)
	public void updateBenefeciary(Beneficiary beneficiary) {	
		em.merge(beneficiary);
		
	}

	@Transactional(value = TxType.REQUIRED)
	public void deleteBeneficiary(int benefAccNumber) {
		em.remove(em.find(Beneficiary.class, benefAccNumber));
		
	}
	
	@Transactional
	public Boolean checkBeneficiaryAccountNumber(int benefAccNumber) {
		if(em.find(Beneficiary.class, benefAccNumber) == null){
			return false;
		}
		else {
			return true;
		}
	}

	public Boolean checkBankName(int benefAccNumber) {
		Beneficiary beneficiary = em.find(Beneficiary.class, benefAccNumber);
		
		if(beneficiary.getBank().equalsIgnoreCase("BitBank")) {
			return true;
		}
		else {
			return false;
		}
	}

	
	
}
