package com.webpage;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.bean.Lesson;
import com.jdbc.MyOperation;

public class gradeGet {
	public static void main(String[] args) {
		
		
		
		String url="E:/大三/软件工程/最终项目/tt.html";
		new commonGet().solve(url);
//		File input = new File(url);
//		try {
//			Document doc = Jsoup.parse(input, "GBK");
//			Elements tbls = doc.select("table");
//			System.out.println("tbl num:"+tbls.size());
//			for(Element tbl : tbls){
//				Elements trs = tbl.select("tr");
//				for(Element tr : trs){
//					Elements tds = tr.select("td");
//					for(Element td : tds){
//						System.out.print(td.text()+'\t');
//					}
//					System.out.println();
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
}
