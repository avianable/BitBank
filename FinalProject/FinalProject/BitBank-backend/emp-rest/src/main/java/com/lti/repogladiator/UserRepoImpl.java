package com.lti.repogladiator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.entitygladiator.Customer;
import com.lti.pojogladiator.Login;

@Repository
public class UserRepoImpl implements UserRepo {

	@PersistenceContext
	private EntityManager em;

	public Customer authenticate(Login login) {
		Query query = em.createNamedQuery("loginvalidate");
		query.setParameter("uname", login.getUsername());
		query.setParameter("pwd", login.getPassword());
		return (Customer) query.getSingleResult();
	}

	public Boolean authenticateAdmin(Login login) {
		if (login.getUsername() == "Arnab" && login.getPassword() == "bithead") {
			return true;
		} else if (login.getUsername() == "Mitshu" && login.getPassword() == "bithead") {
			return true;
		} else
			return false;

	}

}
