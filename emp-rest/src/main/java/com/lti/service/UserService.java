package com.lti.service;

import com.lti.entity.User;
import com.lti.pojo.Login;

public interface UserService {

	void saveUser(User user);
	
	User validate(Login login);
}
