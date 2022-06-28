package Services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import DAOs.ItemDao;
import DAOs.ItemPostgres;
import Models.Item;

public class ItemService {
	private ItemDao id = new ItemPostgres();
	private static Logger log = LogManager.getLogger(ItemService.class);
	
	public List<Item> getItems() throws SQLException, IOException {
		return id.retrieveItems();
	}
	
	public Item createItem(Item i) throws IOException {
		Item item = id.createItem(i);
		log.info("Item: " + item + " was created.");
		return item;
		
	}
	public boolean deleteItem(int i) throws IOException {
		return id.deleteItemByid(i);
	}
	
	public Item makeOffer(Item i) throws IOException {
		return id.makeAnOffer(i);
	}
}
