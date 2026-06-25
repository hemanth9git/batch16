package com.tejait.batch16.exceptions;

public class ExceededAttemptsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExceededAttemptsException() {
		super();
	}
	
	public ExceededAttemptsException(String msg) {
		super(msg);
	}
	
	

}
