package com.revature.beans;

import java.util.ArrayList;
import java.util.List;

import com.revature.menus.Menu;
import com.revature.services.FileStuff;
import com.revature.services.LogThis;
//import com.revature.beans.AccountInfo;
import com.revature.services.Transactions;

public class Employee {
	
	
	private String username;
	private String password;
	private static boolean isAdmin;
	
	private static List<Employee> employeeLogins = new ArrayList<Employee>();
	
	public Employee(String username, String password, boolean isAdmin) {
		this.username = username;
		this.password = password;
		Employee.isAdmin = isAdmin;
		employeeLogins.add(this);
	}
	
	
	
	public static void deleteAccount(int acctNum) {
		AccountInfo  a = AccountInfo.findAccountNum(acctNum);
		AccountInfo.customerAccounts.remove(a);
		System.out.println("Account has been removed from system");
		FileStuff.writeCustomerAccountsFile(AccountInfo.customerAccounts);
		LogThis.LogIt("info", "Account deleted: " + acctNum);
		
	}
	
	
	public static AccountInfo checkOpenCases(String stat) {
		for (int i = 0; i <AccountInfo.customerAccounts.size(); i++) {
			String s = AccountInfo.customerAccounts.get(i).getTransactions().getStatus();
			
			if(stat.equals(s)) {
				return AccountInfo.customerAccounts.get(i);
			} 
			
		}
		System.out.println("No open cases found");
		return null;
		
	}
	
	
	public static void changeStatus(int acctNum, String stats) {
		for (int i = 0; i <AccountInfo.customerAccounts.size(); i++) {
			AccountInfo.customerAccounts.get(i).getTransactions();
			int a = Transactions.getAccountNumber();
			if (a == acctNum) {
				if(stats.equals("a")) {
					AccountInfo.customerAccounts.get(i).getTransactions().setStatus("accepted");
				} 
				else if(stats.equals("d")) {
					AccountInfo.customerAccounts.get(i).getTransactions().setStatus("denied");
				} 
			}
			FileStuff.writeCustomerAccountsFile(AccountInfo.customerAccounts);
			AccountInfo.customerAccounts.get(i).getTransactions();
			LogThis.LogIt("info","Account info changed for customer " + Transactions.getAccountNumber());

		}
	}
	
	
	
	public static boolean isAdmin() {
		return isAdmin;
	}


	public void setAdmin(boolean isAdmin) {
		Employee.isAdmin = isAdmin;
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





	public static List<Employee> getEmployeeLogins() {
		return employeeLogins;
	}





	public static void setEmployeeLogins(List<Employee> employeeLogins) {
		Employee.employeeLogins = employeeLogins;
	}





	public static Employee checkingLogin(String uname, String pword) {
		for (int i = 0; i < employeeLogins.size(); i++) {
			String userName= employeeLogins.get(i).getUsername();
			String userPassword= employeeLogins.get(i).getPassword();
			
			if(userName.equals(uname) && userPassword.equals(pword)) {
				return employeeLogins.get(i);
				
				
			} else {
				System.out.println("Sorry couldn't find that login information.");
				System.out.println("Please make sure you have the correct username and password.");
				Menu.startMenu();
			}
		}
		return null;
		
	}


	@Override
	public String toString() {
		return "Employee [username=" + username + ", password=" + password + ", isAdmin=" + isAdmin + "]";
	}
	
	
	

}
