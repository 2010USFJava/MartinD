package com.revature.beans;

public class User {
	
	private int userId;
	private String username;
	private String pword;
	//private boolean isAdmin;
	private int acctId;
	
	
	
	public User(int userId, String username, String pword, int acctId) {
		super();
		this.userId = userId;
		this.username = username;
		this.pword = pword;
		//this.isAdmin = isAdmin;
		this.acctId = acctId;
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



	/* public boolean isAdmin() {
		return isAdmin;
	} 



	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	} */



	public int getAcctId() {
		return acctId;
	}



	public void setAcctId(int acctId) {
		this.acctId = acctId;
	}



	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", pword=" + pword
				+ ", acctId=" + acctId + "]";
	}
}
