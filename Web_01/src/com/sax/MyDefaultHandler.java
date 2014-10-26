package com.sax;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.xml.sax.*;
import org.xml.sax.helpers.*;
public class MyDefaultHandler extends DefaultHandler {
	/**
	 * 用于保存读入的标签里面的内容，用buf比较节省内存
	 */
    private StringBuffer buf;
    
    public FileOutputStream fos;
    public Writer out;
    /**
     * 开始读文档
     */
    public void startDocument() throws SAXException {
        buf=new StringBuffer();
        try {
			fos = new FileOutputStream("result.txt");
			out = new OutputStreamWriter(fos);
			out.write("*******开始解析文档*******");
			out.write("\n\n\n");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("*******开始解析文档*******");
    }
    /**
     * 结束读文档
     */
    public void endDocument() throws SAXException {
    	try {
    		out.write("\n\n\n");
			out.write("*******解析文档结束*******");
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
        System.out.println("*******解析文档结束*******");
    }
    /**
     * 开始读前缀元素
     */
    public void startPrefixMapping( String prefix, String uri ) {
    }
    /**
     * 结束读前缀元素
     */
    public void endPrefixMapping( String prefix ) {
    }
    /**
     * 开始读元素
     */
    public void startElement( String namespaceURI, String localName,String fullName, Attributes attributes ) throws SAXException {
        try {
			out.write("["+fullName+"]");
			out.write("\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
    	System.out.println("["+fullName+"]");
        // 打印出属性信息
        for ( int i = 0; i < attributes.getLength(); i++ ) {
        	try {
				out.write("\t属性名称:" + attributes.getLocalName(i) + " 属性值:" + attributes.getValue(i));
				out.write("\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
            System.out.println("\t属性名称:" + attributes.getLocalName(i) + " 属性值:" + attributes.getValue(i));
        }
    }
    /**
     * 结束读元素
     */
    public void endElement( String namespaceURI, String localName, String fullName ) throws SAXException {
       //打印出非空的元素内容并将StringBuffer清空
       String nullStr="";
       if (!buf.toString().trim().equals(nullStr)){
    	   try {
			out.write("\t内容: " + buf.toString().trim() + "\n");
			out.write("["+fullName+"]" + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
          System.out.println("\t内容: " + buf.toString().trim());
       }
       buf.setLength(0);
       //打印元素解析结束信息
        System.out.println("["+fullName+"]");
    }
    /**
     * 读标签内的元素
     */
    public void characters( char[] chars, int start, int length ) throws SAXException {
       //将元素内容累加到StringBuffer中
       buf.append(chars,start,length);
    }
    /**
     * 警告
     */
    public void warning( SAXParseException exception ) {
        System.out.println("*******WARNING******");
        System.out.println("\t行:\t" + exception.getLineNumber());
        System.out.println("\t列:\t" + exception.getColumnNumber());
        System.out.println("\t错误信息:\t" + exception.getMessage());
        System.out.println("********************");
    }
    /**
     * 错误
     */
    public void error( SAXParseException exception ) throws SAXException{
        System.out.println("******* ERROR ******");
        System.out.println("\t行:\t" + exception.getLineNumber());
        System.out.println("\t列:\t" + exception.getColumnNumber());
        System.out.println("\t错误信息:\t" + exception.getMessage());
        System.out.println("********************");
    }
    /**
     * 致命错误
     */
    public void fatalError( SAXParseException exception ) throws SAXException {
        System.out.println("******** FATAL ERROR ********");
        System.out.println("\t行:\t" + exception.getLineNumber());
        System.out.println("\t列:\t" + exception.getColumnNumber());
        System.out.println("\t错误信息:\t" + exception.getMessage());
        System.out.println("*****************************");
    }
}

