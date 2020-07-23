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

import com.alg.scholarship.dao.ScholarshipTypeDao;
import com.alg.scholarship.dao.StudentRoleDao;

public class ScholarshipTypeSelectUI extends IndexAdmin{
	//��������
	private JTable  scholarshipTypeTable;
	Font f=new Font("����",Font.BOLD,20);
	Font m=new Font("����", Font.BOLD,16);
	JScrollPane jp = null;
	JButton addButton;
	JButton delButton;
	JButton updateButton;
	//typeid
	int scholarship_id;
	public ScholarshipTypeSelectUI(String username){
		super(username);
		init();
		ScholarshipTypeaction(username);
	}
	private void ScholarshipTypeaction(String username) {
		//���
		addButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//ҳ��ת��
				index.setVisible(false);
				//�����µ�ҳ��
				new ScholarshipTypeAddUI(username);
			}
		});
		//�������¼�
		scholarshipTypeTable.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				//Ϊid��ֵ
				scholarship_id= (int) scholarshipTypeTable.getValueAt(
						scholarshipTypeTable.getSelectedRow(), 0);
				System.out.println(scholarship_id);
			}
		});
		//ɾ����ť����¼�
		delButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//ҳ��ת��
				if (scholarship_id== 0) {
					JOptionPane.showMessageDialog(null,"��ѡ��Ҫɾ���ļ�¼! ! ! ");
				}else {
					//��ʾ
					int mess = JOptionPane.showConfirmDialog(null,"ȷ��Ҫɾ��ô? ","��ʾ��Ϣ",JOptionPane.YES_NO_OPTION);
					//mess��ȷ��1ȡ��
					if (mess == 0) {
						ScholarshipTypeDao scholarshipTypeDao= new ScholarshipTypeDao();
						int del = scholarshipTypeDao.delScholarshipTypeById(scholarship_id); 
						if (del==1) {
							JOptionPane.showMessageDialog(null,"ɾ���ɹ�");
							//���»���ҳ�������
							Vector tt = new Vector<>();
							tt.add("���к�");
							tt.add("��ѧ������");
							tt.add("��ѧ������");
							tt.add("��ѧ����");
							tt.add("��ע");
							//����
							Vector list = scholarshipTypeDao.findAllScholarshipType();
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
				if (scholarship_id == 0) {
					JOptionPane.showMessageDialog(null,"��ѡ��Ҫ�޸ĵļ�¼! ! ! ");
				}else {
					index.setVisible(false);
					new ScholarshipTypeUpdateUI(username,scholarship_id);
				} 
				
			}
			
		});
		
	}
	private void init(){
		//���˵��
		JLabel title = new JLabel("��ѧ�����͹���");
		title.setFont(f);
		title.setBounds(100, 20, 200, 50);
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
		tt.add("���к�");
		tt.add("��ѧ������");
		tt.add("��ѧ������");
		tt.add("��ѧ����");
		tt.add("��ע");
		//����
		ScholarshipTypeDao scholarshiptypedao=new ScholarshipTypeDao();
		Vector list=scholarshiptypedao.findAllScholarshipType();
		
		System.out.println(list);
		scholarshipTypeTable=new JTable(list,tt);
		scholarshipTypeTable.setFont(m);
		jp = new JScrollPane(scholarshipTypeTable);
		jp.setBounds(50,80,550,300);
				
		index.add(title);
		index.add(jp);
		index.add(addButton);
		index.add(delButton);
		index.add(updateButton);
	}
	

}
