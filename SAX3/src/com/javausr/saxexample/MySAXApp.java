package com.javausr.saxexample;

import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
//引入DefaultHandler
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXException;
import java.io.IOException;
public class MySAXApp {
  public static void main( String[] args ) {
 
    try {
        // 初始化reader
        XMLReader reader = XMLReaderFactory.createXMLReader("com.sun.org.apache.xerces.internal.parsers.SAXParser") ;
        // 创建DefaultHandler的实例
        DefaultHandler defaultHandler=new MyDefaultHandler();
        //在reader中将defaultHandler注册为ContentHandler
        reader.setContentHandler(defaultHandler);
        //在reader中将defaultHandler注册为ErrorHandler
        reader.setErrorHandler(defaultHandler);
        // 开始解析文档
        reader.parse("book.xml");
    } catch ( IOException e ) {
        System.out.println("读入文档时错: " + e.getMessage());
    } catch ( SAXException e ) {
        System.out.println("解析文档时错: " + e.getMessage());
    }
  }
}
