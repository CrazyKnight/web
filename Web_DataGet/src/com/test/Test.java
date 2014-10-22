package com.test;

import java.awt.EventQueue;

import javax.swing.JFrame;

import com.awt.MainFrame;

public class Test {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				MainFrame frame = new MainFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}
