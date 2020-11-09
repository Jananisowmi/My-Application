package com.janu.myapplication.exception;

public class UserNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9092189291356675102L;

	public UserNotFoundException(String exception) {
		super(exception);
	}
	

}
