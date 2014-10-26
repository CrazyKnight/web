package com.javausr.saxexample;

import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
//����DefaultHandler
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXException;
import java.io.IOException;
public class MySAXApp {
  public static void main( String[] args ) {
 
    try {
        // ��ʼ��reader
        XMLReader reader = XMLReaderFactory.createXMLReader("com.sun.org.apache.xerces.internal.parsers.SAXParser") ;
        // ����DefaultHandler��ʵ��
        DefaultHandler defaultHandler=new MyDefaultHandler();
        //��reader�н�defaultHandlerע��ΪContentHandler
        reader.setContentHandler(defaultHandler);
        //��reader�н�defaultHandlerע��ΪErrorHandler
        reader.setErrorHandler(defaultHandler);
        // ��ʼ�����ĵ�
        reader.parse("book.xml");
    } catch ( IOException e ) {
        System.out.println("�����ĵ�ʱ��: " + e.getMessage());
    } catch ( SAXException e ) {
        System.out.println("�����ĵ�ʱ��: " + e.getMessage());
    }
  }
}
