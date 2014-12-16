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

import com.bean.taobaoTbl;
import com.jdbc.MyConnection;
import com.opensymphony.xwork2.ActionSupport;

public class ActionTable2 extends ActionSupport {
    private String index2;
    private String _index2;
   
    public String getindex2() {
        return index2;
    }

    public void setindex2(String index2) {
        this.index2 = index2;
    }

    public String get_index2() {
        return _index2;
    }

    public void set_index2(String _index2) {
        this._index2 = _index2;
    }

   
    // 查询
    public String show() throws SQLException {
        MyConnection mc = new MyConnection();
        Connection conn = mc.getConnection();

        // 获取表结构
        List<String> _list2 = new ArrayList<String>();
        DatabaseMetaData myMetaData = conn.getMetaData();
        ResultSet _rs = myMetaData.getColumns(null, "%", "table2", "%");
        while (_rs.next()) {
            String field = _rs.getString("COLUMN_NAME");
            _list2.add(field);
        }
        List<taobaoTbl> list2 = new ArrayList<taobaoTbl>();
        String sql = "select * from  table2";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            taobaoTbl gtbl = new taobaoTbl();
            for (int i = 0; i < _list2.size(); i++) {
                gtbl.set(_list2.get(i),rs.getString(_list2.get(i)));
            }
            list2.add(gtbl);
        }
        mc.close(conn);
        ServletActionContext.getRequest().getSession()
        .setAttribute("_List2", _list2);
        ServletActionContext.getRequest().setAttribute("_list2", _list2);
        
        ServletActionContext.getRequest().getSession()
                .setAttribute("List2", list2);
        ServletActionContext.getRequest().setAttribute("list2", list2);

            return "success";
    }

    //删除行
    public String delete() {
        List<taobaoTbl> list2 = (List<taobaoTbl>) ServletActionContext
                .getRequest().getSession().getAttribute("List2");
        int num = Integer.parseInt(index2);
        taobaoTbl ba = list2.get(num);
        _delete(ba);
        
        try {
            show();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return SUCCESS;
    }
    private void _delete(taobaoTbl ba) {
        MyConnection mc = new MyConnection();
        Connection conn = mc.getConnection();
        String sql = "delete from table2 where numItem=?";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, ba.getNumItem());
            pstmt.executeUpdate();
            mc.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //删除列
    public String delete0() {
        List<String> _list2 = (List<String>) ServletActionContext
                .getRequest().getSession().getAttribute("_List2");
        int _num = Integer.parseInt(_index2);
        String s = _list2.get(_num);
        if(!s.equals("numItem"))
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
        String sql = "alter table table2 drop column "+s;
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            mc.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}