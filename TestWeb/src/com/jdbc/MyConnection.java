package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    
    /*
	public Connection getConnection(String database,String user,String password){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//database = "jdbc:mysql://w.rdc.sae.sina.com.cn:3307/"+database;
			database = "jdbc:mysql://localhost:3306/"+database;
			Connection conn = DriverManager.getConnection(database,user,password);
			return conn;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	*/
	public Connection getConnection() {
	    try {
            Class.forName("com.mysql.jdbc.Driver");
            //Connection conn = DriverManager.getConnection("jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_getwebtable","o45ooj1ykl","0z2hhk45iix5j441mh2wzw4kh001ylkkml055k1z");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webtblget","root","123456");
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
