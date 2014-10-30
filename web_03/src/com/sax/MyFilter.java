package com.sax;

import org.xml.sax.*;
import org.xml.sax.helpers.*;

public class MyFilter extends XMLFilterImpl {
	
   private String currentElement;
   
   public MyFilter( XMLReader parent ) {
      super(parent);
   }
   /**
    * 
    **/
   public void startElement( String namespaceURI, String localName,String fullName, Attributes attributes ) throws SAXException {
         
	   currentElement = localName;
	   Boolean flag = !localName.equals("h1") && !localName.equals("h2") && !localName.equals("h3") && !localName.equals("h4") &&
			          !localName.equals("frameset") && !localName.equals("b") && !localName.equals("strong") && !localName.equals("i") &&
			          !localName.equals("em") && !localName.equals("u") && !localName.equals("font") && !localName.equals("hr") &&
			          !localName.equals("br") && !localName.equals("p") && !localName.equals("center") && !localName.equals("img") &&
			          !localName.equals("form") && !localName.equals("a") && !localName.equals("code") && !localName.equals("comment") &&
			          !localName.equals("DIR") && !localName.equals("dl") && !localName.equals("em") && !localName.equals("html") &&
			          !localName.equals("menu") && !localName.equals("input") && !localName.equals("li") && !localName.equals("script") &&
			          !localName.equals("meta") && !localName.equals("title") && !localName.equals("ul") && !localName.equals("var") &&
			          !localName.equals("div") && !localName.equals("span") && !localName.equals("textarea") && !localName.equals("head") &&
			          !localName.equals("option") && !localName.equals("link") && !localName.equals("style") && !localName.equals("base") &&
			          !localName.equals("body") && !localName.equals("select") && !localName.equals("thead") && !localName.equals("th") &&
			          !localName.equals("iframe") && !localName.equals("") && !localName.equals("") && !localName.equals("") &&
			          !localName.equals("dd") && !localName.equals("dt") && !localName.equals("") && !localName.equals("") &&
			          !localName.equals("label") && !localName.equals("") && !localName.equals("") && !localName.equals("") &&
			          !localName.equals("") && !localName.equals("") && !localName.equals("") && !localName.equals("");
       if (flag) {
           super.startElement(namespaceURI, localName, fullName, attributes);
         }
      }
   /**
    *
    **/
   public void endElement(String namespaceURI, String localName, String fullName) throws SAXException {
       Boolean filterTag = !localName.equals("h1") && !localName.equals("h2") && !localName.equals("h3") && !localName.equals("h4") &&
		          !localName.equals("frameset") && !localName.equals("b") && !localName.equals("strong") && !localName.equals("i") &&
		          !localName.equals("em") && !localName.equals("u") && !localName.equals("font") && !localName.equals("hr") &&
		          !localName.equals("br") && !localName.equals("p") && !localName.equals("center") && !localName.equals("img") &&
		          !localName.equals("form") && !localName.equals("a") && !localName.equals("code") && !localName.equals("comment") &&
		          !localName.equals("DIR") && !localName.equals("dl") && !localName.equals("em") && !localName.equals("html") &&
		          !localName.equals("menu") && !localName.equals("input") && !localName.equals("li") && !localName.equals("script") &&
		          !localName.equals("meta") && !localName.equals("title") && !localName.equals("ul") && !localName.equals("var") &&
		          !localName.equals("div") && !localName.equals("span") && !localName.equals("textarea") && !localName.equals("head") &&
		          !localName.equals("option") && !localName.equals("link") && !localName.equals("base") && !localName.equals("th") &&
		          !localName.equals("body") && !localName.equals("select") && !localName.equals("thead") && !localName.equals("style")&&
		          !localName.equals("iframe") && !localName.equals("dt") && !localName.equals("") && !localName.equals("") &&
		          !localName.equals("dd") && !localName.equals("") && !localName.equals("") && !localName.equals("") &&
		          !localName.equals("") && !localName.equals("") && !localName.equals("") && !localName.equals("") &&
		          !localName.equals("label") && !localName.equals("") && !localName.equals("") && !localName.equals("");
	   if ( filterTag ) {
            super.endElement(namespaceURI, localName, fullName);
         }
    }
   /**
    *
    **/
    public void characters(char[] buffer, int start, int length) throws SAXException {
    	Boolean flag = !currentElement.equals("h1") && !currentElement.equals("h2") && !currentElement.equals("h3") && !currentElement.equals("h4") &&
		          !currentElement.equals("frameset") && !currentElement.equals("b") && !currentElement.equals("strong") && !currentElement.equals("i") &&
		          !currentElement.equals("em") && !currentElement.equals("u") && !currentElement.equals("font") && !currentElement.equals("hr") &&
		          !currentElement.equals("br") && !currentElement.equals("p") && !currentElement.equals("center") && !currentElement.equals("img") &&
		          !currentElement.equals("form") && !currentElement.equals("a") && !currentElement.equals("code") && !currentElement.equals("comment") &&
		          !currentElement.equals("DIR") && !currentElement.equals("dl") && !currentElement.equals("em") && !currentElement.equals("html") &&
		          !currentElement.equals("menu") && !currentElement.equals("input") && !currentElement.equals("li") && !currentElement.equals("script") &&
		          !currentElement.equals("meta") && !currentElement.equals("title") && !currentElement.equals("ul") && !currentElement.equals("var") &&
		          !currentElement.equals("div") && !currentElement.equals("span") && !currentElement.equals("textarea") && !currentElement.equals("head") &&
		          !currentElement.equals("option") && !currentElement.equals("select") && !currentElement.equals("base") && !currentElement.equals("thead") &&
		          !currentElement.equals("body") && !currentElement.equals("link") && !currentElement.equals("style") && !currentElement.equals("th") &&
		          !currentElement.equals("iframe") && !currentElement.equals("") && !currentElement.equals("") && !currentElement.equals("dt") &&
		          !currentElement.equals("dd") && !currentElement.equals("") && !currentElement.equals("") && !currentElement.equals("") &&
		          !currentElement.equals("label") && !currentElement.equals("") && !currentElement.equals("") && !currentElement.equals("") &&
		          !currentElement.equals("") && !currentElement.equals("") && !currentElement.equals("") && !currentElement.equals("");
    	if (flag) {
          super.characters( buffer,start,length );
        }
    }
}
