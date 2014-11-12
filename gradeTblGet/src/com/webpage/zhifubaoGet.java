package com.webpage;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class zhifubaoGet {
	public static void main(String[] args) {
		String url="E:/大三/软件工程/最终项目/交易记录 - 支付宝.htm";
		File input = new File(url);
		
		try {
			Document doc = Jsoup.parse(input, "GBK");
			Elements csmBNos = doc.select("div[class=consumeBizNo]");
			Elements times = doc.select("td[class=time]");
			Elements infos = doc.select("td[class=info");
			Elements incomes = doc.select("td[class=amount income]");
			Elements outlays = doc.select("td[class=amount outlay");
			Elements balances = doc.select("td[class=balance]");
			Elements froms = doc.select("td[class=from]");
			
			System.out.println(csmBNos.size());
			System.out.println(times.size());
			System.out.println(infos.size());
			System.out.println(incomes.size());
			System.out.println(outlays.size());
			System.out.println(balances.size());
			System.out.println(froms.size());
			int out=0;
			int in=0;
			for(int i=0;i<csmBNos.size();i++){
				System.out.print(csmBNos.get(i).text()+'\t');
				System.out.print(times.get(i).text()+'\t');
				System.out.print(infos.get(i).text()+'\t');
				if(froms.get(i).text().equals("支付宝")){
					System.out.print('\t'+outlays.get(out++).text()+'\t');
				}
				else{
					System.out.print(incomes.get(in++).text()+'\t'+'\t');
				}
				System.out.print(balances.get(i).text()+'\t');
				System.out.print(froms.get(i).text()+'\n');
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
