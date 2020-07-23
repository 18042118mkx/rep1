package com.alg.scholarship.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.alg.scholarship.dao.AnnouncementDao;
import com.alg.scholarship.dao.StudentRoleDao;

public class StudentRoleSelectUI extends IndexAdmin{
	//��������
	private JTable  studentroleTable;
	Font f=new Font("����",Font.BOLD,20);
	Font m=new Font("����",Font.BOLD,16);
	JScrollPane jp = null;
	JButton addButton;
	JButton delButton;
	JButton updateButton;
	//sno
	int studentRoleid;
	public StudentRoleSelectUI(String username){
		super(username);
		init();
		StudentRoleaction(username);
	}
	private void StudentRoleaction(String username) {
		//���
		addButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//ҳ��ת��
				index.setVisible(false);
				//�����µ�ҳ��
				new StudentRoleAddUI(username);
			}
		});
		//�������¼�
		studentroleTable.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				//Ϊsno��ֵ
				studentRoleid = (int) studentroleTable.getValueAt(studentroleTable.getSelectedRow(), 0);
				System.out.println(studentRoleid);
			}
		});
		//ɾ����ť����¼�
		delButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//ҳ��ת��
				if (studentRoleid == 0) {
					JOptionPane.showMessageDialog(null,"��ѡ��Ҫɾ���ļ�¼! ! ! ");
				}else {
					//��ʾ
					int mess = JOptionPane.showConfirmDialog(null,"ȷ��Ҫɾ��ô? ","��ʾ��Ϣ",JOptionPane.YES_NO_OPTION);
					//mess��ȷ��1ȡ��
					if (mess == 0) {
						StudentRoleDao studentRoleDao= new StudentRoleDao();
						int del = studentRoleDao.delStudentRoleById(studentRoleid); 
						if (del==1) {
							JOptionPane.showMessageDialog(null,"ɾ���ɹ�");
							//���»���ҳ�������
							Vector tt = new Vector<>();
							tt.add("ѧ��");
							tt.add("����");
							tt.add("רҵ");
							tt.add("�ɼ�");
							tt.add("����");
							tt.add("�꼶");
							//����
							Vector list = studentRoleDao.findAllStudentRole();
							JTable table = new JTable(list,tt);
							table.setFont(m);
							JScrollPane jptable = new JScrollPane(table);
							jptable.setBounds(50,80,550,300);
							//�Ƴ��ɵ����
							index.remove(jp);
							//������齨
							index. add(jptable);
							//���»���
							index.repaint();
						}
					}	
				}
			}
		});
		//�޸�
		updateButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//ҳ��ת��
				if (studentRoleid == 0) {
					JOptionPane.showMessageDialog(null,"��ѡ��Ҫ�޸ĵļ�¼! ! ! ");
				}else {
					index.setVisible(false);
					new StudentRoleUpdateUI(username,studentRoleid);
				} 
				
			}
			
		});
	}
		
	private void init(){
		//���˵��
		JLabel title = new JLabel("ѧ����ɫ����");
		title.setFont(f);
		title.setBounds(100,20,200,50);
		//���
		addButton = new JButton("���");
		addButton.setFont(f);
		addButton.setBounds(300, 30, 90, 30);
		//ɾ��
		delButton = new JButton("ɾ��");
		delButton.setFont(f);
		delButton.setBounds(400, 30, 90, 30);
		//�޸�
		updateButton = new JButton("�޸�");
		updateButton.setFont(f);
		updateButton.setBounds(500, 30, 90, 30);
		//������
		Vector tt = new Vector<>();
		tt.add("ѧ��");
		tt.add("����");
		tt.add("רҵ");
		tt.add("�ɼ�");
		tt.add("����");
		tt.add("�꼶");
		//����
		StudentRoleDao studentRoleDao=new StudentRoleDao();
		Vector list=studentRoleDao.findAllStudentRole();
				
		System.out.println(list);
		studentroleTable=new JTable(list,tt);
		studentroleTable.setFont(m);
		jp = new JScrollPane(studentroleTable);
		jp.setBounds(50,80,550,300);
				
		index.add(title);
		index.add(jp);
		index.add(addButton);
		index.add(delButton);
		index.add(updateButton);
	}
	

}