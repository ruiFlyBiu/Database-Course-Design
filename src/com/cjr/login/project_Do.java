package com.cjr.login;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class project_Do extends JPanel {
	public JTable projectView_Table;
	public final ButtonGroup buttonGroup = new ButtonGroup();
	public JRadioButton add_RadioButton;
	public JRadioButton delete_RadioButton;
	public JRadioButton modify_RadioButton;
	public JRadioButton search_RadioButton;
	public JButton add_Button;
	public JButton delete_Button;
	public JButton modify_Button;	
	public JButton search_Button;
	public JTextField search_Text1;
	public JTextField search_Text4;
	private JLabel search_Label5;
	private JLabel search_Label6;
	private JLabel add_Label1;
	public JTextField add_Text1;
	private JLabel add_Label2;
	public JTextField add_Text2;
	private JLabel add_Label3;
	public JTextField add_Text3;
	private JLabel add_Label5;
	public JTextField add_Text5;
	private JLabel add_Label6;
	public JTextField add_Text6;
	private JLabel add_Label4;
	public JTextField add_Text4;
	public JTextField search_Text2;
	public JTextField search_Text5;
	public JTextField search_Text6;
	public JTextField search_Text3;
	public JTextField modify_Text1;
	public JTextField modify_Text2;
	public JTextField modify_Text3;
	public JTextField modify_Text4;
	/**
	 * Create the panel.
	 */
	public project_Do() {
		setBackground(Color.GRAY);
		
		JScrollPane scrollPane = new JScrollPane();
		
		projectView_Table = new JTable();
		projectView_Table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u9879\u76EE\u7F16\u53F7", "\u9879\u76EE\u540D\u79F0", "\u9879\u76EE\u7C7B\u578B", "\u8D1F\u8D23\u4EBA\u7F16\u53F7", "\u8D1F\u8D23\u4EBA\u540D\u79F0", "\u8D1F\u8D23\u4EBA\u6240\u5728\u5355\u4F4D"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		projectView_Table.getColumnModel().getColumn(5).setPreferredWidth(102);
		scrollPane.setViewportView(projectView_Table);
		
		add_RadioButton = new JRadioButton("\u589E\u52A0");
		buttonGroup.add(add_RadioButton);
		
		delete_RadioButton = new JRadioButton("\u5220\u9664");
		buttonGroup.add(delete_RadioButton);
		
		modify_RadioButton = new JRadioButton("\u4FEE\u6539");
		buttonGroup.add(modify_RadioButton);
		
		search_RadioButton = new JRadioButton("\u67E5\u8BE2");
		buttonGroup.add(search_RadioButton);
		
		delete_Button = new JButton("\u5220\u9664\u9879\u76EE");
		
		modify_Button = new JButton("\u786E\u8BA4\u4FEE\u6539");
		modify_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		search_Button = new JButton("\u67E5\u8BE2");
		
		add_Button = new JButton("\u786E\u8BA4\u6DFB\u52A0");
		add_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JLabel search_Label1 = new JLabel("\u9879\u76EE\u7F16\u53F7\uFF1A");
		search_Label1.setForeground(Color.WHITE);
		search_Label1.setFont(new Font("宋体", Font.BOLD, 15));
		
		search_Text1 = new JTextField();
		search_Text1.setColumns(10);
		
		JLabel search_Label2 = new JLabel("\u9879\u76EE\u540D\u79F0\uFF1A");
		search_Label2.setForeground(Color.WHITE);
		search_Label2.setFont(new Font("宋体", Font.BOLD, 15));
		
		JLabel search_Label4 = new JLabel("\u8D1F\u8D23\u4EBA\u7F16\u53F7\uFF1A");
		search_Label4.setForeground(Color.WHITE);
		search_Label4.setFont(new Font("宋体", Font.BOLD, 15));
		
		search_Text4 = new JTextField();
		search_Text4.setColumns(10);
		
		search_Label5 = new JLabel("\u8D1F\u8D23\u4EBA\u59D3\u540D\uFF1A");
		search_Label5.setForeground(Color.WHITE);
		search_Label5.setFont(new Font("宋体", Font.BOLD, 15));
		
		search_Label6 = new JLabel("\u8D1F\u8D23\u4EBA\u6240\u5728\u5355\u4F4D\uFF1A");
		search_Label6.setForeground(Color.WHITE);
		search_Label6.setFont(new Font("宋体", Font.BOLD, 15));
		
		add_Label1 = new JLabel("\u9879\u76EE\u7F16\u53F7\uFF1A");
		add_Label1.setForeground(Color.WHITE);
		add_Label1.setFont(new Font("宋体", Font.BOLD, 15));
		
		add_Text1 = new JTextField();
		add_Text1.setColumns(10);
		
		add_Label2 = new JLabel("\u9879\u76EE\u540D\u79F0\uFF1A");
		add_Label2.setForeground(Color.WHITE);
		add_Label2.setFont(new Font("宋体", Font.BOLD, 15));
		
		add_Text2 = new JTextField();
		add_Text2.setColumns(10);
		
		add_Label3 = new JLabel("\u9879\u76EE\u7C7B\u578B\uFF1A");
		add_Label3.setForeground(Color.WHITE);
		add_Label3.setFont(new Font("宋体", Font.BOLD, 15));
		
		add_Text3 = new JTextField();
		add_Text3.setColumns(10);
		
		add_Label5 = new JLabel("\u8D1F\u8D23\u4EBA\u59D3\u540D\uFF1A");
		add_Label5.setForeground(Color.WHITE);
		add_Label5.setFont(new Font("宋体", Font.BOLD, 15));
		
		add_Text5 = new JTextField();
		add_Text5.setColumns(10);
		
		add_Label6 = new JLabel("\u8D1F\u8D23\u4EBA\u6240\u5728\u5355\u4F4D\uFF1A");
		add_Label6.setForeground(Color.WHITE);
		add_Label6.setFont(new Font("宋体", Font.BOLD, 15));
		
		add_Text6 = new JTextField();
		add_Text6.setColumns(10);
		
		add_Label4 = new JLabel("\u8D1F\u8D23\u4EBA\u7F16\u53F7\uFF1A");
		add_Label4.setForeground(Color.WHITE);
		add_Label4.setFont(new Font("宋体", Font.BOLD, 15));
		
		add_Text4 = new JTextField();
		add_Text4.setColumns(10);
		
		search_Text2 = new JTextField();
		search_Text2.setColumns(10);
		
		search_Text5 = new JTextField();
		search_Text5.setColumns(10);
		
		search_Text6 = new JTextField();
		search_Text6.setColumns(10);
		
		JLabel search_Label3 = new JLabel("\u9879\u76EE\u7C7B\u578B\uFF1A");
		search_Label3.setForeground(Color.WHITE);
		search_Label3.setFont(new Font("宋体", Font.BOLD, 15));
		
		search_Text3 = new JTextField();
		search_Text3.setColumns(10);
		
		JLabel modify_Label1 = new JLabel("\u9879\u76EE\u540D\u79F0\uFF1A");
		modify_Label1.setForeground(Color.WHITE);
		modify_Label1.setFont(new Font("宋体", Font.BOLD, 15));
		
		modify_Text1 = new JTextField();
		modify_Text1.setColumns(10);
		
		JLabel modify_Label2 = new JLabel("\u9879\u76EE\u7C7B\u578B\uFF1A");
		modify_Label2.setForeground(Color.WHITE);
		modify_Label2.setFont(new Font("宋体", Font.BOLD, 15));
		
		modify_Text2 = new JTextField();
		modify_Text2.setColumns(10);
		
		JLabel modify_Label3 = new JLabel("\u8D1F\u8D23\u4EBA\u59D3\u540D\uFF1A");
		modify_Label3.setFont(new Font("宋体", Font.BOLD, 15));
		modify_Label3.setForeground(Color.WHITE);
		
		JLabel modify_Label4 = new JLabel("\u8D1F\u8D23\u4EBA\u6240\u5728\u5355\u4F4D\uFF1A");
		modify_Label4.setFont(new Font("宋体", Font.BOLD, 15));
		modify_Label4.setForeground(Color.WHITE);
		
		modify_Text3 = new JTextField();
		modify_Text3.setColumns(10);
		
		modify_Text4 = new JTextField();
		modify_Text4.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 715, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED, 2, Short.MAX_VALUE)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(22)
										.addComponent(add_Label5))
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(18)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(add_RadioButton)
												.addGap(18)
												.addComponent(add_Button))
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(modify_RadioButton)
												.addGap(18)
												.addComponent(modify_Button))
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(delete_RadioButton)
												.addGap(18)
												.addComponent(delete_Button))
											.addGroup(groupLayout.createSequentialGroup()
												.addGap(104)
												.addComponent(add_Text5, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
												.addGap(28)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
													.addGroup(groupLayout.createSequentialGroup()
														.addComponent(add_Label6)
														.addGap(2)
														.addComponent(add_Text6, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
													.addGroup(groupLayout.createSequentialGroup()
														.addComponent(search_Label5)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(search_Text5, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)))
												.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
											.addGroup(groupLayout.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(add_Label3)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(add_Text3, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
												.addComponent(add_Label4)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(add_Text4, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
												.addGap(27))
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(modify_Label1)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(modify_Text1, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
												.addGap(18)
												.addComponent(modify_Label2)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(modify_Text2, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE))
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(modify_Label3)
												.addGap(8)
												.addComponent(modify_Text3, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
												.addGap(23)
												.addComponent(modify_Label4)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(modify_Text4, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))))
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(17)
										.addComponent(add_Label1)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(add_Text1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
										.addGap(57)
										.addComponent(add_Label2)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(add_Text2, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)))
								.addGap(238))
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(13)
								.addComponent(search_Label6)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(search_Text6, GroupLayout.PREFERRED_SIZE, 322, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(search_Label4)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(search_Text4, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(search_RadioButton)
									.addGap(28)
									.addComponent(search_Button))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(search_Label3)
											.addGap(18)
											.addComponent(search_Text3))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(search_Label1)
											.addGap(18)
											.addComponent(search_Text1, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(search_Label2)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(search_Text2, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)))
							.addGap(266))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(add_RadioButton)
								.addComponent(add_Button))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(20)
									.addComponent(add_Label1))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(17)
									.addComponent(add_Text1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(55)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(add_Label2)
								.addComponent(add_Text2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(add_Label3)
						.addComponent(add_Text3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(add_Label4)
						.addComponent(add_Text4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(add_Label5)
						.addComponent(add_Label6)
						.addComponent(add_Text5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(add_Text6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(delete_RadioButton)
						.addComponent(delete_Button))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(modify_RadioButton)
						.addComponent(modify_Button))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(modify_Label1)
						.addComponent(modify_Text1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(modify_Label2)
						.addComponent(modify_Text2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(18)
										.addComponent(modify_Label3))
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(14)
										.addComponent(modify_Text3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(search_RadioButton)
									.addComponent(search_Button))
								.addGap(28))
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(17)
								.addComponent(modify_Label4)
								.addPreferredGap(ComponentPlacement.RELATED)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(15)
							.addComponent(modify_Text4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(search_Label1)
						.addComponent(search_Text1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(search_Label2)
						.addComponent(search_Text2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(search_Label3)
						.addComponent(search_Text3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(search_Label4)
						.addComponent(search_Text4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(search_Label5)
						.addComponent(search_Text5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(search_Text6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(search_Label6))
					.addGap(20))
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
		);
		setLayout(groupLayout);

	}
}
