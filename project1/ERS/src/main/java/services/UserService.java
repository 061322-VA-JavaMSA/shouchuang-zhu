package services;

import java.util.List;

import daos.UserDao;
import daos.UserHibernate;
import models.User;

public class UserService {
	public UserDao u = new UserHibernate();
	public List<User> getUsers() {
		return u.getUsers();
	}
}
