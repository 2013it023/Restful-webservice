package com.simple.restapi.simple_crud_application.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * ProfileInformation is model class used to handle user profile information.
 * 
 * @author Saravanan Perumal
 * @since July, 2018
 *
 */
@XmlRootElement
public class ProfileInformation {

	private String userId;

	private String firstName;

	private String lastName;

	private String password;

	private String mail;

	private long mobileNumber;

	public ProfileInformation() {

	}

	public ProfileInformation(String userId, String firstName, String lastName, String password, String mail,
			long mobileNumber) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.mail = mail;
		this.mobileNumber = mobileNumber;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
}
