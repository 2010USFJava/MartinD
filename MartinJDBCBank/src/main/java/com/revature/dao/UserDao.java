package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.User;

public interface UserDao {

	//insert method
	public void registerUser(String userName, String password) throws SQLException;
	
	//read methods
	public User loginUser(String userName, String password) throws SQLException;
	
	public List<User> getUsers() throws SQLException;
	
	//public List<Integer> getUserAccounts(int userId) throws SQLException;
	
	//delete methods
	public void removeUser(int id) throws SQLException;
	
	
	//update methods
	public void updateUsername(int id, String userName) throws SQLException;
	public void updatePassword(int id, String password) throws SQLException;
	
}
