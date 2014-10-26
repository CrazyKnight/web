package com.javausr.saxexample;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.SAXException;
public class MyErrorHandler implements ErrorHandler {
    public void warning( SAXParseException exception ) {
        System.out.println("*******WARNING******");
        System.out.println("\t行:\t" + exception.getLineNumber());
        System.out.println("\t列:\t" + exception.getColumnNumber());
        System.out.println("\t错误信息:\t" + exception.getMessage());
        System.out.println("********************");
    }
    public void error( SAXParseException exception ) throws SAXException{
        System.out.println("******* ERROR ******");
        System.out.println("\t行:\t" + exception.getLineNumber());
        System.out.println("\t列:\t" + exception.getColumnNumber());
        System.out.println("\t错误信息:\t" + exception.getMessage());
        System.out.println("********************");
    }
    public void fatalError( SAXParseException exception ) throws SAXException {
        System.out.println("******** FATAL ERROR ********");
        System.out.println("\t行:\t" + exception.getLineNumber());
        System.out.println("\t列:\t" + exception.getColumnNumber());
        System.out.println("\t错误信息:\t" + exception.getMessage());
        System.out.println("*****************************");
    }
}
