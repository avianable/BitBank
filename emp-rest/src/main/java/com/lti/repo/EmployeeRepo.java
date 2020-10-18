package com.lti.repo;

import java.util.List;

import com.lti.entity.Employee;

public interface EmployeeRepo {

	void save(Employee emp);
	
	Employee fetch(int empid);
	
	List<Employee> list();
	
	void delete(int empid);
	
	void update(Employee emp);
	
}
