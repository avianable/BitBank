package com.lti.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lti.entity.Employee;

@Repository
public class EmployeeRepoImpl implements EmployeeRepo {

	@PersistenceContext
	private EntityManager em;
	
	public void save(Employee emp) {
		em.persist(emp);
	}

	public Employee fetch(int empid) {
		return em.find(Employee.class, empid);
		
	}

	public List<Employee> list() {
		return em.createQuery("from Employee").getResultList();
	}

	public void delete(int empid) {
		em.remove(em.find(Employee.class, empid));
	}

	public void update(Employee emp) {
		em.merge(emp);

	}

}
