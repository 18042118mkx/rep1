package com.alg.scholarship.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.*;

import com.alg.scholarship.dao.InformationDao;

public class InformationUI extends IndexAdmin {
	// ��������
	private JTable informationTable;
	Font f = new Font("����", Font.BOLD, 20);
	Font m = new Font("����", Font.BOLD, 16);

	// ������� ��ȡ��������
	JScrollPane jp = null;

	JButton addButton;
	JButton delButton;
	JButton updateButton;
	// id
	int informationid;

	public InformationUI(String username) {
		super(username);
		init();
		informationaction(username);
	}

	private void informationaction(String username) {
		// ��Ӱ�ť
		addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// ҳ��ת��
				index.setVisible(false);
				// �����µ�ҳ��
				new InformationAddUI(username);
			}
		});
		// �������¼�
		informationTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// Ϊid��ֵ
				informationid = (int) informationTable.getValueAt(
						informationTable.getSelectedRow(), 0);
				System.out.println(informationid);
			};
		});
		// ɾ����ť
		delButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ҳ��ת��
				if (informationid == 0) {
					JOptionPane.showMessageDialog(null, "��ѡ��Ҫɾ���ļ�¼��");
				} else {
					// ��ʾ
					int mess = JOptionPane.showConfirmDialog(null, "ȷ��Ҫɾ����",
							"��ʾ��Ϣ", JOptionPane.YES_NO_OPTION);
					// mess 0ȷ�� 1ȡ��
					if (mess == 0) {
						InformationDao informationDao = new InformationDao();
						int del = informationDao
								.delInformationById(informationid);
						if (del == 1) {
							JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
							// ���»���ҳ�� ������
							Vector tt = new Vector<>();
							tt.add("id");
							tt.add("�û���");
							tt.add("����");
							tt.add("�û�����");
							tt.add("�绰");
							tt.add("�༶");
							tt.add("סַ");
							tt.add("��ʦ");

							// ����
							Vector list = informationDao.findAllInformation();

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
				if (informationid == 0) {
					JOptionPane.showMessageDialog(null, "��ѡ��Ҫ�޸ĵļ�¼��");
				} else {
					index.setVisible(false);
					new InformationUpdateUI(username,informationid);
				}
			}
		});
	}

	private void init() {
		// ���˵��
		JLabel title = new JLabel("����Ա������Ϣ");
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
		tt.add("����");
		tt.add("�û�����");
		tt.add("�绰");
		tt.add("�༶");
		tt.add("סַ");
		tt.add("��ʦ");

		// ����
		InformationDao informationDao = new InformationDao();
		Vector list = informationDao.findAllInformation();

		informationTable = new JTable(list, tt);
		informationTable.setFont(m);
		jp = new JScrollPane(informationTable);
		jp.setBounds(50, 60, 650, 300);

		index.add(title);
		index.add(jp);
		index.add(addButton);
		index.add(delButton);
		index.add(updateButton);
	}

}
