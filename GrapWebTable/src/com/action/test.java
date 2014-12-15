package com.action;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class test {
	public static void main(String[] args) {
		//File html = new File("E:/����/�������/������Ŀ/�ֻ�ͨѶ¼.html");
		//File html = new File("E:/����/�������/������Ŀ/douban.html");
		//File html = new File("E:/����/�������/������Ŀ/metal.html");
		//File html = new File("E:/����/�������/������Ŀ/HITORADIO.htm");
		//File html = new File("E:/����/�������/������Ŀ/2014����ϸ߿���Ƴɼ�����һ��һ�α�--�߿���.htm");
		//File html = new File("E:/����/�������/������Ŀ/�����Ӱ���а�_���羭���Ӱ���а�_2014����ϲ���Ӱ���а�2345��Ӱ��.htm");
		File html = new File("E:/����/�������/������Ŀ/��Ӱר��-���µ�ӰBT���ӷ���-BT���ӣ�Ѹ�����أ���ӰBT��Ӱ��BT - ��������Ӱ.htm"); 
		/*
		private String title;
		private String day;
		private String actor;
		private String type;
		private String scan_num;*/
		try {
			Document doc = Jsoup.parse(html,"gb2312");
			Elements titles = doc.select("a[class=title]");
			Elements infos = doc.select("span[class=add]");
			for(int i=0;i<titles.size();i++){
				Element title = titles.get(i);
				Element info = infos.get(i);
				Elements bigs = info.select("big");
				System.out.print(title.text()+'\t');
				for(int j=0;j<bigs.size();j++){
					
					System.out.print(bigs.get(j).text()+'\t');
				}
				System.out.println();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
