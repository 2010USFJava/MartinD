package com.revature.exceptions;

public class InvalidUsernameException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4836818490443331095L;

	
	@Override
	public String getMessage() {
		return "Invalid username.";
	}
}
