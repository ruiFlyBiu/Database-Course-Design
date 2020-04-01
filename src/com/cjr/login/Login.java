package com.cjr.login;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.cjr.Util.*;

import java.sql.*;

/**
 * 用户登录
 * @author 陈坚锐
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
		//添加面板到容器中
//		 contentPane = new JPanel();
//         contentPane.setBackground(Color.white);
//		 contentPane.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));	   	 
//		 contentPane.setLayout(null);
//		 
//		 //设置背景
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
		
		 //账号标签
		 label1=new JLabel("");
		 label1.setBounds(80,76, 54, 28);
		 label1.setIcon(new ImageIcon(Login.class.getResource("/images/user.png")));
		 contentPane.add(label1);

		 //密码标签
		 label2=new JLabel("");
		 label2.setBounds(80, 76, 54, 28);
		 label2.setIcon(new ImageIcon(Login.class.getResource("/images/psw.png"))); 	
		 contentPane.add(label2);
	
         //账号输入框
		 userName=new JTextField();
		 userName.setBounds(139, 80, 161, 25);
		 contentPane.add(userName);
		 
		 //密码输入框
		 password=new JPasswordField();
		 password.setBounds(139, 140, 161, 25);
	     contentPane.add(password);
	     
	     //按钮—登录
	     btn1=new JButton("登   录");
	     btn1.setBounds(95, 210, 80, 23);
	     btn1.setIcon(new ImageIcon(Login.class.getResource("/images/btn.png")));
	     btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btn1) {	 
					try {
						conn=jdbcUtil.getConnection();//获取数据库连接
						stam= (Statement) conn.createStatement();  //创建sql语句执行对象
						//编写sql语句
						String sql="select * from tprinciple where Tid='"+userName.getText()+"'  and Password='"+password.getText()+"'     ";
					    //执行sql语句
						ResultSet rs=stam.executeQuery(sql);
						if(rs.next()) {
					    dispose();//关闭当前窗口							
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
	     
	     //按钮—退出
	     btn2=new JButton("退  出");
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
	     
	     //按钮-注册
	     btn3=new JButton("注	册");
	     btn3.setBounds(95,240,200, 23);
	     btn3.setIcon(new ImageIcon(Login.class.getResource("/images/btn.png")));
	     btn3.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				 dispose();//关闭登录窗体
				new Register().addMan(); // 打开注册窗体
				
			}
		});
	     contentPane.add(btn3);
	     
	     //设置窗体
	     setTitle("Login_Windows");  //设置窗体标题
	     Point point = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();//获取屏幕中心点坐标
		 setBounds(point.x - LOGIN_WIDTH/ 2,point.y - LOGIN_HEIGTH/2, LOGIN_WIDTH, LOGIN_HEIGTH);  //设置窗体坐标以及大小
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //设置窗体可关闭
		 setResizable(true);  //设置窗体大小不可以改变
		 setVisible(true);    //设置窗体可见
		 
		 //设置窗体标题图标
		 setIconImage(
			Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/Wave_welcome.png"))
			);
		 setContentPane(contentPane);     
	}	
	
	//主函数	
	public static void main(String[] args) {
		new Login();
	}	
	}
	
