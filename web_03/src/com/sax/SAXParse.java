package com.sax;

import java.io.IOException;
import java.net.URL;

import org.xml.sax.SAXException;
import org.xml.sax.XMLFilter;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import com.util.DoTidy;
import com.util.GetSourceFile;

public class SAXParse {

	public boolean DoSAX(String url) {

		@SuppressWarnings("unused")
		URL curURL;
		try {
			curURL = new URL(url);
			//InputStream in = curURL.openStream();
			System.out.println("连接可用");
		} catch (Exception e1) {
			System.out.println("连接打不开!");
			url = null;
			return false;
		}

		/**
		 * to get source file
		 */
		GetSourceFile client = new GetSourceFile(url);
		try {
			client.run();

		} catch (Exception e) {
			e.printStackTrace();
		}

		/**
		 * Do Tidy
		 */
		DoTidy doTidy = new DoTidy();
		doTidy.doTidy();

		try {
			// 初始化reader
			XMLReader reader = XMLReaderFactory
					.createXMLReader("com.sun.org.apache.xerces.internal.parsers.SAXParser");
			// 初始化过滤器
			XMLFilter myFilter = new MyFilter(reader);
			// 创建DefaultHandler的实例
			DefaultHandler defaultHandler = new MyDefaultHandler();
			// 为过滤后的事件流设置ContentHandler
			myFilter.setContentHandler(defaultHandler);
			// 为过滤后的事件流设置ErrorHandler
			myFilter.setErrorHandler(defaultHandler);
			// 开始解析文档，注意是使用myFilter中的解析方法
			myFilter.parse("out.xml");
		} catch (IOException e) {
			System.out.println("读入文档时错: " + e.getMessage());
		} catch (SAXException e) {
			System.out.println("解析文档时错: " + e.getMessage());
		}
		return true;
	}
}
