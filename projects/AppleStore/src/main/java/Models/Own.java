package Models;


public class Own {
	int userId;
	int itemId;
	String itemName;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public String toString() {
		return "Owned Item [userId=" + userId + ",itemId=" + itemId + ",item name=" + itemName + "]";
	}
}
