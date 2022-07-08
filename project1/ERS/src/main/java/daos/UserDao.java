package daos;

import java.util.List;

import models.User;

public interface UserDao {
	List<User> getUsers();

	User getUserByUsername(String username);
}
