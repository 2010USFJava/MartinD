package com.revature.dao;

import java.sql.SQLException;

import com.revature.beans.Account;
import com.revature.beans.User;

public interface AccountDao {

	
	//read method
	public Account getAccountHistory(User u) throws SQLException;
	
	//insert method
	public void createAccount() throws SQLException;
	
	//remove method
	public void deleteAccount() throws SQLException;
	
	//update methods
	public void depositMoney() throws SQLException;
	
	public void withdrawMoney() throws SQLException;
	
}
