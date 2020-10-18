package com.lti.servicegladiator;

import com.lti.entitygladiator.Customer;
import com.lti.pojogladiator.Login;

public interface UserService {
	Customer validate(Login login);

	Boolean validateAdmin(Login login);
}
