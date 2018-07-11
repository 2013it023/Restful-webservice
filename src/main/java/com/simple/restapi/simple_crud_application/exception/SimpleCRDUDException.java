package com.simple.restapi.simple_crud_application.exception;

/**
 * SimpleCRDUDException class used to throw a custom exception
 * 
 * @author Saravanan Perumal
 * @since July, 2018
 *
 */
public class SimpleCRDUDException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8554808493691827036L;

	/**
	 * SimpleCRDUDException constructor
	 * 
	 * @param exception
	 */
	public SimpleCRDUDException(String exception) {
		super(exception);
	}

}
