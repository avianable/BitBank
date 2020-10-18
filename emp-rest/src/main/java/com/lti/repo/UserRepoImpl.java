package com.lti.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.entity.User;
import com.lti.pojo.Login;

@Repository
public class UserRepoImpl implements UserRepo{
	
	@PersistenceContext
	private EntityManager em;
	
	public void addUser(User user) {
		em.persist(user);
		
	}

	public User authenticate(Login login) {
		Query query = em.createNamedQuery("login");
		query.setParameter("uname", login.getUsername());
		query.setParameter("pwd", login.getPassword());
		query.setParameter("rol", login.getRole());
		return (User) query.getSingleResult();
	}

}