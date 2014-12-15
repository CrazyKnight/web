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

import com.bean.gaokaoTbl;
import com.jdbc.MyConnection;
import com.opensymphony.xwork2.ActionSupport;

public class ActionTable8 extends ActionSupport {
    private String index8;
    private String _index8;

    public String getindex8() {
        return index8;
    }

    public void setindex8(String index8) {
        this.index8 = index8;
    }

    public String get_index8() {
        return _index8;
    }

    public void set_index8(String _index8) {
        this._index8 = _index8;
    }

    // 查询
    public String show() throws SQLException {
        MyConnection mc = new MyConnection();
        Connection conn = mc.getConnection();
        try {
            // 获取表结构
            List<String> _list8 = new ArrayList<String>();
            DatabaseMetaData myMetaData = conn.getMetaData();
            ResultSet _rs = myMetaData.getColumns(null, "%", "table8", "%");
            while (_rs.next()) {
                String field = _rs.getString("COLUMN_NAME");
                _list8.add(field);
            }

            List<gaokaoTbl> list8 = new ArrayList<gaokaoTbl>();
            String sql = "select * from  table8";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                gaokaoTbl gtbl = new gaokaoTbl();
                for (int i = 0; i < _list8.size(); i++) {
                    gtbl.set(_list8.get(i), rs.getString(_list8.get(i)));
                }
                list8.add(gtbl);
            }
            mc.close(conn);

            ServletActionContext.getRequest().getSession()
                    .setAttribute("_List", _list8);
            ServletActionContext.getRequest().setAttribute("_list8", _list8);

            ServletActionContext.getRequest().getSession()
                    .setAttribute("List", list8);
            ServletActionContext.getRequest().setAttribute("list8", list8);

            if (list8.isEmpty())
                return "failure";
            else
                return "success";
        } catch (Exception e) {
            return "failure";
        }
    }

    // 删除行
    public String delete() {
        List<gaokaoTbl> list8 = (List<gaokaoTbl>) ServletActionContext
                .getRequest().getSession().getAttribute("List");
        int num = Integer.parseInt(index8);
        gaokaoTbl ba = list8.get(num);
        _delete(ba);

        try {
            show();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return SUCCESS;
    }

    private void _delete(gaokaoTbl ba) {
        MyConnection mc = new MyConnection();
        Connection conn = mc.getConnection();
        String sql = "delete from table8 where stuNum=?";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, ba.getStuNum());
            pstmt.executeUpdate();
            mc.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 删除列
    public String delete0() {
        List<String> _list8 = (List<String>) ServletActionContext.getRequest()
                .getSession().getAttribute("_List");
        int _num = Integer.parseInt(_index8);
        String s = _list8.get(_num);
        if (!s.equals("stuNum"))
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
        String sql = "alter table table8 drop column " + s;
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            mc.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}