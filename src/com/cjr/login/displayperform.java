package com.cjr.login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class displayperform extends JFrame {

	private JPanel contentPane;
	private int w= 400;
	private int h= 450;
	/**
	 * չʾ���߻����ڰ汾��
	 */
	public displayperform(String performtype) {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setVisible(true);
		setBounds((Toolkit.getDefaultToolkit().getScreenSize().width- w)/2, (Toolkit.getDefaultToolkit().getScreenSize().height- h)/2, w, h);
		contentPane = new JPanel();
		if(performtype == "author") {
			JLabel authorLabel = new JLabel();
			authorLabel.setText("<html><body><p align=\"left\">���ߣ�	��Sir<br/>ѧԺ��	��Ϣ��ѧ����ѧԺ<br/>רҵ��		�������ѧ�뼼��</p></body></html>");
			contentPane.add(authorLabel, BorderLayout.NORTH);
			authorLabel.setBackground(Color.gray);
		}
		else if (performtype == "data_vertion") {
			JLabel dvLabel = new JLabel();
			dvLabel.setText("<html><body><p align=\"left\">�汾��	1.0<br/>ϵͳ�������ڣ�	2019-12-10</p></body></html>");
			contentPane.add(dvLabel, BorderLayout.NORTH);
		}
		setContentPane(contentPane);
	}

}
