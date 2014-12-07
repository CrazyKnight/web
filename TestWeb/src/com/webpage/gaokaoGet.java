package com.webpage;

import java.io.File;
import java.io.IOException;
import com.table8.action.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.bean.gaokaoTbl;
import com.bean.gradeTbl;
import com.jdbc.MyOperation;

public class gaokaoGet {
	public void get(File html){
		MyOperation util = new MyOperation();
        String database = "app_webexceltest";
        String user = "ow3kjm3l5m";
        
        String password = "133lxi3wk414hy32k05y4h0ixihzl4l5xy5yxml2";
        String tblName = "table8";
        
        gaokaoTbl T = new gaokaoTbl();
        String str[] = new String[2];
        boolean isFirst = true;
        try {
            Document doc = Jsoup.parse(html, "GB2312");
            Element tbl = doc.select("table").get(0);
            Elements trs = tbl.select("tr");
            boolean flag = false;
            for (int i = 0; i < trs.size(); i++) {
                Element tr = trs.get(i);
                Elements tds = tr.select("td");
                for (int j = 0; j < tds.size(); j++) {
                    Element td = tds.get(j);
                    str[j] = td.text();

                }
                T.setGrade(str[0]);
                T.setStuNum(str[1]);
                if (isFirst) {
                    util.addgaokao(T, database, user, password, tblName, true);
                    isFirst = false;
                } else {
                    util.addgaokao(T, database, user, password, tblName, false);
                }

            }
            new ActionTable8().show();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
