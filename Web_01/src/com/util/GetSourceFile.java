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
	        byte[] bytes = new byte[1024*2];	//��Ŷ������Ϣ��һ�ζ���1024���ֽ�
	        bin.mark(1024*2);	//��ǳ�ʼλ��,����ʧЧ������ֽ���Ϊ1024
	        int len = bin.read(bytes);
	        String encoding;
	        String encoding_tag = "<meta[^;]+;\\s*charset\\s*=\\s*([^\"\\s]+)[^>]*>";   //ʹ��������ʽƥ��charset
	        String detector = new String(bytes, 0, len, "iso8859-1");   //Ĭ����iso8859-1�����ⶪʧ��Ϣ
	        Pattern encodingPattern = Pattern.compile(encoding_tag, Pattern.CASE_INSENSITIVE);
	        Matcher m = encodingPattern.matcher(detector);
	        if (m.find()) {
	            encoding = m.group(1);	//��1��groupƥ��ľ�����Ҫ���ַ�����
	        } else {
	            encoding = "iso8859-1";	//���û�ҵ��͵���iso8859-1����
	        }
	        bin.reset();
	        return encoding;
	    }
}
