package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.dao.UserDao;
import com.revature.services.LogThis;
import com.revature.util.ConnFactory;

public class UserDaoImpl implements UserDao {

	
	public static ConnFactory cf = ConnFactory.getInstance();
	
	@Override
	public void registerUser(String username, String password) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "insert into users values(DEFAULT, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql,
				Statement.RETURN_GENERATED_KEYS);
		ps.setString(1,username);
		ps.setString(2, password);
		ps.executeUpdate();	
		LogThis.LogIt("info", "New User created: " + username);
	}

	@Override
	public User loginUser(String userName, String password) throws SQLException {	
		Connection conn = cf.getConnection();
		String sql = "select  * from users where username = ? and pword = ?";
		PreparedStatement ps = conn.prepareStatement(sql,
				Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, userName);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		User now = null;
		while(rs.next()) {
			now = new User(rs.getInt(1), rs.getString(2), rs.getString(3));
			
		}
		
		return now;
	}

	@Override
	public List<User> getUsers() throws SQLException {
		List<User> userList = new ArrayList<User>();
		Connection conn = cf.getConnection();
		String sql = "select * from users";
		PreparedStatement ps = conn.prepareStatement(sql,
				Statement.RETURN_GENERATED_KEYS);
		ResultSet rs = ps.executeQuery();
		User now = null;
		while (rs.next()) {
			now = new User(rs.getInt(1), rs.getString(2), rs.getString(3));
			userList.add(now);
		}
		return userList;
	}

	@Override
	public void removeUser(int id) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "delete from users where user_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql,
				Statement.RETURN_GENERATED_KEYS);
		ps.setInt(1,id);
		ps.executeUpdate();	
	}
	
	/*@Override
	public List<Account> getUserAccounts(int userId) throws SQLException {
		int acctNum = 0;
		List<Users> myAccounts = new ArrayList<Account>();
		Connection conn = cf.getConnection();
		String sql = "select * from users where user_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, userId);
		ResultSet rs = ps.executeQuery();
		User a = null;
		while(rs.next()) {
			a = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			myAccounts.add(a);
		}
		return myAccounts;
	}*/

	@Override
	public void updateUsername(int id, String userName) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "update users set username=? where user_id =?";
		PreparedStatement ps = conn.prepareStatement(sql,
				Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, userName);
		ps.setInt(2, id);
		ps.executeUpdate();
	}

	@Override
	public void updatePassword(int id, String password) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "update users set pword=? where user_id=?";
		PreparedStatement ps = conn.prepareStatement(sql,
				Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, password);
		ps.setInt(2, id);
		ps.executeUpdate();
		
	}
	
	
}
