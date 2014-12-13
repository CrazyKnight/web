package com.webpage;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.table.action.*;
import com.bean.zfbTbl;
import com.jdbc.MyConnection;
import com.jdbc.MyOperation;

public class zfbGet {
	public void get(File html) {
		try {
			Document doc = Jsoup.parse(html, "GBK");
			Elements csmBNos = doc.select("div[class=consumeBizNo]");
			Elements times = doc.select("td[class=time]");
			Elements infos = doc.select("td[class=info");
			Elements incomes = doc.select("td[class=amount income]");
			Elements outlays = doc.select("td[class=amount outlay");
			Elements balances = doc.select("td[class=balance]");
			Elements froms = doc.select("td[class=from]");

			int out = 0;
			int in = 0;
			MyOperation util = new MyOperation();
			zfbTbl T = new zfbTbl();
	        String database = "app_webexceltest";
	        String user = "ow3kjm3l5m";
	        
	        String password = "133lxi3wk414hy32k05y4h0ixihzl4l5xy5yxml2";
			String tblName = "table3";
			
			 MyConnection util1 = new MyConnection();
			//Connection conn = util1.getConnection(database, user, password);
			Connection conn = util1.getConnection();
			String clean_sql = "drop table if exists table3";
	        try {
	            Statement stmt = conn.createStatement();
	            stmt.execute(clean_sql);
	            stmt.execute("create table table3("+ 
	                    "csmBNos varchar(50),"+
	                    "times varchar(50),"+
	                    "infos varchar(50),"+
	                    "incomes varchar(50),"+
	                    "outlays varchar(50),"+
	                    "balances varchar(50),"+
	                    "froms varchar(50));");
	        } catch (SQLException e1) {
	            // TODO Auto-generated catch block
	            e1.printStackTrace();
	        }
			
			for (int i = 0; i < csmBNos.size(); i++) {
				T.setCsmBNos(csmBNos.get(i).text());
				T.setTimes(times.get(i).text());
				T.setInfos(infos.get(i).text());
				if (froms.get(i).text().equals("Ö§¸¶±¦")) {
					T.setOutlays(outlays.get(out++).text());
					T.setIncomes("");
				} else {
					T.setOutlays("");
					T.setIncomes(incomes.get(in++).text());
				}
				T.setBalances(balances.get(i).text());
				T.setFroms(froms.get(i).text());
				util.addzfb(T, database, user, password, tblName);
			}
			new ActionTable3().show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
