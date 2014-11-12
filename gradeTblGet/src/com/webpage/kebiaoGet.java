package com.webpage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.bean.KLes;
import com.bean.Lesson;
import com.bean.kebiaoLss;
import com.jdbc.MyOperation;

public class kebiaoGet {
	public static void main(String[] args) {

		String url = "E:/大三/软件工程/最终项目/课表查询.htm";
		
		
		new commonGet().solve(url);
		
//		File input = new File(url);
//		try {
//			Document doc = Jsoup.parse(input, "GBK");
//			Elements tbls = doc.select("table[border=1]");
//			System.out.println(tbls.size());
//			
//			Elements tds = tbls.get(0).select("td table:eq(1)");
//			System.out.println("tds num="+tds.size());
//			
			
			
			
			
			
			
			
			
			
			
//			kebiaoLss K[] = new kebiaoLss[8];
//			
//			for(int i=0;i<8;i++){
//				K[i] = new kebiaoLss();
//				K[i].info = new String();
//			}
//			for(Element tbl : tbls){
//				Elements trs = tbl.select("tr td:gt(2)");
//				System.out.println("tr num:"+ trs.size());
//				for(Element tr : trs){
//					Elements tds = tr.select("td");
//					int cur = 0;
//					for(Element td : tds){
//						Elements subTbls = td.select("table");
//						if(subTbls.size()==0){
//							K[cur].num = 0;
//							if(td.text().equals(""))
//								K[cur].info ="没有课";
//							else
//								K[cur].info = td.text();
//						}
//						else{
//							System.out.println("找到字表");
//							Elements subTds = subTbls.get(0).select("td");
//							K[cur].num = subTds.size();
//							K[cur].lesson = new String[K[cur].num];
//							int i=0;
//							for(Element subTd : subTds){
//								K[cur].lesson[i++] = subTd.text();
//							}
//						}
//					}
//					int maxNum = 0;
//					for(int i=0;i<8;i++){
//						if(K[i].num > maxNum)
//							maxNum = K[i].num;
//					}
//					System.out.println("maxNum="+maxNum);
//					for(int i=0;i<8;i++){
//						if(K[i].num==0){
//							System.out.print(K[i].info+'\t');
//						}
//						else{
//							for(int j=0;j<K[i].num;j++){
//								System.out.print(K[i].lesson[j]+" ");
//							}
//							System.out.print('\t');
//						}
//					}
//					System.out.println();
//					
//					
//					for(int i=0;i<maxNum;i++){
//						for(int j=0;j<8;j++){
//							if(K[j].num==0){
//								System.out.print(K[j].info+'\t');
//								K[j].info = "   ";
//							}
//							else{
//								System.out.print(K[j].lesson[K[j].cur++]+'\t');
//							}
//						}
//					}
//					System.out.println();
//				}
//			}
			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
}
