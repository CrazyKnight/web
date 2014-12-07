package com.MusicOpera;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.singTbl;
import com.jdbc.MyConnection;
import com.mysql.jdbc.Connection;

public class OperaMusic {
	public List<singTbl> showTbl(){
		MyConnection util = new MyConnection();
		Connection conn = (Connection) util.getConnection("app_webexceltest", "ow3kjm3l5m","133lxi3wk414hy32k05y4h0ixihzl4l5xy5yxml2");
		String sql = "select *from table7";
		try {
			PreparedStatement pstmt1 = conn.prepareStatement(sql);
			ResultSet rs = pstmt1.executeQuery();
			List<singTbl> list = new ArrayList<singTbl>();
			while(rs.next()){
				singTbl tb = new singTbl();
				tb.setAlbum(rs.getString("album"));
				tb.setCompany(rs.getString("company"));
				tb.setCur_week(rs.getString("cur_week"));
				tb.setLast_week(rs.getString("last_week"));
				tb.setNum_week(rs.getString("num_week"));
				tb.setSinger(rs.getString("singer"));
				tb.setSong(rs.getString("song"));
				tb.setTop_his(rs.getString("top_his"));
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
	public void DeleteMusic(singTbl tb) {
		MyConnection db  = new MyConnection();
		Connection conn  = (Connection) db.getConnection("app_webexceltest", "ow3kjm3l5m","133lxi3wk414hy32k05y4h0ixihzl4l5xy5yxml2");
		String sql = "delete from table7 where song=?";
		
			PreparedStatement pstmt;
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,tb.getSong());
				pstmt.executeUpdate();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
	}

}
