package com.lti.repogladiator;

import com.lti.entitygladiator.Customer;
import com.lti.pojogladiator.Login;

public interface UserRepo {
	Customer authenticate(Login login);

	Boolean authenticateAdmin(Login login);
}
