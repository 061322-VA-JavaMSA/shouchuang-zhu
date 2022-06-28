import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Exception.LoginException;
import Models.Item;
import Models.Offer;
import Models.Payment;
import Models.PaymentHistory;
import Models.User;
import Services.AuthService;
import Services.ItemService;
import Services.OfferService;
import Services.UserService;
import Services.PaymentService;

public class Driver {
	static Scanner scan;
	static AuthService as;
	static UserService us;
	static ItemService is;
	static OfferService os;
	static PaymentService ps;
	
	static String username = null;
	static String password = null;
	static int user_id;
	
	private static Logger log = LogManager.getLogger(Driver.class);
	public static void main(String[] args) throws LoginException, IOException, SQLException {
		scan = new Scanner(System.in);
		as = new AuthService();
		us = new UserService();
		is = new ItemService();
		os = new OfferService();
		ps = new PaymentService();
		
		//start of the program
		System.out.println("Enter 1 to signup and enter 2 to login");
		 while (!scan.hasNextInt()) {
		      System.out.println("Input is not a number. Please enter 1 to signup and enter 2 to login");
		      log.info("User input not number error");
		      scan.nextLine();
		    }
		int number = scan.nextInt();
		switch (number) {
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
		
		//login page
		loginPage(username, password);
		
		scan.close();
	}
	
	public static void loginPage(String username, String password) throws IOException, SQLException {
		try {
			//login method
			as.login(username, password);
			
		} catch (LoginException e) {
			System.out.println("Invalid credentials.");
			log.error("Login exception was thrown: " + e.fillInStackTrace());
			scan.close();
			System.exit(0);
		}
		user_id = as.checkid(username);
		//check if logged in user is admin or not
		if(as.checkAdmin(username) == false) {
			//methods for customer
			
			menu();
			
		} else {
			//methods for admin
			adminMenu();
		}
	}
	//Customer menu
	public static void menu( ) throws SQLException, IOException {
		System.out.println("Enter the Customer Page");
		System.out.println("Enter 1 to check item list");
		System.out.println("Enter 2 to make an offer");
		System.out.println("Enter 3 to check accepted offers");
		System.out.println("Enter 4 to check own items");
		switch(scan.nextInt()) {
		case 1: 
				listItem();
				System.out.println("-----------------------------------");
				menu();
				break;
		case 2: makeOffer();
				System.out.println("-----------------------------------");
				menu();
				break;
		case 3: checkAcceptOffer();
				System.out.println("-----------------------------------");
				makePayment();
				menu();
				break;
		case 4: checkOwnItems();
				System.out.println("-----------------------------------");
				menu();
				break;
		default: 
				menu();
				break;
	}
	}
	
	public static void listItem() throws SQLException, IOException {
		List<Item> items = is.getItems();
		for(Item i: items) {
			System.out.println(i);
		}
	}
	public static void makeOffer() throws IOException, SQLException {
		int itemid;
		int price;
		Item i = new Item();
	
		listItem();
		System.out.println("Please enter item id that you want to make offer");
		itemid = scan.nextInt();
		System.out.println("Please enter the price");
		price = scan.nextInt();
		i.setId(itemid);
		i.setOffer(price);
		i.setUserId(user_id);
		//System.out.println(u.getId());
		is.makeOffer(i);
		System.out.println("Offer has been made!");
		
	}
	public static void checkAcceptOffer() throws IOException {
		System.out.println("My items: ");
		List<Payment> payments = ps.checkPaymentInfo(user_id);
		for(Payment p : payments) {
			System.out.println(p);
		}
		
	}
	
	public static void makePayment() throws SQLException, IOException {
		System.out.println("Enter 1 to make payment, else back to the menu");
		int number = scan.nextInt();
		if(number != 1) {
			log.info("User hesitate to make a payment!");
		}
		switch(number) {
		case 1: 
				int remainingAmount = 0;
				System.out.println("Please enter the payment id: ");
				int payment_id = scan.nextInt();
				remainingAmount = ps.remainingPayment(payment_id);
				System.out.println("The remaining balance is " + remainingAmount);
				System.out.println("Please enter the payment amount: ");
				
				int payment = scan.nextInt();
				if(payment < remainingAmount) {
					ps.makePayment(payment, payment_id, user_id);
					ps.addToHistory(user_id, payment_id, payment);
				} else if (payment == remainingAmount) {
					ps.makePayment(payment, payment_id, user_id);
					ps.addToHistory(user_id, payment_id, payment);
					Payment p = new Payment();
					p = ps.retrivePaymentByPaymentId(payment_id);
					ps.addToOwnedItems(user_id, p.getItemId() );
				} else if (remainingAmount == 0) {
					System.out.println("You do not own any amount, you cannot make a payment");
					log.info("User try to overpay!");
					menu();
				}
				  else {
					System.out.println("Entered amount is exceeding balance!");
					makePayment();
				}
				
				
		default:
			   menu();
			   break;
		}
	}
	
	public static void checkOwnItems() throws IOException {
		List<String> li = ps.checkOwnedItems(user_id);
		for(String l : li) {
			System.out.println(l);
		}
	}
	
	//admin menu
	public static void adminMenu() throws  IOException, SQLException {
		
		System.out.println("Enter the Admin Page");
		System.out.println("Enter 1 to remove item from list");
		System.out.println("Enter 2 to add item");
		System.out.println("Enter 3 to check customer sent offers");
		System.out.println("Enter 4 to check payment histoy");
		System.out.println("Enter 5 to check payment weekly payment sum");
		switch(scan.nextInt()) {
		case 1: 
				deleteItem();
				System.out.println("-----------------------------------");
				adminMenu();
				break;
		case 2: 
				addItem();
				System.out.println("-----------------------------------");
				adminMenu();
				break;
		case 3: 
				checkOffers();
				System.out.println("-----------------------------------");
				adminMenu();
				break;
		case 4: 
				checkPaymentHistory();
				System.out.println("-----------------------------------");
				adminMenu();
				break;
		case 5: 
				checkWeeklyPaymentTotal();
				System.out.println("-----------------------------------");
				adminMenu();
				break;
		default: 
				adminMenu();
				break;
	}
	};

	

	public static void addItem() throws IOException {
		String itemname;
		int price;
		System.out.println("Enter the itemname: ");
		itemname = scan.next();
		System.out.println("Enter the item price: ");
		price = scan.nextInt();
		Item addItem = new Item();
		addItem.setItemname(itemname);
		addItem.setPrice(price);
		System.out.println(is.createItem(addItem));
		System.out.println("item has been successfully added");
	}
	
	public static void deleteItem() {
		try {
			listItem();
			System.out.println("Enter the item id to delete: ");
			is.deleteItem(scan.nextInt());
			System.out.println("item has been successfully deleted");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//accept or reject offers
	private static void checkOffers() throws SQLException, IOException {
		int offerId;
		int status;
		int itemId;
		List<Offer> offers = os.getOffers();
		for(Offer o: offers) {
			System.out.println(o);
		}
		System.out.println("Enter the offer_id to accept/reject offer");
		offerId = scan.nextInt();
		System.out.println("Enter the 1 to accept offer and 0 to reject offer");
		status = scan.nextInt();
		Offer of = new Offer();
		
		of.setOfferId(offerId);
		of.setStatus(status);
		os.ChangeOfferStatus(of);
		
		if(status == 1) {
			itemId = directToPayment(offerId);
			os.rejectPendingOffers(itemId);
		}
		
	}
	
	//pass the offer to payment
	public static int directToPayment(int offerId) throws SQLException, IOException {
		Offer offer = new Offer();
		offer = os.retrieveOfferById(offerId);
		Payment pm = new Payment();
		pm.setItemId(offer.getItemId());
		pm.setUserId(offer.getUserId());
		pm.setOffer(offer.getPrice());
		ps.createPayment(pm);
		return pm.getItemId();
	}
	
	public static void checkPaymentHistory() throws IOException {
		List<PaymentHistory> his = ps.checkPaymentHistory();
		for(PaymentHistory h: his) {
			System.out.println(h);
		}
	}
	
	public static int checkWeeklyPaymentTotal() throws IOException {
		return ps.checkWeeklyPayment();
	}
	
};
