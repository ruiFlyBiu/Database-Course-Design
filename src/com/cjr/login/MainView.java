package com.cjr.login;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import com.cjr.login.displayperform;

import java.sql.*;
import java.util.Vector;

import com.cjr.Util.jdbcUtil;
import com.cjr.Util.StringUtil;

/**
 * ������
 * @author �¼���
 *
 */
public class MainView extends JFrame {
	private JPanel contentPane;
	private manager_Add ma;
	private manager_view mv;
	private project_Do pd;
	private String modifypid;
	private String modifytid;
	public MainView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainView.class.getResource("/images/Wave_welcome.png")));
		setTitle("���¹��̹���ϵͳ");
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setVisible(true);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u9879\u76EE\u7BA1\u7406");
		mnNewMenu.setIcon(new ImageIcon(MainView.class.getResource("/images/manage2.png")));
		menuBar.add(mnNewMenu);
		
		JMenuItem menuItem = new JMenuItem("\u8FDB\u5165");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				projectDoperformed(e);
			}
		});
		menuItem.setIcon(new ImageIcon(MainView.class.getResource("/images/in.png")));
		mnNewMenu.add(menuItem);
		
		JMenu mnNewMenu_2 = new JMenu("\u7BA1\u7406\u5458\u7BA1\u7406");
		mnNewMenu_2.setIcon(new ImageIcon(MainView.class.getResource("/images/generator.png")));
		mnNewMenu_2.setSelectedIcon(new ImageIcon(MainView.class.getResource("/images/add.png")));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u7BA1\u7406\u5458\u4FE1\u606F");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				managerViewperform(e);
			}
		});
		mntmNewMenuItem_2.setIcon(new ImageIcon(MainView.class.getResource("/images/manager.png")));
		mnNewMenu_2.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u65B0\u589E\u7BA1\u7406\u5458");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addmanagerperform(e);
			}
		});
		mntmNewMenuItem_3.setIcon(new ImageIcon(MainView.class.getResource("/images/add3.png")));
		mnNewMenu_2.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_3 = new JMenu("\u5173\u4E8E");
		mnNewMenu_3.setIcon(new ImageIcon(MainView.class.getResource("/images/about.png")));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem Author = new JMenuItem("\u4F5C\u8005");
		Author.setIcon(new ImageIcon(MainView.class.getResource("/images/author.png")));
		Author.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayperform(e);
			}
		});
		mnNewMenu_3.add(Author);
		
		JMenuItem data_vertion = new JMenuItem("\u65E5\u671F\u7248\u672C");
		data_vertion.setIcon(new ImageIcon(MainView.class.getResource("/images/data_vertion.png")));
		data_vertion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayperform_2(e);
			}
		});
		mnNewMenu_3.add(data_vertion);
		
		contentPane  = new JPanel();
		contentPane.setBackground(Color.white);
		getContentPane().add(contentPane, BorderLayout.CENTER);
		contentPane.setVisible(true);
	}
	/*
	 * ����Ŀ�������
	 */
	private void projectDoperformed(ActionEvent evt) {
		pd = new project_Do();
		getContentPane().removeAll();
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(pd);
		revalidate();
		repaint();
		/*
		 * ����RadioButton����
		 */
		pd.add_RadioButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == pd.add_RadioButton) {
					pd.add_Button.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e1) {
							addActionPerformed(e1);
//							return;
						}
					});
				}
			}
		});
		pd.delete_RadioButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == pd.delete_RadioButton) {
					pd.delete_Button.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e2) {
							// TODO Auto-generated method stub
							deleteActionPerfomed(e2);
//							return;
						}
					});
				}
			}
		});
		pd.modify_RadioButton.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == pd.modify_RadioButton) {
					/*
					 * �ȳ��ּ����޸ĵ�����
					 */
					pd.projectView_Table.addMouseListener(new MouseListener() {
						
						@Override
						public void mouseClicked(MouseEvent arg0) {
							// TODO Auto-generated method stub
							JTable table = pd.projectView_Table;
							modifypid = (String) table.getValueAt(table.getSelectedRow(), 0);
							modifytid = (String) table.getValueAt(table.getSelectedColumn(), 3);
							String sql1 = "select project.pname,project.ptype from project where project.pid="+modifypid+";";
							String sql2 = "select tprinciple.tname,tprinciple.tcom from tprinciple where tprinciple.tid="+modifytid+";";
							System.out.println(sql1);
							Connection conn = null;
							try {
								conn = jdbcUtil.getConnection();
								Statement stam = conn.createStatement();
								
								ResultSet rs1 = stam.executeQuery(sql1);
								ResultSet rs2 = stam.executeQuery(sql2);
								
//								pd.modify_Text1.setText("��֯ѧ");
//								pd.modify_Text2.setText("���ʿγ�");
//								pd.modify_Text3.setText("����");
//								pd.modify_Text4.setText("ҽѧԺ");
								
							}catch(Exception ep) {
								ep.printStackTrace();
								System.out.println("�޷��޸ģ�");
							}finally {
								jdbcUtil.result(conn);
							}
						}

						@Override
						public void mouseEntered(MouseEvent arg0) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void mouseExited(MouseEvent arg0) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void mousePressed(MouseEvent arg0) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void mouseReleased(MouseEvent arg0) {
							// TODO Auto-generated method stub
							
						}
					});
					pd.modify_Button.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e3) {
							// TODO Auto-generated method stub
							modifyActionPerformed(e3);
							JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
							
						}
					});
				}
			}
		});
		pd.search_RadioButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e4) {
				// TODO Auto-generated method stub
				pd.search_Button.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e4) {
						// TODO Auto-generated method stub
						searchActionPerformed(e4);
					}
				});
			}
		});
	}
	
	/*
	 * ����Button����
	 */
	
	/*
	 * ��ӷ���
	 */
	private void addActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		DefaultTableModel dtm = (DefaultTableModel) pd.projectView_Table.getModel();
		dtm.setRowCount(0);
		Connection conn = null;
		
		String Pid = pd.add_Text1.getText();
		String Pname = pd.add_Text2.getText();
		String Ptype = pd.add_Text3.getText();
		String Tid = pd.add_Text4.getText();
		String Tname = pd.add_Text5.getText();
		String Tcom = pd.add_Text6.getText();
		
		String sql1 = "insert into project values(?,?,?)";
		String sql2 = "insert into tprinciple values(?,?,?);";
		String sql3 = "insert into pt values(?,?);";
		try {
			conn = jdbcUtil.getConnection();
			
			PreparedStatement stam1 = conn.prepareStatement(sql1);
			stam1.setString(1, Pid);
			stam1.setString(2, Pname);
			stam1.setString(3, Ptype);
			pd.search_Button.doClick();
			PreparedStatement stam2 = conn.prepareStatement(sql2);
			stam2.setString(1, Tid);
			stam2.setString(2, Tname);
			stam2.setString(3, Tcom);
			
			PreparedStatement stam3 = conn.prepareStatement(sql3);
			stam3.setString(1, Pid);
			stam3.setString(2, Tid);	
			
			stam1.executeUpdate();
			stam2.executeUpdate();
			stam3.executeUpdate();
			JOptionPane.showMessageDialog(null, "��ӳɹ���");
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "���ʧ�ܣ�");
		}finally {
			jdbcUtil.result(conn);
			
		}
	}
	
	private void deleteActionPerfomed(ActionEvent evt) {
		// TODO Auto-generated method stub
//		int count=table.getSelectedRow();//��ȡ��ѡ�е��кţ���¼��
//		String getname= table.getValueAt(count, 1).toString();//��ȡ���ȡ�кŵ�ĳһ�е�ֵ��Ҳ�����ֶΣ�
		JTable table = pd.projectView_Table;
		String selectedPid = (String) table.getValueAt(table.getSelectedRow(), 0);
//		String sql1 = "delete from pt where PPid="+selectedPid+";";
		String sql = "delete from project where Pid="+selectedPid+";";
		Connection conn = null;
		try {
			conn = jdbcUtil.getConnection();
			Statement stam = conn.createStatement();
//			Statement stam2 = conn.createStatement()
			stam.execute(sql);
			JOptionPane.showMessageDialog(null, "ɾ���ɹ���");
		}catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ�");
		}finally {
			jdbcUtil.result(conn);
			pd.search_Button.doClick();
		}
		
		
	}
	
	private void modifyActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
