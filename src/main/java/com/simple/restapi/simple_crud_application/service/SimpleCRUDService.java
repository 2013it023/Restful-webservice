package com.simple.restapi.simple_crud_application.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.simple.restapi.simple_crud_application.dao.SimpleCRUDDatabase;
import com.simple.restapi.simple_crud_application.exception.SimpleCRDUDException;
import com.simple.restapi.simple_crud_application.model.ProfileInformation;

/**
 * SimpleCRUDService class used to hanlde all the business logics.
 * 
 * @author Saravanan Perumal
 * @since July, 2018
 *
 */
public class SimpleCRUDService {

	/**
	 * stmt, which is used to perform insertion, deletion, update and retrival
	 * operation.
	 */
	private static final Statement stmt = SimpleCRUDDatabase.getConnectionStatement();

	/**
	 * getAllProfiles method used to fetch list of profile information from
	 * Database.
	 * 
	 * @return list of profile information.
	 */
	public List<ProfileInformation> getAllProfiles() {
		List<ProfileInformation> profileInformationList = new ArrayList<>();
		try {
			String selectQuery = "SELECT * FROM public.simpleapp";
			ResultSet resultSet = stmt.executeQuery(selectQuery);
			while (resultSet.next()) {
				profileInformationList.add(this.getProfileInformation(resultSet));
			}
		} catch (SQLException exception) {
			new SimpleCRDUDException(exception.getMessage());
		}
		return profileInformationList;
	}

	/**
	 * getProfile method used to fetch a profile from database based upon the user
	 * id
	 * 
	 * @param userId,
	 *            unique id of the user.
	 * @return profile information.
	 */
	public ProfileInformation getProfile(String userId) {
		ProfileInformation information = new ProfileInformation();
		try {
			String query = "SELECT * FROM public.simpleapp WHERE userId = '" + userId + "'";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				information = this.getProfileInformation(rs);
			}
		} catch (SQLException exception) {
			throw new SimpleCRDUDException(exception.getMessage());
		}
		return information;
	}

	/**
	 * createProfile method used to create a new profile
	 * 
	 * @param information,
	 *            which received from client side.
	 */
	public void createProfile(ProfileInformation information) {
		try {
			String query = "INSERT INTO public.simpleapp (userId, password, firstName, lastName, emailId, mobileNumber) VALUES ('"
					+ information.getUserId() + "', '" + information.getPassword() + "','" + information.getFirstName()
					+ "' , '" + information.getLastName() + "','" + information.getMail() + "' ,"
					+ information.getMobileNumber() + ")";
			stmt.executeUpdate(query);
		} catch (SQLException exception) {
			throw new SimpleCRDUDException(exception.getMessage());
		}
	}

	/**
	 * deleteProfile method used to delete a profile from database.
	 * 
	 * @param userId,
	 *            unique id of the user.
	 */
	public void deleteProfile(String userId) {
		String query = "DELETE FROM public.simpleapp WHERE userId = '" + userId + "'";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException exception) {
			throw new SimpleCRDUDException(exception.getMessage());
		}
	}

	/**
	 * updateProfile method used to update a profile.
	 * 
	 * @param profileInformation,
	 *            which is contains new details to modify the existing content.
	 * @return modified profile information.
	 */
	public ProfileInformation updateProfile(ProfileInformation profileInformation) {
		ProfileInformation information = new ProfileInformation();
		try {
			String query = "UPDATE public.simpleapp SET firstName = '" + profileInformation.getFirstName()
					+ "', lastName = '" + profileInformation.getLastName() + "', emailId = '"
					+ profileInformation.getMail() + "' WHERE userId = '" + profileInformation.getUserId() + "';";
			stmt.executeUpdate(query);
			query = "SELECT * FROM public.simpleapp WHERE userId = '" + profileInformation.getUserId() + "'";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				information = this.getProfileInformation(rs);
			}
		} catch (SQLException exception) {
			throw new SimpleCRDUDException(exception.getMessage());
		}
		return information;
	}

	/**
	 * getProfileInformation method used to get profile information from result set
	 * 
	 * @param resultSet,
	 *            which is fetched from database.
	 * @return profile information.
	 * @throws SQLException
	 */
	private ProfileInformation getProfileInformation(ResultSet resultSet) throws SQLException {
		ProfileInformation information = new ProfileInformation();
		information.setUserId(resultSet.getString("userId"));
		information.setFirstName(resultSet.getString("firstName"));
		information.setLastName(resultSet.getString("lastName"));
		information.setPassword(resultSet.getString("password"));
		information.setMail(resultSet.getString("emailId"));
		information.setMobileNumber(resultSet.getLong("mobileNumber"));
		return information;
	}

}
