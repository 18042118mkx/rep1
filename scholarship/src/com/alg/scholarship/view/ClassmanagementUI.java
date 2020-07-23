package com.alg.scholarship.view;

import java.awt.Font;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.alg.scholarship.dao.ClassmanagementDao;



public class ClassmanagementUI extends IndexAdmin{
	public ClassmanagementUI(String username) {
			super(username);
			init();
			classmanagementaction(username);
		}
	
		//��������
		private JTable classmanagementTable;
		Font f=new Font("����",Font.BOLD,20);
		Font m=new Font("����", Font.BOLD,16);
		
		// ������� ��ȡ��������
		JScrollPane jp = null;

		JButton addButton;
		JButton delButton;
		JButton updateButton;
		// id
		int classmanagementid;

		

		private void classmanagementaction(String username) {
			// ��Ӱ�ť
			addButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// ҳ��ת��
					index.setVisible(false);
					// �����µ�ҳ��
					new ClassmanagementAddUI(username);
				}
			});
			// �������¼�
			classmanagementTable.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					// Ϊid��ֵ
					classmanagementid = (int) classmanagementTable.getValueAt(
							classmanagementTable.getSelectedRow(), 0);
					System.out.println(classmanagementid);
				};
			});
			// ɾ����ť
			delButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// ҳ��ת��
					if (classmanagementid == 0) {
						JOptionPane.showMessageDialog(null, "��ѡ��Ҫɾ���ļ�¼��");
					} else {
						// ��ʾ
						int mess = JOptionPane.showConfirmDialog(null, "ȷ��Ҫɾ����",
								"��ʾ��Ϣ", JOptionPane.YES_NO_OPTION);
						// mess 0ȷ�� 1ȡ��
						if (mess == 0) {
							ClassmanagementDao classmanagementDao = new ClassmanagementDao();
							int del = classmanagementDao
									.delclassmanagementById(classmanagementid);
							if (del == 1) {
								JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
								// ���»���ҳ�� ������
								Vector tt = new Vector<>();
								tt.add("id");
								tt.add("�༶");
								tt.add("����");
								tt.add("״̬");
								tt.add("������");

								// ����
								Vector list = classmanagementDao.findAllClassmanagement();

								JTable table = new JTable(list, tt);
								table.setFont(m);
								JScrollPane jptable = new JScrollPane(table);
								jptable.setBounds(50, 60, 650, 300);
								// �Ƴ��ɵ����
								index.remove(jp);
								// ��������
								index.add(jptable);
								// ���»���
								index.repaint();

							}
						}
					}
				}
			});
			// �޸�
			updateButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// ҳ��ת��
					if (classmanagementid == 0) {
						JOptionPane.showMessageDialog(null, "��ѡ��Ҫ�޸ĵļ�¼��");
					} else {
						index.setVisible(false);
						new ClassmanagementUpdateUI(username,classmanagementid);
					}
				}
			});
		}
		
		private void init(){
			        //���˵��
			        JLabel title = new JLabel("�༶����");
					title.setFont(f);
					title.setBounds(200, 30, 200, 50);
					// ��Ӱ�ť
					addButton = new JButton("���");
					addButton.setFont(f);
					addButton.setBounds(400, 30, 90, 30);
					// ɾ����ť
					delButton = new JButton("ɾ��");
					delButton.setFont(f);
					delButton.setBounds(500, 30, 90, 30);
					// �޸İ�ť
					updateButton = new JButton("�޸�");
					updateButton.setFont(f);
					updateButton.setBounds(600, 30, 90, 30);

					//������
					Vector tt = new Vector<>();
					tt.add("id");
					tt.add("�༶");
					tt.add("����");
					tt.add("״̬");
					tt.add("������");
					//����
					ClassmanagementDao classmanagementDao=new ClassmanagementDao();
					Vector list=classmanagementDao.findAllClassmanagement();
					
					System.out.println(list);
					classmanagementTable=new JTable(list,tt);
					classmanagementTable.setFont(m);
					jp = new JScrollPane(classmanagementTable);
					jp.setBounds(50,80,550,300);
					
					index.add(title);
					index.add(jp);
					index.add(addButton);
					index.add(delButton);
					index.add(updateButton);
		}
		

	
}