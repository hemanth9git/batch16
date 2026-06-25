package com.tejait.batch16.exceptions;

public class DataNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DataNotFoundException() {
		super();
	}
	
	public DataNotFoundException(String msg) {
		super(msg);
	}

}
