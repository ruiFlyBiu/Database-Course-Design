package test;
 
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import javax.swing.JRadioButton; 

public class swingtest2 extends JFrame implements ActionListener
{
	JRadioButton Tselect = new JRadioButton("��ʦ");
	JRadioButton Sselect = new JRadioButton("ѧ��");
	JButton login = new JButton("��¼");
	JButton exit = new JButton("�˳�");
	JLabel  name = new JLabel("�û�����");
	JLabel password = new JLabel("���룺"); 
	JTextField JName = new JTextField(10); //�����˺�����
	JPasswordField JPassword = new JPasswordField(10); // �������������룻
	
	public swingtest2() 
	{
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(3,3));  //3��2�е����jp�����񲼾֣�
		
		name.setHorizontalAlignment(SwingConstants.RIGHT);  //���ø�����Ķ��뷽ʽΪ���Ҷ���
		password.setHorizontalAlignment(SwingConstants.RIGHT);
		
		jp.add(Tselect);
		jp.add(name);   //�����ݼӵ����jp��
		jp.add(JName);
		jp.add(Sselect);
		jp.add(password);
		jp.add(JPassword);  
		jp.add(login);
		jp.add(exit);
		
		login.addActionListener(this); //��¼�����¼�����
		exit.addActionListener(this);	//�˳������¼�����
		
		this.add(jp,BorderLayout.CENTER);	//��������嶨�����м�
		
		this.setTitle("��¼����");
		this.setLocation(500,300);	//���ó�ʼλ��
		this.pack();  		//��ʾ��������Զ�������С
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e)  // ��ʱ����д���
	{
		if(e.getSource() == exit)
		{
			int i = JOptionPane.showConfirmDialog(null,"ȷ��Ҫ�˳���", "ȷ��", JOptionPane.YES_NO_OPTION);
			// ��ʾѡ��Ի���
			if(i == JOptionPane.YES_OPTION);
			System.exit(0);
		}
		else
		{
			if(JName.getText().equals("admin")&& String.valueOf(JPassword.getPassword()).equals("admin"))
			{
				JOptionPane.showMessageDialog(null, "��¼�ɹ�����ӭ������");
				//��ʾ��Ϣ��ʾ��
				System.exit(0);
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "�û��������������µ�¼��");
				//��ʾ��Ϣ��ʾ��
				JName.setText(""); 
				JPassword.setText("");
			}
		}
	}
	public static void main(String[] args)
	{
		JFrame.setDefaultLookAndFeelDecorated(true);
		new swingtest2();
	}
}
