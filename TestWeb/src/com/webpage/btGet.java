package com.webpage;

import java.io.File;
import java.io.IOException;
import com.table10.action.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.bean.btTbl;
import com.bean.movieTbl;
import com.jdbc.MyOperation;

public class btGet {
	public void get(File html){
		MyOperation util = new MyOperation();
        String database = "app_webexceltest";
        String user = "ow3kjm3l5m";
        
        String password = "133lxi3wk414hy32k05y4h0ixihzl4l5xy5yxml2";
        String tblName = "table10";
        String str[] = new String[5];
        btTbl T = new btTbl();
        try {
            Document doc = Jsoup.parse(html,"gb2312");
            Elements titles = doc.select("a[class=title]");
            Elements infos = doc.select("span[class=add]");
            boolean isFirst=true;
            for(int i=0;i<titles.size();i++){
                Element title = titles.get(i);
                Element info = infos.get(i);
                Elements bigs = info.select("big");
                T.setTitle(title.text());
                for(int j=0;j<bigs.size();j++)
                    str[j+1] = bigs.get(j).text();
                T.setDay(str[1]);
                T.setActor(str[2]);
                T.setType(str[3]);
                T.setScan_num(str[4]);
                if(isFirst) {
                util.addBT(T, database, user, password, tblName,true);
                isFirst=false;}
                else {
                    util.addBT(T, database, user, password, tblName,false);
                }
            }
            new ActionTable10().show();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
