package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.AccountInfo;

import java.io.Serializable;

//import com.revature.beans.AccountInfo;

public class Transactions implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3501618849283679804L;
	private String status;
	private static double balance = 0.00;
	private static int accountNumber = 0000;
	private int counter = 0;
	private AccountInfo cust;
	private static String accountType;
	
	public static List<Transactions> accounts = new ArrayList<Transactions>();
	public static ArrayList<String> tItems;
	
	
	public Transactions(String accountType, double balance) {
		Transactions.accountType = accountType;
		Transactions.balance = balance;
		accountNumber = ++counter;
		status = "open";
		accounts.add(this);
		tItems = new ArrayList<String>();
		addTransactions("Initial balance: " + String.valueOf(balance));
		FileStuff.writeAccountsFile(accounts);
	}
	
	
	public Transactions(String accountType, double balance, AccountInfo cust) {
		Transactions.accountType = accountType;
		Transactions.balance = balance;
		this.cust = cust;
		accountNumber = ++counter;
		status = "open";
		accounts.add(this);
		tItems = new ArrayList<String>();
		addTransactions("Initial balance: " + String.valueOf(balance));
		FileStuff.writeAccountsFile(accounts);
	}
	
	
	
	public static void addTransactions(String message) {
		tItems.add(0, message);
	}
	
	
	public static void transferMoney(int fromAcct, int toAcct, double amt) {
		
		withdrawMoney(amt, fromAcct);
		depositMoney(amt, toAcct);
		addTransactions("The amount of " + String.valueOf(amt) + " was transferred from " +  String.valueOf(fromAcct) + " to " + String.valueOf(toAcct));
		FileStuff.writeAccountsFile(accounts);
	}
	
	
	
	
	
	
	public static void withdrawMoney(double amount, int accountNumber) {
		AccountInfo  a = AccountInfo.findAccountNum(accountNumber);
		balance = a.getTransactions().getBalance();
		if ( balance <= 0.00) {
			System.out.println("Insufficient Balance");
		} else {
			balance -= amount;
			a.getTransactions().setBalance(balance);
			addTransactions(String.valueOf(amount) + "has been added to your account. New Balance: " + String.valueOf(balance));
			FileStuff.writeAccountsFile(accounts);
			a.getTransactions();
			LogThis.LogIt("info", "Balance was withdrawn $" + amount + "from " + Transactions.getAccountNumber());
		}	
		
	}
	
	

	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		Transactions.balance = balance;
	}


	public ArrayList<String> gettItems() {
		return tItems;
	}


	public void settItems(ArrayList<String> tItems) {
		Transactions.tItems = tItems;
	}


	public static int getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(int accountNumber) {
		Transactions.accountNumber = accountNumber;
	}


	public int getCounter() {
		return counter;
	}


	public void setCounter(int counter) {
		this.counter = counter;
	}


	public static String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		Transactions.accountType = accountType;
	}


	public static void depositMoney(double amount, int accountNumber) {
		AccountInfo  a = AccountInfo.findAccountNum(accountNumber);
		balance = a.getTransactions().getBalance();
		balance += amount;
		a.getTransactions().setBalance(balance);
		addTransactions(String.valueOf(amount) + "has been added to your account. New Balance: " + String.valueOf(balance));
		FileStuff.writeAccountsFile(accounts);
		a.getTransactions();
		LogThis.LogIt("info", "A deposit has been made " + amount + "added to account " + Transactions.getAccountNumber());
	}


	@Override
	public String toString() {
		return "Transactions [status=" + status + ", balance=" + balance + ", tItems=" + tItems
				+ ", accountNumber=" + accountNumber + ", counter=" + counter + ", accountType=" + accountType + "]";
	}
	
	
	
	

}
