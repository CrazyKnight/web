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

import com.bean.zfbTbl;
import com.jdbc.MyConnection;
import com.opensymphony.xwork2.ActionSupport;

public class ActionTable3 extends ActionSupport {
    private String index3;
    private String _index3;

    public String getindex3() {
        return index3;
    }

    public void setindex3(String index3) {
        this.index3 = index3;
    }

    public String get_index3() {
        return _index3;
    }

    public void set_index3(String _index3) {
        this._index3 = _index3;
    }

    // 查询
    public String show() {
        MyConnection mc = new MyConnection();
        Connection conn = mc.getConnection();
        try {
            // 获取表结构
            List<String> _list3 = new ArrayList<String>();
            DatabaseMetaData myMetaData = conn.getMetaData();
            ResultSet _rs = myMetaData.getColumns(null, "%", "table3", "%");
            while (_rs.next()) {
                String field = _rs.getString("COLUMN_NAME");
                _list3.add(field);
            }

            List<zfbTbl> list3 = new ArrayList<zfbTbl>();
            String sql = "select * from  table3";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                zfbTbl gtbl = new zfbTbl();
                for (int i = 0; i < _list3.size(); i++) {
                    gtbl.set(_list3.get(i), rs.getString(_list3.get(i)));
                }
                list3.add(gtbl);
            }
            mc.close(conn);

            ServletActionContext.getRequest().getSession()
                    .setAttribute("_List", _list3);
            ServletActionContext.getRequest().setAttribute("_list3", _list3);

            ServletActionContext.getRequest().getSession()
                    .setAttribute("List", list3);
            ServletActionContext.getRequest().setAttribute("list3", list3);

            if (list3.isEmpty())
                return "failure";
            else
                return "success";
        } catch (Exception e) {
            return "failure";
        }
    }

    // 删除行
    public String delete() {
        List<zfbTbl> list3 = (List<zfbTbl>) ServletActionContext.getRequest()
                .getSession().getAttribute("List");
        int num = Integer.parseInt(index3);
        zfbTbl ba = list3.get(num);
        _delete(ba);
        show();
        return SUCCESS;
    }

    private void _delete(zfbTbl ba) {
        MyConnection mc = new MyConnection();
        Connection conn = mc.getConnection();
        String sql = "delete from table3 where csmBNos=?";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, ba.getCsmBNos());
            pstmt.executeUpdate();
            mc.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 删除列
    public String delete0() {
        List<String> _list3 = (List<String>) ServletActionContext.getRequest()
                .getSession().getAttribute("_List");
        int _num = Integer.parseInt(_index3);
        String s = _list3.get(_num);
        if (!s.equals("csmBNos"))
            _delete0(s);
        show();
        return SUCCESS;
    }

    private void _delete0(String s) {
        MyConnection mc = new MyConnection();
        Connection conn = mc.getConnection();
        String sql = "alter table table3 drop column " + s;
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            mc.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}