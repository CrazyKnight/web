package com.grade;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class test {
	public static void main(String[] args) {
		String str = "<table><tr onmouseover=SeeSetBg(this) 'onmouseout'='SeeReBg(this)' >"
				+ "<td height=25>\n<div align=center>2014ÏÄ¼¾</div></td>"
				+"<td><div align=center>GO90300300</div></td>"
          +"</tr></table>"+"<table> <tr> </tr> </table>";
		 
        Document doc = Jsoup.parse(str);
        System.out.println(doc.select("table").size());
        Elements trs = doc.select("table").select("tr");
        System.out.println(trs.size());
        for(int i = 0;i<trs.size();i++){
            Elements tds = trs.get(i).select("td");
            for(int j = 0;j<tds.size();j++){
                String text = tds.get(j).text();
                System.out.println(text);
            }
        }
	}
}
