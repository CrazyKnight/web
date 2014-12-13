package com.table.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DatabaseMetaData;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.bean.gradeTbl;
import com.jdbc.MyConnection;
import com.opensymphony.xwork2.ActionSupport;

public class ActionTable1 extends ActionSupport {
    private String index1;
    private String _index1;

    public String getIndex1() {
        return index1;
    }

    public void setIndex1(String index1) {
        this.index1 = index1;
    }

    public String get_index1() {
        return _index1;
    }

    public void set_index1(String _index1) {
        this._index1 = _index1;
    }

    // 查询
    public String show() throws SQLException {

        MyConnection mc = new MyConnection();
        Connection conn = mc.getConnection();
        try {
            // 获取表结构
            List<String> _list1 = new ArrayList<String>();
            DatabaseMetaData myMetaData = conn.getMetaData();
            ResultSet _rs = myMetaData.getColumns(null, "%", "table1", "%");
            while (_rs.next()) {
                String field = _rs.getString("COLUMN_NAME");
                _list1.add(field);
            }

            List<gradeTbl> list1 = new ArrayList<gradeTbl>();
            String sql = "select * from  table1";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                gradeTbl gtbl = new gradeTbl();
                for (int i = 0; i < _list1.size(); i++) {
                    gtbl.set(_list1.get(i), rs.getString(_list1.get(i)));
                }
                list1.add(gtbl);
            }
            mc.close(conn);

            ServletActionContext.getRequest().getSession()
                    .setAttribute("_List", _list1);
            ServletActionContext.getRequest().setAttribute("_list1", _list1);

            ServletActionContext.getRequest().getSession()
                    .setAttribute("List", list1);
            ServletActionContext.getRequest().setAttribute("list1", list1);

            if (list1.isEmpty())
                return "failure";
            else
                return "success";
        } catch (Exception e) {
            return "failure";
        }
    }

    // 删除行
    public String delete() {
        List<gradeTbl> list1 = (List<gradeTbl>) ServletActionContext
                .getRequest().getSession().getAttribute("List");
        int num = Integer.parseInt(index1);
        gradeTbl ba = list1.get(num);
        _delete(ba);

        try {
            show();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return SUCCESS;
    }

    private void _delete(gradeTbl ba) {
        MyConnection mc = new MyConnection();
        Connection conn = mc.getConnection("webtblget", "root", "123456");
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

    // 删除列
    public String delete0() {
        List<String> _list1 = (List<String>) ServletActionContext.getRequest()
                .getSession().getAttribute("_List");
        int _num = Integer.parseInt(_index1);
        String s = _list1.get(_num);
        if (!s.equals("lessonNum"))
            _delete0(s);
        try {
            show();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    private void _delete0(String s) {
        MyConnection mc = new MyConnection();
        Connection conn = mc.getConnection("webtblget", "root", "123456");
        String sql = "alter table table1 drop column " + s;
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            mc.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}