package com.awt;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.bean.DBdata;
import com.sax.SAXParse;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private JPanel panel = new JPanel();

	private JMenuBar menuBar = new JMenuBar();
	private JMenu FileMenu = new JMenu("File");
	private JMenu DataOPMenu = new JMenu("���ݲ���");

	private JMenuItem OpenFileItem = new JMenuItem("Open");
	private JMenuItem showDB = new JMenuItem("��ʾ���ݿ�");
	private JMenuItem showResult = new JMenuItem("��ʾ�������");

	private JFileChooser chooser = new JFileChooser();
	private JTextField url = new JTextField();

	int returnVal;

	public MainFrame() {
		setTitle("Web��ҳ���ݳ�ȡ");
		setSize(400, 400);
		setJMenuBar(menuBar);
		// panel.setBackground(Color.white);
		panel.setLayout(new GridLayout(1, 2));
		panel.add(new JLabel("������ַ��", SwingConstants.CENTER));
		panel.add(url);

		menuBar.add(FileMenu);
		menuBar.add(DataOPMenu);

		FileMenu.add(OpenFileItem);
		DataOPMenu.add(showDB);
		DataOPMenu.add(showResult);

		OpenFileItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				FileNameExtensionFilter filter = new FileNameExtensionFilter(
						"HTML file", "html", "xml");
				chooser.setFileFilter(filter);
				chooser.setDialogTitle("��ѡ��html�ļ�");
				returnVal = chooser.showOpenDialog(null);
			}
		});

		showDB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JdbcDialog dialog = new JdbcDialog(MainFrame.this);
				dialog.setVisible(true);
			}
		});

		showResult.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				CshowResult s = new CshowResult(MainFrame.this);
			}

		});
		add(panel, BorderLayout.NORTH);

		JPanel ButtonPanel = new JPanel();
		JButton commit = new JButton("�ύ");
		commit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				String Myurl = url.getText();
				SAXParse sax = new SAXParse();
				boolean isSuc = sax.DoSAX(Myurl);
				if (isSuc) {
					new showError("��ȡ�ɹ�");
				} else {
					new showError("��ַ��ʽ�������������룡");
				}
			}
		});
		ButtonPanel.add(commit);
		add(ButtonPanel, BorderLayout.CENTER);
	}

	File getSelectedFile() {
		if (JFileChooser.APPROVE_OPTION == returnVal)
			return chooser.getSelectedFile();
		return null;
	}
}

@SuppressWarnings("serial")
class showError extends JDialog {
	public showError(String s){
		super();
		setSize(200,200);
		JPanel panel = new JPanel();
		add(panel);
		panel.add(new JLabel(s),BorderLayout.CENTER);
		setVisible(true);
	}
}

@SuppressWarnings("serial")
class JdbcDialog extends JDialog {

	private JTextField username;
	private JTextField password;
	private JTextField dbname;
	private JTextField Tblname;

	public JdbcDialog(final JFrame owner) {
		super(owner, "�������ݿ������Ϣ", true);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 2));

		panel.add(new JLabel("�û�����"));
		panel.add(username = new JTextField(""));
		panel.add(new JLabel("���룺"));
		panel.add(password = new JTextField(""));
		panel.add(new JLabel("���ݿ���"));
		panel.add(dbname = new JTextField(""));
		panel.add(new JLabel("����"));
		panel.add(Tblname = new JTextField(""));
		add(panel, BorderLayout.CENTER);
		setSize(250, 150);

		JButton okJButton = new JButton("ok");
		okJButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {

				/*
				 * ���data�����Ǹ�����öԻ�����Ϣ�Ķ��󣬷������ݿ�Ĳ���Ҫ�õ������Ϣ
				 */
				DBdata data = new DBdata();
				data.setUsername(username.getText());
				data.setPassword(password.getText());
				data.setDBname(dbname.getText());
				data.setTblname(Tblname.getText());
				@SuppressWarnings("unused")
				CshowDB s = new CshowDB(owner);
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

@SuppressWarnings("serial")
class CshowDB extends JDialog {
	public CshowDB(JFrame owner) {
		super(owner, "������ʾ", true);
		JPanel panel = new JPanel();
		add(panel);
		setSize(400, 400);
		setVisible(true);
	}
}

@SuppressWarnings("serial")
class CshowResult extends JDialog {

	JTextArea showText;

	@SuppressWarnings("resource")
	public CshowResult(JFrame owner) {
		super(owner, "���������ʾ", true);
		String text = new String("");
		showText = new JTextArea();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(
					"result.txt")));
			while ((text = reader.readLine()) != null) {
				text += "\n";
				showText.append(text);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		showText.setEditable(false);
		JScrollPane panel = new JScrollPane(showText);
		add(panel);
		setSize(300, 300);
		setVisible(true);

	}
}
