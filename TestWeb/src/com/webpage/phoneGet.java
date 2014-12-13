package com.webpage;

import java.io.File;
import java.io.IOException;
import com.table.action.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.bean.phoneRecordTbl;
import com.jdbc.MyOperation;

public class phoneGet {
	public void get(File html) {
		MyOperation util = new MyOperation();
        String database = "app_webexceltest";
        String user = "ow3kjm3l5m";
        
        String password = "133lxi3wk414hy32k05y4h0ixihzl4l5xy5yxml2";
		String tblName = "table4";
		
		phoneRecordTbl T = new phoneRecordTbl();
		Document doc;
		String str[] = new String[9];
		 boolean isFirst = true;
	        try {
	            doc = Jsoup.parse(html, "GBK");
	            Element tbl = doc.select("table").get(6);
	            Elements trs = tbl.select("tr");
	            for (int i = 0; i < trs.size(); i++) {
	                Element tr = trs.get(i);
	                Elements tds = tr.select("td");
	                for (int j = 0; j < tds.size(); j++) {
	                    Element td = tds.get(j);
	                    str[j] = td.text();
	                }
	                T.setNum(str[0]);
	                T.setFrom_phone(str[1]);
	                T.setCity_code(str[2]);
	                T.setTo_phone(str[3]);
	               //T.setSt_time(str[4]);
	                T.setTime_length(str[5]);
	                T.setPrice(str[6]);
	                T.setWay(str[7]);
	                T.setExtend_price(str[8]);
	                if (isFirst) {
	                    util.addphoneRecord(T, database, user, password, tblName,
	                            true);
	                    isFirst = false;
	                } else {
	                    util.addphoneRecord(T, database, user, password, tblName,
	                            false);
	                }
	                
	             new ActionTable4().show(); 
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		
	}
}
