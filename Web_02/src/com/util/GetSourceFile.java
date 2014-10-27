package com.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class GetSourceFile {
	
	 String urlString;
	 String encoding;
	 
	 public GetSourceFile(String urlString) {
	  this.urlString = urlString;
	 }
	 public void run() throws Exception {

	  URL url = new URL(urlString);
	  
	  HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
	  InputStream in = urlConnection.getInputStream();
	  BufferedInputStream getEncoding = new BufferedInputStream(in);
	  encoding = getEncodingOfStream(getEncoding);
	  getEncoding.close();
	  in.close();
	  
	  HttpURLConnection urlConnection1 = (HttpURLConnection) url.openConnection();
	  InputStream in1 = urlConnection1.getInputStream();
	  BufferedReader  reader = new BufferedReader(new InputStreamReader(in1,encoding));

	  String line;
	  FileOutputStream fos = new FileOutputStream("Source.html");
	  Writer out = new OutputStreamWriter(fos,encoding);
	  
	  while ((line = reader.readLine()) != null){
		out.write(line + "\n");
		//System.out.println(line);
	  }
	  reader.close();
	  in.close();
	  out.close();
	  fos.close();	  
	 }
	 
	 public String getEncodingOfStream(BufferedInputStream bin) throws IOException {
	        byte[] bytes = new byte[1024*2];	//存放读入的信息，一次读入1024个字节
	        bin.mark(1024*2);	//标记初始位置,设标记失效的最大字节数为1024
	        int len = bin.read(bytes);
	        String encoding;
	        String encoding_tag = "<meta[^;]+;\\s*charset\\s*=\\s*([^\"\\s]+)[^>]*>";   //使用正则表达式匹配charset
	        String detector = new String(bytes, 0, len, "iso8859-1");   //默认用iso8859-1，避免丢失信息
	        Pattern encodingPattern = Pattern.compile(encoding_tag, Pattern.CASE_INSENSITIVE);
	        Matcher m = encodingPattern.matcher(detector);
	        if (m.find()) {
	            encoding = m.group(1);	//第1个group匹配的就是需要的字符编码
	        } else {
	            encoding = "iso8859-1";	//如果没找到就当做iso8859-1算了
	        }
	        bin.reset();
	        return encoding;
	    }
}
