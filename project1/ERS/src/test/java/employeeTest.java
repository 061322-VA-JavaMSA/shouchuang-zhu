import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import services.EmployeeService;

class employeeTest {
	public static EmployeeService es = new EmployeeService();
	@Test
	void getTicketTest() {
		assertNotNull(es.getReimbursement());
	}

}
