package testTidy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;


import org.w3c.tidy.Tidy;

public class Test {

    public static void main(String[] args) throws Exception {

	Tidy tidy = new Tidy();	//使用Jtidy几乎只需要用的这一个类
	
        //设置jtidy的配置文件，当然你也可以在程序根据需要中设置
	tidy.setXmlOut(true);
	tidy.setDropFontTags(true);
	tidy.setDropEmptyParas(true);
	tidy.setFixComments(true);
	tidy.setFixBackslash(true);
	tidy.setMakeClean(true);
	tidy.setOutputEncoding("utf-8");
	tidy.setInputEncoding("gb2312");

	tidy.setErrout(new PrintWriter("error.txt")); //输出错误与警告信息,默认输出到stdout
        //需要转换的文件，当然你也可以转换URL的内容
	FileInputStream in = new FileInputStream("original.html");   
	FileOutputStream out = new FileOutputStream("out.html");    //输出的文件
	tidy.parse(in, out);	//开始转换了~~~Jtidy把所有东西都封装好了，哈哈~~
	out.close();	//转换完成关闭输入输出流
	in.close();
    }
}



