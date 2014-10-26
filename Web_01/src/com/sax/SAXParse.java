package com.sax;
import java.io.IOException;

import org.xml.sax.SAXException;
import org.xml.sax.XMLFilter;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import com.util.DoTidy;
import com.util.GetSourceFile;

public class SAXParse {
	
	public void DoSAX(String url) {
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
        myFilter.parse("out.xml");
      } catch ( IOException e ) {
            System.out.println("�����ĵ�ʱ��: " + e.getMessage());
      } catch ( SAXException e ) {
            System.out.println("�����ĵ�ʱ��: " + e.getMessage());
      }
	}
}
