package com.cjr.login;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.cjr.Util.StringUtil;
import com.cjr.Util.jdbcUtil;
import java.sql.*;

public class manager_Add extends JPanel {
	private JTextField MidText;
	private JTextField MpasswordText;
	private JTextField MmailText;
	private JTextField MphoneText;
	private Connection con;
	private Statement stam;
	/**
	 * Create the panel.
	 */
	public manager_Add() {
		setBackground(Color.GRAY);
		
		JLabel Mid_Label = new JLabel("\u7BA1\u7406\u5458\u8D26\u53F7\uFF1A");
		Mid_Label.setForeground(Color.CYAN);
		Mid_Label.setFont(new Font("宋体", Font.BOLD, 25));
		
		MidText = new JTextField();
		MidText.setColumns(10);
		
		JLabel Mpassword_Label = new JLabel("  \u5BC6  \u7801 \uFF1A");
		Mpassword_Label.setFont(new Font("宋体", Font.BOLD, 25));
		Mpassword_Label.setForeground(Color.CYAN);
		
		MpasswordText = new JTextField();
		MpasswordText.setColumns(10);
		
		JLabel Mmail_Label = new JLabel("  \u90AE  \u7BB1 \uFF1A");
		Mmail_Label.setFont(new Font("宋体", Font.BOLD, 25));
		Mmail_Label.setForeground(Color.CYAN);
		
		MmailText = new JTextField();
		MmailText.setColumns(10);
		
		JLabel Mphone_Label = new JLabel("\u8054\u7CFB\u7535\u8BDD \uFF1A");
		Mphone_Label.setFont(new Font("宋体", Font.BOLD, 25));
		Mphone_Label.setForeground(Color.CYAN);
		
		MphoneText = new JTextField();
		MphoneText.setColumns(10);
		
		JButton Mok_Button = new JButton("\u6DFB   \u52A0");
		Mok_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Mokperform(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		Mok_Button.setFont(new Font("宋体", Font.BOLD, 25));
		Mok_Button.setForeground(Color.CYAN);
		
		JButton Mreset_Button = new JButton("\u91CD   \u7F6E");
		Mreset_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mresetperform(e);
			}
		});
		Mreset_Button.setFont(new Font("宋体", Font.BOLD, 25));
		Mreset_Button.setForeground(Color.CYAN);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(90)
					.addComponent(Mid_Label, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addComponent(MidText, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(95)
					.addComponent(Mpassword_Label, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addGap(40)
					.addComponent(MpasswordText, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(95)
					.addComponent(Mmail_Label, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addGap(40)
					.addComponent(MmailText, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(96)
					.addComponent(Mphone_Label, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addGap(42)
					.addComponent(MphoneText, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(106)
					.addComponent(Mok_Button)
					.addGap(209)
					.addComponent(Mreset_Button))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(90)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(Mid_Label)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(MidText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(65)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(Mpassword_Label)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(MpasswordText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(65)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(Mmail_Label)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(MmailText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(65)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(Mphone_Label)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(MphoneText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(65)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(Mok_Button)
						.addComponent(Mreset_Button)))
		);
		setLayout(groupLayout);

	}
	
	/*
	 *按钮重置 
	 */
	private void Mresetperform(ActionEvent evt) {
		// TODO Auto-generated method stub
		resetValue();
	}
	/*
	 * 重置TextField
	 */
	private void resetValue() {
		this.MidText.setText("");
		this.MpasswordText.setText("");
		this.MmailText.setText("");
		this.MphoneText.setText("");
	}

	/*
	 * 添加管理员
	 */
	private void Mokperform(ActionEvent evt){
		String Mid = MidText.getText();
		String MpassWord = MpasswordText.getText();
		String Mmail = MmailText.getText();
		String Mphone = MphoneText.getText();
		try {
			if(StringUtil.isEmpty(Mid)) {
				JOptionPane.showMessageDialog(null, "管理员账号不能为空！");
				return;
			}
			if(StringUtil.isEmpty(MpassWord)) {
				JOptionPane.showMessageDialog(null, "管理员密码不能为空！");
				return;
			}
			if(StringUtil.isEmpty(Mmail)) {
				JOptionPane.showMessageDialog(null, "管理员邮箱不能为空！");
				return;
			}
			if(StringUtil.isEmpty(Mphone)) {
				JOptionPane.showMessageDialog(null, "管理员联系方式不能为空！");
				return;
			}
			
			String sql = "insert into manager values(?,?,?,?)";
			Connection con = jdbcUtil.getConnection();
			PreparedStatement stam = con.prepareStatement(sql);
			stam.setString(1, Mid);
			stam.setString(2, MpassWord);
			stam.setString(3, Mmail);
			stam.setString(4, Mphone);
			
			int i = stam.executeUpdate();
			if(i == 1) {
				JOptionPane.showMessageDialog(null, "添加管理员成功！");
				this.resetValue();
			}
			else {
				JOptionPane.showMessageDialog(null, "添加管理员失败！");
				return;
			}
		}catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "添加管理员失败！");
		}finally {
			jdbcUtil.result(con, stam);
		}
	}
	
	/*
	 * test
	 */
//	public static void main(String[] args) {
//		JFrame j = new JFrame();
//		j.setVisible(true);
//		j.setSize(Toolkit.getDefaultToolkit().getScreenSize());
//		j.setLocation(0,0);
//		manager_Add m = new manager_Add();
//		j.add(m);
//	}
}
