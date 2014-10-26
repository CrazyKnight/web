package com.javausr.saxexample;

import org.xml.sax.*;
import org.xml.sax.helpers.*;

public class MyFilter extends XMLFilterImpl {
	
   private String currentElement;
   
   public MyFilter( XMLReader parent ) {
      super(parent);
   }
   /**
    * ���˵�Ԫ��<�����鼮>�Ŀ�ʼ�¼�
    **/
   public void startElement( String namespaceURI, String localName,String fullName, Attributes attributes ) throws SAXException {
         
	   currentElement = localName;
	   
       if ( !localName.equals("�����鼮") && !localName.equals("�ҵ����")  ) {
           super.startElement(namespaceURI, localName, fullName, attributes);
         }
      }
   /**
    * ���˵�Ԫ��<�����鼮>�Ľ����¼�
    **/
   public void endElement(String namespaceURI, String localName, String fullName) throws SAXException {
       Boolean filterTag = !localName.equals("�����鼮") && !localName.equals("�ҵ����");
	   if ( filterTag ) {
            super.endElement(namespaceURI, localName, fullName);
         }
    }
   /**
    * ���˵�Ԫ��<�����鼮>�е�����
    **/
    public void characters(char[] buffer, int start, int length) throws SAXException {
        if ( !currentElement.equals("�����鼮") && !currentElement.equals("�ҵ����")) {
          super.characters( buffer,start,length );
        }
    }
}
