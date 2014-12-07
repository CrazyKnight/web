package com.zfbOpera;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.bean.zfbTbl;
import com.jdbc.MyConnection;
import com.mysql.jdbc.Connection;
public class OperaZfb {
		public List<zfbTbl> showTbl(){
			MyConnection util = new MyConnection();
			Connection conn = (Connection) util.getConnection("app_webexceltest", "ow3kjm3l5m","133lxi3wk414hy32k05y4h0ixihzl4l5xy5yxml2");
			String sql = "select *from table3";
			try {
				PreparedStatement pstmt1 = conn.prepareStatement(sql);
				ResultSet rs = pstmt1.executeQuery();
				List<zfbTbl> list = new ArrayList<zfbTbl>();
				while(rs.next()){
					zfbTbl zfb = new zfbTbl();
					zfb.setBalances(rs.getString("balances"));
					zfb.setCsmBNos(rs.getString("csmBNos"));
					zfb.setFroms(rs.getString("froms"));
					zfb.setIncomes(rs.getString("incomes"));
					zfb.setInfos(rs.getString("infos"));
					zfb.setOutlays(rs.getString("outlays"));
					zfb.setTimes(rs.getString("times"));
					
					list.add(zfb);
				}
				conn.close();
				return list;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
			
			
		}
		public void DeleteZfb(zfbTbl tb) {
			MyConnection db  = new MyConnection();
			Connection conn  = (Connection) db.getConnection("app_webexceltest", "ow3kjm3l5m","133lxi3wk414hy32k05y4h0ixihzl4l5xy5yxml2");
			String sql = "delete from table3 where csmBNos=?";
			
				PreparedStatement pstmt;
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,tb.getCsmBNos());
					pstmt.executeUpdate();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		
		}

	


}
