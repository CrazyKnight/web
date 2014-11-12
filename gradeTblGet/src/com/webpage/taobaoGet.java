package com.webpage;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class taobaoGet {
	public static void main(String[] args) throws IOException {
		String url="E:/����/�������/������Ŀ/���򵽵ı���.htm";
		File input = new File(url);
		
		Document doc = Jsoup.parse(input, "GBK");
		Elements numItem = doc.select("span[class=number last-item]");//������
		Elements shops= doc.select("a[class=shopname J_MakePoint]");//������
		Elements baobeiNames = doc.select("p[class=baobei-name]");//��������
		Elements Specs = doc.select("div[class=spec]");//������Ϣ
		Elements prices = doc.select("em[class=real-price special-num");//�۸���Ϣ
		Elements qutys = doc.select("td[class=quantity][title]");//��������
		
		System.out.println(numItem.size());
		System.out.println(shops.size());
		System.out.println(baobeiNames.size());
		System.out.println(Specs.size());
		System.out.println(prices.size());
		System.out.println(qutys.size());
		
		for(int i=0;i<numItem.size();i++){
			System.out.print(numItem.get(i).text()+'\t');
			System.out.print(shops.get(i).text()+'\t');
			System.out.print(baobeiNames.get(i).text()+'\t');
			System.out.print(Specs.get(i).text()+'\t');
			System.out.print(qutys.get(i).text()+'\t');
			System.out.print(prices.get(i).text()+'\n');
		}
	}
}
