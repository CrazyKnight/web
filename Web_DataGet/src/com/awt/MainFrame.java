package com.awt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private JPanel panel = new JPanel();

	private JMenuBar menuBar = new JMenuBar();
	private JMenu FileMenu = new JMenu("File");
	private JMenu DataOPMenu = new JMenu("���ݲ���");

	private JMenuItem OpenFileItem = new JMenuItem("Open");
	private JMenuItem showData = new JMenuItem("��ʾ����");

	private JFileChooser chooser = new JFileChooser();
	int returnVal;

	public MainFrame() {
		setTitle("Web���ݳ�ȡ");
		setSize(600, 400);
		setJMenuBar(menuBar);
		panel.setBackground(Color.white);

		menuBar.add(FileMenu);
		menuBar.add(DataOPMenu);

		FileMenu.add(OpenFileItem);
		DataOPMenu.add(showData);

		OpenFileItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				FileNameExtensionFilter filter = new FileNameExtensionFilter(
						"HTML file", "html", "jsp");
				chooser.setFileFilter(filter);
				chooser.setDialogTitle("��ѡ��html�ļ�");
				returnVal = chooser.showOpenDialog(null);
			}
		});

		showData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JdbcDialog dialog = new JdbcDialog(MainFrame.this);
				dialog.setVisible(true);
			}
		});
		add(panel);
	}

	File getSelectedFile() {
		if (chooser.APPROVE_OPTION == returnVal)
			return chooser.getSelectedFile();
		return null;
	}
}
class JdbcDialog extends JDialog{
	
	private JTextField username;
	private JTextField password;
	private JTextField dbname;
	
	public JdbcDialog(JFrame owner){
		super(owner,"�������ݿ������Ϣ",true);
		JPanel panel = new JPanel();	
		panel.setLayout(new GridLayout(3,2));
		
		panel.add(new JLabel("�û�����"));
		panel.add(username = new JTextField(""));
		panel.add(new JLabel("���룺"));
		panel.add(password = new JTextField(""));
		panel.add(new JLabel("���ݿ���"));
		panel.add(dbname = new JTextField(""));
		add(panel,BorderLayout.CENTER);
		setSize(250,150);
		
		
		
		JButton okJButton = new JButton("ok");
		okJButton.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent event) {
				
			}
			
		});
		JButton cancelButton = new JButton("cancel");
		
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(okJButton);
		buttonPanel.add(cancelButton);
		add(buttonPanel,BorderLayout.SOUTH);
		
		
	}
}

