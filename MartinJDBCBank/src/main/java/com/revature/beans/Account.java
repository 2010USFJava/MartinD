package com.revature.beans;

public class Account {
	
	
	private int acctId;
	private double balance;
	private String accType;
	private int userId;
	
	public Account(int acctId, double balance, String accType, int userId) {
		super();
		this.acctId = acctId;
		this.balance = balance;
		this.accType = accType;
		this.userId = userId;
	}
	
	

	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public int getAcctId() {
		return acctId;
	}

	public void setAcctId(int acctId) {
		this.acctId = acctId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	@Override
	public String toString() {
		return "Account [acctId=" + acctId + ", balance=" + balance + ", accType=" + accType + ", userId=" + userId
				+ "]";
	}
}
