package com.revature.beans;

public class Account {
	
	
	private int acctId;
	private double balance;
	private String transacType;
	private double amount;
	
	public Account(int acctId, double balance, String transacType, double amount) {
		super();
		this.acctId = acctId;
		this.balance = balance;
		this.transacType = transacType;
		this.amount = amount;
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

	public String getTransacType() {
		return transacType;
	}

	public void setTransacType(String transacType) {
		this.transacType = transacType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Account [acctId=" + acctId + ", balance=" + balance + ", transacType=" + transacType + ", amount="
				+ amount + "]";
	}
}
