package com.table.action;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bean.phoneRecordTbl;

import org.apache.struts2.ServletActionContext;

import com.bean.phoneRecordTbl;
import com.jdbc.MyConnection;
import com.opensymphony.xwork2.ActionSupport;

public class ActionTable4 extends ActionSupport {
    private String index4;
    private String _index4;

    public String getIndex4() {
        return index4;
    }

    public void setIndex4(String index4) {
        this.index4 = index4;
    }

    public String get_index4() {
        return _index4;
    }

    public void set_index4(String _index4) {
        this._index4 = _index4;
    }

    // 查询
    public String show() throws SQLException {
        MyConnection mc = new MyConnection();
        Connection conn = mc.getConnection();

        try {
            // 获取表结构
            List<String> _list4 = new ArrayList<String>();
            DatabaseMetaData myMetaData = conn.getMetaData();
            ResultSet _rs = myMetaData.getColumns(null, "%", "table4", "%");
            while (_rs.next()) {
                String field = _rs.getString("COLUMN_NAME");
                _list4.add(field);
            }

            List<phoneRecordTbl> list4 = new ArrayList<phoneRecordTbl>();
            String sql = "select * from  table4";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                phoneRecordTbl gtbl = new phoneRecordTbl();
                for (int i = 0; i < _list4.size(); i++) {
                    gtbl.set(_list4.get(i), rs.getString(_list4.get(i)));
                }
                list4.add(gtbl);
            }
            mc.close(conn);

            ServletActionContext.getRequest().getSession()
                    .setAttribute("_List", _list4);
            ServletActionContext.getRequest().setAttribute("_list4", _list4);

            ServletActionContext.getRequest().getSession()
                    .setAttribute("List", list4);
            ServletActionContext.getRequest().setAttribute("list4", list4);

            if (list4.isEmpty())
                return "failure";
            else
                return "success";
        } catch (Exception e) {
            return "failure";
        }
    }

    // 删除行
    public String delete() {
        List<phoneRecordTbl> list4 = (List<phoneRecordTbl>) ServletActionContext
                .getRequest().getSession().getAttribute("List");
        int num = Integer.parseInt(index4);
        phoneRecordTbl ba = list4.get(num);
        _delete(ba);
        try {
            show();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    private void _delete(phoneRecordTbl ba) {
        MyConnection mc = new MyConnection();
        Connection conn = mc.getConnection();
        String sql = "delete from table4 where num=?";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, ba.getNum());
            pstmt.executeUpdate();
            mc.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 删除列
    public String delete0() {
        List<String> _list4 = (List<String>) ServletActionContext.getRequest()
                .getSession().getAttribute("_List");
        int _num = Integer.parseInt(_index4);
        String s = _list4.get(_num);
        if (!s.equals("num"))
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
        String sql = "alter table table4 drop column " + s;
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            mc.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}