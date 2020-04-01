package com.cjr.login;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import com.cjr.Util.jdbcUtil;

public class manager_view extends JPanel {
	private JTable managerTable;
	private JButton delete_Button;
	public JButton add_Button;
	/**
	 * Create the panel.
	 */
	public manager_view() {
		setBackground(Color.GRAY);
		
		JScrollPane scrollPane = new JScrollPane();
		
		delete_Button = new JButton("\u5220\u9664");
		delete_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		delete_Button.setFont(new Font("宋体", Font.BOLD, 25));
		delete_Button.setForeground(Color.CYAN);
		
		add_Button = new JButton("\u589E\u6DFB");
		add_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				addManagerPerformed(e);
			}
		});
		add_Button.setForeground(Color.CYAN);
		add_Button.setFont(new Font("宋体", Font.BOLD, 25));
		
		JLabel label = new JLabel("\u7BA1\u7406\u5458\u4FE1\u606F");
		label.setBackground(Color.LIGHT_GRAY);
		label.setFont(new Font("宋体", Font.BOLD, 40));
		label.setForeground(Color.CYAN);
		
		managerTable = new JTable();
		managerTable.setFont(new Font("宋体", Font.BOLD, 15));
		managerTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7BA1\u7406\u5458\u8D26\u53F7", "\u5BC6\u7801", "\u90AE\u7BB1", "\u8054\u7CFB\u7535\u8BDD"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, true, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		managerTable.getColumnModel().getColumn(0).setPreferredWidth(76);
		managerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(managerTable);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(293)
					.addComponent(label))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(101)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 595, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(147)
					.addComponent(delete_Button)
					.addGap(314)
					.addComponent(add_Button))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(49)
					.addComponent(label)
					.addGap(41)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 316, GroupLayout.PREFERRED_SIZE)
					.addGap(69)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(delete_Button)
						.addComponent(add_Button)))
		);
		setLayout(groupLayout);
		
		fillTable();
	}

	private void fillTable() {
		DefaultTableModel dtm = (DefaultTableModel) managerTable.getModel();
		dtm.setRowCount(0);
		Connection conn = null;	
		String sql = "select * from manager";
		try {
			conn = jdbcUtil.getConnection();
			PreparedStatement stam = conn.prepareStatement(sql);
			ResultSet rs = stam.executeQuery();
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("Mid"));
				v.add(rs.getString("Mpassword"));
				v.add(rs.getString("Mail"));
				v.add(rs.getString("phonenumber"));
				dtm.addRow(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			jdbcUtil.result(conn);
		}
	}
/*
 * 实例演示	
 */
//	public static void main(String[] args) {
//		JFrame jf = new JFrame();
//		jf.setVisible(true);
//		manager_view mv = new manager_view();
//		jf.add(mv);
//		jf.setBounds(0, 0 , 400, 500);
//	}
}
