package com.table.action;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bean.movieTbl;

import org.apache.struts2.ServletActionContext;

import com.jdbc.MyConnection;
import com.opensymphony.xwork2.ActionSupport;

public class ActionTable9 extends ActionSupport {
    private String index9;
    private String _index9;

    public String getIndex9() {
        return index9;
    }

    public void setIndex9(String index9) {
        this.index9 = index9;
    }

    public String get_index9() {
        return _index9;
    }

    public void set_index9(String _index9) {
        this._index9 = _index9;
    }

    // 查询
    public String show() throws SQLException {
        MyConnection mc = new MyConnection();
        Connection conn = mc.getConnection();
        try {
            // 获取表结构
            List<String> _list9 = new ArrayList<String>();
            DatabaseMetaData myMetaData = conn.getMetaData();
            ResultSet _rs = myMetaData.getColumns(null, "%", "table9", "%");
            while (_rs.next()) {
                String field = _rs.getString("COLUMN_NAME");
                _list9.add(field);
            }

            List<movieTbl> list9 = new ArrayList<movieTbl>();
            String sql = "select * from  table9";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                movieTbl gtbl = new movieTbl();
                for (int i = 0; i < _list9.size(); i++) {
                    gtbl.set(_list9.get(i), rs.getString(_list9.get(i)));
                }
                list9.add(gtbl);
            }
            mc.close(conn);

            ServletActionContext.getRequest().getSession()
                    .setAttribute("_List", _list9);
            ServletActionContext.getRequest().setAttribute("_list9", _list9);

            ServletActionContext.getRequest().getSession()
                    .setAttribute("List", list9);
            ServletActionContext.getRequest().setAttribute("list9", list9);

            if (list9.isEmpty())
                return "failure";
            else
                return "success";
        } catch (Exception e) {
            return "failure";
        }
    }

    // 删除行
    public String delete() {
        List<movieTbl> list9 = (List<movieTbl>) ServletActionContext
                .getRequest().getSession().getAttribute("List");
        int num = Integer.parseInt(index9);
        movieTbl ba = list9.get(num);
        _delete(ba);
        try {
            show();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    private void _delete(movieTbl ba) {
        MyConnection mc = new MyConnection();
        Connection conn = mc.getConnection();
        String sql = "delete from table9 where name=?";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, ba.getName());
            pstmt.executeUpdate();
            mc.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 删除列
    public String delete0() {
        List<String> _list9 = (List<String>) ServletActionContext.getRequest()
                .getSession().getAttribute("_List");
        int _num = Integer.parseInt(_index9);
        String s = _list9.get(_num);
        if (!s.equals("name"))
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
        String sql = "alter table table9 drop column " + s;
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            mc.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}