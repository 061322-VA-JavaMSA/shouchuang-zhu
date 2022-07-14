package services;

import java.util.List;

import daos.UserDao;
import daos.UserHibernate;
import models.User;

public class UserService {
	public UserDao ud = new UserHibernate();
	public List<User> getUsers() {
		List<User> users = ud.getUsers();
		return users;
	}
	
	public User getUsersByUsername(String u) {
		return ud.getUserByUsername(u);
	}
	
	public void updateUserInfo(User u) {
		ud.updateUser(u);
	}
}
