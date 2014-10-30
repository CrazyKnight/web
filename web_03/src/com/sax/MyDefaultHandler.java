package com.sax;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.xml.sax.*;
import org.xml.sax.helpers.*;
public class MyDefaultHandler extends DefaultHandler {
	/**
	 * ���ڱ������ı�ǩ��������ݣ���buf�ȽϽ�ʡ�ڴ�
	 */
    private StringBuffer buf;
    
    public FileOutputStream fos;
    public Writer out;
    /**
     * ��ʼ���ĵ�
     */
    public void startDocument() throws SAXException {
        buf=new StringBuffer();
        try {
			fos = new FileOutputStream("result.txt");
			out = new OutputStreamWriter(fos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    /**
     * �������ĵ�
     */
    public void endDocument() throws SAXException {
    	try {
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   
    }
    /**
     * ��ʼ��ǰ׺Ԫ��
     */
    public void startPrefixMapping( String prefix, String uri ) {
    }
    /**
     * ������ǰ׺Ԫ��
     */
    public void endPrefixMapping( String prefix ) {
    }
    /**
     * ��ʼ��Ԫ��
     */
    public void startElement( String namespaceURI, String localName,String fullName, Attributes attributes ) throws SAXException {
        try {
			out.write("["+fullName);
			for ( int i = 0; i < attributes.getLength(); i++ ) {
				if(attributes.getValue(i).equals("rowspan") || attributes.getValue(i).equals("colapan"))
				out.write(" " + attributes.getLocalName(i) + "=" + attributes.getValue(i));	
			}
			out.write("]");
			out.write("\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
    	System.out.print("["+fullName);
        // ��ӡ��������Ϣ
        for ( int i = 0; i < attributes.getLength(); i++ ) {
        	if(attributes.getValue(i).equals("rowspan") || attributes.getValue(i).equals("colapan"))
            System.out.print(" " + attributes.getLocalName(i) + "=" + attributes.getValue(i));
        }
        System.out.println("]");
    }
    /**
     * ������Ԫ��
     */
    public void endElement( String namespaceURI, String localName, String fullName ) throws SAXException {
       //��ӡ���ǿյ�Ԫ�����ݲ���StringBuffer���
       String nullStr="";
       if (!buf.toString().trim().equals(nullStr)){
    	   try {
			out.write(buf.toString().trim() + "\n");
			out.write("[\\"+fullName+"]" + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
          System.out.println(buf.toString().trim());
       }
       buf.setLength(0);
       //��ӡԪ�ؽ���������Ϣ
        System.out.println("[\\"+fullName+"]");
    }
    /**
     * ����ǩ�ڵ�Ԫ��
     */
    public void characters( char[] chars, int start, int length ) throws SAXException {
       //��Ԫ�������ۼӵ�StringBuffer��
       buf.append(chars,start,length);
    }
    /**
     * ����
     */
    public void warning( SAXParseException exception ) {
        System.out.println("*******WARNING******");
        System.out.println("\t��:\t" + exception.getLineNumber());
        System.out.println("\t��:\t" + exception.getColumnNumber());
        System.out.println("\t������Ϣ:\t" + exception.getMessage());
        System.out.println("********************");
    }
    /**
     * ����
     */
    public void error( SAXParseException exception ) throws SAXException{
        System.out.println("******* ERROR ******");
        System.out.println("\t��:\t" + exception.getLineNumber());
        System.out.println("\t��:\t" + exception.getColumnNumber());
        System.out.println("\t������Ϣ:\t" + exception.getMessage());
        System.out.println("********************");
    }
    /**
     * ��������
     */
    public void fatalError( SAXParseException exception ) throws SAXException {
        System.out.println("******** FATAL ERROR ********");
        System.out.println("\t��:\t" + exception.getLineNumber());
        System.out.println("\t��:\t" + exception.getColumnNumber());
        System.out.println("\t������Ϣ:\t" + exception.getMessage());
        System.out.println("*****************************");
    }
}

