package com.javausr.saxexample;

import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.ContentHandler;
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
        // ��ʼ�����ĵ�
        reader.parse("book.xml");
    } catch ( IOException e ) {
        System.out.println("�����ĵ�ʱ��: " + e.getMessage());
    } catch ( SAXException e ) {
        System.out.println("�����ĵ�ʱ��: " + e.getMessage());
    }
  }
}
