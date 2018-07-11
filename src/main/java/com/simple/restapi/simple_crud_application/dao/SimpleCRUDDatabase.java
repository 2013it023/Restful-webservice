package com.simple.restapi.simple_crud_application.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.simple.restapi.simple_crud_application.exception.SimpleCRDUDException;

/**
 * SimpleCRUDDatabase class used to handle the database connection.
 * 
 * @author Saravanan Perumal
 * @since July, 2018
 *
 */
public class SimpleCRUDDatabase {

	/**
	 * getConnectionStatement method used to connect with postgresql database.
	 * 
	 * @return statement
	 */
	public static Statement getConnectionStatement() {
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SimpleApp", "postgres",
					"");
			stmt = con.createStatement();
		} catch (Exception exception) {
			throw new SimpleCRDUDException(exception.getMessage());
		}
		return stmt;
	}
}
