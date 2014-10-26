package com.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.w3c.tidy.Tidy;

public class DoTidy {
	
	public void doTidy() {
		Tidy tidy = new Tidy();
		//tidy.setConfigurationFromFile("config.txt");
		tidy.setXmlOut(true);		//����ĸ�ʽΪXML
		tidy.setDropFontTags(true); //�����������α�ǩ
		tidy.setDropEmptyParas(true); //����ն���
		tidy.setFixComments(true); //�޸��쳣���ַ�
		tidy.setFixBackslash(true);//Ҫ��URLs�е�"/"�滻Ϊ"\"
		tidy.setMakeClean(true); //���������ı��ֱ�ǩ����style�����滻����,�Լ��ʵ������ĵ��ṹ
		tidy.setOutputEncoding("UTF8");//����������ַ���
		tidy.setWraplen(0);
		try {
			//��ȡ���뷽ʽ
			BufferedInputStream encoding = new BufferedInputStream(new FileInputStream("Source.html"));
			tidy.setInputEncoding(getEncodingOfStream(encoding));
			encoding.close();
			//��ص��ļ�
			tidy.setErrout(new PrintWriter("error.txt"));
			FileInputStream in = new FileInputStream("Source.html");
			FileOutputStream out = new FileOutputStream("out.xml");
			
			tidy.parse(in,out);
			out.close();
			in.close();
			//tidy.getConfiguration().printConfigOptions(new PrintWriter(System.out), true);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
