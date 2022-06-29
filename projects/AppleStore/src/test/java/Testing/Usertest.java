package Testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Models.User;

class userTest { 
	@Test
	public void userTest() {
		User u = new User();
		u.setUsername("hello");
		assertNotNull(u);
	}

}
