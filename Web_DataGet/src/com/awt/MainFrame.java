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

import com.bean.DBdata;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private JPanel panel = new JPanel();

	private JMenuBar menuBar = new JMenuBar();
	private JMenu FileMenu = new JMenu("File");
	private JMenu DataOPMenu = new JMenu("数据操作");

	private JMenuItem OpenFileItem = new JMenuItem("Open");
	private JMenuItem showData = new JMenuItem("显示数据");

	private JFileChooser chooser = new JFileChooser();
	int returnVal;

	public MainFrame() {
		setTitle("Web数据抽取");
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
				chooser.setDialogTitle("请选择html文件");
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

class JdbcDialog extends JDialog {

	private JTextField username;
	private JTextField password;
	private JTextField dbname;
	private JTextField Tblname;

	public JdbcDialog(final JFrame owner) {
		super(owner, "输入数据库相关信息", true);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 2));

		panel.add(new JLabel("用户名："));
		panel.add(username = new JTextField(""));
		panel.add(new JLabel("密码："));
		panel.add(password = new JTextField(""));
		panel.add(new JLabel("数据库名"));
		panel.add(dbname = new JTextField(""));
		panel.add(new JLabel("表名"));
		panel.add(Tblname = new JTextField(""));
		add(panel, BorderLayout.CENTER);
		setSize(250, 150);

		JButton okJButton = new JButton("ok");
		okJButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {
				
				/*
				 * 这个data就是那个保存该对话框信息的对象，访问数据库的操作要用到这个信息
				 */
				DBdata data = new DBdata();
				data.setUsername(username.getText());
				data.setPassword(password.getText());
				data.setDBname(dbname.getText());
				data.setTblname(Tblname.getText());
				showData s = new showData(owner);
			}

		});
		JButton cancelButton = new JButton("cancel");

		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(okJButton);
		buttonPanel.add(cancelButton);
		add(buttonPanel, BorderLayout.SOUTH);

	}
}
class showData extends JDialog{
	public showData(JFrame owner){
		super(owner, "数据显示", true);
		JPanel panel = new JPanel();
		add(panel);
		setSize(300,300);
		setVisible(true);
	}
}
