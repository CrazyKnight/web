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

import com.bean.btTbl;
import com.jdbc.MyConnection;
import com.opensymphony.xwork2.ActionSupport;

public class ActionTable10 extends ActionSupport {
    private String index10;
    private String _index10;

    public String getindex10() {
        return index10;
    }

    public void setindex10(String index10) {
        this.index10 = index10;
    }

    public String get_index10() {
        return _index10;
    }

    public void set_index10(String _index10) {
        this._index10 = _index10;
    }

    // 查询
    public String show() throws SQLException {
        MyConnection mc = new MyConnection();
        Connection conn = mc.getConnection();
            // 获取表结构
            List<String> _list10 = new ArrayList<String>();
            DatabaseMetaData myMetaData = conn.getMetaData();
            ResultSet _rs = myMetaData.getColumns(null, "%", "table10", "%");
            while (_rs.next()) {
                String field = _rs.getString("COLUMN_NAME");
                _list10.add(field);
            }

            List<btTbl> list10 = new ArrayList<btTbl>();
            String sql = "select * from  table10";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                btTbl gtbl = new btTbl();
                for (int i = 0; i < _list10.size(); i++) {
                    gtbl.set(_list10.get(i), rs.getString(_list10.get(i)));
                }
                list10.add(gtbl);
            }
            mc.close(conn);

            ServletActionContext.getRequest().getSession()
                    .setAttribute("_List10", _list10);
            ServletActionContext.getRequest().setAttribute("_list10", _list10);

            ServletActionContext.getRequest().getSession()
                    .setAttribute("List10", list10);
            ServletActionContext.getRequest().setAttribute("list10", list10);
                
            return "success";
    }

    // 删除行
    public String delete() {
        List<btTbl> list10 = (List<btTbl>) ServletActionContext.getRequest()
                .getSession().getAttribute("List10");
        int num = Integer.parseInt(index10);
        btTbl ba = list10.get(num);
        _delete(ba);

        try {
            show();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return SUCCESS;
    }

    private void _delete(btTbl ba) {
        MyConnection mc = new MyConnection();
        Connection conn = mc.getConnection();
        String sql = "delete from table10 where title=?";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, ba.getTitle());
            pstmt.executeUpdate();
            mc.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 删除列
    public String delete0() {
        List<String> _list10 = (List<String>) ServletActionContext.getRequest()
                .getSession().getAttribute("_List10");
        int _num = Integer.parseInt(_index10);
        String s = _list10.get(_num);
        if (!s.equals("title"))
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
        String sql = "alter table table10 drop column " + s;
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            mc.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}