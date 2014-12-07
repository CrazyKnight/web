package com.dbOpera;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.doubanTbl;
import com.jdbc.MyConnection;
import com.mysql.jdbc.Connection;

public class OperaDB {
	public List<doubanTbl> showTbl(){
		MyConnection util = new MyConnection();
		Connection conn = (Connection) util.getConnection("app_webexceltest", "ow3kjm3l5m","133lxi3wk414hy32k05y4h0ixihzl4l5xy5yxml2");
		String sql = "select *from table5";
		try {
			PreparedStatement pstmt1 = conn.prepareStatement(sql);
			ResultSet rs = pstmt1.executeQuery();
			List<doubanTbl> db_list = new ArrayList<doubanTbl>();
			while(rs.next()){
				doubanTbl db = new doubanTbl();
				db.setAuthor(rs.getString("author"));
				db.setLast_re(rs.getString("last_re"));
				db.setResponse(rs.getString("response"));
				db.setTopic(rs.getString("topic"));
				db_list.add(db);
			}
			conn.close();
			return db_list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}
	public void DeleteDB(doubanTbl douban) {
		MyConnection db  = new MyConnection();
		Connection conn  = (Connection) db.getConnection("app_webexceltest", "ow3kjm3l5m","133lxi3wk414hy32k05y4h0ixihzl4l5xy5yxml2");
		String sql = "delete from table5 where topic=?";
		
			PreparedStatement pstmt;
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,douban.getTopic());
				pstmt.executeUpdate();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
	}

}
