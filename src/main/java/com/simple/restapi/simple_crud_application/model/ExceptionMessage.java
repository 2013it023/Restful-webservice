package com.simple.restapi.simple_crud_application.model;

import javax.ws.rs.core.Response.Status;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * ExceptionMessage class used to throw a custom exception, which is directly
 * returned to client side.
 * 
 * @author Saravanan Perumal
 * @since July, 2018
 *
 */
@XmlRootElement
public class ExceptionMessage {

	/**
	 * exceptionMessage, which is got from database.
	 */
	private String exceptionMessage;

	/**
	 * status, status code for the failure
	 */
	private Status status;

	/**
	 * ExceptionMessage, constructor
	 */
	public ExceptionMessage() {

	}

	/**
	 * ExceptionMessage parameterized constructor to initialize an instances
	 * 
	 * @param exceptionMessage,
	 *            which is received from Database
	 * @param status
	 *            status to identify the fault.
	 */
	public ExceptionMessage(String exceptionMessage, Status status) {
		super();
		this.exceptionMessage = exceptionMessage;
		this.status = status;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
