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

import com.alg.scholarship.dao.StudentDao;


public class StudentSeletUI extends IndexAdmin{

	public StudentSeletUI(String username) {
		super(username);
		init();
		scholarshipaction(username);
	}
	// ��������
		private JTable scholarshipTable;
		Font f = new Font("����", Font.BOLD, 20);
		Font m = new Font("����", Font.BOLD, 16);

		// ������� ��ȡ��������
		JScrollPane jp = null;

		JButton addButton;
		JButton delButton;
		JButton updateButton;
		// id
		int scholarshipid;

		private void scholarshipaction(String username) {
			// ��Ӱ�ť
			addButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// ҳ��ת��
					index.setVisible(false);
					// �����µ�ҳ��
					new StudentAddUI(username);
				}
			});
			// �������¼�
			scholarshipTable.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					// Ϊid��ֵ
					scholarshipid = (int) scholarshipTable.getValueAt(
							scholarshipTable.getSelectedRow(), 0);
					System.out.println(scholarshipid);
				};
			});
			// ɾ����ť
			delButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// ҳ��ת��
					if (scholarshipid == 0) {
						JOptionPane.showMessageDialog(null, "��ѡ��Ҫɾ���ļ�¼��");
					} else {
						// ��ʾ
						int mess = JOptionPane.showConfirmDialog(null, "ȷ��Ҫɾ����",
								"��ʾ��Ϣ", JOptionPane.YES_NO_OPTION);
						// mess 0ȷ�� 1ȡ��
						if (mess == 0) {
							StudentDao scholarshipDao = new StudentDao();
							int del = scholarshipDao
									.delStudentById(scholarshipid);
							if (del == 1) {
								JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
								// ���»���ҳ�� ������
								Vector tt = new Vector<>();
								tt.add("id");
								tt.add("��ѧ������");
								tt.add("���");
								tt.add("��ѧ������");
								tt.add("����");
								tt.add("�걨����");
								tt.add("�ɹ�����");

								// ����
								Vector list = scholarshipDao.findAllStudent();

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
					if (scholarshipid == 0) {
						JOptionPane.showMessageDialog(null, "��ѡ��Ҫ�޸ĵļ�¼��");
					} else {
						index.setVisible(false);
						new StudentUpdateUI(username, scholarshipid);
					}
				}
			});
		}

		private void init() {
			// ���˵��
			JLabel title = new JLabel("ѧ������");
			title.setFont(f);
			title.setBounds(200, 20, 200, 50);
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
			// ������
			Vector tt = new Vector<>();
			tt.add("id");
			tt.add("�û���");
			tt.add("ѧ��");
			tt.add("�ɼ�");
			tt.add("״̬");

			// ����
			StudentDao studentDao = new StudentDao();
			Vector list = studentDao.findAllStudent();

			scholarshipTable = new JTable(list, tt);
			scholarshipTable.setFont(m);
			jp = new JScrollPane(scholarshipTable);
			jp.setBounds(50, 60, 650, 300);

			index.add(title);
			index.add(jp);
			index.add(addButton);
			index.add(delButton);
			index.add(updateButton);
		}
}
