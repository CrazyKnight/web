package testTidy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;


import org.w3c.tidy.Tidy;

public class Test {

    public static void main(String[] args) throws Exception {

	Tidy tidy = new Tidy();	//ʹ��Jtidy����ֻ��Ҫ�õ���һ����
	
        //����jtidy�������ļ�����Ȼ��Ҳ�����ڳ��������Ҫ������
	tidy.setXmlOut(true);
	tidy.setDropFontTags(true);
	tidy.setDropEmptyParas(true);
	tidy.setFixComments(true);
	tidy.setFixBackslash(true);
	tidy.setMakeClean(true);
	tidy.setOutputEncoding("utf-8");
	tidy.setInputEncoding("gb2312");

	tidy.setErrout(new PrintWriter("error.txt")); //��������뾯����Ϣ,Ĭ�������stdout
        //��Ҫת�����ļ�����Ȼ��Ҳ����ת��URL������
	FileInputStream in = new FileInputStream("original.html");   
	FileOutputStream out = new FileOutputStream("out.html");    //������ļ�
	tidy.parse(in, out);	//��ʼת����~~~Jtidy�����ж�������װ���ˣ�����~~
	out.close();	//ת����ɹر����������
	in.close();
    }
}



