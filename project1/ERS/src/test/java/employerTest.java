import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import services.EmployerService;

class employerTest {
	public static EmployerService es = new EmployerService();
	@Test
	void getTicketTest() {
		assertNotNull(es.getReimbursement());
	}

}
