package com.sax;

import org.xml.sax.*;
import org.xml.sax.helpers.*;

public class MyFilter extends XMLFilterImpl {
	
   private String currentElement;
   
   public MyFilter( XMLReader parent ) {
      super(parent);
   }
   /**
    * ����
    **/
   public void startElement( String namespaceURI, String localName,String fullName, Attributes attributes ) throws SAXException {
         
	   currentElement = localName;
	   
       if (localName.equals("table")) {
           super.startElement(namespaceURI, localName, fullName, attributes);
         }
      }
   /**
    * ����
    **/
   public void endElement(String namespaceURI, String localName, String fullName) throws SAXException {
       Boolean filterTag = localName.equals("table");
	   if ( filterTag ) {
            super.endElement(namespaceURI, localName, fullName);
         }
    }
   /**
    * ����
    **/
    public void characters(char[] buffer, int start, int length) throws SAXException {
        if (currentElement.equals("table")) {
          super.characters( buffer,start,length );
        }
    }
}
