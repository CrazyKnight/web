package com.table.action;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.jdbc.*;
import com.opensymphony.xwork2.ActionSupport;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class OutToExcel extends ActionSupport {
    private String tindex;
    private String download;

    public String getTindex() {
        return tindex;
    }

    public void setTindex(String tindex) {
        this.tindex = tindex;
    }

    public String getDownload() {
        return download;
    }

    public void setDownload(String download) {
        this.download = download;
    }

    public String execute() throws SQLException {
        Connection conn = new MyConnection().getConnection();
        try {
            String sql = "select * from table" + tindex;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // 获取表结构
            List<String> list = new ArrayList<String>();
            DatabaseMetaData myMetaData = conn.getMetaData();
            ResultSet _rs = myMetaData.getColumns(null, "%", "table" + tindex,
                    "%");
            while (_rs.next()) {
                String field = _rs.getString("COLUMN_NAME");
                list.add(field);
            }

            int i = 0;

            WritableWorkbook book = Workbook.createWorkbook(new File("f:/"
                    + "table" + tindex + ".xls"));
            WritableSheet sheet = book.createSheet("table" + tindex, 0);

            while (rs.next()) {
                WritableCellFormat wc = new WritableCellFormat();
                wc.setAlignment(Alignment.CENTRE); // 设置居中
                wc.setBorder(Border.ALL, BorderLineStyle.THIN); // 设置边框线

                if (i == 0)
                    for (int j = 0; j < list.size(); j++) {
                        sheet.addCell(new Label(j, i, list.get(j), wc));
                    }
                else
                    for (int j = 0; j < list.size(); j++) {
                        sheet.addCell(new Label(j, i,
                                rs.getString(list.get(j)), wc));
                    }
                i++;
            }
            book.write();
            book.close();

            int index = Integer.parseInt(tindex);
            switch (index) {
            case 1:
                new ActionTable1().show();
                break;
            case 2:
                new ActionTable2().show();
                break;
            case 3:
                new ActionTable3().show();
                break;
            case 4:
                new ActionTable4().show();
                break;
            case 5:
                new ActionTable5().show();
                break;
            case 6:
                new ActionTable6().show();
                break;
            case 7:
                new ActionTable7().show();
                break;
            case 8:
                new ActionTable8().show();
                break;
            case 9:
                new ActionTable9().show();
                break;
            case 10:
                new ActionTable10().show();
                break;
            }
        } catch (Exception e) {
            download = "下载失败，请上传数据";
            return "failure";
        }
        download = "已下载到f盘根目录";
        return SUCCESS;
    }
}
