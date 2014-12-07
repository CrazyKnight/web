package com.table1.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.bean.gradeTbl;
import com.jdbc.MyConnection;
import com.opensymphony.xwork2.ActionSupport;

public class ActionTable1 extends ActionSupport {
    private String index1;
    private String tipAdd;
    private String newterm;
    private String newlessonNum;
    private String newlessonName;
    private String newtecherName;
    private String newkind;
    private String newgrade;
    private String newtime;
    private String newmyPoint;
    private String newgradeKind;
    private String newremark;
    private String tipUpdate;

    public String getIndex1() {
        return index1;
    }

    public void setIndex1(String index1) {
        this.index1 = index1;
    }

    public String getTipAdd() {
        return tipAdd;
    }

    public void setTipAdd(String tipAdd) {
        this.tipAdd = tipAdd;
    }

    public String getTipUpdate() {
        return tipUpdate;
    }

    public void setTipUpdate(String tipUpdate) {
        this.tipUpdate = tipUpdate;
    }

    public String getNewterm() {
        return newterm;
    }

    public void setNewterm(String newterm) {
        this.newterm = newterm;
    }

    public String getNewlessonNum() {
        return newlessonNum;
    }

    public void setNewlessonNum(String newlessonNum) {
        this.newlessonNum = newlessonNum;
    }

    public String getNewlessonName() {
        return newlessonName;
    }

    public void setNewlessonName(String newlessonName) {
        this.newlessonName = newlessonName;
    }

    public String getNewtecherName() {
        return newtecherName;
    }

    public void setNewtecherName(String newtecherName) {
        this.newtecherName = newtecherName;
    }

    public String getNewkind() {
        return newkind;
    }

    public void setNewkind(String newkind) {
        this.newkind = newkind;
    }

    public String getNewgrade() {
        return newgrade;
    }

    public void setNewgrade(String newgrade) {
        this.newgrade = newgrade;
    }

    public String getNewtime() {
        return newtime;
    }

    public void setNewtime(String newtime) {
        this.newtime = newtime;
    }

    public String getNewmyPoint() {
        return newmyPoint;
    }

    public void setNewmyPoint(String newmyPoint) {
        this.newmyPoint = newmyPoint;
    }

    public String getNewgradeKind() {
        return newgradeKind;
    }

    public void setNewgradeKind(String newgradeKind) {
        this.newgradeKind = newgradeKind;
    }

    public String getNewremark() {
        return newremark;
    }

    public void setNewremark(String newremark) {
        this.newremark = newremark;
    }
    // 查询
    public String show() throws SQLException {
        MyConnection mc = new MyConnection();
        Connection conn = mc.getConnection("app_webexceltest", "ow3kjm3l5m", "133lxi3wk414hy32k05y4h0ixihzl4l5xy5yxml2");
        List<gradeTbl> list1 = new ArrayList<gradeTbl>();

        String sql = "select * from  table1";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            gradeTbl gtbl = new gradeTbl();
            gtbl.setGrade(rs.getString("grade"));
            gtbl.setGradeKind(rs.getString("gradeKind"));
            gtbl.setKind(rs.getString("kind"));
            gtbl.setLessonName(rs.getString("lessonName"));
            gtbl.setLessonNum(rs.getString("lessonNum"));
            gtbl.setMyPoint(rs.getString("myPoint"));
            gtbl.setRemark(rs.getString("remark"));
            gtbl.setTecherName(rs.getString("techerName"));
            gtbl.setTerm(rs.getString("term"));
            gtbl.setTime(rs.getString("time"));
            list1.add(gtbl);
        }
        mc.close(conn);
        ServletActionContext.getRequest().getSession()
                .setAttribute("List", list1);
        ServletActionContext.getRequest().setAttribute("list1", list1);

