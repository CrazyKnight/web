package com.javausr.saxexample;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class MyContentHandler implements ContentHandler {
	/**
	 * StringBuffer 可以对字符串进行增删查改而不生成新的对象，在内存上的性能要优于String类
	 */
    private StringBuffer buf;
    /**
     * 设置一个可以定位文档内容事件发生位置的定位器对象
     */
    public void setDocumentLocator( Locator locator ) {
    }
    /**
     * 用于处理文档解析开始事件
     */
    public void startDocument() throws SAXException {
    	
        buf=new StringBuffer();
        System.out.println("*******开始解析文档*******");
    }
    /**
     * 用于处理文档解析结束事件
     */
    public void endDocument() throws SAXException {
        System.out.println("*******解析文档结束*******");
    }
    /**
     * 处理解析中产生的处理指令事件
     */
    public void processingInstruction( String target, String instruction )throws SAXException {
    }
    /**
     * 用于处理前缀映射开始事件，从参数中可以得到前缀名称以及所指向的uri
     */
    public void startPrefixMapping( String prefix, String uri ) {
          System.out.println("\n前缀映射: " + prefix +" 开始!"+ "  它的URI是:" + uri);
    }
    /**
     * 用于处理前缀映射结束事件，从参数中可以得到前缀名称
     */
    public void endPrefixMapping( String prefix ) {
          System.out.println("\n前缀映射: "+prefix+" 结束!");
    }
    /**
     * 处理元素开始事件，从参数中可以获得元素所在名称空间的uri，元素名称，属性列表等信息
     */
    public void startElement( String namespaceURI, String localName,String fullName, Attributes attributes ) throws SAXException {
        System.out.println("\n 元素: " + "["+fullName+"]" +" 开始解析!");
        // 打印出属性信息
        for ( int i = 0; i < attributes.getLength(); i++ ) {
            System.out.println("\t属性名称:" + attributes.getLocalName(i) + " 属性值:" + attributes.getValue(i));
        }
    }
    /**
     * 处理元素结束事件，从参数中可以获得元素所在名称空间的uri，元素名称等信息
     */
    public void endElement( String namespaceURI, String localName,String fullName ) throws SAXException {
        //打印出非空的元素内容并将StringBuffer清空                  
        String nullStr="";
      
        if (!buf.toString().trim().equals(nullStr)){
           System.out.println("\t内容是: " + buf.toString().trim());
        }
        //将StringBuffer清空
        buf.setLength(0);
        //打印元素解析结束信息
        System.out.println("元素: "+"["+fullName+"]"+" 解析结束!");              
    }
    /**
     * 处理元素的字符内容，从参数中可以获得内容
     */
    public void characters( char[] chars, int start, int length ) throws SAXException {
          //将元素内容累加到StringBuffer中                
          buf.append(chars,start,length);
    }
    /**
     * 处理元素的可忽略空格
     */
    public void ignorableWhitespace( char[] chars, int start, int length ) throws SAXException {
    }
    public void skippedEntity( String name ) throws SAXException {
    }
}

