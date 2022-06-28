package Services;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import DAOs.UserDao;
import DAOs.UserPostgres;
import Models.User;

public class UserService {
	private UserDao ud = new UserPostgres();
	private static Logger log = LogManager.getLogger(UserService.class);
	public User createUser(User u) throws IOException {
		User user = ud.createUser(u);
		log.info("User: " + user + "was created.");
		return user;
	}
	
}
