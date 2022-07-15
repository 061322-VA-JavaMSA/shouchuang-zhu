import static org.junit.jupiter.api.Assertions.*;

import javax.security.auth.login.LoginException;

import org.junit.jupiter.api.Test;

import exceptions.UserNotFoundException;
import services.AuthService;

class authTest {
	public static AuthService as = new AuthService();
	@Test
	void loginTest() throws LoginException, UserNotFoundException {
		assertNotNull(as.login("iris", "iris"));
	}

}
