package services;

import javax.security.auth.login.LoginException;

import daos.UserDao;
import daos.UserHibernate;
import exceptions.UserNotFoundException;
import models.User;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AuthService {
	private UserDao ud = new UserHibernate();
	private static Logger log = LogManager.getLogger(AuthService.class);
	
	public User login(String username, String password) throws UserNotFoundException, LoginException {
		
		// principal refers to "currently logged in user"
		User principal = ud.getUserByUsername(username);
		
		if(principal == null) {
			log.info("login fails");
			throw new UserNotFoundException();
		}
		
		if(!principal.getPassword().equals(password)){
			log.info("login fails");
			throw new LoginException();
		}
		
		return principal;
	}
}
