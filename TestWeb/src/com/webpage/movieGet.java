package com.webpage;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.table.action.*;
import com.bean.movieTbl;
import com.jdbc.MyConnection;
import com.jdbc.MyOperation;

public class movieGet {
    public void get(File[] html) {
        MyOperation util = new MyOperation();

        String tblName = "table9";
        String database = "app_webexceltest";
        String user = "ow3kjm3l5m";

        String password = "133lxi3wk414hy32k05y4h0ixihzl4l5xy5yxml2";

        MyConnection util1 = new MyConnection();
        // Connection conn = util1.getConnection(database, user, password);
        Connection conn = util1.getConnection();
        String clean_sql = "drop table if exists table9";
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(clean_sql);
            stmt.execute("create table table9(" + "name varchar(30),"
                    + "actor varchar(100)," + "place varchar(20),"
                    + "type varchar(100)," + "grade varchar(20));");
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        String str[] = new String[5];
        movieTbl T = new movieTbl();
        Document doc;
        try {
            for (int k = 0; k < html.length; k++) {
                doc = Jsoup.parse(html[k], "gb2312");
                Element tbl = doc.select("table").get(0);
                Elements trs = tbl.select("tr");
                for (int i = 0; i < trs.size(); i++) {
                    Element tr = trs.get(i);
                    Elements tds = tr.select("td");
                    for (int j = 0; j < tds.size(); j++) {
                        Element td = tds.get(j);
                        str[j] = td.text();
                    }
                    T.setName(str[0]);
                    T.setActor(str[1]);
                    T.setPlace(str[2]);
                    T.setType(str[3]);
                    T.setGrade(str[4]);
                    util.addmovie(T, database, user, password, tblName);
                }
            }
            new ActionTable9().show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
