package com.revature.exceptions;

public class InvalidPasswordException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5107114096950026843L;
	
	@Override
	public String getMessage() {
		return "Invalid Password.";
	}

}