        if (list1.isEmpty())
            return "failure";
        else
            return "success";
    }

    //鍒犻櫎
    public String delete() {
        List<gradeTbl> list1 = (List<gradeTbl>) ServletActionContext
                .getRequest().getSession().getAttribute("List");
        int num = Integer.parseInt(index1);
        gradeTbl ba = list1.get(num);
        _delete(ba);
        list1.remove(num);
        ServletActionContext.getRequest().getSession()
                .setAttribute("List", list1);
        ServletActionContext.getRequest().setAttribute("list1", list1);
        return SUCCESS;
    }

    public void _delete(gradeTbl ba) {
        MyConnection mc = new MyConnection();
        Connection conn = mc.getConnection("app_webexceltest", "ow3kjm3l5m", "133lxi3wk414hy32k05y4h0ixihzl4l5xy5yxml2");
        String sql = "delete from table1 where lessonNum=?";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, ba.getLessonNum());
            pstmt.executeUpdate();
            mc.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String add() {
        tipAdd = "";
        if (hasGrade(newlessonNum)) {

            tipAdd = "您要添加的信息已存在！";
            return "input";
        }
        if (newterm.equals("") || newlessonNum.equals("")
                || newlessonName.equals("") || newtecherName.equals("")
                || newkind.equals("") || newgrade.equals("")
                || newtime.equals("") || newmyPoint.equals("")) {
            tipAdd = "您输入的信息不完整，请重试！";
            return "failure";
        }
        MyConnection mc = new MyConnection();
        Connection conn = mc.getConnection("app_webexceltest", "ow3kjm3l5m", "133lxi3wk414hy32k05y4h0ixihzl4l5xy5yxml2");
        try {
            String sql = "insert into table1 values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newterm);
            pstmt.setString(2, newlessonNum);
            pstmt.setString(3, newlessonName);
            pstmt.setString(4, newtecherName);
            pstmt.setString(5, newkind);
            pstmt.setString(6, newgrade);
            pstmt.setString(7, newtime);
            pstmt.setString(8, newmyPoint);
            pstmt.setString(9, "" + newgradeKind);
            pstmt.setString(10, "" + newremark);
            pstmt.executeUpdate();
            mc.close(conn);
            tipAdd = "添加成功";
            return SUCCESS;
        } catch (SQLException e) {
            e.printStackTrace();
            tipAdd = "添加失败，请重试!";
            return "failure";
        }
    }

    private boolean hasGrade(String lessonNum) {
        MyConnection mc = new MyConnection();
        Connection conn = mc.getConnection("app_webexceltest", "ow3kjm3l5m", "133lxi3wk414hy32k05y4h0ixihzl4l5xy5yxml2");
        String sql = "select * from table1 where lessonNum=" + "\"" + lessonNum
                + "\"";

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                mc.close(conn);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        mc.close(conn);
        return false;
    }

    public String update() {
        if(!hasGrade(newlessonNum)) {
            this.setTipUpdate("您要更新的数据不存在！");
            return "failure";
        }
        MyConnection mc = new MyConnection();
        Connection conn = mc.getConnection("app_webexceltest", "ow3kjm3l5m", "133lxi3wk414hy32k05y4h0ixihzl4l5xy5yxml2");
        try {
            String sql = "update table1 set term=?,lessonName=?,techerName=?,kind=?,grade=?,time=?,myPoint=?,gradeKind=?,remark=? where lessonNum=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, ""+newterm);
            pstmt.setString(2, ""+newlessonName);
            pstmt.setString(3, ""+newtecherName);
            pstmt.setString(4, ""+newkind);
            pstmt.setString(5, ""+newgrade);
            pstmt.setString(6, ""+newtime);
            pstmt.setString(7, ""+newmyPoint);
            pstmt.setString(8, "" + newgradeKind);
            pstmt.setString(9, "" + newremark);
            pstmt.setString(10, newlessonNum);
            pstmt.executeUpdate();
            mc.close(conn);
            tipUpdate = "更新成功!";
            return SUCCESS;
        } catch (SQLException e) {
            e.printStackTrace();
            tipUpdate = "更新失败，请重试！";
            return "failure";
        }
        
    }
}
