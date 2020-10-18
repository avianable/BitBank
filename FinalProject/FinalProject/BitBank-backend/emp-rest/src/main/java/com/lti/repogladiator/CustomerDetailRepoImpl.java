package com.lti.repogladiator;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.lti.entitygladiator.CustomerDetail;
import org.hibernate.Session; 


@Repository
public class CustomerDetailRepoImpl implements CustomerDetailRepo {
	
	@PersistenceContext  
	private EntityManager em;
     
	@Transactional(value=TxType.REQUIRED)
	public void saveCustomerDetail(CustomerDetail customerDetail) { 
		em.persist(customerDetail);
	}

	public List<CustomerDetail> fetchAll() {
		return em.createQuery("from CustomerDetail").getResultList();
	} 

	@Transactional(value=TxType.REQUIRED)
	public CustomerDetail fetch(String aadharNo) {
		return em.find(CustomerDetail.class,aadharNo);
	}

	@Transactional(value=TxType.REQUIRED)
	public void deleteCustomerDetail(String aadharNo) {
		em.remove(em.find(CustomerDetail.class, aadharNo));  
	}
    
	@Transactional(value=TxType.REQUIRED)
	public void updateCustomerDetail(CustomerDetail customerDetail) {   
		em.merge(customerDetail);  
	}
	
}