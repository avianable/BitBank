package com.lti.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Employee;
import com.lti.service.EmployeeService;

@CrossOrigin
@RestController
public class EmployeeRestController {

	@Autowired
	private EmployeeService service;
	
	@PostMapping(value = "/add", consumes = "application/json")
	public String addEmployee(@RequestBody Employee emp) {
		service.persist(emp);
		return "Employee added successfully";
	}
	
	@GetMapping(value = "/fetch/{id}", produces = "application/json")
	public Employee fetchEmployee(@PathVariable int id) {
		return service.find(id);
	}
	
	@GetMapping(value = "/list", produces = "application/json")
	public List<Employee> listEmployee(){
		return service.load();
	}
	
	@PutMapping(value = "/edit", consumes = "application/json")
	public String updateEmployee(@RequestBody Employee emp) {
		service.edit(emp);
		return "Employee updated successfully";
	}
	
	@DeleteMapping("/del/{id}")
	public String delEmployee(@PathVariable int id) {
		service.remove(id);
		return "Employee deleted successfully";
	}
}
