package com.webpage;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.MusicOpera.ShowMusic;
import com.bean.singTbl;
import com.jdbc.MyConnection;
import com.jdbc.MyOperation;

public class singGet {
	public void get(File html){
		MyOperation util = new MyOperation();
        String database = "app_webexceltest";
        String user = "ow3kjm3l5m";
        
        String password = "133lxi3wk414hy32k05y4h0ixihzl4l5xy5yxml2";
        String tblName = "table7";
        
        MyConnection util1 = new MyConnection();
		Connection conn = util1.getConnection(database, user, password);
		String clean_sql = "delete from table7";
		PreparedStatement pstmt1;
		try {
			pstmt1 = conn.prepareStatement(clean_sql);
			pstmt1.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
        
        singTbl T = new singTbl();
        String str[] = new String[8];
        Document doc;
		try {
			doc = Jsoup.parse(html,"GBK");
			Element tbl = doc.select("table").get(8);
			Elements trs = tbl.select("tr");
			boolean flag = false;
			for(int i=0;i<trs.size();i++){
				Element tr = trs.get(i);
				Elements tds = tr.select("td");
				for(int j=0;j<tds.size();j++){
					Element td = tds.get(j);
					str[j] = td.text();
				}
				T.setCur_week(str[0]);
				T.setLast_week(str[1]);
				T.setNum_week(str[2]);
				T.setAlbum(str[3]);
				T.setSong(str[4]);
				T.setSinger(str[5]);
				T.setCompany(str[6]);
				T.setTop_his(str[7]);
				util.addsong(T, database, user, password, tblName);
			}
			new ShowMusic().execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
