package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String database = "jdbc:mysql://localhost:3306/"+"grades";
            String user = "root";
            String password = "123456";
            Connection conn = DriverManager.getConnection(database,user,password);
            return conn;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
        
    }
	public Connection getConnection(String database,String user,String password){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			database = "jdbc:mysql://localhost:3306/"+database;
			Connection conn = DriverManager.getConnection(database,user,password);
			return conn;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	public void close(Connection conn){
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
