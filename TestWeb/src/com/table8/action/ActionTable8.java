
package com.table8.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bean.gaokaoTbl;

import org.apache.struts2.ServletActionContext;

import com.bean.gaokaoTbl;
import com.jdbc.MyConnection;
import com.opensymphony.xwork2.ActionSupport;

public class ActionTable8 extends ActionSupport{
    private String index8;
    private String tipAdd8;
    private String newGrade;
    private String newStuNum;
    private String tipUpdate8;
    
    public String getNewGrade() {
        return newGrade;
    }

    public void setNewGrade(String newGrade) {
        this.newGrade = newGrade;
    }

    public String getNewStuNum() {
        return newStuNum;
    }

    public void setNewStuNum(String newStuNum) {
        this.newStuNum = newStuNum;
    }

    public String getIndex8() {
        return index8;
    }

    public void setIndex8(String index8) {
        this.index8 = index8;
    }

    public String getTipAdd8() {
        return tipAdd8;
    }

    public void setTipAdd8(String tipAdd8) {
        this.tipAdd8 = tipAdd8;
    }


    public String getTipUpdate8() {
        return tipUpdate8;
    }

    public void setTipUpdate8(String tipUpdate8) {
        this.tipUpdate8 = tipUpdate8;
    }

    public String getindex8() {
        return index8;
    }

    public void setindex8(String index8) {
        this.index8 = index8;
    }

    public String gettipAdd8() {
        return tipAdd8;
    }

    public void settipAdd8(String tipAdd8) {
        this.tipAdd8 = tipAdd8;
    }

    public String getnewGrade() {
        return newGrade;
    }

    public void setnewGrade(String newGrade) {
        this.newGrade = newGrade;
    }

    public String getnewStuNum() {
        return newStuNum;
    }

    public void setnewStuNum(String newStuNum) {
        this.newStuNum = newStuNum;
    }


    public String gettipUpdate8() {
        return tipUpdate8;
    }

    public void settipUpdate8(String tipUpdate8) {
        this.tipUpdate8 = tipUpdate8;
    }

    // 查询
    public String show() throws SQLException {
        MyConnection mc = new MyConnection();
        Connection conn = mc.getConnection("app_webexceltest", "ow3kjm3l5m", "133lxi3wk414hy32k05y4h0ixihzl4l5xy5yxml2");
        List<gaokaoTbl> list8 = new ArrayList<gaokaoTbl>();

        String sql = "select * from  table8";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            gaokaoTbl gdtl = new gaokaoTbl();
            gdtl.setGrade(rs.getString("grade"));
            gdtl.setStuNum(rs.getString("stuNum"));
            list8.add(gdtl);
        }
        mc.close(conn);
        ServletActionContext.getRequest().getSession()
                .setAttribute("List", list8);
        ServletActionContext.getRequest().setAttribute("list8", list8);

        if (list8.isEmpty())
            return "failure";
        else
            return "success";
    }

    //删除
    public String delete() {
        List<gaokaoTbl> list8 = (List<gaokaoTbl>) ServletActionContext
                .getRequest().getSession().getAttribute("List");
        int num = Integer.parseInt(index8);
        gaokaoTbl pr = list8.get(num);
        _delete(pr);
        list8.remove(num);
        ServletActionContext.getRequest().getSession()
                .setAttribute("List", list8);
        ServletActionContext.getRequest().setAttribute("list8", list8);
        return SUCCESS;
    }

    public void _delete(gaokaoTbl pr) {
        MyConnection mc = new MyConnection();
        Connection conn = mc.getConnection("app_webexceltest", "ow3kjm3l5m", "133lxi3wk414hy32k05y4h0ixihzl4l5xy5yxml2");
        String sql = "delete from table8 where stuNum=?";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, pr.getStuNum());
            pstmt.executeUpdate();
            mc.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String add() {
        tipAdd8 = "";
        if (newGrade.equals("") || newStuNum.equals("")
               ) {
            tipAdd8 = "您输入的信息不完整，请重试！";
            return "failure";
        }
        MyConnection mc = new MyConnection();
        Connection conn = mc.getConnection("app_webexceltest", "ow3kjm3l5m", "133lxi3wk414hy32k05y4h0ixihzl4l5xy5yxml2");
        try {
            String sql = "insert into table8 values(?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newGrade);
            pstmt.setString(2, newStuNum);
            pstmt.executeUpdate();
            mc.close(conn);
            tipAdd8 = "添加成功！";
            return SUCCESS;
        } catch (SQLException e) {
            e.printStackTrace();
            tipAdd8 = "添加失败，请重试！";
            return "failure";
        }
    }  
    
}
