package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "emps")
@SequenceGenerator(name = "emseq", sequenceName = "seq_emp", initialValue = 1001, allocationSize = 1)
public class Employee {

	@Id
	@GeneratedValue(generator = "emseq", strategy = GenerationType.SEQUENCE)
	private int empid;
	@Column(length = 30)
	private String ename;
	private double salary;
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
}
