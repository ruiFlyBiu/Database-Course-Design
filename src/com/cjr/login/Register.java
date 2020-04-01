package com.cjr.login;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.cjr.Util.jdbcUtil;
/**
 * �û�ע��
 * @author ���Ϻ�
 *
 */
 
public class Register  extends JFrame {
  
	  private int LOGIN_WIDTH=360;
	  private int LOGIN_HEIGTH=350;
	  private JPanel contentPane;
	  private JTextField userName;
	  private JPasswordField password;
	  private JButton btn3,btn4;
	  private JLabel label3,label4;
	  Connection conn;
	  Statement stam;
	  
	  
       public void addMan() {
      	   
//      	   //��ӱ���
//      	   JLabel pglabel = new JLabel();
//      	   ImageIcon background = new ImageIcon(Login.class.getResource("/images/bg.png"));
//      	   pglabel.setIcon(background);
//      	   pglabel.setBounds(0,0,background.getIconWidth(),background.getIconHeight());
//      	   getLayeredPane().add(pglabel,new Integer(Integer.MIN_VALUE));
//      	   contentPane.setOpaque(false);
//      	    
//  		   contentPane = new JPanel();
//           contentPane.setBackground(Color.WHITE);
//  		   contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//  	   	   setContentPane(contentPane);
//  		   contentPane.setLayout(null);
      	   
      	   JLabel contentPane = new JLabel() {
      		   public void paintComponent(Graphics g) {
      			   super.paintComponent(g);
      			   ImageIcon background = new ImageIcon(Register.class.getResource("/images/pg.png"));
      			   g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), background.getImageObserver());
      		   }
      	   };
      	   contentPane.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
      	   contentPane.setLayout(null);
      	   
  		   
  		//�˺ű�ǩ
  		 label3=new JLabel("");
  		 label3.setBounds(80,76, 54, 28);
  		 label3.setIcon(new ImageIcon(Login.class.getResource("/images/user.png")));
  		 contentPane.add(label3);
  		 	 
  		 //�����ǩ
  		 label4=new JLabel("");
  		 label4.setBounds(80, 135, 54, 28);
  		 label4.setIcon(new ImageIcon(Login.class.getResource("/images/psw.png")));
  		 contentPane.add(label4);
  	
           //�˺������
  		 userName=new JTextField();
  		 userName.setBounds(139, 80, 161, 25);
  		 contentPane.add(userName);
  		 
  		 //���������
  		 password=new JPasswordField();
  		 password.setBounds(139, 140, 161, 25);
  	     contentPane.add(password);
  		   
  	     btn3=new JButton("��   ¼");
	     btn3.setBounds(95, 210, 80, 23);
	     btn3.setIcon(new ImageIcon(Login.class.getResource("/images/btn.png")));
  		 btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource()==btn3) {
					try {
						
						//�������ݿ�����
						conn=jdbcUtil.getConnection();
						//����ִ��sql���Ķ���
						stam=conn.createStatement();
						//��дsql���
						String sql="insert into tourist values('"+userName.getText()+"','"+password.getPassword()+"')";
						//ִ��sql���
						stam.execute(sql);
						JOptionPane.showMessageDialog(null, "ע��ɹ�!");
						dispose();  //�ر�ע�ᴰ��
					    new Login();  //�򿪵�¼����
						
						
					}catch (Exception e1) {
						e1.printStackTrace();
					}finally {
						jdbcUtil.result(conn, stam);
					}
				}
				
			}
		});
	     contentPane.add(btn3);
  		  
  		 btn4=new JButton("��  ��");
	     btn4.setBounds(210, 210, 80, 23);
	     btn4.setIcon( new ImageIcon(Login.class.getResource("/images/btn.png")));
	     btn4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {			
				if(e.getSource()==btn4) {				  
				    dispose();
				}
			}
		});
	     contentPane.add(btn4);
	     
	     
    	   setTitle("ע��");
    	   Point point = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();//��ȡ��Ļ���ĵ�����
    	   setBounds(point.x-LOGIN_WIDTH/2,point.y-LOGIN_HEIGTH/2, LOGIN_WIDTH, LOGIN_HEIGTH	);
    	   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	   setResizable(true);
    	   setVisible(true);
    	   //���ô������ͼ��
    	   setIconImage(
  			Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/Wave_welcome.png"))	 	 
  				 );
    	   setContentPane(contentPane);
	}
}
