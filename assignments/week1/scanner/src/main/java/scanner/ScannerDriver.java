package scanner;

import java.util.Scanner;
import java.lang.Math;
//import java.util.*; // imports everything... but bad practice

public class ScannerDriver {

	// instead of being method scope, scan is now static scope
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {

		loginScreen();
		menu();
		scan.close();
	}

	
	public static void loginScreen() {
		String username = "admin";
		String password = "pass";
		
		System.out.println("Please enter your username");
		String usernameInput = scan.nextLine();
		System.out.println("Please enter your password");
		String passwordInput = scan.nextLine();
		
		if(username.equals(usernameInput) && password.equals(passwordInput)) {
			System.out.println("Welcome!");
		} else {
			System.out.println("Invalid credentials.");
		}
	}
	public static void menu() {
		/*
		 * Menu that gives a user multiple options:
		 * 	- 1: get a random number
		 *  - 2: reverse a String of the user's choice
		 *  - 3: exit the program
		 *  
		 *  this menu should repeat until the user decides to exit
		 */
		int number;
		System.out.println("Please select an option from the menu:");
		System.out.println("1: Generate a random number between 1 and 100.");
		System.out.println("2: Reverse a word of your choice.");
		System.out.println("3: Exit the program.");
		number = scan.nextInt();
		switch(number) {
		case 1:
			double rand = Math.random();
			System.out.println(rand);
			break;
		case 2:
			System.out.println("Please enter a string to reverse: ");
			String s = scan.next();
			StringBuffer rev = new StringBuffer(s);
			System.out.println("Reverse string: " + rev.reverse());
			break;
		case 3:
			System.out.println("Exit");
			break;
		default:
			menu();
		}
		
	}
}