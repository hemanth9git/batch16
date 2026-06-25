package com.tejait.batch16.exceptions;

public class IdNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public IdNotFoundException() {
		super();
	}
	
	public IdNotFoundException(String msg) {
		super(msg);
	}

	
}
