package com.lti.restgladiator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entitygladiator.Customer;
import com.lti.pojogladiator.Login;
import com.lti.servicegladiator.UserService;

@CrossOrigin
@RestController
public class UserRestController {
	@Autowired
	UserService service;

	@GetMapping(value = "/loginvalidate", produces = "application/json")
	public Customer login(@RequestParam("username") String username, @RequestParam("password") String password) {
		Login login = new Login(username, password);
		Customer cust = service.validate(login);
		System.out.println((cust.getAccountBalance()) + "\t" + cust.getPassword());
		return cust;
	}

	@GetMapping(value = "/loginadmin", produces = "application/json")
	public String loginAdmin(@RequestParam("username") String username, @RequestParam("password") String password) {
		Login login = new Login(username, password);
		if (service.validateAdmin(login)) {
			return "Login Success";
		} else {
			return "Login Failed";
		}

	}
}
