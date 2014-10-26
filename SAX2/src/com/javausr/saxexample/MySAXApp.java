package com.javausr.saxexample;

import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.ContentHandler;
//引入ErrorHandler
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import java.io.IOException;
public class MySAXApp {
    
        public static void main( String[] args ) {
        
        try {
            // 初始化reader
            XMLReader reader = XMLReaderFactory.createXMLReader("com.sun.org.apache.xerces.internal.parsers.SAXParser") ;
            // 创建ContentHandler的实例
            ContentHandler contentHandler = new MyContentHandler();
            // 在reader中注册实例化的ContentHandler
            reader.setContentHandler( contentHandler );
            // 创建ErrorHandler的实例
            ErrorHandler errorHandler = new MyErrorHandler();
            // 在reader中注册实例化的ErrorHandler
            reader.setErrorHandler( errorHandler );
            // 开始解析文档
            reader.parse("book.xml");
    } catch ( IOException e ) {
        System.out.println("读入文档时错: " + e.getMessage());
    } catch ( SAXException e ) {
        System.out.println("解析文档时错: " + e.getMessage());
    }
  }
}