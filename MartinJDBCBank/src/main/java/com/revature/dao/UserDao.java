package com.revature.dao;

import java.sql.SQLException;

import com.revature.beans.User;

public interface UserDao {

	//insert method
	public void registerUser(User u) throws SQLException;
	
	//read method
	//public User loginUser() throws SQLException;
	
}
