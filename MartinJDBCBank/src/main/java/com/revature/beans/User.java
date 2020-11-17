package com.revature.beans;

public class User {
	
	private int userId;
	private String username;
	private String pword;
	
	
	
	public User(int userId, String username, String pword) {
		super();
		this.userId = userId;
		this.username = username;
		this.pword = pword;
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPword() {
		return pword;
	}



	public void setPword(String pword) {
		this.pword = pword;
	}



	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", pword=" + pword
				+ "]";
	}
}
