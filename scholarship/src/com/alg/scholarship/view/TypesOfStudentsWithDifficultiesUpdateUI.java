package com.alg.scholarship.view;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


import com.alg.scholarship.bean.TypesOfStudentsWithDifficulties;
import com.alg.scholarship.dao.TypesOfStudentsWithDifficultiesDao;

public class TypesOfStudentsWithDifficultiesUpdateUI extends IndexAdmin{
	// student
	TypesOfStudentsWithDifficulties typesOfStudentsWithDifficulties;

		public TypesOfStudentsWithDifficultiesUpdateUI(String username, int typesOfStudentsWithDifficultiesid) {
				super(username);
				// Ϊtype��ֵ
				TypesOfStudentsWithDifficultiesDao typesOfStudentsWithDifficultiesDao = new TypesOfStudentsWithDifficultiesDao();
				// ����id��ѯ��Ϣ
				typesOfStudentsWithDifficulties = typesOfStudentsWithDifficultiesDao.findTypesOfStudentsWithDifficultiesById(typesOfStudentsWithDifficultiesid);
				// ��ʼ��
				init();
			}
		

		// ���������õ������
		// ��ʼ������
		Font f = new Font("����", Font.BOLD, 19);
		// ��ʼ������
		JLabel idla = new JLabel("id:");
		JLabel typela = new JLabel("����:");
		JLabel healthyla = new JLabel("�������:");
		JLabel incomela = new JLabel("��ͥ����:");
		JLabel regionla = new JLabel("����:");

		JTextField id = new JTextField();
		JRadioButton radioButton1 = new JRadioButton("һ��ƶ��");
		JRadioButton radioButton2 = new JRadioButton("�ر�ƶ��");
		JTextField healthy = new JTextField();
		JTextField income = new JTextField();
		JRadioButton radioButton3 = new JRadioButton("ʡ��");
		JRadioButton radioButton4 = new JRadioButton("ʡ��");

		// ��ť��
		ButtonGroup btButtonGroup = new ButtonGroup();
		JButton addStudentButton = new JButton("�޸�");

		private void init() {
			// ��ť��
			ButtonGroup btButtonGroup = new ButtonGroup();
			btButtonGroup.add(radioButton1);
			btButtonGroup.add(radioButton2);
			ButtonGroup btButtonGroup1 = new ButtonGroup();
			btButtonGroup1.add(radioButton3);
			btButtonGroup1.add(radioButton4);
			// id
			idla.setBounds(100, 20, 100, 30);
			idla.setFont(f);
			// ����
			typela.setBounds(100, 70, 100, 30);
			typela.setFont(f);
			// �������
			healthyla.setBounds(100, 120, 100, 30);
			healthyla.setFont(f);
			// ����
			incomela.setBounds(100, 170, 130, 30);
			incomela.setFont(f);
			// ����
			regionla.setBounds(100, 220, 100, 30);
			regionla.setFont(f);

			// ����� //���û���
			// id
			id.setBounds(230, 20, 240, 30);
			id.setFont(f);
			id.setText(String.valueOf(typesOfStudentsWithDifficulties.getId()));
			// ����
			radioButton1.setBounds(230, 70, 100, 30);
			radioButton2.setBounds(330, 70, 100, 30);
			
			// �������
			healthy.setBounds(230, 120, 240, 30);
			healthy.setFont(f);
			healthy.setText(typesOfStudentsWithDifficulties.getHealthy());
			// �ɼ�
			income.setBounds(230, 170, 240, 30);
			income.setFont(f);
			income.setText(String.valueOf(typesOfStudentsWithDifficulties.getIncome()));
			// ״̬
			radioButton3.setBounds(230, 220, 100, 30);
			radioButton4.setBounds(330, 220, 100, 30);
			
			// ��ť
			addStudentButton.setBounds(170, 290, 180, 50);
			addStudentButton.setFont(f);
			// ���� Ĭ��
			radioButton1.setSelected(typesOfStudentsWithDifficulties.getType() == 1 ? true : false);
			radioButton2.setSelected(typesOfStudentsWithDifficulties.getType() == 0 ? true : false);
			radioButton3.setSelected(typesOfStudentsWithDifficulties.getType() == 1 ? true : false);
			radioButton4.setSelected(typesOfStudentsWithDifficulties.getType() == 0 ? true : false);

			index.add(idla);
			index.add(typela);
			index.add(healthyla);
			index.add(incomela);
			index.add(regionla);
			index.add(id);
			index.add(healthy);
			index.add(income);
			index.add(radioButton1);
			index.add(radioButton2);
			index.add(radioButton3);
			index.add(radioButton4);
			index.add(addStudentButton);

			// ����¼�
			addStudentButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					String idText = id.getText();
					int i = Integer.parseInt(idText);
					String healthyText = healthy.getText();
					String incomeText = income.getText();
					int m = Integer.parseInt(incomeText);

					// ��װ��Ϣ����
					typesOfStudentsWithDifficulties.setId(i);
					typesOfStudentsWithDifficulties.setHealthy(healthyText);
					typesOfStudentsWithDifficulties.setIncome(m);
					if (radioButton1.isSelected()) {
						typesOfStudentsWithDifficulties.setType(1);
					}
					if (radioButton2.isSelected()) {
						typesOfStudentsWithDifficulties.setType(2);
					}
					if (radioButton3.isSelected()) {
						typesOfStudentsWithDifficulties.setRegion(1);
					}
					if (radioButton4.isSelected()) {
						typesOfStudentsWithDifficulties.setRegion(2);
					}


					// �޸�
					TypesOfStudentsWithDifficultiesDao typesOfStudentsWithDifficultiesDao = new TypesOfStudentsWithDifficultiesDao();
					int i1 = typesOfStudentsWithDifficultiesDao.updateTypesOfStudentsWithDifficultiesById(typesOfStudentsWithDifficulties);
					if (i1 == 1) {
						// ҳ��ת��
						index.setVisible(false);
						// �����µ�ҳ��
						new TypesOfStudentsWithDifficultiesUI("mkx");
					}

				}
			});
		}

}
