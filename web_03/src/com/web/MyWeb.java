package com.web;

import java.awt.EventQueue;

import javax.swing.JFrame;

import com.awt.*;
//import com.sax.SAXParse;

public class MyWeb {
	
	//private static String url;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable(){
			public void run(){
				MainFrame frame = new MainFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
		//url = "http://jwc.hit.edu.cn/";
		//SAXParse sax = new SAXParse();
		//sax.DoSAX(url);
	}

}
