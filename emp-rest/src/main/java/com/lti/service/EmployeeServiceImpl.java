package com.lti.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.Employee;
import com.lti.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo repo;
	
	@Transactional(value = TxType.REQUIRED)
	public void persist(Employee emp) {
		repo.save(emp);
	}

	public Employee find(int empid) {
		return repo.fetch(empid);
	}

	public List<Employee> load() {
		return repo.list();
	}

	@Transactional(value = TxType.REQUIRED)
		public void remove(int empid) {
			repo.delete(empid);
	}

	@Transactional(value = TxType.REQUIRED)
	public void edit(Employee emp) {
		repo.update(emp);

	}

}
