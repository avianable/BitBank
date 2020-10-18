package com.lti.repo;

import com.lti.entity.User;
import com.lti.pojo.Login;

public interface UserRepo {

	void addUser(User user);
	
	User authenticate(Login login);
}
