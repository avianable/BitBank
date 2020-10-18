package com.lti.service;

import java.util.List;

import com.lti.entity.Employee;

public interface EmployeeService {

	void persist(Employee emp);
	
	Employee find(int empid);
	
	List<Employee> load();
	
	void remove(int empid);
	
	void edit(Employee emp);
}
