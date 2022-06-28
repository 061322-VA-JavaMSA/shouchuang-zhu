package Testing;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.io.IOException;

import org.junit.Test;

import Models.User;
import Services.UserService;

public class Usertest {

	@Test
	public void test() throws IOException {
		User user = new User();
		user.setId(0);
		user.setUsername("gee");
		User expected = user;
		User actuals = null;
		assertNotEquals(expected, actuals);
	}

}
