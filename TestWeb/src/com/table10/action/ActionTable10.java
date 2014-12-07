
package com.table10.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bean.btTbl;

import org.apache.struts2.ServletActionContext;

import com.bean.btTbl;
import com.jdbc.MyConnection;
import com.opensymphony.xwork2.ActionSupport;

public class ActionTable10 extends ActionSupport{
    private String index10;
    private String tipAdd10;
    private String newTitle;
    private String newDay;
    private String newActor;
    private String newType;
    private String newScan_num;
    private String tipUpdate10;
    
    

    public String getNewTitle() {
        return newTitle;
    }

    public void setNewTitle(String newTitle) {
        this.newTitle = newTitle;
    }

    public String getNewDay() {
        return newDay;
    }

    public void setNewDay(String newDay) {
        this.newDay = newDay;
    }

    public String getNewActor() {
        return newActor;
    }

    public void setNewActor(String newActor) {
        this.newActor = newActor;
    }

    public String getNewType() {
        return newType;
    }

    public void setNewType(String newType) {
        this.newType = newType;
    }

    public String getNewScan_num() {
        return newScan_num;
    }

    public void setNewScan_num(String newScan_num) {
        this.newScan_num = newScan_num;
    }

    public String getIndex10() {
        return index10;
    }

    public void setIndex10(String index10) {
        this.index10 = index10;
    }

    public String getTipAdd10() {
        return tipAdd10;
    }

    public void setTipAdd10(String tipAdd10) {
        this.tipAdd10 = tipAdd10;
    }


    public String getTipUpdate10() {
        return tipUpdate10;
    }

    public void setTipUpdate10(String tipUpdate10) {
        this.tipUpdate10 = tipUpdate10;
    }

    public String getindex10() {
        return index10;
    }

    public void setindex10(String index10) {
        this.index10 = index10;
    }

    public String gettipAdd10() {
        return tipAdd10;
    }

    public void settipAdd10(String tipAdd10) {
        this.tipAdd10 = tipAdd10;
    }

    public String getnewTitle() {
        return newTitle;
    }

    public void setnewTitle(String newTitle) {
        this.newTitle = newTitle;
    }

    public String getnewDay() {
        return newDay;
    }

    public void setnewDay(String newDay) {
        this.newDay = newDay;
    }


    public String gettipUpdate10() {
        return tipUpdate10;
    }

    public void settipUpdate10(String tipUpdate10) {
        this.tipUpdate10 = tipUpdate10;
    }

    // 查询
    public String show() throws SQLException {
        MyConnection mc = new MyConnection();
        Connection conn = mc.getConnection("app_webexceltest", "ow3kjm3l5m", "133lxi3wk414hy32k05y4h0ixihzl4l5xy5yxml2");
        List<btTbl> list10 = new ArrayList<btTbl>();

        String sql = "select * from  table10";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            btTbl btbl = new btTbl();
            btbl.setTitle(rs.getString("title"));
            btbl.setDay(rs.getString("day"));
            btbl.setActor(rs.getString("actor"));
            btbl.setType(rs.getString("type"));
            btbl.setScan_num(rs.getString("scan_num"));
            list10.add(btbl);
        }
        mc.close(conn);
        ServletActionContext.getRequest().getSession()
                .setAttribute("List", list10);
        ServletActionContext.getRequest().setAttribute("list10", list10);

        if (list10.isEmpty())
            return "failure";
        else
            return "success";
    }

    //删除
    public String delete() {
        List<btTbl> list10 = (List<btTbl>) ServletActionContext
                .getRequest().getSession().getAttribute("List");
        int num = Integer.parseInt(index10);
        btTbl pr = list10.get(num);
        _delete(pr);
        list10.remove(num);
        ServletActionContext.getRequest().getSession()
                .setAttribute("List", list10);
        ServletActionContext.getRequest().setAttribute("list10", list10);
        return SUCCESS;
    }

    public void _delete(btTbl pr) {
        MyConnection mc = new MyConnection();
        Connection conn = mc.getConnection("app_webexceltest", "ow3kjm3l5m", "133lxi3wk414hy32k05y4h0ixihzl4l5xy5yxml2");
        String sql = "delete from table10 where title=?";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, pr.getTitle());
            pstmt.executeUpdate();
            mc.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String add() {
        tipAdd10 = "";
        if (newTitle.equals("") || newDay.equals("")||
                newActor.equals("")||newType.equals("")||
                newScan_num.equals("")
               ) {
            tipAdd10 = "您输入的信息不完整，请重试！";
            return "failure";
        }
        MyConnection mc = new MyConnection();
        Connection conn = mc.getConnection("app_webexceltest", "ow3kjm3l5m", "133lxi3wk414hy32k05y4h0ixihzl4l5xy5yxml2");
        try {
            String sql = "insert into table10 values(?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newTitle);
            pstmt.setString(2, newDay);
            pstmt.setString(3, newActor);
            pstmt.setString(4, newType);
            pstmt.setString(5, newScan_num);
            pstmt.executeUpdate();
            mc.close(conn);
            tipAdd10 = "添加成功！";
            return SUCCESS;
        } catch (SQLException e) {
            e.printStackTrace();
            tipAdd10 = "添加失败，请重试！";
            return "failure";
        }
    }  
    
}
