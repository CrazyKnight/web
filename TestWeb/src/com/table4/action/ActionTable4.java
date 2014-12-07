
package com.table4.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bean.phoneRecordTbl;

import org.apache.struts2.ServletActionContext;

import com.bean.gradeTbl;
import com.jdbc.MyConnection;
import com.opensymphony.xwork2.ActionSupport;

public class ActionTable4 extends ActionSupport{
    private String index4;
    private String tipAdd4;
    private String newnum;
    private String newfrom_phone;
    private String newcity_code;
    private String newto_phone;
//    private String newst_time;
    private String newtime_length;
    private String newprice;
    private String newway;
    private String newextend_price;
    private String tipUpdate4;
    
    public String getIndex4() {
        return index4;
    }

    public void setIndex4(String index4) {
        this.index4 = index4;
    }

    public String getTipAdd4() {
        return tipAdd4;
    }

    public void setTipAdd4(String tipAdd4) {
        this.tipAdd4 = tipAdd4;
    }

    public String getNewnum() {
        return newnum;
    }

    public void setNewnum(String newnum) {
        this.newnum = newnum;
    }

    public String getNewfrom_phone() {
        return newfrom_phone;
    }

    public void setNewfrom_phone(String newfrom_phone) {
        this.newfrom_phone = newfrom_phone;
    }

    public String getNewcity_code() {
        return newcity_code;
    }

    public void setNewcity_code(String newcity_code) {
        this.newcity_code = newcity_code;
    }

    public String getNewto_phone() {
        return newto_phone;
    }

    public void setNewto_phone(String newto_phone) {
        this.newto_phone = newto_phone;
    }

//    public String getNewst_time() {
//        return newst_time;
//    }
//
//    public void setNewst_time(String newst_time) {
//        this.newst_time = newst_time;
//    }

    public String getNewtime_length() {
        return newtime_length;
    }

    public void setNewtime_length(String newtime_length) {
        this.newtime_length = newtime_length;
    }

    public String getNewprice() {
        return newprice;
    }

    public void setNewprice(String newprice) {
        this.newprice = newprice;
    }

    public String getNewway() {
        return newway;
    }

    public void setNewway(String newway) {
        this.newway = newway;
    }

    public String getNewextend_price() {
        return newextend_price;
    }

    public void setNewextend_price(String newextend_price) {
        this.newextend_price = newextend_price;
    }

    public String getTipUpdate4() {
        return tipUpdate4;
    }

    public void setTipUpdate4(String tipUpdate4) {
        this.tipUpdate4 = tipUpdate4;
    }

    // 查询
    public String show() throws SQLException {
        MyConnection mc = new MyConnection();
        Connection conn = mc.getConnection("app_webexceltest", "ow3kjm3l5m", "133lxi3wk414hy32k05y4h0ixihzl4l5xy5yxml2");
        List<phoneRecordTbl> list4 = new ArrayList<phoneRecordTbl>();

        String sql = "select * from  table4";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            phoneRecordTbl prtb = new phoneRecordTbl();
            prtb.setNum(rs.getString("num"));
            prtb.setFrom_phone(rs.getString("from_phone"));
            prtb.setCity_code(rs.getString("city_code"));
            prtb.setTo_phone(rs.getString("to_phone"));
            //prtb.setSt_time(rs.getString("st_time"));
            prtb.setTime_length(rs.getString("time_length"));
            prtb.setPrice(rs.getString("price"));
            prtb.setWay(rs.getString("way"));
            prtb.setExtend_price(rs.getString("extend_price"));
            list4.add(prtb);
        }
        mc.close(conn);
        ServletActionContext.getRequest().getSession()
                .setAttribute("List", list4);
        ServletActionContext.getRequest().setAttribute("list4", list4);

        if (list4.isEmpty())
            return "failure";
        else
            return "success";
    }

    //删除
    public String delete() {
        List<phoneRecordTbl> list4 = (List<phoneRecordTbl>) ServletActionContext
                .getRequest().getSession().getAttribute("List");
        int num = Integer.parseInt(index4);
        phoneRecordTbl pr = list4.get(num);
        _delete(pr);
        list4.remove(num);
        ServletActionContext.getRequest().getSession()
                .setAttribute("List", list4);
        ServletActionContext.getRequest().setAttribute("list4", list4);
        return SUCCESS;
    }

    public void _delete(phoneRecordTbl pr) {
        MyConnection mc = new MyConnection();
        Connection conn = mc.getConnection("app_webexceltest", "ow3kjm3l5m", "133lxi3wk414hy32k05y4h0ixihzl4l5xy5yxml2");
        String sql = "delete from table4 where num=?";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, pr.getNum());
            pstmt.executeUpdate();
            mc.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String add() {
        tipAdd4 = "";
        if (newnum.equals("") || newfrom_phone.equals("")
                || newcity_code.equals("") || newto_phone.equals("")
                || newtime_length.equals("")
                || newprice.equals("") || newway.equals("")||newextend_price.equals("")) {
            tipAdd4 = "您输入的信息不完整，请重试！";
            return "failure";
        }
        MyConnection mc = new MyConnection();
        Connection conn = mc.getConnection("app_webexceltest", "ow3kjm3l5m", "133lxi3wk414hy32k05y4h0ixihzl4l5xy5yxml2");
        try {
            String sql = "insert into table4 values(?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newnum);
            pstmt.setString(2, newfrom_phone);
            pstmt.setString(3, newcity_code);
            pstmt.setString(4, newto_phone);
            //pstmt.setString(5, newst_time);
            pstmt.setString(5, newtime_length);
            pstmt.setString(6, newprice);
            pstmt.setString(7, newway);
            pstmt.setString(8, newextend_price);
            pstmt.executeUpdate();
            mc.close(conn);
            tipAdd4 = "添加成功！";
            return SUCCESS;
        } catch (SQLException e) {
            e.printStackTrace();
            tipAdd4 = "添加失败，请重试！";
            return "failure";
        }
    }  
    
}
