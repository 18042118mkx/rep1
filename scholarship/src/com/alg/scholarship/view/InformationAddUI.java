package com.alg.scholarship.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javafx.scene.control.RadioButton;

import javax.swing.*;

import com.alg.scholarship.bean.Information;
import com.alg.scholarship.dao.InformationDao;

public class InformationAddUI extends IndexAdmin {
	// ���������õ������
	// ��ʼ������
	Font f = new Font("����", Font.BOLD, 19);
	Information information = new Information();
	// ��ʼ������
	JLabel idla = new JLabel("id:");
	JLabel usernamela = new JLabel("�û���:");
	JLabel passwordla = new JLabel("����:");
	JLabel usertypela = new JLabel("�û����:");
	JLabel telephonela = new JLabel("�绰:");
	JLabel classnamela = new JLabel("�༶:");
	JLabel addressla = new JLabel("��ַ:");
	JLabel teacherla = new JLabel("��ʦ:");

	JTextField id = new JTextField();
	JTextField username = new JTextField();
	JTextField password = new JTextField();
	JRadioButton radioButton1 = new JRadioButton("ѧ��");
	JRadioButton radioButton2 = new JRadioButton("��ʦ");
	JTextField telephone = new JTextField();
	JTextField classname = new JTextField();
	JTextField address = new JTextField();
	JTextField teacher = new JTextField();

	// ��ť��
	ButtonGroup btButtonGroup = new ButtonGroup();
	JButton addInformationButton = new JButton("����");

	public InformationAddUI(String username) {
		super(username);
		init();
	}

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
		// ����
		passwordla.setBounds(100, 120, 100, 30);
		passwordla.setFont(f);
		// �û����
		usertypela.setBounds(100, 170, 100, 30);
		usertypela.setFont(f);
		// �绰
		telephonela.setBounds(100, 220, 100, 30);
		telephonela.setFont(f);
		// �༶
		classnamela.setBounds(100, 270, 100, 30);
		classnamela.setFont(f);
		// ��ַ
		addressla.setBounds(100, 320, 100, 30);
		addressla.setFont(f);
		// ��ʦ
		teacherla.setBounds(100, 370, 100, 30);
		teacherla.setFont(f);

		// �����
		// id
		id.setBounds(230, 20, 240, 30);
		id.setFont(f);
		// �û���
		username.setBounds(230, 70, 240, 30);
		username.setFont(f);
		// ����
		password.setBounds(230, 120, 240, 30);
		password.setFont(f);
		// �û����
		radioButton1.setBounds(230, 170, 80, 30);
		radioButton2.setBounds(330, 170, 80, 30);
		// �绰
		telephone.setBounds(230, 220, 240, 30);
		telephone.setFont(f);
		// �༶
		classname.setBounds(230, 270, 240, 30);
		classname.setFont(f);
		// ��ַ
		address.setBounds(230, 320, 240, 30);
		address.setFont(f);
		// ��ʦ
		teacher.setBounds(230, 370, 240, 30);
		teacher.setFont(f);
		// ��ť
		addInformationButton.setBounds(170, 420, 180, 50);
		addInformationButton.setFont(f);
		// ���� Ĭ��
		radioButton1.setSelected(true);

		index.add(idla);
		index.add(usernamela);
		index.add(passwordla);
		index.add(usertypela);
		index.add(telephonela);
		index.add(classnamela);
		index.add(addressla);
		index.add(teacherla);

		index.add(id);
		index.add(username);
		index.add(password);
		index.add(radioButton1);
		index.add(radioButton2);
		index.add(telephone);
		index.add(classname);
		index.add(address);
		index.add(teacher);
		index.add(addInformationButton);

		// ����¼�
		addInformationButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String idText = id.getText();
				int i = Integer.parseInt(idText);
				String usernameText = username.getText();
				String passwordText = password.getText();
				String addressText = address.getText();
				String classnameText = classname.getText();
				String telephoneText = telephone.getText();
				String teacherText = teacher.getText();
				// ��װ��Ϣ����
				information.setUserId(i);
				information.setUserName(usernameText);
				information.setPassWord(passwordText);
				information.setHomeAddress(addressText);
				information.setClassName(classnameText);
				information.setTelephone(telephoneText);
				information.setTeacher(teacherText);
				if (radioButton1.isSelected()) {
					information.setUserType(1);
				}
				if (radioButton2.isSelected()) {
					information.setUserType(2);
				}

				// ���
				InformationDao informationDao = new InformationDao();
				Boolean b = informationDao.addInformation(information);
				if (b) {
					// ҳ��ת��
					index.setVisible(false);
					// �����µ�ҳ��
					new InformationUI("mkx");
				}
			}
		});
	}
}
