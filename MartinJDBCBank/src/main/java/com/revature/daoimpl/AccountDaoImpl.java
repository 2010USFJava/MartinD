package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.dao.AccountDao;
import com.revature.util.ConnFactory;

public class AccountDaoImpl implements AccountDao {

	
	
	public static ConnFactory cf = ConnFactory.getInstance();
	
	
	@Override
	public Account getAccountHistory(User u) throws SQLException {
		
		String sql = "select * from accounts where bank_account_id = ?";
		try(Connection conn = cf.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, u.getAcctId());
			ResultSet rs = ps.executeQuery();
			Account current = null;
			while(rs.next()) {
				current = new Account(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getDouble(4));
			}
			return current;
		} catch (SQLException e ) {
			//
		}
		
	}

	@Override
	public void createAccount() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAccount() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void depositMoney() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void withdrawMoney() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
}
