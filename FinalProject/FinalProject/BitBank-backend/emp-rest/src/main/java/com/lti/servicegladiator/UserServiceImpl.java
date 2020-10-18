package com.lti.servicegladiator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entitygladiator.Customer;
import com.lti.pojogladiator.Login;
import com.lti.repogladiator.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo repo;

	public Customer validate(Login login) {

		return repo.authenticate(login);
	}

	public Boolean validateAdmin(Login login) {
		return repo.authenticateAdmin(login);
	}

}
