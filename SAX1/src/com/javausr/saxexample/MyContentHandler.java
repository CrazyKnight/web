package com.javausr.saxexample;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class MyContentHandler implements ContentHandler {
	/**
	 * StringBuffer ���Զ��ַ���������ɾ��Ķ��������µĶ������ڴ��ϵ�����Ҫ����String��
	 */
    private StringBuffer buf;
    /**
     * ����һ�����Զ�λ�ĵ������¼�����λ�õĶ�λ������
     */
    public void setDocumentLocator( Locator locator ) {
    }
    /**
     * ���ڴ����ĵ�������ʼ�¼�
     */
    public void startDocument() throws SAXException {
    	
        buf=new StringBuffer();
        System.out.println("*******��ʼ�����ĵ�*******");
    }
    /**
     * ���ڴ����ĵ����������¼�
     */
    public void endDocument() throws SAXException {
        System.out.println("*******�����ĵ�����*******");
    }
    /**
     * ��������в����Ĵ���ָ���¼�
     */
    public void processingInstruction( String target, String instruction )throws SAXException {
    }
    /**
     * ���ڴ���ǰ׺ӳ�俪ʼ�¼����Ӳ����п��Եõ�ǰ׺�����Լ���ָ���uri
     */
    public void startPrefixMapping( String prefix, String uri ) {
          System.out.println("\nǰ׺ӳ��: " + prefix +" ��ʼ!"+ "  ����URI��:" + uri);
    }
    /**
     * ���ڴ���ǰ׺ӳ������¼����Ӳ����п��Եõ�ǰ׺����
     */
    public void endPrefixMapping( String prefix ) {
          System.out.println("\nǰ׺ӳ��: "+prefix+" ����!");
    }
    /**
     * ����Ԫ�ؿ�ʼ�¼����Ӳ����п��Ի��Ԫ���������ƿռ��uri��Ԫ�����ƣ������б����Ϣ
     */
    public void startElement( String namespaceURI, String localName,String fullName, Attributes attributes ) throws SAXException {
        System.out.println("\n Ԫ��: " + "["+fullName+"]" +" ��ʼ����!");
        // ��ӡ��������Ϣ
        for ( int i = 0; i < attributes.getLength(); i++ ) {
            System.out.println("\t��������:" + attributes.getLocalName(i) + " ����ֵ:" + attributes.getValue(i));
        }
    }
    /**
     * ����Ԫ�ؽ����¼����Ӳ����п��Ի��Ԫ���������ƿռ��uri��Ԫ�����Ƶ���Ϣ
     */
    public void endElement( String namespaceURI, String localName,String fullName ) throws SAXException {
        //��ӡ���ǿյ�Ԫ�����ݲ���StringBuffer���                  
        String nullStr="";
      
        if (!buf.toString().trim().equals(nullStr)){
           System.out.println("\t������: " + buf.toString().trim());
        }
        //��StringBuffer���
        buf.setLength(0);
        //��ӡԪ�ؽ���������Ϣ
        System.out.println("Ԫ��: "+"["+fullName+"]"+" ��������!");              
    }
    /**
     * ����Ԫ�ص��ַ����ݣ��Ӳ����п��Ի������
     */
    public void characters( char[] chars, int start, int length ) throws SAXException {
          //��Ԫ�������ۼӵ�StringBuffer��                
          buf.append(chars,start,length);
    }
    /**
     * ����Ԫ�صĿɺ��Կո�
     */
    public void ignorableWhitespace( char[] chars, int start, int length ) throws SAXException {
    }
    public void skippedEntity( String name ) throws SAXException {
    }
}

