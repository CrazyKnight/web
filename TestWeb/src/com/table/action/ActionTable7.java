package com.table.action;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bean.singTbl;

import org.apache.struts2.ServletActionContext;

import com.jdbc.MyConnection;
import com.opensymphony.xwork2.ActionSupport;

public class ActionTable7 extends ActionSupport {
    private String index7;
    private String _index7;

    public String getIndex7() {
        return index7;
    }

    public void setIndex7(String index7) {
        this.index7 = index7;
    }

    public String get_index7() {
        return _index7;
    }

    public void set_index7(String _index7) {
        this._index7 = _index7;
    }

    // 查询
    public String show() throws SQLException {
        MyConnection mc = new MyConnection();
        Connection conn = mc.getConnection();
            // 获取表结构
            List<String> _list7 = new ArrayList<String>();
            DatabaseMetaData myMetaData = conn.getMetaData();
            ResultSet _rs = myMetaData.getColumns(null, "%", "table7", "%");
            while (_rs.next()) {
                String field = _rs.getString("COLUMN_NAME");
                _list7.add(field);
            }

            List<singTbl> list7 = new ArrayList<singTbl>();
            String sql = "select * from  table7";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                singTbl gtbl = new singTbl();
                for (int i = 0; i < _list7.size(); i++) {
                    gtbl.set(_list7.get(i), rs.getString(_list7.get(i)));
                }
                list7.add(gtbl);
            }
            mc.close(conn);

            ServletActionContext.getRequest().getSession()
                    .setAttribute("_List7", _list7);
            ServletActionContext.getRequest().setAttribute("_list7", _list7);

            ServletActionContext.getRequest().getSession()
                    .setAttribute("List7", list7);
            ServletActionContext.getRequest().setAttribute("list7", list7);

                return "success";
    }

    // 删除行
    public String delete() {
        List<singTbl> list7 = (List<singTbl>) ServletActionContext.getRequest()
                .getSession().getAttribute("List7");
        int num = Integer.parseInt(index7);
        singTbl ba = list7.get(num);
        _delete(ba);
        try {
            show();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    private void _delete(singTbl ba) {
        MyConnection mc = new MyConnection();
        Connection conn = mc.getConnection();
        String sql = "delete from table7 where song=?";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, ba.getSong());
            pstmt.executeUpdate();
            mc.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 删除列
    public String delete0() {
        List<String> _list7 = (List<String>) ServletActionContext.getRequest()
                .getSession().getAttribute("_List7");
        int _num = Integer.parseInt(_index7);
        String s = _list7.get(_num);
        if (!s.equals("song"))
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
        Connection conn = mc.getConnection();
        String sql = "alter table table7 drop column " + s;
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            mc.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}