package DAOs;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import Models.Item;

public interface ItemDao {
	Item createItem(Item i) throws IOException;
	List<Item> retrieveItems() throws SQLException, IOException;
	boolean deleteItemByid(int id) throws IOException;
	Item makeAnOffer(Item i) throws IOException;
}
