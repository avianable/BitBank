package com.lti.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.User;
import com.lti.pojo.Login;
import com.lti.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo repo;
	
	@Transactional(value = TxType.REQUIRED)
	public void saveUser(User user) {
		repo.addUser(user);
	}

	public User validate(Login login) {
		return repo.authenticate(login);
	}

}
