package com.alg.scholarship.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.alg.scholarship.bean.User;
import com.alg.scholarship.dao.UserDao;

public class RegisterUI {
	
	public RegisterUI() {
		super();
		registerUi();
	}

	// ���������õ������
	// ��ʼ������
	Font d = new Font("����", Font.BOLD, 42);
	Font f = new Font("����", Font.BOLD, 25);
	// ��ʼ������
	JFrame registerui = new JFrame("�û�ע�����");
	JLabel system = new JLabel("��������ѧ�����ϵͳ");
	JLabel usernamela = new JLabel("�û���:");
	JLabel passwordla = new JLabel("����:");
	JLabel usertypela = new JLabel("��ɫ:");

	JTextField username = new JTextField();
	JPasswordField password = new JPasswordField();
	JRadioButton radioButton1=new JRadioButton("ѧ��");
	JRadioButton radioButton2=new JRadioButton("��ʦ");
	//��ť��
	ButtonGroup btButtonGroup;
	JButton register = new JButton("ע��");

	User user = new User();

	private void registerUi() {
		// ����x y w h
		registerui.setBounds(800, 310, 650, 500);
		// �����˳�
		registerui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		registerui.setVisible(true);
		// ���Բ���
		registerui.setLayout(null);
		// ϵͳ����
		system.setBounds(110, 65, 600, 40);
		system.setFont(d);
		// �û���
		usernamela.setBounds(120, 150, 100, 30);
		usernamela.setFont(f);
		// ����
		passwordla.setBounds(120, 210, 100, 30);
		passwordla.setFont(f);
		usertypela.setBounds(120, 270, 100, 30);
		usertypela.setFont(f);
		
		// �����
		username.setBounds(250, 150, 200, 30);
		username.setFont(f);
		password.setBounds(250, 210, 200, 30);
		password.setFont(f);
		radioButton1.setBounds(250, 270, 80, 30);
		radioButton2.setBounds(350, 270, 80, 30);
		// ��ť
		register.setBounds(120, 330, 330, 50);
		register.setFont(f);

		registerui.add(system);
		registerui.add(usernamela);
		registerui.add(passwordla);
		registerui.add(usertypela);
		registerui.add(username);
		registerui.add(password);
		registerui.add(radioButton1);
		registerui.add(radioButton2);
		registerui.add(register);
		//�û�����
		btButtonGroup=new ButtonGroup();
		btButtonGroup.add(radioButton1);
		btButtonGroup.add(radioButton2);
		radioButton1.setSelected(true);
		
		// ��¼
		register.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// ��ȡ�û�������
				String usernameText = username.getText();
				char[] p = password.getPassword();
				String passwordText = new String(p);
				
				user.setUserName(usernameText);
				user.setPassWord(passwordText);
				//��ɫ
				if(radioButton1.isSelected()){
					user.setUserType(0);
				}
				if(radioButton2.isSelected()){
					user.setUserType(1);
				}
				// ���� �û������� ��֤
				UserDao userDao = new UserDao();
				//����û�
				int i = userDao.saveUser(user);
				if(i==1){
					JOptionPane.showMessageDialog(null, "ע��ɹ������¼");
					new LoginUI();
				}
			}
		});
	}

	
}