//		JTable table = pd.projectView_Table;
//		String selectedPid
		String pname = pd.modify_Text1.getText();
		String ptype = pd.modify_Text2.getText();
		String tname = pd.modify_Text3.getText();
		String tcom = pd.modify_Text4.getText();
		
		String sql1 = "update project set pname=\""+pname+"\",ptype=\""+ptype+"\" where pid="+modifypid+";";
		
		String sql2 = "update tprinciple set tname=\""+tname+"\",tcom=\""+tcom+"\" where tid ="+modifytid+";";
		
		Connection conn = null;
		try {
			conn = jdbcUtil.getConnection();
			Statement stam = conn.createStatement();
			
			stam.execute(sql1);
			stam.execute(sql2);
			System.out.println(sql2);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			jdbcUtil.result(conn);
			pd.search_Button.doClick();
		}
	}
	/*
	 * ��ѯ����
	 */
	private void searchActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		DefaultTableModel dtm = (DefaultTableModel) pd.projectView_Table.getModel();
		dtm.setRowCount(0);
		Connection conn = null;
		String sql = "select project.pid,project.pname,project.ptype,tprinciple.tid,tprinciple.tname,tprinciple.tcom "
				+ "from project,tprinciple,pt "
				+ "where project.pid=pt.ppid and tprinciple.tid=pt.ttid";
		String sql1 = " and project.pid like \"%"+pd.search_Text1.getText()+"%\"";
		String sql2 = " and project.pname like \"%"+pd.search_Text2.getText()+"%\"";
		String sql3 = " and project.ptype like \"%"+pd.search_Text3.getText()+"%\"";
		String sql4 = " and tprinciple.tid like \"%"+pd.search_Text4.getText()+"%\"";
		String sql5 = " and tprinciple.tname like \"%"+pd.search_Text5.getText()+"%\"";
		String sql6 = " and tprinciple.tcom like \"%"+pd.search_Text6.getText()+"%\"";
		if(StringUtil.isNotEmpty(pd.search_Text1.getText())) {
			sql = sql+sql1;
		}
		if(StringUtil.isNotEmpty(pd.search_Text2.getText())) {
			sql = sql+sql2;
//			System.out.println(sql);
		}
		if(StringUtil.isNotEmpty(pd.search_Text3.getText())) {
			sql = sql+sql3;
		}
		if(StringUtil.isNotEmpty(pd.search_Text4.getText())) {
			sql = sql+sql4;
		}
		if(StringUtil.isNotEmpty(pd.search_Text5.getText())) {
			sql = sql+sql5;
		}
		if(StringUtil.isNotEmpty(pd.search_Text6.getText())) {
			sql = sql+sql6;
		}
		sql = sql+";";
