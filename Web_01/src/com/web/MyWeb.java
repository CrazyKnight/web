package com.web;

import com.sax.SAXParse;

public class MyWeb {
	
	private static String url;

	public static void main(String[] args) {
		url = "http://jwc.hit.edu.cn/";
		SAXParse sax = new SAXParse();
		sax.DoSAX(url);
	}

}
