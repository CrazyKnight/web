package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB_Connection {
	public Connection getConnection(String databaseName, String user, String password){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/"+databaseName;
			return DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
