package com.javausr.saxexample;

import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
//����XMLFilter
import org.xml.sax.XMLFilter;
import org.xml.sax.SAXException;
import java.io.IOException;
public class MySAXApp {
  public static void main( String[] args ) {
    
    try {
            // ��ʼ��reader
        XMLReader reader = XMLReaderFactory.createXMLReader("com.sun.org.apache.xerces.internal.parsers.SAXParser") ;
        //��ʼ��������
        XMLFilter myFilter=new MyFilter(reader);
        // ����DefaultHandler��ʵ��
        DefaultHandler defaultHandler=new MyDefaultHandler();
        //Ϊ���˺���¼�������ContentHandler
        myFilter.setContentHandler(defaultHandler);
        //Ϊ���˺���¼�������ErrorHandler
        myFilter.setErrorHandler(defaultHandler);
            // ��ʼ�����ĵ���ע����ʹ��myFilter�еĽ�������
        myFilter.parse("book.xml");
      } catch ( IOException e ) {
            System.out.println("�����ĵ�ʱ��: " + e.getMessage());
      } catch ( SAXException e ) {
            System.out.println("�����ĵ�ʱ��: " + e.getMessage());
      }
  }
}
