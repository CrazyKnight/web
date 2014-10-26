package com.javausr.saxexample;

import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
//引入XMLFilter
import org.xml.sax.XMLFilter;
import org.xml.sax.SAXException;
import java.io.IOException;
public class MySAXApp {
  public static void main( String[] args ) {
    
    try {
            // 初始化reader
        XMLReader reader = XMLReaderFactory.createXMLReader("com.sun.org.apache.xerces.internal.parsers.SAXParser") ;
        //初始化过滤器
        XMLFilter myFilter=new MyFilter(reader);
        // 创建DefaultHandler的实例
        DefaultHandler defaultHandler=new MyDefaultHandler();
        //为过滤后的事件流设置ContentHandler
        myFilter.setContentHandler(defaultHandler);
        //为过滤后的事件流设置ErrorHandler
        myFilter.setErrorHandler(defaultHandler);
            // 开始解析文档，注意是使用myFilter中的解析方法
        myFilter.parse("book.xml");
      } catch ( IOException e ) {
            System.out.println("读入文档时错: " + e.getMessage());
      } catch ( SAXException e ) {
            System.out.println("解析文档时错: " + e.getMessage());
      }
  }
}
