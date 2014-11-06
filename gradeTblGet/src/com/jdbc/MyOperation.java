package com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bean.Lesson;


public class MyOperation {
	public void add(Lesson L,String database,String user,String password,String tblName){
		MyConnection util = new MyConnection();
		Connection conn = util.getConnection(database, user, password);
		String sql = "insert into "+tblName+" values(?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, L.getTerm());
			pstmt.setString(2, L.getLessonNum());
			pstmt.setString(3, L.getLessonName());
			pstmt.setString(4, L.getTecherName());
			pstmt.setString(5, L.getKind());
			pstmt.setString(6, L.getGrade());
			pstmt.setString(7,L.getTime());
			pstmt.setString(8,L.getMyPoint());
			pstmt.setString(9,L.getGradeKind());
			pstmt.setString(10,L.getRemark());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			util.close(conn);
		}
		
	}
}
