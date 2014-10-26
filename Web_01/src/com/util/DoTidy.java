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
		tidy.setXmlOut(true);		//输出的格式为XML
		tidy.setDropFontTags(true); //清除字体等修饰标签
		tidy.setDropEmptyParas(true); //清除空段落
		tidy.setFixComments(true); //修复异常连字符
		tidy.setFixBackslash(true);//要把URLs中的"/"替换为"\"
		tidy.setMakeClean(true); //否清理多余的表现标签并用style规则替换属性,以及适当调整文档结构
		tidy.setOutputEncoding("UTF8");//设置输出的字符集
		tidy.setWraplen(0);
		try {
			//获取编码方式
			BufferedInputStream encoding = new BufferedInputStream(new FileInputStream("Source.html"));
			tidy.setInputEncoding(getEncodingOfStream(encoding));
			encoding.close();
			//相关的文件
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
