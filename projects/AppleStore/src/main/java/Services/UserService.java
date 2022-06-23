package Services;

import java.io.IOException;
import java.util.List;

import DAOs.UserDao;
import DAOs.UserPostgres;
import Models.User;

public class UserService {
private UserDao ud = new UserPostgres();
	
	public User createUser(User u) throws IOException {
		return ud.createUser(u);
	}
	
	
}
