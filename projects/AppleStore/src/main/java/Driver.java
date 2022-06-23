import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import Exception.LoginException;
import Models.Item;
import Models.User;
import Services.AuthService;
import Services.ItemService;
import Services.UserService;

public class Driver {
	static Scanner scan;
	static AuthService as;
	static UserService us;
	static ItemService is;
	public static void main(String[] args) throws LoginException, IOException, SQLException {
		scan = new Scanner(System.in);
		as = new AuthService();
		us = new UserService();
		is = new ItemService();
		
		String username = null;
		String password = null;
		
		//start of the program
		System.out.println("Enter 1 to signup and enter 2 to login");
		
		switch (scan.nextInt()) {
		//case 1 for register
			case 1: System.out.println("Please enter username");
					String uname = scan.next();
					System.out.println("Please enter password");
					String pass = scan.next();
					User userTBC = new User();
					userTBC.setUsername(uname);
					userTBC.setPassword(pass);
					System.out.println(us.createUser(userTBC));
					username = uname;
					password = pass;
					break;
		//cast 2 for sign in
			case 2: System.out.println("Please enter username:");
					username = scan.next();
					System.out.println("Please enter password:");
					password = scan.next();	
					break;
			default: System.out.println("Wrong input mission abort!");
					 System.exit(0);
			
		}
		try {
			//login method
			as.login(username, password);
		} catch (LoginException e) {
			System.out.println("Invalid credentials.");
			System.exit(0);
		}
		//check if logged in user is admin or not
		if(as.checkAdmin(username) == false) {
			//methods for customer
			
			menu();
			
		} else {
			//methods for admin
			adminMenu();
		}
		
		
		
		scan.close();
	}
	
	public static void menu( ) throws SQLException, IOException {
		System.out.println("Enter the Customer Page");
		System.out.println("Enter 1 to check item list");
		switch(scan.nextInt()) {
		case 1: 
				List<Item> items = is.getItems();
				for(Item i: items) {
					System.out.println(i);
				}
				menu();
				break;
		default: 
				menu();
				break;
	}
	}
	
	public static void adminMenu() throws SQLException, IOException {
		String itemname;
		int price;
		System.out.println("Enter the Admin Page");
		System.out.println("Enter 1 to remove item from list");
		System.out.println("Enter 2 to add item");
		switch(scan.nextInt()) {
		case 1: 
				List<Item> items = is.getItems();
				for(Item i: items) {
					System.out.println(i);
				}
				adminMenu();
				break;
		case 2: System.out.println("Enter the itemname: ");
				itemname = scan.next();
				System.out.println("Enter the item price: ");
				price = scan.nextInt();
				Item addItem = new Item();
				addItem.setItemname(itemname);
				addItem.setPrice(price);
				System.out.println(is.createItem(addItem));
				System.out.println("item has been successfully added");
				adminMenu();
				break;
				
		default: 
				
				adminMenu();
				break;
	}
	}
};
