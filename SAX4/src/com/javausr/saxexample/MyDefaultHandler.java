package com.javausr.saxexample;

import org.xml.sax.*;
import org.xml.sax.helpers.*;
public class MyDefaultHandler extends DefaultHandler {
    private StringBuffer buf;
    public void startDocument() throws SAXException {
        buf=new StringBuffer();
        System.out.println("*******��ʼ�����ĵ�*******");
    }
    public void endDocument() throws SAXException {
        System.out.println("*******�����ĵ�����*******");
    }
    public void startPrefixMapping( String prefix, String uri ) {
System.out.println("\nǰ׺ӳ��: " + prefix +" ��ʼ!"+ "  ����URI��:"+uri);
    }
    public void endPrefixMapping( String prefix ) {
       System.out.println("\nǰ׺ӳ��: "+prefix+" ����!");
    }
    public void startElement( String namespaceURI, String localName,
                                  String fullName, Attributes attributes )
                          throws SAXException {
        System.out.println("\nԪ��: " + "["+fullName+"]" +" ��ʼ����!");
        // ��ӡ��������Ϣ
        for ( int i = 0; i < attributes.getLength(); i++ ) {
            System.out.println("\t��������:" + attributes.getLocalName(i)
                + " ����ֵ:" + attributes.getValue(i));
        }
    }
    public void endElement( String namespaceURI, String localName,
                                                      String fullName )
                          throws SAXException {
       //��ӡ���ǿյ�Ԫ�����ݲ���StringBuffer���
       String nullStr="";
       if (!buf.toString().trim().equals(nullStr)){
          System.out.println("\t������: " + buf.toString().trim());
       }
       buf.setLength(0);
       //��ӡԪ�ؽ���������Ϣ
        System.out.println("Ԫ��: "+"["+fullName+"]"+" ��������!");
    }
    public void characters( char[] chars, int start, int length )
                                throws SAXException {
       //��Ԫ�������ۼӵ�StringBuffer��
       buf.append(chars,start,length);
    }
    public void warning( SAXParseException exception ) {
        System.out.println("*******WARNING******");
        System.out.println("\t��:\t" + exception.getLineNumber());
        System.out.println("\t��:\t" + exception.getColumnNumber());
        System.out.println("\t������Ϣ:\t" + exception.getMessage());
        System.out.println("********************");
    }
    public void error( SAXParseException exception ) throws SAXException{
        System.out.println("******* ERROR ******");
        System.out.println("\t��:\t" + exception.getLineNumber());
        System.out.println("\t��:\t" + exception.getColumnNumber());
        System.out.println("\t������Ϣ:\t" + exception.getMessage());
        System.out.println("********************");
    }
    public void fatalError( SAXParseException exception ) throws SAXException {
        System.out.println("******** FATAL ERROR ********");
        System.out.println("\t��:\t" + exception.getLineNumber());
        System.out.println("\t��:\t" + exception.getColumnNumber());
        System.out.println("\t������Ϣ:\t" + exception.getMessage());
        System.out.println("*****************************");
    }
}

