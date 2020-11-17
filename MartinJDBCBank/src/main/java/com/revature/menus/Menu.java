package com.revature.menus;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import com.revature.services.LogThis;
import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.dao.AccountDao;
import com.revature.dao.UserDao;
import com.revature.daoimpl.AccountDaoImpl;
import com.revature.daoimpl.UserDaoImpl;
import com.revature.exceptions.InvalidAmountException;
import com.revature.exceptions.InvalidPasswordException;
import com.revature.exceptions.InvalidUsernameException;

public class Menu {
	
	static Scanner scan = new Scanner(System.in);
	static User user = null;
	
	public static void startMenu() throws IOException {
		System.out.println("Welcome to DSM Bank\nPlease enter a number\n1.\tLogin\n2.\tRegister\n3.\tAdmin Menu\n4.\tQuit");
		int choice = Integer.parseInt(scan.nextLine());
		switch(choice) {
		case 1:
			try {
				loginMenu();
			} catch (InvalidUsernameException | InvalidPasswordException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			break;
		case 2:
			registerMenu();
			break;
		case 3:
			adminLoginMenu();
			break;
		case 4: 
			LogThis.LogIt("info", "User " + user.getUserId() + " has left the bank.");
			System.out.println("Thank you for using DSM Bank.");
			break;
		default:
			System.out.println("Please enter a valid selection");
			startMenu();
			break;
		}
	}
	
	
	public static void registerMenu() {
		UserDao u = new UserDaoImpl();
		System.out.println("~New User Menu~");
		System.out.println("Please enter a username:");
		String username = scan.nextLine();
		System.out.println("Please enter a password:");
		String password = scan.nextLine();
		try {
			 u.registerUser(username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Account setup successful. Going to Log in...");
		try {
			loginMenu();
		} catch (InvalidUsernameException | InvalidPasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void loginMenu() throws InvalidUsernameException, InvalidPasswordException {
		System.out.println("Please enter your username");
		String username = scan.nextLine();
		System.out.println("Please enter your password");
		String password = scan.nextLine();
		UserDao u = new UserDaoImpl();
		try {
			user = u.loginUser(username, password);
			userMenu(user);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Incorrect login info");
			loginMenu();
		}
	}
	
	public static void userMenu(User user) {
		System.out.println(" What would you like to do?\n1.\tCreate Account\n2.\tGo to Accounts\n3.\tLogout\n4.\tQuit");
		int choice = Integer.parseInt(scan.nextLine());
		switch(choice) {
		case 1:
			System.out.println("What kind of account would you like to open?\n1.\tChecking\n2.\tSavings");
			int accountType = Integer.parseInt(scan.nextLine());
			switch (accountType) {
				case 1:
					String type = "Checking";
					System.out.println("How much would you like to deposit?");
					int deposit = Integer.parseInt(scan.nextLine());
					AccountDao acct = new AccountDaoImpl();
					try {
						acct.createAccount(deposit, type, user);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					userMenu(user);
					break;
				case 2:
					String typ = "Savings";
					System.out.println("How much would you like to deposit?");
					int depo= Integer.parseInt(scan.nextLine());
					AccountDao acc = new AccountDaoImpl();
				try {
					acc.createAccount(depo, typ, user);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				userMenu(user);
				break;
				default:
					System.out.println("Please enter a valid selection");
					userMenu(user);
					break;
				}
			break;
		case 2:
			System.out.println("What would you like to do?\n1.\tView Accounts\n2.\tDeposit\n3.\tWithdraw\n4.\tDelete Account\n5.\tLogOut");
			int choice3 = Integer.parseInt(scan.nextLine());
			switch (choice3) {
			case 1:
				AccountDaoImpl acct = new AccountDaoImpl();
				try {
					List<Account> accts = (ArrayList<Account>) acct.getMyAccounts(user.getUserId());
					System.out.println(accts.toString());
				} catch (SQLException e) {
					e.printStackTrace();
				}
				userMenu(user);
				break;
			case 2:
				AccountDao deposit = new AccountDaoImpl();
				System.out.println("Please enter bank_account_ID you wish to access");
				int id2 = Integer.parseInt(scan.nextLine());
				System.out.println("How much do you want to deposit?");
				double depositAmt = Double.parseDouble(scan.nextLine());
				if (depositAmt < 0) {
					try {
						throw new InvalidAmountException();
					} catch(InvalidAmountException e) {
						e.printStackTrace();
					}
					finally {
						userMenu(user);
					}
				} else {
				try {
					Account depositAcct = deposit.getBankAccount(id2);
					double depositNewBalance = depositAmt + depositAcct.getBalance();
					deposit.updateBalance(depositNewBalance, id2);
					LogThis.LogIt("info", "Bank Account  " + depositAcct.getAcctId() + " changed account balance to: " + depositAcct.getBalance());
					System.out.println("Deposit successful");
				} catch (SQLException e) {
					e.printStackTrace();
				}
				}
				userMenu(user);
				break;
			case 3:
				AccountDao withdraw = new AccountDaoImpl();
				System.out.println("Please enter account ID you wish to access");
				int id = Integer.parseInt(scan.nextLine());
				System.out.println("How much would you like to withdraw");
				double withdrawAmt = Double.parseDouble(scan.nextLine());
				if(withdrawAmt < 0) {
					try {
						throw new InvalidAmountException();
					} catch(InvalidAmountException e) {
						e.printStackTrace();
					}
					finally {
						userMenu(user);
					}
				} else {
				try {
					Account withdrawAcct = withdraw.getBankAccount(id);
					if (withdrawAmt > withdrawAcct.getBalance()) {
						System.out.println("Not enough to withdraw");
						
						userMenu(user);
					} else {
						withdrawAmt = withdrawAcct.getBalance() - withdrawAmt;
						withdraw.updateBalance(withdrawAmt, id);
						System.out.println("Withdraw successful");
						LogThis.LogIt("info", "Bank Account  " + withdrawAcct.getAcctId() + " changed account balance to: " + withdrawAcct.getBalance());
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				}
				userMenu(user);
				break;
			case 4:
				AccountDao delete = new AccountDaoImpl();
				System.out.println("Please enter account ID you wish to delete: ");
				int id3 = Integer.parseInt(scan.nextLine());
				Account deleteAccount = null;
				try {
					deleteAccount = delete.getBankAccount(id3);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(deleteAccount.getBalance()==0) {
					try {
						delete.deleteAccount(id3);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("Account deleted!");
				} else {
					System.out.println("Account not eligible to be deleted becuase it does not have a balance of 0");
					userMenu(user);
				}
				break;
			case 5:
				try {
					startMenu();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			default:
				System.out.println("Please enter a valid selection");
				userMenu(user);
				break;
			}
			break;
		case 3:
			try {
				startMenu();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case 4:
			System.out.println("Thank you for using DSM Bank!");
			System.exit(0);
			break;
		default:
			System.out.println("Please enter a valid selection");
			break;
		}
	}
	
	public static void adminLoginMenu() {
		Properties prop = new Properties();
		try {
			prop.load(new FileReader("database.properties"));
			String username = prop.getProperty("adminU");
			String password = prop.getProperty("adminP");
			System.out.println(username);
			System.out.println("login succesful!");
			adminMenu(username);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public static void adminMenu(String username) {
		System.out.println(username + ", what would you like to do?\n1.\tView Accounts\n2.\tCreate User\n3.\tUpdate user\n4.\tDelete user\n5.\tLogout");
		int choice = Integer.parseInt(scan.nextLine());
		switch (choice) {
		case 1:
			System.out.println("Search by\n1.\tuser_id\n2.\tbank_account_id");
			int choice2 = Integer.parseInt(scan.nextLine());
			switch(choice2) {
			case 1:
				System.out.println("Enter user_id");
				int use = Integer.parseInt(scan.nextLine());
				//UserDao u = new UserDaoImpl();
				AccountDaoImpl a = new AccountDaoImpl();
				try {
					
					List<Account> accts = (ArrayList<Account>) a.getMyAccounts(user.getUserId());
					System.out.println(accts.toString());
				} catch (SQLException e) {
					e.printStackTrace();
				}
				adminMenu(username);
				break;
			case 2:
				System.out.println("Enter bank_account_id: ");
				int myacct = Integer.parseInt(scan.nextLine());
				AccountDaoImpl adi = new AccountDaoImpl();
				//UserDao udi = new UserDaoImpl();
				try {
					Account acct = adi.getBankAccount(myacct);;
					System.out.println(acct);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				adminMenu(username);
				break;
			default:
				System.out.println("Please enter a valid selection");
				adminMenu(username);
				break;
			}
			adminMenu(username);
			break;
		case 2:
			System.out.println("Please enter a username");
			String uname = scan.nextLine();
			System.out.println("Please enter password");
			String pword = scan.nextLine();
			UserDao ud = new UserDaoImpl();
			try {
				ud.registerUser(uname, pword);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("User created successfully");
			adminMenu(username);
			break;
		case 3:
			System.out.println("Enter user_id you would wish to update");
			int id = Integer.parseInt(scan.nextLine());
			UserDao udi = new UserDaoImpl();
			try {
				System.out.println("What would you like to update?\n1.\tUsername\n2.\tPassword\n3.\tBack");
				int userChoice = Integer.parseInt(scan.nextLine());
				switch (userChoice) {
				case 1:
					System.out.println("Enter new username: ");
					String newUsername = scan.nextLine();
					udi.updateUsername(id, newUsername);
					System.out.println("User " + id +  "updated to " + newUsername);
					adminMenu(username);
					break;
				case 2:
					System.out.println("What is the new password?");
					String newPassword = scan.nextLine();
					udi.updatePassword(id, newPassword);
					System.out.println("User " + id + "Password updated to " + newPassword);
					adminMenu(username);
					break;
				case 5:
					adminMenu(username);
					break;
				default:
					System.out.println("Please enter a valid selection");
					adminMenu(username);
					break;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			adminMenu(username);
			break;
		case 4:
			AccountDao delete = new AccountDaoImpl();
			System.out.println("Please enter the bank_account_id you wish to delete: ");
			int id4 = Integer.parseInt(scan.nextLine());
			Account deleteAccount = null;
			try {
				deleteAccount = delete.getBankAccount(id4);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(deleteAccount.getBalance()==0) {
				try {
					delete.deleteAccount(id4);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Account deleted!");
			} else {
				System.out.println("Account not eligible to be deleted becuase it does not have a balance of 0");
				userMenu(user);
			}
			break;
		case 5:
			try {
				startMenu();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:
			System.out.println("Please enter a valid selection");
			break;
		}
	}
	
}
