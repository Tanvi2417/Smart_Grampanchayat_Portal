package com.gpp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	public Connection connect() {
		
		String url = "jdbc:mysql://localhost:3306/smart_gram_panchayat";
		String username = "root";
		String password = "Sid@6431t";
		
		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			
			System.out.println("Database Connected");
			
			return connection;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
