package com.cjr.login;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.cjr.Util.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.sql.*;

/**
 * ��¼����
 * @author �¼���
 *
 */
public class LoginView extends JFrame {
	private JPanel contentPane;
	private JPasswordField passWordText;
	private JTextField userNumberText;
	private JButton login_Button;
	private JButton reset_Button;
	Connection conn;
	Statement stam;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					LoginView frame = new LoginView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginView() {
		setTitle("\u521B\u65B0\u5DE5\u7A0B\u7BA1\u7406\u767B\u5F55");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 350);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u7BA1\u7406\u5458\u767B\u9646");
		lblNewLabel.setIcon(new ImageIcon(LoginView.class.getResource("/images/login2.png")));
		lblNewLabel.setFont(new Font("����", Font.BOLD, 20));
		
		JLabel lblNewLabel_1 = new JLabel("\u8D26 \u53F7\uFF1A");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel_1.setIcon(new ImageIcon(LoginView.class.getResource("/images/user.png")));
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6 \u7801\uFF1A");
		lblNewLabel_2.setIcon(new ImageIcon(LoginView.class.getResource("/images/psw.png")));
		lblNewLabel_2.setFont(new Font("����", Font.PLAIN, 20));
		
		userNumberText = new JTextField();
		
		passWordText = new JPasswordField();
		
		login_Button = new JButton("\u767B\u5F55");
		login_Button.setBackground(Color.GRAY);
		login_Button.setIcon(new ImageIcon(LoginView.class.getResource("/images/login.png")));
		login_Button.setFont(new Font("����", Font.BOLD, 20));
		login_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginperform(e);
			}
		});
		/*
		 * ����Enter->Login�¼���failed��
		 */
		login_Button.addKeyListener(new KeyAdapter() {
			public void enterKeypressed(java.awt.event.KeyEvent e) {
				int k = e.getKeyCode();
				if(k == e.VK_ENTER) {
					login_Button.doClick();
				}
			}
		});
		reset_Button = new JButton("\u91CD\u7F6E");
		reset_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetperform(e);
			}

		});
		reset_Button.setBackground(Color.GRAY);
		reset_Button.setIcon(new ImageIcon(LoginView.class.getResource("/images/\u91CD\u7F6E.png")));
		reset_Button.setFont(new Font("����", Font.BOLD, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(109)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(134))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(58)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(login_Button)
							.addPreferredGap(ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
							.addComponent(reset_Button))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(passWordText, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
								.addComponent(userNumberText, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))))
					.addGap(47))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(48)
					.addComponent(lblNewLabel)
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(11)
							.addComponent(userNumberText))
						.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(passWordText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(login_Button)
						.addComponent(reset_Button))
					.addGap(53))
		);
		
		contentPane.setLayout(gl_contentPane);
	}
	/**
	 * ��¼�¼�
	 * @param evt
	 */
	private void loginperform(ActionEvent evt) {
		String userNumber = userNumberText.getText();
		String passWord = new String(passWordText.getPassword());
		try {
			if(StringUtil.isEmpty(userNumber)) {
				JOptionPane.showMessageDialog(null,"�˺Ų���Ϊ�գ�");
				return;
			}
			if(StringUtil.isEmpty(passWord)) {
				JOptionPane.showMessageDialog(null, "���벻��Ϊ�գ�");
				return;
			}
			conn = jdbcUtil.getConnection();
			stam =(Statement) conn.createStatement();
			/*
			 * ��֤�˺�
			 */
			String sql1 = "select Mid from manager where Mid = "+userNumber;
			ResultSet rs1 = stam.executeQuery(sql1);
			if(!rs1.next()) {
				JOptionPane.showMessageDialog(null, "����Ա�˺Ų����ڣ��������������˺�");
				return;
			}
			String sql2 = "select * from manager where Mid = '"+userNumber+"' and Mpassword = '"+passWord+"'";
			ResultSet rs2 = stam.executeQuery(sql2);
			if(rs2.next()) {
				JOptionPane.showMessageDialog(null, "��¼�ɹ���");
				dispose();
				new MainView();
			}else {
				JOptionPane.showMessageDialog(null, "����Ա���벻��ȷ����������������ȷ����");
				return;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			jdbcUtil.result(conn, stam);
		}	
	}
	/**
	 * �����¼�
	 * @param evt
	 */
	private void resetperform(ActionEvent evt) {
		this.passWordText.setText("");
		this.userNumberText.setText("");
	}
}
