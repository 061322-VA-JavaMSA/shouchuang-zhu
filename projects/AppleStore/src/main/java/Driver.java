import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import Exception.LoginException;
import Models.User;
import Services.AuthService;
import Services.UserService;

public class Driver {
	static Scanner scan;
	static AuthService as;
	static UserService us;
	public static void main(String[] args) throws LoginException, IOException {
		scan = new Scanner(System.in);
		as = new AuthService();
		us = new UserService();
		
		String username = null;
		String password = null;
		
		System.out.println("Please enter username:");
		username = scan.nextLine();
		System.out.println("Please enter password:");
		password = scan.nextLine();
		
		try {
			System.out.println(as.login(username, password));
		} catch (LoginException e) {
			System.out.println("Invalid credentials.");
//			e.printStackTrace();
		}
		scan.close();
	}
	
}
