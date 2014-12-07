package com.MovieOpera;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.movieTbl;
import com.jdbc.MyConnection;
import com.mysql.jdbc.Connection;

public class OperaMovie {
	public List<movieTbl> showTbl(){
		MyConnection util = new MyConnection();
		Connection conn = (Connection) util.getConnection("app_webexceltest", "ow3kjm3l5m","133lxi3wk414hy32k05y4h0ixihzl4l5xy5yxml2");
		String sql = "select *from table9";
		try {
			PreparedStatement pstmt1 = conn.prepareStatement(sql);
			ResultSet rs = pstmt1.executeQuery();
			List<movieTbl> list = new ArrayList<movieTbl>();
			while(rs.next()){
				movieTbl tb = new movieTbl();
				tb.setActor(rs.getString("actor"));
				tb.setGrade(rs.getString("grade"));
				tb.setName(rs.getString("name"));
				tb.setPlace(rs.getString("place"));
				tb.setType(rs.getString("type"));
				list.add(tb);
			}
			conn.close();
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}
	public void DeleteTB(movieTbl tb) {
		MyConnection db  = new MyConnection();
		Connection conn  = (Connection) db.getConnection("app_webexceltest", "ow3kjm3l5m","133lxi3wk414hy32k05y4h0ixihzl4l5xy5yxml2");
		String sql = "delete from table9 where name=?";
		
			PreparedStatement pstmt;
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,tb.getName());
				pstmt.executeUpdate();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
	}

}
