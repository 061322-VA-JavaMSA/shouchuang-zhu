package Testing;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import Services.ItemService;

class itemTest {
	
	public static ItemService i = new ItemService();
	
	@BeforeAll
	public static void createItem() {
		
	}
	
	@AfterAll
	public static void deleteItem() {
		
	}
	@Test
	void getItemTest() throws SQLException, IOException {
		assertNotNull(i.getItems());
	}
	@Test
	void checkEqual() {
		assertNotNull(i.equals(i));
	}
	
	@Test
	void checkDelete() throws IOException {
		assertFalse(i.deleteItem(0));
	}

}
