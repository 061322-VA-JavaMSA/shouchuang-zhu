package DAOs;
import java.io.IOException;
import java.util.List;

import Models.User;

public interface UserDao {
	User createUser(User u) throws IOException;
	User retriveUserByUsername(String username) throws IOException;
}
