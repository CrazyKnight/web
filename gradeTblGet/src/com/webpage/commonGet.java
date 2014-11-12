package com.webpage;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class commonGet {
	public static void main(String[] args) {
		
	}

	void solve(String url) {
		File input = new File(url);
		try {
			Document doc = Jsoup.parse(input, "GBK");
			Elements tbls = doc.select("table");
			for (Element tbl : tbls) {
				Elements trs = tbl.select("tr");
				for (Element tr : trs) {
					Elements tds = tr.select("td");
					for (Element td : tds) {
						System.out.print(td.text() + '\t');
					}
					System.out.println();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}