package com.alg.scholarship.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.alg.scholarship.bean.DifficultStudents;
import com.alg.scholarship.dao.DifficultStudentsDao;

public class DifficultStudentsUpdateUI extends IndexAdmin{
	// student
	DifficultStudents difficultStudents;

		public DifficultStudentsUpdateUI(String username, int difficultStudentsid) {
			super(username);
			// Ϊtype��ֵ
			DifficultStudentsDao difficultStudentsDao = new DifficultStudentsDao();
			// ����id��ѯ��Ϣ
			difficultStudents = difficultStudentsDao.findDifficultstudentsById(difficultStudentsid);
			// ��ʼ��
			init();
		}

		// ���������õ������
		// ��ʼ������
		Font f = new Font("����", Font.BOLD, 19);
		// ��ʼ������
		JLabel idla = new JLabel("id:");
		JLabel usernamela = new JLabel("�û���:");
		JLabel classnamela = new JLabel("�༶:");
		JLabel telephonela = new JLabel("�绰:");
		JLabel typela = new JLabel("���������:");

		JTextField id = new JTextField();
		JTextField username = new JTextField();
		JTextField classname = new JTextField();
		JTextField telephone = new JTextField();
		JRadioButton radioButton1 = new JRadioButton("0");
		JRadioButton radioButton2 = new JRadioButton("1");

		// ��ť��
		ButtonGroup btButtonGroup = new ButtonGroup();
		JButton addStudentButton = new JButton("�޸�");

		private void init() {
			// ��ť��
			ButtonGroup btButtonGroup = new ButtonGroup();
			btButtonGroup.add(radioButton1);
			btButtonGroup.add(radioButton2);
			// id
			idla.setBounds(100, 20, 100, 30);
			idla.setFont(f);
			// �û���
			usernamela.setBounds(100, 70, 100, 30);
			usernamela.setFont(f);
			// ѧ��
			classnamela.setBounds(100, 120, 100, 30);
			classnamela.setFont(f);
			// �ɼ�
			telephonela.setBounds(100, 170, 100, 30);
			telephonela.setFont(f);
			// ״̬
			typela.setBounds(100, 220, 130, 30);
			typela.setFont(f);

			// ����� //���û���
			// id
			id.setBounds(230, 20, 240, 30);
			id.setFont(f);
			id.setText(String.valueOf(difficultStudents.getId()));
			// �û���
			username.setBounds(230, 70, 240, 30);
			username.setFont(f);
			username.setText(difficultStudents.getUsername());
			// ѧ��
			classname.setBounds(230, 120, 240, 30);
			classname.setFont(f);
			classname.setText(String.valueOf(difficultStudents.getClassname()));
			// �ɼ�
			telephone.setBounds(230, 170, 240, 30);
			telephone.setFont(f);
			telephone.setText(difficultStudents.getTelephone());
			// ״̬
			radioButton1.setBounds(230, 220, 80, 30);
			radioButton2.setBounds(330, 220, 80, 30);
			
			// ��ť
			addStudentButton.setBounds(170, 290, 180, 50);
			addStudentButton.setFont(f);
			// ���� Ĭ��
			radioButton1.setSelected(difficultStudents.getType() == 1 ? true : false);
			radioButton2.setSelected(difficultStudents.getType() == 0 ? true : false);

			index.add(idla);
			index.add(usernamela);
			index.add(classnamela);
			index.add(telephonela);
			index.add(typela);
			index.add(id);
			index.add(username);
			index.add(classname);
			index.add(telephone);
			index.add(radioButton1);
			index.add(radioButton2);
			index.add(addStudentButton);

			// ����¼�
			addStudentButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					String idText = id.getText();
					int i = Integer.parseInt(idText);
					String usernameText = username.getText();
					String classnameText = classname.getText();
					String telephoneText = telephone.getText();

					// ��װ��Ϣ����
					difficultStudents.setId(i);
					difficultStudents.setUsername(usernameText);
					difficultStudents.setClassname(classnameText);
					difficultStudents.setTelephone(telephoneText);
					if (radioButton1.isSelected()) {
						difficultStudents.setType(1);
					}
					if (radioButton2.isSelected()) {
						difficultStudents.setType(2);
					}


					// �޸�
					DifficultStudentsDao difficultStudentsDao = new DifficultStudentsDao();
					int i1 = difficultStudentsDao.updateDifficultstudentsById(difficultStudents);
					if (i1 == 1) {
						// ҳ��ת��
						index.setVisible(false);
						// �����µ�ҳ��
						new DifficultStudentsUI("mkx");
					}

				}
			});
		}

}
