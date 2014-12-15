package com.webpage;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.bean.doubanTbl;
import com.table.action.*;
import com.jdbc.MyConnection;
import com.jdbc.MyOperation;

public class doubanGet {
    public void get(File[] html) {
    	String tblName = "table5";
        MyOperation util = new MyOperation();
        MyConnection util1 = new MyConnection();
        Connection conn = util1.getConnection();
        String clean_sql = "drop table if exists table5";
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(clean_sql);
            stmt.execute("create table table5(" + "topic varchar(100),"
                    + "author varchar(20)," + "response varchar(20),"
                    + "last_re varchar(20));");
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        doubanTbl T = new doubanTbl();
        Document doc;
        String str[] = new String[4];
        try {
            for (int k = 0; k < html.length; k++) {
                doc = Jsoup.parse(html[k], "utf-8");
                Element tbl = doc.select("table").get(2);
                Elements trs = tbl.select("tr");
                for (int i = 0; i < trs.size(); i++) {
                    Element tr = trs.get(i);
                    Elements tds = tr.select("td");
                    for (int j = 0; j < tds.size(); j++) {
                        Element td = tds.get(j);
                        str[j] = td.text();
                    }
                    T.setTopic(str[0]);
                    T.setAuthor(str[1]);
                    T.setResponse(str[2]);
                    T.setLast_re(str[3]);
                    util.adddouban(T,tblName);
                }
            }
            new ActionTable5().show();

        } catch (Exception e) {
            try {
                new ActionTable5().show();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            e.printStackTrace();
        }

    }
}
