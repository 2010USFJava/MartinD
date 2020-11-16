package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.beans.User;
import com.revature.dao.UserDao;
import com.revature.util.ConnFactory;

public class UserDaoImpl implements UserDao {

	
	public static ConnFactory cf = ConnFactory.getInstance();
	
	@Override
	public void registerUser(User u) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "insert into users values(?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, u.getUserId()); //index is for the question marks
		ps.setString(2, u.getUsername());
		ps.setString(3, u.getPword());
		ps.setInt(4, u.getAcctId());
		ps.executeUpdate();	
	}

	//@Override
	/*public User loginUser(String user, String pass) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "select * from pookiemans where pid = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Pookieman hannah = null;
		while(rs.next()) {
			hannah = new Pookieman(rs.getInt(1), rs.getString(2));
		}
		return hannah;
	} */
	
	
	

}
