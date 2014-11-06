package com.grade;

import java.io.File;
import java.sql.SQLException;

import jxl.read.biff.BiffException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.bean.Lesson;
import com.jdbc.MyOperation;
import com.excel.*;

public class GradeGet {
    
	public static void main(String[] args) throws BiffException, SQLException {
	    new GradeGet().getData("");
	}
	public void getData(String url) throws BiffException, SQLException {	
		MyOperation util = new MyOperation();
		Lesson L = new Lesson();
		String database = "grades";
		String user = "root";
		String tblName = "zgy";
		String password = "123456";
		
		//String url="E:/大三/软件工程/view-source xscj.hit.edu.cn hitjwgl xs cjcx CX_1.asp LB=1.htm";
		String url2="e:/tt.html";
		File input = new File(url2);
		try {
			Document doc = Jsoup.parse(input, "GBK");
			
			Elements trs = doc.select("tr:has(td)");
			int i=0;
			boolean flag = false;
			String str[] = new String[10];
			for(Element tr : trs){
				Elements tds = tr.getElementsByTag("td");
				for(Element td : tds){
					String cur = td.ownText();
					if(cur.equals("学期"))
						flag = true;
					if(cur.equals("&nbsp;") || cur.equals(">"))
						cur="";
					if(cur.equals("学分统计"))
						flag = false;
					if(flag && !cur.equals("")){
					    if(cur.indexOf("&nbsp;")!=-1)
	                        cur=cur.replaceAll("&nbsp;", "");
						System.out.print(cur+ "  ");
						str[i++]=cur;
					
						if(i==10){
							L.setTerm(str[0]);
							L.setLessonNum(str[1]);
							L.setLessonName(str[2]);
							L.setTecherName(str[3]);
							L.setKind(str[4]);
							L.setGrade(str[5]);
							L.setTime(str[6]);
							L.setMyPoint(str[7]);
							L.setGradeKind(str[8]);
							L.setRemark(str[9]);
							util.add(L, database, user, password, tblName);
							//for(int j=0;j<10;j++)
							//System.out.println(str);
							i=0;
							System.out.println();
						}
					}			
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		new OutToExcel().launch();;
	}
}
