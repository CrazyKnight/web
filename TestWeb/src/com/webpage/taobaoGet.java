package com.webpage;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.TaoBaoOpera.ShowTaoBao;
import com.bean.taobaoTbl;
import com.jdbc.MyConnection;
import com.jdbc.MyOperation;

public class taobaoGet {
	public void get(File html){
		Document doc;
		try {
			doc = Jsoup.parse(html, "GBK");
			Elements numItem = doc.select("span[class=number last-item]");//订单号
			Elements shops= doc.select("a[class=shopname J_MakePoint]");//店铺名
			Elements baobeiNames = doc.select("p[class=baobei-name]");//宝贝名称
			Elements Specs = doc.select("div[class=spec]");//货物信息
			Elements prices = doc.select("em[class=real-price special-num");//价格信息
			Elements qutys = doc.select("td[class=quantity][title]");//购买数量
			
			taobaoTbl T = new taobaoTbl();
			MyOperation util = new MyOperation();
	        String database = "app_webexceltest";
	        String user = "ow3kjm3l5m";
	        
	        String password = "133lxi3wk414hy32k05y4h0ixihzl4l5xy5yxml2";
	        String tblName = "table2";
	        
	        MyConnection util1 = new MyConnection();
			Connection conn = util1.getConnection(database, user, password);
			String clean_sql = "delete from table2";
			PreparedStatement pstmt1 = conn.prepareStatement(clean_sql);
			pstmt1.executeUpdate();
			for(int i=0;i<numItem.size();i++){
				T.setNumItem(numItem.get(i).text());
				T.setShops(shops.get(i).text());
				T.setBaobeiNames(baobeiNames.get(i).text());
				T.setSpecs(Specs.get(i).text());
				T.setPrices(prices.get(i).text());
				T.setQutys(qutys.get(i).text());
				util.addbaobei(T, database, user, password, tblName);
				
			}
			new ShowTaoBao().execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
