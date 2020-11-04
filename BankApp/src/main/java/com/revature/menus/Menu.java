package com.revature.menus;

import java.util.Scanner;

import com.revature.beans.AccountInfo;


public class Menu {
	
	
	static Scanner scan = new Scanner(System.in);  // Create a Scanner object
	
	
	public static void startMenu() {
		
		
		System.out.println("Welcome to DSM Bank.");
		System.out.println("Are you a");
		System.out.println("\t[c]ustomer");
		System.out.println("or");
		System.out.println("\t[e]mployee");
		System.out.println("or");
		System.out.println("\t[q]uit");
		
		
		String choice = scan.nextLine();
		
		switch(choice.toLowerCase()) {
		
			case "c":
				System.out.println("\t[r]egister");
				System.out.println("\t[l]ogin");
				
				String option = scan.nextLine();
				
				switch(option.toLowerCase()) {
				
					case "r":
						registerMenu();
						break;
					case "l": 
						//loginMenu();
						break;			
				}
				break;
			case "e":
				//loginMenu();
				break;
			case "q":
				System.out.println("Thank you for using DSM Bank.");
				break;
			default:
				System.out.println("Sorry. Please enter [c], [e], or [q]");
				startMenu();
				break;				
		}	
		
	}
	
	
	public static void registerMenu() {
		System.out.println("Create a new account");
		System.out.println("Please enter your name (First and Last):");
		String fullName = scan.nextLine();
		System.out.println("Please enter your address:");
		String address = scan.nextLine();
		System.out.println("Please enter your phone number:");
		String phoneNumber = scan.nextLine();
		System.out.println("Please enter your email address:");
		String emailAddress = scan.nextLine();
		System.out.println("Please enter your date of birth (xx-xx-xxxx):");
		String dateOfBirth = scan.nextLine();
		System.out.println("Please verify that all the information you entered is correct:");
		System.out.println(fullName);
		System.out.println(address);
		System.out.println(phoneNumber);
		System.out.println(emailAddress);
		System.out.println(dateOfBirth);
		System.out.println("IS all the information entered correct (y/n) ? ");
		String answer = scan.nextLine();
		
		switch(answer.toLowerCase()) {
			
		case "y": 
			System.out.println("Great! Now that we have your personal information, let's create your login");
			System.out.println("Create a username (Use a minimum of 10 or more characters including uppercase and lowercase letters, numbers and special characters):");
			String userName = scan.nextLine();
			System.out.println("Create a password");
			System.out.println("\t Must be more than six characters");
			System.out.println("\t Must be case sensitive (have upper and lowercase letters)");
			System.out.println("\t Must contain a mix of letters, numbers, and specual characters (!@#$ etc.)");
			String password = scan.nextLine();
			
			AccountInfo current = new AccountInfo(fullName, address, phoneNumber, emailAddress, dateOfBirth, userName);
			
			System.out.println("Account Created! Now taking you to login....");
			//LoginMenu();
		
		case "n":
			System.out.println("Okay, let's start again...");
			registerMenu();
		}
		
	}
	
	
	public static void loginMenu() {
		
		System.out.println("Enter username:");
		String userName = scan.nextLine();
		System.out.println("Enter password:");
		String password  = scan.nextLine();
		AccountInfo.checkingLogin(userName, password);
		
	}
	
	

}
