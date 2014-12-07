package com.webpage;

import java.io.File;
import java.io.IOException;
import com.table1.action.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.bean.gradeTbl;
import com.jdbc.MyOperation;

public class gradeGet {
	public void get(File html){
		MyOperation util = new MyOperation();
        String database = "app_webexceltest";
        String user = "ow3kjm3l5m";
        
        String password = "133lxi3wk414hy32k05y4h0ixihzl4l5xy5yxml2";
        //String database ="webtblget";
        //String user = "root";
        //String password = "123456";
		String tblName = "table1";
        
        gradeTbl L = new gradeTbl();
        Document doc;
        boolean isFirst = true;
        try {
            doc = Jsoup.parse(html, "GBK");
            Element tbl = doc.select("table").get(1);
            Elements trs = tbl.select("tr");
            String str[] = new String[10];
            for (int i = 0; i < trs.size(); i++) {
                Elements tds = trs.get(i).select("td");
                for (int j = 0; j < tds.size(); j++) {
                    Element td = tds.get(j);
                    str[j] = td.text();
                }
                if (str[0].charAt(0) == '2') {
                    L.setTerm(str[0]);
                    L.setLessonNum(str[1]);
                    String tag = str[2].substring(1);
                    L.setLessonName(tag);
                    L.setTecherName(str[3]);
                    L.setKind(str[4]);
                    L.setGrade(str[5]);
                    L.setTime(str[6]);
                    L.setMyPoint(str[7]);
                    L.setGradeKind(str[8]);
                    L.setRemark(str[9]);
                    if (isFirst) {
                        util.addgrade(L, database, user, password, tblName,
                                true);
                        isFirst = false;
                    } else
                        util.addgrade(L, database, user, password, tblName,
                                false);
                }
            }
            new ActionTable1().show();
        } catch (Exception e) {
            e.printStackTrace();
        } 
		
	}
}
