package com.alg.scholarship.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.alg.scholarship.bean.Student;
import com.alg.scholarship.dao.StudentDao;

public class StudentUpdateUI extends IndexAdmin {
	// student
	Student student;

	public StudentUpdateUI(String username, int studentid) {
		super(username);
		// Ϊtype��ֵ
		StudentDao studentDao = new StudentDao();
		// ����id��ѯ��Ϣ
		student = studentDao.findStudentById(studentid);
		// ��ʼ��
		init();
	}

	// ���������õ������
	// ��ʼ������
	Font f = new Font("����", Font.BOLD, 19);
	// ��ʼ������
	JLabel idla = new JLabel("id:");
	JLabel usernamela = new JLabel("�û���:");
	JLabel creditla = new JLabel("ѧ��:");
	JLabel gradela = new JLabel("�ɼ�:");
	JLabel statela = new JLabel("״̬:");

	JTextField id = new JTextField();
	JTextField username = new JTextField();
	JTextField credit = new JTextField();
	JTextField grade = new JTextField();
	JRadioButton radioButton1 = new JRadioButton("�ɹ�");
	JRadioButton radioButton2 = new JRadioButton("ʧ��");

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
		creditla.setBounds(100, 120, 100, 30);
		creditla.setFont(f);
		// �ɼ�
		gradela.setBounds(100, 170, 100, 30);
		gradela.setFont(f);
		// ״̬
		statela.setBounds(100, 220, 100, 30);
		statela.setFont(f);

		// ����� //���û���
		// id
		id.setBounds(230, 20, 240, 30);
		id.setFont(f);
		id.setText(String.valueOf(student.getUserId()));
		// �û���
		username.setBounds(230, 70, 240, 30);
		username.setFont(f);
		username.setText(student.getUserName());
		// ѧ��
		credit.setBounds(230, 120, 240, 30);
		credit.setFont(f);
		credit.setText(String.valueOf(student.getCredit()));
		// �ɼ�
		grade.setBounds(230, 220, 240, 30);
		grade.setFont(f);
		grade.setText(String.valueOf(student.getGrade()));
		// ״̬
		radioButton1.setBounds(230, 170, 80, 30);
		radioButton2.setBounds(330, 170, 80, 30);
		
		// ��ť
		addStudentButton.setBounds(170, 290, 180, 50);
		addStudentButton.setFont(f);
		// ���� Ĭ��
		radioButton1.setSelected(student.getState() == 1 ? true : false);
		radioButton2.setSelected(student.getState() == 0 ? true : false);

		index.add(idla);
		index.add(usernamela);
		index.add(creditla);
		index.add(gradela);
		index.add(statela);
		index.add(id);
		index.add(username);
		index.add(credit);
		index.add(grade);
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
				String creditText = credit.getText();
				int m = Integer.parseInt(creditText);
				String gradeText = grade.getText();
				int n = Integer.parseInt(gradeText);
				// ��װ��Ϣ����
				student.setUserId(i);
				student.setUserName(usernameText);
				student.setCredit(m);
				student.setGrade(n);
				if (radioButton1.isSelected()) {
					student.setState(1);
				}
				if (radioButton2.isSelected()) {
					student.setState(2);
				}

				// �޸�
				StudentDao studentDao = new StudentDao();
				int i1 = studentDao.updateStudentById(student);
				if (i1 == 1) {
					// ҳ��ת��
					index.setVisible(false);
					// �����µ�ҳ��
					new StudentSeletUI("mkx");
				}

			}
		});
	}
}
