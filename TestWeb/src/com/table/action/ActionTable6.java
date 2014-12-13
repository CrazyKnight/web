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

import com.bean.metalTbl;
import com.jdbc.MyConnection;
import com.opensymphony.xwork2.ActionSupport;

public class ActionTable6 extends ActionSupport {
    private String index6;
    private String _index6;

    public String getindex6() {
        return index6;
    }

    public void setindex6(String index6) {
        this.index6 = index6;
    }

    public String get_index6() {
        return _index6;
    }

    public void set_index6(String _index6) {
        this._index6 = _index6;
    }

    // 查询
    public String show() throws SQLException {
        MyConnection mc = new MyConnection();
        Connection conn = mc.getConnection();
        try {
            // 获取表结构
            List<String> _list6 = new ArrayList<String>();
            DatabaseMetaData myMetaData = conn.getMetaData();
            ResultSet _rs = myMetaData.getColumns(null, "%", "table6", "%");
            while (_rs.next()) {
                String field = _rs.getString("COLUMN_NAME");
                _list6.add(field);
            }

            List<metalTbl> list6 = new ArrayList<metalTbl>();
            String sql = "select * from  table6";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                metalTbl gtbl = new metalTbl();
                for (int i = 0; i < _list6.size(); i++) {
                    gtbl.set(_list6.get(i), rs.getString(_list6.get(i)));
                }
                list6.add(gtbl);
            }
            mc.close(conn);

            ServletActionContext.getRequest().getSession()
                    .setAttribute("_List", _list6);
            ServletActionContext.getRequest().setAttribute("_list6", _list6);

            ServletActionContext.getRequest().getSession()
                    .setAttribute("List", list6);
            ServletActionContext.getRequest().setAttribute("list6", list6);

            if (list6.isEmpty())
                return "failure";
            else
                return "success";
        } catch (Exception e) {
            return "failure";
        }
    }

    // 删除行
    public String delete() {
        List<metalTbl> list6 = (List<metalTbl>) ServletActionContext
                .getRequest().getSession().getAttribute("List");
        int num = Integer.parseInt(index6);
        metalTbl ba = list6.get(num);
        _delete(ba);

        try {
            show();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return SUCCESS;
    }

    private void _delete(metalTbl ba) {
        MyConnection mc = new MyConnection();
        Connection conn = mc.getConnection();
        String sql = "delete from table6 where Metal=?";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, ba.getMetal());
            pstmt.executeUpdate();
            mc.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 删除列
    public String delete0() {
        List<String> _list6 = (List<String>) ServletActionContext.getRequest()
                .getSession().getAttribute("_List");
        int _num = Integer.parseInt(_index6);
        String s = _list6.get(_num);
        if (!s.equals("Metal"))
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
        String sql = "alter table table6 drop column " + s;
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            mc.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}