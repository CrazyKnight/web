
package com.excel;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import com.jdbc.*;

public class OutToExcel {
    /*
    public static void main(String args[]) throws SQLException, BiffException {
        new OutToExcel().launch();
    }
     */
    public void launch() throws SQLException, BiffException {
        Connection conn = new MyConnection().getConnection();
        String sql = "select * from zgy";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        int i = 0;
        try {
            WritableWorkbook book = Workbook.createWorkbook(new File(
                    "f:/成绩单.xls"));
            WritableSheet sheet = book.createSheet("成绩单", 0);
            
            //设置列宽
            sheet.setColumnView(0, 15);
            sheet.setColumnView(1, 20);
            sheet.setColumnView(2, 40);
            sheet.setColumnView(3, 10);
            sheet.setColumnView(4, 10);
            sheet.setColumnView(5, 10);
            sheet.setColumnView(6, 10);
            sheet.setColumnView(7, 10);
            sheet.setColumnView(8, 10);
            sheet.setColumnView(9, 10);
            
            while (rs.next()) {

                WritableCellFormat wc = new WritableCellFormat(); 
                // 设置居中 
                wc.setAlignment(Alignment.CENTRE); 
                // 设置边框线 
                wc.setBorder(Border.ALL, BorderLineStyle.THIN); 
                // 设置单元格的背景颜色 
                wc.setBackground(jxl.format.Colour.BRIGHT_GREEN); 
                
                Label label0 = new Label(0, i, rs.getString("term"),wc);
                Label label1 = new Label(1, i, rs.getString("lessonNum"),wc);
                Label label2 = new Label(2, i, rs.getString("lessonName"),wc);
                Label label3 = new Label(3, i, rs.getString("teacherName"),wc);
                Label label4 = new Label(4, i, rs.getString("kind"),wc);
                Label label5 = new Label(5, i, rs.getString("grade"),wc);
                Label label6 = new Label(6, i, rs.getString("time"),wc);
                Label label7 = new Label(7, i, rs.getString("myPoint"),wc);
                Label label8 = new Label(8, i, rs.getString("gradeKind"),wc);
                Label label9 = new Label(9, i, rs.getString("remark"),wc);
                
                // 将值添加到单元格中
                sheet.addCell(label0);
                sheet.addCell(label1);
                sheet.addCell(label2);
                sheet.addCell(label3);
                sheet.addCell(label4);
                sheet.addCell(label5);
                sheet.addCell(label6);
                sheet.addCell(label7);
                sheet.addCell(label8);
                sheet.addCell(label9);

                i++;
            }
            
            book.write();
            book.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (RowsExceededException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (WriteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
