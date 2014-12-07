package com.TaoBaoOpera;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.taobaoTbl;
import com.jdbc.MyConnection;
import com.mysql.jdbc.Connection;

public class OperaTaoBao {
	public List<taobaoTbl> showTbl(){
		MyConnection util = new MyConnection();
		Connection conn = (Connection) util.getConnection("app_webexceltest", "ow3kjm3l5m","133lxi3wk414hy32k05y4h0ixihzl4l5xy5yxml2");
		String sql = "select *from table2";
		try {
			PreparedStatement pstmt1 = conn.prepareStatement(sql);
			ResultSet rs = pstmt1.executeQuery();
			List<taobaoTbl> taobao_list = new ArrayList<taobaoTbl>();
			while(rs.next()){
				taobaoTbl tb = new taobaoTbl();
				tb.setBaobeiNames(rs.getString("baobeiNames"));
				tb.setNumItem(rs.getString("numItem"));
				tb.setPrices(rs.getString("prices"));
				tb.setQutys(rs.getString("qutys"));
				tb.setShops(rs.getString("shops"));
				tb.setSpecs(rs.getString("Specs"));
				taobao_list.add(tb);
			}
			conn.close();
			return taobao_list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}
	public void DeleteTB(taobaoTbl tb) {
		MyConnection db  = new MyConnection();
		Connection conn  = (Connection) db.getConnection("app_webexceltest", "ow3kjm3l5m","133lxi3wk414hy32k05y4h0ixihzl4l5xy5yxml2");
		String sql = "delete from table2 where baobeiNames=?";
		
			PreparedStatement pstmt;
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,tb.getBaobeiNames());
				pstmt.executeUpdate();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
	}

}
