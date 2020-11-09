package com.revature.menus;

import java.util.Scanner;

import com.revature.beans.AccountInfo;
import com.revature.beans.Employee;
import com.revature.services.Transactions;

import java.util.regex.*;


public class Menu {
	
	
	static Scanner scan = new Scanner(System.in);  // Create a Scanner object
	
	private static AccountInfo current;
	
	private static AccountInfo additional;
	
	private static String userName;
	
	
	
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
						loginMenu();
						break;
					default: 
						System.out.println("Please enter l or r");
						startMenu();
				}
				break;
			case "e":
				System.out.println("\t[r]egister");
				System.out.println("\t[l]ogin");
				
				String option2 = scan.nextLine();
				
				switch(option2.toLowerCase()) {
				
					case "r":
						empRegMenu();
						break;
					case "l": 
						empLoginMenu();
						break;	
					default: 
						System.out.println("Please enter l or r");
				}
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
			userNameMenu();
			current = new AccountInfo(fullName, address, phoneNumber, emailAddress, dateOfBirth, userName);
			System.out.println("Account Created! Now taking you to login....");
			loginMenu();
			break;
		
		case "n":
			System.out.println("Okay, let's start again...");
			registerMenu();
			break;
		}
		
	}
	
	
	public static void userNameMenu() {
		
		/* String regex = "^(?=.*[a-z])(?=."
                + "*[A-Z])(?=.*\\d)"
                + "(?=.*[-+_!@#$%^&*., ?]).+$";
		Pattern p = Pattern.compile(regex);
		*/
		System.out.println("Create a username (Use a minimum of 10 or more characters including uppercase and lowercase letters, numbers and special characters):");
		userName = scan.nextLine();
		//Matcher m = p.matcher(userName);
		/*if (userName.length() < 10 || !(m.matches())) {
			System.out.println("The username you entered does not meet the requirements. Please try again");
			userNameMenu();
		} else { */
			System.out.println("Create a password");
			System.out.println("\t Must be more than six characters");
			System.out.println("\t Must be case sensitive (have upper and lowercase letters)");
			System.out.println("\t Must contain a mix of letters, numbers, and specual characters (!@#$ etc.)");
			String password = scan.nextLine();
			//Matcher ma = p.matcher(password);
			/*if (password.length() < 6 || !(ma.matches())) {
				System.out.println("The username you entered does not meet the requirements.Let's start from beginning");
				userNameMenu();
			} else { */
				AccountInfo a = new AccountInfo(userName,password);
			//}
			
		//}
		
	}
	
	
	
	public static void empRegMenu() {
		/* String regex = "^(?=.*[a-z])(?=."
                + "*[A-Z])(?=.*\\d)"
                + "(?=.*[-+_!@#$%^&*., ?]).+$";
		Pattern p = Pattern.compile(regex);
		*/
		System.out.println("Create a username (Use a minimum of 10 or more characters including uppercase and lowercase letters, numbers and special characters):");
		userName = scan.nextLine();
		//Matcher m = p.matcher(userName);
		
		/* if (userName.length() < 10 || !(m.matches())) { 
			System.out.println("The username you entered does not meet the requirements. Please try again");
			userNameMenu();
		} else { */
			System.out.println("Create a password");
			System.out.println("\t Must be more than six characters");
			System.out.println("\t Must be case sensitive (have upper and lowercase letters)");
			System.out.println("\t Must contain a mix of letters, numbers, and specual characters (!@#$ etc.)");
			String password = scan.nextLine();
			/*Matcher ma = p.matcher(password);
			if (password.length() < 6 || !(ma.matches())) {
				System.out.println("The username you entered does not meet the requirements.Let's start from beginning");
				userNameMenu();
			} else { */
				System.out.println("Are you an admin?");
				boolean admin = Boolean.parseBoolean(scan.nextLine());
				Employee e = new Employee(userName,password, admin);
				System.out.println("Account Created! Now taking you to login....");
				empLoginMenu();
			//}
		//}
	}
	
	
	public static void loginMenu() {
		
		System.out.println("Enter username:");
		String userName = scan.nextLine();
		System.out.println("Enter password:");
		String password  = scan.nextLine();
		AccountInfo.checkingLogin(userName, password);
		
	}
	
	public static void empLoginMenu() {
		System.out.println("Enter username:");
		String userName = scan.nextLine();
		System.out.println("Enter password:");
		String password  = scan.nextLine();
		Employee.checkingLogin(userName, password);
		System.out.println("Login Successful!");
		Menu.empMenu();
	}
	
	public static void empMenu() {
		System.out.println("Welcome to the Employee Portal!");
		System.out.println("[1] Look at all customer accounts");
		System.out.println("[2] Check only open customer accounts");
		System.out.println("[3] Exit");
		if (Employee.isAdmin() == true) {
			System.out.println("[4] Act as a customer");
			System.out.println("[5] Cancel account");
		}
		int num = scan.nextInt();
		
		switch (num) {
		
		case 1:
			for (AccountInfo cust : AccountInfo.customerAccounts) {
				System.out.print(AccountInfo.getTransactions());
				
			}
			changeStatusMenu();
			break;
		case 2: 
			System.out.println(Employee.checkOpenCases("open"));
			changeStatusMenu();
			break;
		case 3:
			System.out.println("Thank you for using DSM Bank.");
			break;
		case 4:
			transactionsMenu();
			break;
		case 5:
			System.out.println("Please enter the account number:");
			int accNum = Integer.parseInt(scan.nextLine());
			Employee.deleteAccount(accNum);
			empMenu();
			break;
		default: 
			System.out.println("PLease enter a number 1-5");
			empMenu();
		}
		
		
		
	}
	
	
	public static void changeStatusMenu() {
		System.out.println("Would you like to accept/deny a case? (y/n)");
		String say = scan.nextLine();
		
		switch (say.toLowerCase()) {
		
			case "y": 
				System.out.println("Please enter the account number:");
				int accNum = Integer.parseInt(scan.nextLine());
				System.out.println("[A]ccept or [D]eny");
				String st = scan.nextLine();
				Employee.changeStatus(accNum, st);
				changeStatusMenu();
				break;
				
			case "n":
				empMenu();
				break;
			default:
				System.out.println("PLease enter a number y or n");
				changeStatusMenu();
			
		
		}
	}
	
	public static void accountMenu() {
		
		System.out.println("[C]urrent Accounts");
		System.out.println("[R]equest to open a new account");
		System.out.println("[E]xit");
		String response = scan.nextLine();
		
		switch(response.toLowerCase()) {
		
		case "c":
			current.getTransactions();
			transactionsMenu();
			break;
			
		case "e":
			System.out.println("Thank you for using DSM Bank.");
			break;
		case "r":
			System.out.println("What kind of account are you looking to open?");
			System.out.println("[1] Joint Checking");
			System.out.println("[2] Joint Savings");
			System.out.println("[3] Checking");
			System.out.println("[4] Savings");
			int number = Integer.parseInt(scan.nextLine());
			System.out.println("Please enter a starting balance: (e.i. 0.00)");
			double balance = Double.parseDouble(scan.nextLine());
			
			switch (number) {
		
				case 1 : 
					
					jointAcctMenu();
					Transactions jc = new Transactions("Joint Checking",balance, additional);
					current.setTransactions(jc);
					break;
					
				case 2 : 
					jointAcctMenu();
					Transactions sc = new Transactions("Joint Savings",balance, additional);
					current.setTransactions(sc);
					break;
					
				case 3 : 	
					Transactions c = new Transactions("Checkings",balance);
					current.setTransactions(c);
					break;
					
				case 4:
					Transactions s = new Transactions("Savings",balance);
					current.setTransactions(s);
					break;
					
				default:
					System.out.println(" Sorry, please enter 1, 2, 3, or 4");
					accountMenu();
			
			}
			
			System.out.println("Your requests for an account has been entered. Please login again to see if your account has been accepted or denied.");
			loginMenu();
			break;
		default:
			System.out.println("PLease enter a number 1-4");
			accountMenu();
				
		}
		
		
	}
	
	
	public static void jointAcctMenu() {
		
		System.out.println("Please enter the information for the person who will be joining you on the account.");
		System.out.println("Name (First and Last):");
		String fullName = scan.nextLine();
		System.out.println("Address:");
		String address = scan.nextLine();
		System.out.println("Phone Number:");
		String phoneNumber = scan.nextLine();
		System.out.println("Email Address:");
		String emailAddress = scan.nextLine();
		System.out.println("Date of Birth (xx-xx-xxxx):");
		String dateOfBirth = scan.nextLine();
		System.out.println("Verify that all the information you entered is correct:");
		System.out.println(fullName);
		System.out.println(address);
		System.out.println(phoneNumber);
		System.out.println(emailAddress);
		System.out.println(dateOfBirth);
		System.out.println("IS all the information entered correct (y/n) ? ");
		String answer = scan.nextLine();
		
		switch(answer.toLowerCase()) {
			
		case "y": 
			additional  = new AccountInfo(fullName, address, phoneNumber, emailAddress, dateOfBirth);
			break;
			
		case "n":
			System.out.println("Let's try again...");
			jointAcctMenu();
			break;
		default:
			System.out.println("PLease enter a  y or n. Sorry now you have to start over");
			jointAcctMenu();
			
		}
	
		
	}
	
	
	public static void anyMoreMenu() {
		System.out.println("Would you like to add another person to the account? (y/n)");
		String response = scan.nextLine();
		
		switch (response.toLowerCase()) {
		
		case "y":
			jointAcctMenu();
			break;
			
		case "n":
			accountMenu();
			break;
			
		default:
			System.out.println("PLease enter a y or n");
			anyMoreMenu();
		
		}
		
	}
	
	
	public static void transactionsMenu() {
		if (current.getTransactions().getStatus().equals("approved")) {
			System.out.println("Which action are you looking to complete? ");
			System.out.println("[1] Desposit");
			System.out.println("[2] Withdraw");
			System.out.println("[3] Go back to see Accounts");
			int which = Integer.parseInt(scan.nextLine());
			
			switch(which) {
			
				case 1:
					System.out.println("Please enter the account number: ");
					String acctNum = scan.nextLine();
					System.out.println("Please enter the amount:");
					double amt = Double.parseDouble(scan.nextLine());
					Transactions.depositMoney(amt, Integer.valueOf(acctNum));
					anotherTrans();
					break;
					
				case 2:
					System.out.println("Please enter the account number: ");
					String acctNum2 = scan.nextLine();
					System.out.println("Please enter the amount:");
					double amt2 =Double.parseDouble(scan.nextLine());
					Transactions.withdrawMoney(amt2, Integer.valueOf(acctNum2));
					anotherTrans();
					break;	
					
				case 3:
					accountMenu();
					break;
					
				default:
					System.out.println("PLease enter a number 1-3");
					transactionsMenu();
			}
			
		} else if(current.getTransactions().getStatus().equals("denied")) {
			
			System.out.println("Sorry this account has been denied!");
			System.out.println("...taking you back to main menu...");
			startMenu();
			
		} else {	
			System.out.print("Your account hasn't been approvedyet, please check back in later!");
			System.out.println("...taking you back to main menu...");
			startMenu();	
		}
		
	}
	
	public static void anotherTrans() {
		System.out.println("Would you like to make another transaction? (y/n)");
		String again = scan.nextLine();
		switch (again.toLowerCase()) {
			case "y":
				transactionsMenu();
				break;
			case "n":
				accountMenu();
				break;
			default:
				System.out.println("PLease enter a y or n");
				anotherTrans();
		}
	}
	

}
