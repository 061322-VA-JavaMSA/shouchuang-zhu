package Services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import DAOs.ItemDao;
import DAOs.ItemPostgres;
import Models.Item;

public class ItemService {
	private ItemDao id = new ItemPostgres();
	
	public List<Item> getItems() throws SQLException, IOException {
		return id.retrieveItems();
	}
	
	public Item createItem(Item i) throws IOException {
		return id.createItem(i);
		
	}
	public boolean deleteItem(int i) throws IOException {
		return id.deleteItemByid(i);
	}
	
	public Item makeOffer(Item i) throws IOException {
		return id.makeAnOffer(i);
	}
}
