package com.webpage;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class taobaoGet {
	public static void main(String[] args) throws IOException {
		String url="E:/大三/软件工程/最终项目/已买到的宝贝.htm";
		File input = new File(url);
		
		Document doc = Jsoup.parse(input, "GBK");
		Elements numItem = doc.select("span[class=number last-item]");//订单号
		Elements shops= doc.select("a[class=shopname J_MakePoint]");//店铺名
		Elements baobeiNames = doc.select("p[class=baobei-name]");//宝贝名称
		Elements Specs = doc.select("div[class=spec]");//货物信息
		Elements prices = doc.select("em[class=real-price special-num");//价格信息
		Elements qutys = doc.select("td[class=quantity][title]");//购买数量
		
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
