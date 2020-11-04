package com.revature.beans;

import java.util.ArrayList;
import java.util.List;
import com.revature.menus.Menu;

public class AccountInfo {
	
	private String name;
	private String address;
	private String phoneNumber;
	private String emailAddress;
	private String dateOfBirth;
	private String accountType;
	private int accountNumber;
	private String username;
	private String password;
	
	public static List<AccountInfo> accountLogins = new ArrayList<AccountInfo>();
	
	
	
	
	//constructor for customer username and password (not open to users)
	//could ason just use a hashmap to store usernames and passwords !!!!
	AccountInfo(String username, String password) {
		this.username = username;
		this.password = password;
		accountLogins.add(this);
	}
	
	
	//constructor for when customer is registering (employees and costumers will be able to see.
	public AccountInfo(String name, String address, String phoneNumber, String emailAddress, String dateOfBirth, String username) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.dateOfBirth = dateOfBirth;
		//this.accountType = accountType;
		this.username = username;
		//this.accountNumber = accountNumber;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public String getEmailAddress() {
		return emailAddress;
	}


	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	public int getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "AccountInfo [name=" + name + ", address=" + address + ", phoneNumber=" + phoneNumber + ", emailAddress="
				+ emailAddress + ", dateOfBirth=" + dateOfBirth + ", accountType=" + accountType + ", accountNumber="
				+ accountNumber + ", username=" + username + ", password=" + password + "]";
	}
	
	
	
	public static void checkingLogin(String uname, String pword) {
		for (int i = 0; i < accountLogins.size(); i++) {
			String userName= accountLogins.get(i).getUsername();
			String userPassword= accountLogins.get(i).getPassword();
			
			if(userName.equals(uname) && userPassword.equals(pword)) {
				System.out.println("Login Successful!");
			} else {
				System.out.println("Sorry couldn't find that login information.");
				System.out.println("Please make sure you have the correct username and password.");
				Menu.startMenu();
			}
		}
		
	}
	
	
	
	
	

}
