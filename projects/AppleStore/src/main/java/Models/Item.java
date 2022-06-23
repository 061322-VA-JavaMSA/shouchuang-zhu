package Models;

public class Item {
	int itemId;
	String itemName;
	int price;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void setId(int id) {
		// TODO Auto-generated method stub
		this.itemId = id;
	}
	
	public int getId() {
		return itemId;
	}

	public void setItemname(String itemName) {
		// TODO Auto-generated method stub
		this.itemName = itemName;
	}
	
	public String getItemname() {
		return itemName;
	}

	public void setPrice(int price) {
		// TODO Auto-generated method stub
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}
	
	public String toString() {
		return "Item [itemname=" + itemName + ", price=" + price + "]";
	}
}
