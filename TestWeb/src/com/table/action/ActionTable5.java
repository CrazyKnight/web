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

import com.bean.doubanTbl;
import com.jdbc.MyConnection;
import com.opensymphony.xwork2.ActionSupport;

public class ActionTable5 extends ActionSupport {
    private String index5;
    private String _index5;

    public String getindex5() {
        return index5;
    }

    public void setindex5(String index5) {
        this.index5 = index5;
    }

    public String get_index5() {
        return _index5;
    }

    public void set_index5(String _index5) {
        this._index5 = _index5;
    }

    // 查询
    public String show() throws SQLException {
        MyConnection mc = new MyConnection();
        Connection conn = mc.getConnection();

        try {
            // 获取表结构
            List<String> _list5 = new ArrayList<String>();
            DatabaseMetaData myMetaData = conn.getMetaData();
            ResultSet _rs = myMetaData.getColumns(null, "%", "table5", "%");
            while (_rs.next()) {
                String field = _rs.getString("COLUMN_NAME");
                _list5.add(field);
            }

            List<doubanTbl> list5 = new ArrayList<doubanTbl>();
            String sql = "select * from  table5";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                doubanTbl gtbl = new doubanTbl();
                for (int i = 0; i < _list5.size(); i++) {
                    gtbl.set(_list5.get(i), rs.getString(_list5.get(i)));
                }
                list5.add(gtbl);
            }
            mc.close(conn);

            ServletActionContext.getRequest().getSession()
                    .setAttribute("_List", _list5);
            ServletActionContext.getRequest().setAttribute("_list5", _list5);

            ServletActionContext.getRequest().getSession()
                    .setAttribute("List", list5);
            ServletActionContext.getRequest().setAttribute("list5", list5);

            if (list5.isEmpty())
                return "failure";
            else
                return "success";
        } catch (Exception e) {
            return "failure";
        }
    }

    // 删除行
    public String delete() {
        List<doubanTbl> list5 = (List<doubanTbl>) ServletActionContext
                .getRequest().getSession().getAttribute("List");
        int num = Integer.parseInt(index5);
        doubanTbl ba = list5.get(num);
        _delete(ba);

        try {
            show();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return SUCCESS;
    }

    private void _delete(doubanTbl ba) {
        MyConnection mc = new MyConnection();
        Connection conn = mc.getConnection();
        String sql = "delete from table5 where topic=?";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, ba.getTopic());
            pstmt.executeUpdate();
            mc.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 删除列
    public String delete0() {
        List<String> _list5 = (List<String>) ServletActionContext.getRequest()
                .getSession().getAttribute("_List");
        int _num = Integer.parseInt(_index5);
        String s = _list5.get(_num);
        if (!s.equals("topic"))
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
        String sql = "alter table table5 drop column " + s;
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            mc.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}