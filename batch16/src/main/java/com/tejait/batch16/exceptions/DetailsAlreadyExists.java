package com.tejait.batch16.exceptions;

public class DetailsAlreadyExists extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DetailsAlreadyExists() {
		super();
	}
	
	public DetailsAlreadyExists(String msg) {
		super(msg);
	}

}
