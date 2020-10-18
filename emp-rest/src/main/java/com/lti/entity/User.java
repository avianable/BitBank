package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "users")
//@NamedQuery(name = "login",query =  "FROM User where userName=:uname AND password=:pwd AND role=:rol")
public class User {

	@Id
	@Column(length = 15)
	private String userName;
	@Column(length = 15)
	private String password;
	@Column(length = 30)
	private String name;
	@Column(length = 40)
	private String email;
	@Column(length = 10)
	private String role;
	@Column(length = 10)
	private String phone;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
