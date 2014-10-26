package com.javausr.saxexample;

import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.ContentHandler;
//����ErrorHandler
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import java.io.IOException;
public class MySAXApp {
    
        public static void main( String[] args ) {
        
        try {
            // ��ʼ��reader
            XMLReader reader = XMLReaderFactory.createXMLReader("com.sun.org.apache.xerces.internal.parsers.SAXParser") ;
            // ����ContentHandler��ʵ��
            ContentHandler contentHandler = new MyContentHandler();
            // ��reader��ע��ʵ������ContentHandler
            reader.setContentHandler( contentHandler );
            // ����ErrorHandler��ʵ��
            ErrorHandler errorHandler = new MyErrorHandler();
            // ��reader��ע��ʵ������ErrorHandler
            reader.setErrorHandler( errorHandler );
            // ��ʼ�����ĵ�
            reader.parse("book.xml");
    } catch ( IOException e ) {
        System.out.println("�����ĵ�ʱ��: " + e.getMessage());
    } catch ( SAXException e ) {
        System.out.println("�����ĵ�ʱ��: " + e.getMessage());
    }
  }
}