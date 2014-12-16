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
import com.bean.taobaoTbl;
import com.jdbc.MyConnection;
import com.jdbc.MyOperation;

public class taobaoGet {
    public void get(File[] html) {
        Document doc;
        try {
            // 数据库初始化
            MyConnection util1 = new MyConnection();
            Connection conn = util1.getConnection();
            String clean_sql = "drop table if exists table2";
            Statement stmt = conn.createStatement();
            stmt.execute(clean_sql);
            stmt.execute("create table table2(" +"Multi varchar(50),"+ "numItem varchar(50),"
                    + "shops varchar(100)," + "baobeiNames varchar(100),"
                    + "Specs varchar(100)," + "prices varchar(10),"
                    + "qutys varchar(10));");

            for (int k = 0; k < html.length; k++) {
                doc = Jsoup.parse(html[k], "GBK");
                
                
                taobaoTbl T = new taobaoTbl();
                MyOperation util = new MyOperation();
                String database = "app_webexceltest";
                String user = "ow3kjm3l5m";
                String password = "133lxi3wk414hy32k05y4h0ixihzl4l5xy5yxml2";
                String tblName = "table2";
                
                
                Elements tbody = doc.select("tbody");
                for(int i=0;i<tbody.size();i++){
                	Elements numItem = tbody.get(i).select("span[class=number last-item]");// 订单号
                    Elements shops = tbody.get(i).select("a[class=shopname J_MakePoint]");// 店铺名
                    Elements baobeiNames = tbody.get(i).select("p[class=baobei-name]");// 宝贝名称
                    Elements Specs = tbody.get(i).select("div[class=spec]");// 货物信息
                    Elements prices = tbody.get(i).select("em[class=real-price special-num");// 价格信息
                    Elements qutys = tbody.get(i).select("td[class=quantity][title]");// 购买数量
                    
                    T.setMulti(String.valueOf(baobeiNames.size()));
                    T.setNumItem(numItem.get(0).text());
                    T.setShops(shops.get(0).text());
                    T.setBaobeiNames(baobeiNames.get(0).text());
                    T.setSpecs(Specs.get(0).text());
                    T.setPrices(prices.get(0).text());
                    T.setQutys(qutys.get(0).text());
                    
                    util.addbaobei(T, database, user, password, tblName);
                    if(baobeiNames.size()!=1){
                    	for(int j=1;j<baobeiNames.size();j++){
                            T.setMulti("");
                            T.setNumItem(numItem.get(0).text());
                            T.setShops(shops.get(0).text());
                            T.setBaobeiNames(baobeiNames.get(j).text());
                            T.setSpecs(Specs.get(j).text());
                            T.setPrices(" ");
                            T.setQutys(qutys.get(j).text());
                            
                            util.addbaobei(T, database, user, password, tblName);
                    	}
                    }
                }
             
            }
            new ActionTable2().show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
