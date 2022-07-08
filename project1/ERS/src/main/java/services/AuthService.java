package services;

import javax.security.auth.login.LoginException;

import daos.UserDao;
import daos.UserHibernate;
import exceptions.UserNotFoundException;
import models.User;

public class AuthService {
	private UserDao ud = new UserHibernate();
	
	public User login(String username, String password) throws UserNotFoundException, LoginException {
		
		// principal refers to "currently logged in user"
		User principal = ud.getUserByUsername(username);
		
		if(principal == null) {
			throw new UserNotFoundException();
		}
		
		if(!principal.getPassword().equals(password)){
			throw new LoginException();
		}
		
		return principal;
	}
}
