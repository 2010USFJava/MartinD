package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.User;

public interface AccountDao {

	
	//read method
	public List<Account> getMyAccounts(int userId) throws SQLException;
	public Account getAccountByUserId(User userId) throws SQLException;
	public Account getBankAccount(int acctId) throws SQLException;
	//insert method
	public void createAccount(double initial, String type) throws SQLException;
	
	//remove method
	public void deleteAccount(int id) throws SQLException;
	
	//update methods
	public void updateBalance(double b, int acctId) throws SQLException;

	
	
}
