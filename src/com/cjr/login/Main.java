package com.cjr.login;

import java.awt.*;
import java.util.LinkedList;
import java.util.WeakHashMap;
import javax.swing.*;

import com.cjr.Util.*;
 
public class Main extends JFrame {
		
	private static final int GAME_WIDTH = 1100;
	private static final int GAME_HEIGTH = 600;
	public static int w = Toolkit.getDefaultToolkit().getScreenSize().width;//get the width of my screen
	public static int h = Toolkit.getDefaultToolkit().getScreenSize().height;//get the height of my screen
	
	public Main() {
		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.white);
		contentPane.setLayout(null);
		
		
		JLabel up = new JLabel("创业工程项目管理",new ImageIcon(Main.class.getResource("/images/uptip.jpg")),JLabel.NORTH_EAST);
		up.setBounds(0,0,w,150);
		contentPane.add(up);
		
		
		setTitle("创业工程项目管理");
		setSize(Toolkit.getDefaultToolkit().getScreenSize());//setfull of the screen
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(Color.black);
		setContentPane(contentPane);
		
	} 
}