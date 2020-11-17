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
import com.revature.dao.AccountDao;
import com.revature.services.LogThis;
import com.revature.util.ConnFactory;

public class AccountDaoImpl implements AccountDao {
	
	public static ConnFactory cf = ConnFactory.getInstance();


	@Override
	public void createAccount(double initial, String type, User u) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "insert into accounts values(default,?,?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql,
				Statement.RETURN_GENERATED_KEYS);
		ps.setDouble(1, initial);
		ps.setString(2, type);
		ps.setInt(3, u.getUserId());
		ps.executeUpdate();
		LogThis.LogIt("info", "New Account created and added to database initial deposit: $" + initial);
	}

	@Override
	public List<Account> getMyAccounts(int userId) throws SQLException {
		List<Account> history = new ArrayList<Account>();
		String sql = "select * from accounts where user_id = ?";
		Connection conn = cf.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql,
				Statement.RETURN_GENERATED_KEYS);
		ps.setInt(1, userId);
		ResultSet rs = ps.executeQuery();
		Account current = null;
		while(rs.next()) {
			current = new Account(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getInt(4));
			history.add(current);
		}
		return history;
	}
	
	
	public Account getAccountByUserId(User userId) throws SQLException {
		String sql = "select bank_account_id from accounts where bank_account_id = ?";
		Connection conn = cf.getConnection();
		PreparedStatement ps = conn.prepareCall(sql);
		
		ps.setInt(1,userId.getUserId());
		ResultSet rs = ps.executeQuery();
		Account a = null;
		while(rs.next()) {
			a = new Account(rs.getInt(1), rs.getDouble(4), rs.getString(3), rs.getInt(4));
		}
		return a;
	}
	
	@Override
	public Account getBankAccount(int acctId) throws SQLException{
		Connection conn = cf.getConnection();
		String sql = "select * from accounts where bank_account_id=?";
		PreparedStatement ps = conn.prepareCall(sql);
		Account now = null;
		ps.setInt(1, acctId);
		
		ResultSet rs =ps.executeQuery();
		
		while(rs.next()) {
			now = new Account(rs.getInt(1),rs.getDouble(2),rs.getString(3), rs.getInt(4));
		}
		
		return now;
}

	

	@Override
	public void deleteAccount(int id) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "delete from accounts where bank_account_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql,
				Statement.RETURN_GENERATED_KEYS);
		ps.setInt(1,id);
		ps.executeUpdate();
		LogThis.LogIt("info", " Bank Account deleted from database for account number: " + id );
		
	}

	@Override
	public void updateBalance(double b, int acctId) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "update accounts set balance = ?::NUMERIC where bank_account_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql,
				Statement.RETURN_GENERATED_KEYS);
		ps.setDouble(1,b);
		ps.setInt(2, acctId);
		ps.executeUpdate();	
		
	}

	
	
	
	
	
	
}
