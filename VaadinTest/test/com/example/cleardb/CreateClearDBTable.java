/**
 * 
 */
package com.example.cleardb;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author q791213
 *
 */
public class CreateClearDBTable {

	/**
	 * 
	 */
	public CreateClearDBTable() {
		// TODO Auto-generated constructor stub
	}
	public static Connection getConnection() throws URISyntaxException, SQLException {
	    URI dbUri = new URI(System.getenv("CLEARDB_DATABASE_URL"));

	    String username = dbUri.getUserInfo().split(":")[0];
	    String password = dbUri.getUserInfo().split(":")[1];
	    String dbUrl = "jdbc:mysql://" + dbUri.getHost() + dbUri.getPath();
	    
	    	 try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	    
	    return DriverManager.getConnection(dbUrl, username, password);
	}

}