//		System.out.println(sql);
		try {
			conn = jdbcUtil.getConnection();
			PreparedStatement stam = conn.prepareStatement(sql);
			ResultSet rs = stam.executeQuery();
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("Pid"));
				v.add(rs.getString("Pname"));
				v.add(rs.getString("Ptype"));
				v.add(rs.getString("Tid"));
				v.add(rs.getString("Tname"));
				v.add(rs.getString("Tcom"));			
				dtm.addRow(v);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			jdbcUtil.result(conn);
		} 
	}
	/*
	 * ˢ�±��
	 */
//	private 
	/*
	 * �鿴����Ա��Ϣ
	 */
	private void managerViewperform(ActionEvent evt) {
			mv = new manager_view();
			getContentPane().removeAll();
			getContentPane().setLayout(new BorderLayout(0, 0));
			getContentPane().add(mv);
			revalidate();
			repaint();
			/*
			 * ����ť�¼�
			 */
			mv.add_Button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					addmanagerperform(e);
				}
			});
	}
	/*
	 * ���ӹ���Ա
	 */
	private void addmanagerperform(ActionEvent evt) {
		ma = new manager_Add();
		getContentPane().removeAll();
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(ma);
		revalidate();
		repaint();
		return;
	}
	/*
	 * չ�������ڰ汾��ҳ��
	 */
	private void displayperform_2(ActionEvent e) {
		displayperform dv = new displayperform("data_vertion");
		dv.setAlwaysOnTop(true);
	}
	/*
	 * չ�������ߡ�ҳ��
	 */
	private void displayperform(ActionEvent evt) {
		displayperform at = new displayperform("author");
		at.setAlwaysOnTop(true);
	}
}