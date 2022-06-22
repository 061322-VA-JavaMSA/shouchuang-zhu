package Services;

import java.util.List;

import DAOs.UserDao;
import DAOs.UserPostgres;
import Models.User;

public class UserService {
private UserDao ud = new UserPostgres();
	
	public User createUser(User u) {
		return ud.createUser(u);
	}
	
	
}
