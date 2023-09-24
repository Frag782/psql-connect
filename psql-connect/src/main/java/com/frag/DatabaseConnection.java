package com.frag;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnection {	
	static Connection open(String dbUrl, String dbUser, String dbPassword) {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			System.out.println("Connected to database successfully !");
		} catch(Exception e) { 
			e.printStackTrace(); 
		}
		return conn; 
	}
	
	static void close(Connection connection) {
		try {
			connection.close();
			System.out.println("Connection closed successfully !");
		} catch(Exception e) { e.printStackTrace(); }
	}
}
