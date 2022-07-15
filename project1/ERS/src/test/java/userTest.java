import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import services.UserService;

class userTest {
	public static UserService u = new UserService();
	@Test
	void getUserTest() {
		assertNotNull(u.getUsers());
	}
	@Test
	void getUserByNameTest() {
		assertNotNull(u.getUsersByUsername("iris"));
	}
}
