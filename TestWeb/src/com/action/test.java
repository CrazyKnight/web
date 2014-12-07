package com.action;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class test {
	public static void main(String[] args) {
		//File html = new File("E:/大三/软件工程/最终项目/手机通讯录.html");
		//File html = new File("E:/大三/软件工程/最终项目/douban.html");
		//File html = new File("E:/大三/软件工程/最终项目/metal.html");
		//File html = new File("E:/大三/软件工程/最终项目/HITORADIO.htm");
		//File html = new File("E:/大三/软件工程/最终项目/2014年河南高考理科成绩排名一分一段表--高考网.htm");
		//File html = new File("E:/大三/软件工程/最终项目/经典电影排行榜_世界经典电影排行榜_2014经典喜剧电影排行榜【2345电影】.htm");
		File html = new File("E:/大三/软件工程/最终项目/电影专区-最新电影BT种子发布-BT种子，迅雷下载，电影BT，影视BT - 贼吧网电影.htm"); 
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
