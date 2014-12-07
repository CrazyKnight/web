
package com.table6.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bean.metalTbl;

import org.apache.struts2.ServletActionContext;

import com.bean.gradeTbl;
import com.jdbc.MyConnection;
import com.opensymphony.xwork2.ActionSupport;

public class ActionTable6 extends ActionSupport{
    private String index6;
    private String tipAdd6;
    private String newMetal;
    private String newMelPoint_C;
    private String newMelPoint_F;
    private String tipUpdate6;
    
    public String getIndex6() {
        return index6;
    }

    public void setIndex6(String index6) {
        this.index6 = index6;
    }

    public String getTipAdd6() {
        return tipAdd6;
    }

    public void setTipAdd6(String tipAdd6) {
        this.tipAdd6 = tipAdd6;
    }

    public String getNewMetal() {
        return newMetal;
    }

    public void setNewMetal(String newMetal) {
        this.newMetal = newMetal;
    }

    public String getNewMelPoint_C() {
        return newMelPoint_C;
    }

    public void setNewMelPoint_C(String newMelPoint_C) {
        this.newMelPoint_C = newMelPoint_C;
    }

    public String getNewMelPoint_F() {
        return newMelPoint_F;
    }

    public void setNewMelPoint_F(String newMelPoint_F) {
        this.newMelPoint_F = newMelPoint_F;
    }

    public String getTipUpdate6() {
        return tipUpdate6;
    }

    public void setTipUpdate6(String tipUpdate6) {
        this.tipUpdate6 = tipUpdate6;
    }

    public String getindex6() {
        return index6;
    }

    public void setindex6(String index6) {
        this.index6 = index6;
    }

    public String gettipAdd6() {
        return tipAdd6;
    }

    public void settipAdd6(String tipAdd6) {
        this.tipAdd6 = tipAdd6;
    }

    public String getnewMetal() {
        return newMetal;
    }

    public void setnewMetal(String newMetal) {
        this.newMetal = newMetal;
    }

    public String getnewMelPoint_C() {
        return newMelPoint_C;
    }

    public void setnewMelPoint_C(String newMelPoint_C) {
        this.newMelPoint_C = newMelPoint_C;
    }

    public String getnewMelPoint_F() {
        return newMelPoint_F;
    }

    public void setnewMelPoint_F(String newMelPoint_F) {
        this.newMelPoint_F = newMelPoint_F;
    }


    public String gettipUpdate6() {
        return tipUpdate6;
    }

    public void settipUpdate6(String tipUpdate6) {
        this.tipUpdate6 = tipUpdate6;
    }

    // 查询
    public String show() throws SQLException {
        MyConnection mc = new MyConnection();
        Connection conn = mc.getConnection("app_webexceltest", "ow3kjm3l5m", "133lxi3wk414hy32k05y4h0ixihzl4l5xy5yxml2");
        List<metalTbl> list6 = new ArrayList<metalTbl>();

        String sql = "select * from  table6";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            metalTbl mtbl = new metalTbl();
            mtbl.setMetal(rs.getString("Metal"));
            mtbl.setMelPoint_C(rs.getString("MelPoint_C"));
            mtbl.setMelPoint_F(rs.getString("MelPoint_F"));
            list6.add(mtbl);
        }
        mc.close(conn);
        ServletActionContext.getRequest().getSession()
                .setAttribute("List", list6);
        ServletActionContext.getRequest().setAttribute("list6", list6);

        if (list6.isEmpty())
            return "failure";
        else
            return "success";
    }

    //删除
    public String delete() {
        List<metalTbl> list6 = (List<metalTbl>) ServletActionContext
                .getRequest().getSession().getAttribute("List");
        int num = Integer.parseInt(index6);
        metalTbl pr = list6.get(num);
        _delete(pr);
        list6.remove(num);
        ServletActionContext.getRequest().getSession()
                .setAttribute("List", list6);
        ServletActionContext.getRequest().setAttribute("list6", list6);
        return SUCCESS;
    }

    public void _delete(metalTbl pr) {
        MyConnection mc = new MyConnection();
        Connection conn = mc.getConnection("app_webexceltest", "ow3kjm3l5m", "133lxi3wk414hy32k05y4h0ixihzl4l5xy5yxml2");
        String sql = "delete from table6 where Metal=?";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, pr.getMetal());
            pstmt.executeUpdate();
            mc.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String add() {
        tipAdd6 = "";
        if (newMetal.equals("") || newMelPoint_C.equals("")
                || newMelPoint_F.equals("")) {
            tipAdd6 = "您输入的信息不完整，请重试！";
            return "failure";
        }
        MyConnection mc = new MyConnection();
        Connection conn = mc.getConnection("app_webexceltest", "ow3kjm3l5m", "133lxi3wk414hy32k05y4h0ixihzl4l5xy5yxml2");
        try {
            String sql = "insert into table6 values(?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newMetal);
            pstmt.setString(2, newMelPoint_C);
            pstmt.setString(3, newMelPoint_F);
            pstmt.executeUpdate();
            mc.close(conn);
            tipAdd6 = "添加成功！";
            return SUCCESS;
        } catch (SQLException e) {
            e.printStackTrace();
            tipAdd6 = "添加失败，请重试！";
            return "failure";
        }
    }  
    
}
