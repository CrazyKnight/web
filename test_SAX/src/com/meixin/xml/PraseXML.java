package com.meixin.xml; 

import java.io.File; 
import java.util.Vector; 
import org.xml.sax.Attributes; 
import org.xml.sax.SAXException; 
import org.xml.sax.helpers.DefaultHandler; 
import javax.xml.parsers.SAXParser; 
import javax.xml.parsers.SAXParserFactory; 

public class PraseXML extends DefaultHandler 
{ 

  private Vector<String> tagName; 

  private Vector<String> tagValue; 

  private int step; 

  // ��ʼ����XML�ļ� 
  public void startDocument() throws SAXException 
  { 
    tagName = new Vector<String>(); 
    tagValue = new Vector<String>(); 
    step = 0; 
  } 

  // ��������XML�ļ� 
  public void endDocument() throws SAXException 
  { 
    for (int i = 0; i < tagName.size(); i++) 
    { 
      if (!tagName.get(i).equals("") || tagName.get(i) != null) 
      { 
        System.out.println("�ڵ����ƣ�" + tagName.get(i)); 
        System.out.println("�ڵ�ֵ��" + tagValue.get(i)); 
      } 
    } 
  } 

  /** 
    * �ڽ��͵�һ����ʼԪ��ʱ����ô˷���.���ǵ�Ԫ�����ظ�ʱ�����Լ�д�㷨������ 
    * ��Щ�ظ���Ԫ��.qName��ʲô? <name:page ll=""></name:page>����д�ͻ��׳�SAXException���� 
    * ͨ�������qName����localName 
    */ 
  public void startElement(String uri, String localName, String qName, 
      Attributes attributes) throws SAXException 
  { 
    // �ڵ����� 
    tagName.add(qName); 
    // ѭ��������� 
    for (int i = 0; i < attributes.getLength(); i++) 
    { 
      // ��ȡ�������� 
      System.out.println("�������ƣ�" + attributes.getQName(i)); 
      // ��ȡ����ֵ 
      System.out.println("����ֵ��" 
          + attributes.getValue(attributes.getQName(i))); 
    } 

  } 

  /** 
    * ������������ǩʱ���ô˷��� 
    */ 
  public void endElement(String uri, String localName, String qName) 
      throws SAXException 
  { 

    step = step + 1; 
  } 

  /** 
    * ��ȡ��ǩ���ֵ,ch�������ĳ�е�xml���ַ�����,������ǩ,��ʼ��С��2048, 
    * ÿ���͵��µ��ַ��������ӵ�char[]�    * ע��,���char�ַ����Լ�����洢���ַ�, 
    * ������ÿһ�оͻ�ˢ��һ��char,start,length����xml��Ԫ������ȷ����, 
    * ��ʱ�Ҳ�������,�Ժ�Դ����. 
    *    
    * ����һ������ǩ������ǩ���ᱻִ��һ��characters�������ڷ���ǩʱ���û�����е�ֵ 
    */ 
  public void characters(char ch[], int start, int length) 
      throws SAXException 
  { 
    // ֻҪ��ǰ�ı�ǩ��ĳ���һ����ֵ�Ͳ������򷴱�ǩ�����ƻ����� 
    if (tagName.size() - 1 == tagValue.size()) 
    { 
      tagValue.add(new String(ch, start, length)); 
    } 
  } 

  public static void main(String[] args) 
  { 
    String filename = "MyXml.xml"; 
    SAXParserFactory spf = SAXParserFactory.newInstance(); 
    try 
    { 
      SAXParser saxParser = spf.newSAXParser(); 
      saxParser.parse(new File(filename), new PraseXML()); 
    } 
    catch (Exception e) 
    { 
      e.printStackTrace(); 
    } 
  } 

  @SuppressWarnings("rawtypes")
public Vector getTagName() 
  { 
    return tagName; 
  } 

  @SuppressWarnings("unchecked")
public void setTagName(@SuppressWarnings("rawtypes") Vector tagName) 
  { 
    this.tagName = tagName; 
  } 

  @SuppressWarnings("rawtypes")
public Vector getTagValue() 
  { 
    return tagValue; 
  } 

  @SuppressWarnings("unchecked")
public void setTagValue(@SuppressWarnings("rawtypes") Vector tagValue) 
  { 
    this.tagValue = tagValue; 
  } 

} 