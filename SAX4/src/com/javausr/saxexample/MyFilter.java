package com.javausr.saxexample;

import org.xml.sax.*;
import org.xml.sax.helpers.*;

public class MyFilter extends XMLFilterImpl {
	
   private String currentElement;
   
   public MyFilter( XMLReader parent ) {
      super(parent);
   }
   /**
    * 过滤掉元素<技术书籍>的开始事件
    **/
   public void startElement( String namespaceURI, String localName,String fullName, Attributes attributes ) throws SAXException {
         
	   currentElement = localName;
	   
       if ( !localName.equals("技术书籍") && !localName.equals("我的书架")  ) {
           super.startElement(namespaceURI, localName, fullName, attributes);
         }
      }
   /**
    * 过滤掉元素<技术书籍>的结束事件
    **/
   public void endElement(String namespaceURI, String localName, String fullName) throws SAXException {
       Boolean filterTag = !localName.equals("技术书籍") && !localName.equals("我的书架");
	   if ( filterTag ) {
            super.endElement(namespaceURI, localName, fullName);
         }
    }
   /**
    * 过滤掉元素<技术书籍>中的内容
    **/
    public void characters(char[] buffer, int start, int length) throws SAXException {
        if ( !currentElement.equals("技术书籍") && !currentElement.equals("我的书架")) {
          super.characters( buffer,start,length );
        }
    }
}
