package com.lti.repogladiator;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;
import javax.persistence.Query;
import org.hibernate.Session; 
import org.springframework.stereotype.Repository;

import com.lti.entitygladiator.Beneficiary;
import com.lti.entitygladiator.Customer;

@Repository 
public class BeneficiaryRepoImpl implements BeneficiaryRepo {
	
	@PersistenceContext
	private EntityManager em;

	@Transactional(value = TxType.REQUIRED)
	public void save(Beneficiary benficiary) {
		em.persist(benficiary);	
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
	
	
	public Beneficiary fetchBeneficiaryById(int benefId) {
		Beneficiary b1=em.find(Beneficiary.class,benefId);
		return b1;
	}

	@Transactional(value = TxType.REQUIRED)
	public List<Beneficiary> fetchAllBeneficiaries() {
	     return em.createQuery("from Beneficiary").getResultList();
		
	}

	@Transactional(value = TxType.REQUIRED)
	public void updateBenefeciary(Beneficiary beneficiary) {	
		em.merge(beneficiary); 
	}

	@Transactional(value = TxType.REQUIRED)
	public void deleteBeneficiary(int benefId) {
		em.remove(em.find(Beneficiary.class, benefId));
		
	}

	public List <Beneficiary> fetchBeneficiaryByAccountNumber(int accountNo) {
		Customer c1=em.find(Customer.class, accountNo);
		return c1.getBeneficiariesList();
		/*
		 * Query query = em.createNamedQuery("findBenef");
		 * query.setParameter("benefAccNo",accountNo); return (Beneficiary)
		 * query.getSingleResult();
		 */	
		}

//	@Transactional(value = TxType.REQUIRED)
//	public void deleteBeneficiaryByAccountNumber(int accountNo) {
//		Query query = em.createNamedQuery("findBenef");
//		query.setParameter("benefAccNo",accountNo);
//		Beneficiary bnf = (Beneficiary) query.getSingleResult();
//		em.remove(bnf);
//	}
   
}