package com.webpage;

import java.io.File;
import java.io.IOException;
import com.table.action.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.bean.doubanTbl;
import com.bean.metalTbl;
import com.jdbc.MyOperation;

public class metalGet {
	public void get(File html){
		MyOperation util = new MyOperation();
        String database = "app_webexceltest";
        String user = "ow3kjm3l5m";
        
        String password = "133lxi3wk414hy32k05y4h0ixihzl4l5xy5yxml2";
        String tblName = "table6";
        
        metalTbl T = new metalTbl();
        Document doc;
        String str[] = new String[3];
        boolean isFirst=true;
        try {
            doc = Jsoup.parse(html,"utf-8");
            Element tbl = doc.select("table").get(0);
            Elements trs = tbl.select("tr");
            boolean flag = false;
            for(int i=0;i<trs.size();i++){
                Element tr = trs.get(i);
                Elements tds = tr.select("td");
                for(int j=0;j<tds.size();j++){
                    Element td = tds.get(j);
                    String cur = td.text();
                    if(cur.charAt(0)=='A')
                        flag=true;
                    if(flag)
                        str[j] = cur;
                }
                if(i<=1)
                    continue;
                T.setMetal(str[0]);
                T.setMelPoint_C(str[1]);
                T.setMelPoint_F(str[2]);
                if(isFirst) {
                util.addmetal(T, database, user, password, tblName,true);
                isFirst=false;}
                else {
                    util.addmetal(T, database, user, password, tblName,false);
                }
            }
        new ActionTable6().show();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}
}
