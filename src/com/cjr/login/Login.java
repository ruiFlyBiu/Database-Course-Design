package com.cjr.login;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.cjr.Util.*;

import java.sql.*;

/**
 * �û���¼
 * @author �¼���
 *
 */
public class Login extends JFrame{
	private JPanel contentPane;
	private JButton btn1,btn2,btn3;
	private JTextField userName;
	private JPasswordField password;
	private JLabel label1,label2;
	
	private int LOGIN_WIDTH=360;
	private int LOGIN_HEIGTH=350;
	
	
	Connection conn;
	Statement stam;
	
//    public static void getBackgroundPicture() {
//   	 JLabel bglabel=new JLabel();
//   	 ImageIcon background = new ImageIcon(Login.class.getResource("/images/bg.png"));
//   	 bglabel.setIcon(background);
//    }
	
	@SuppressWarnings("deprecation")
	public Login() {
		//�����嵽������
//		 contentPane = new JPanel();
//         contentPane.setBackground(Color.white);
//		 contentPane.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));	   	 
//		 contentPane.setLayout(null);
//		 
//		 //���ñ���
//	   	 ImageIcon background = new ImageIcon(Login.class.getResource("/images/bg.png"));
//	   	 JLabel bglabel = new JLabel(background);
//	   	 getLayeredPane().add(bglabel,new Integer(Integer.MIN_VALUE));
//	   	 bglabel.setBounds(0,0,background.getIconWidth(),background.getIconHeight());
//		 contentPane.setOpaque(false);
		
		JPanel contentPane = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon background = new ImageIcon(Login.class.getResource("/images/bg.png"));
				g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), background.getImageObserver());
			}
		};
		contentPane.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
		contentPane.setLayout(null);//set the Panel
		
		 //�˺ű�ǩ
		 label1=new JLabel("");
		 label1.setBounds(80,76, 54, 28);
		 label1.setIcon(new ImageIcon(Login.class.getResource("/images/user.png")));
		 contentPane.add(label1);

		 //�����ǩ
		 label2=new JLabel("");
		 label2.setBounds(80, 76, 54, 28);
		 label2.setIcon(new ImageIcon(Login.class.getResource("/images/psw.png"))); 	
		 contentPane.add(label2);
	
         //�˺������
		 userName=new JTextField();
		 userName.setBounds(139, 80, 161, 25);
		 contentPane.add(userName);
		 
		 //���������
		 password=new JPasswordField();
		 password.setBounds(139, 140, 161, 25);
	     contentPane.add(password);
	     
	     //��ť����¼
	     btn1=new JButton("��   ¼");
	     btn1.setBounds(95, 210, 80, 23);
	     btn1.setIcon(new ImageIcon(Login.class.getResource("/images/btn.png")));
	     btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btn1) {	 
					try {
						conn=jdbcUtil.getConnection();//��ȡ���ݿ�����
						stam= (Statement) conn.createStatement();  //����sql���ִ�ж���
						//��дsql���
						String sql="select * from tprinciple where Tid='"+userName.getText()+"'  and Password='"+password.getText()+"'     ";
					    //ִ��sql���
						ResultSet rs=stam.executeQuery(sql);
						if(rs.next()) {
					    dispose();//�رյ�ǰ����							
						new MainView();
						}		
					}catch (Exception e0) {
						e0.printStackTrace();
					}finally {
						jdbcUtil.result(conn, stam);
						
					}
				}
			}
		});
	     contentPane.add(btn1);
	     
	     //��ť���˳�
	     btn2=new JButton("��  ��");
	     btn2.setBounds(210, 210, 80, 23);
	     btn2.setIcon( new ImageIcon(Login.class.getResource("/images/btn.png")));
	     btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btn2) {
				    dispose();
				}
			}
		});  
	     contentPane.add(btn2);
	     
	     //��ť-ע��
	     btn3=new JButton("ע	��");
	     btn3.setBounds(95,240,200, 23);
	     btn3.setIcon(new ImageIcon(Login.class.getResource("/images/btn.png")));
	     btn3.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				 dispose();//�رյ�¼����
				new Register().addMan(); // ��ע�ᴰ��
				
			}
		});
	     contentPane.add(btn3);
	     
	     //���ô���
	     setTitle("Login_Windows");  //���ô������
	     Point point = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();//��ȡ��Ļ���ĵ�����
		 setBounds(point.x - LOGIN_WIDTH/ 2,point.y - LOGIN_HEIGTH/2, LOGIN_WIDTH, LOGIN_HEIGTH);  //���ô��������Լ���С
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //���ô���ɹر�
		 setResizable(true);  //���ô����С�����Ըı�
		 setVisible(true);    //���ô���ɼ�
		 
		 //���ô������ͼ��
		 setIconImage(
			Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/Wave_welcome.png"))
			);
		 setContentPane(contentPane);     
	}	
	
	//������	
	public static void main(String[] args) {
		new Login();
	}	
	}
	
