package com.example.cleardb;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;

public class CreateTables {
    
    public static String create() throws Exception {
       
        Connection connection = CreateClearDBTable.getConnection();
        
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("DROP TABLE IF EXISTS ticks");
        stmt.executeUpdate("CREATE TABLE ticks (tick timestamp)");
        stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
        ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");
        String output = "";
        while (rs.next()) {
            //System.out.println("Read from DB: " + rs.getTimestamp("tick"));
            output=output+"Read from DB: " + rs.getTimestamp("tick");
        }
        rs.close();
        stmt.close();
        connection.close();
       return output; 
    }
    
    private static Connection getConnection() throws URISyntaxException, SQLException {
        //URI dbUri = new URI(System.getenv("DATABASE_URL"));

        //String username = dbUri.getUserInfo().split(":")[0];
        //String password = dbUri.getUserInfo().split(":")[1];
        String username = "bc4e2f8474c80f";
        String password = "5e47269b";
       // String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + dbUri.getPath();
        String dbUrl = "jdbc:mysql://us-cdbr-iron-east-03.cleardb.net/ad_ae3b1d16c91325c";

        return DriverManager.getConnection(dbUrl, username, password);
       // return DriverManager.getConnection(dbUrl);
    }

}