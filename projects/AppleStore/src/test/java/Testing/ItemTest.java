package Testing;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.Test;

import Services.ItemService;

public class ItemTest {

	@Test
	public void test() throws IOException {
		ItemService i = new ItemService();
		assertEquals(i.deleteItem(0),i.deleteItem(0));
	}

}
