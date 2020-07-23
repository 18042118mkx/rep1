package com.alg.scholarship.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.alg.scholarship.bean.User;
import com.alg.scholarship.dao.UserDao;

public class LoginUI {
	// ���������õ������
	// ��ʼ������
	Font d = new Font("����", Font.BOLD, 42);
	Font f = new Font("����", Font.BOLD, 25);
	// ��ʼ������
	JFrame loginui = new JFrame("�û���¼����");
	JLabel system = new JLabel("��������ѧ�����ϵͳ");
	JLabel usernamela = new JLabel("�û���:");
	JLabel passwordla = new JLabel("����:");
	JLabel usertypela = new JLabel("��ɫ:");

	JTextField username = new JTextField();
	JPasswordField password = new JPasswordField();
	JComboBox<String> usertype = new JComboBox<>(new String[] { "ѧ��", "��ʦ" });
	JButton login = new JButton("��¼");
	JButton register = new JButton("ע��");

	User user = new User();

	//����
	public LoginUI() {
		super();
		loginUi();
	}

	private void loginUi() {
		// ����x y w h
		loginui.setBounds(800, 310, 650, 500);
		// �����˳�
		loginui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		loginui.setVisible(true);
		// ���Բ���
		loginui.setLayout(null);
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
		usertype.setBounds(250, 270, 200, 30);
		usertype.setFont(f);
		// ��ť
		login.setBounds(110, 350, 140, 50);
		login.setFont(f);
		register.setBounds(330, 350, 140, 50);
		register.setFont(f);

		loginui.add(system);
		loginui.add(usernamela);
		loginui.add(passwordla);
		loginui.add(usertypela);
		loginui.add(username);
		loginui.add(password);
		loginui.add(usertype);
		loginui.add(login);
		loginui.add(register);

		// ����¼�
		usertype.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox j = (JComboBox) e.getSource();
				if (j.getSelectedItem().equals("ѧ��")) {
					user.setUserType(0);
				} else {
					user.setUserType(1);
				}
			}
		});
		// ��¼
		login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// ��ȡ�û�������
				String usernameText = username.getText();
				char[] p = password.getPassword();
				String passwordText = new String(p);
				// �ж�
				if (usernameText.trim().equals("")) {
					// ��ʾ
					 JOptionPane.showMessageDialog(null,"�û�������Ϊ��");
				}
				// ���뵽 user
				user.setUserName(usernameText);
				user.setPassWord(passwordText);
				// ���� �û������� ��֤
				UserDao userDao = new UserDao();
				// У��
				Boolean u = userDao.checkUser(user);
			    if (!u) {
//				if (u) {
					// ��ʾ
					JOptionPane.showMessageDialog(null, "�û��������������");
					username.setText("");
					password.setText("");
				} else {
					// ����ҳ������
					loginui.setVisible(false);
					// �����µ�ҳ�� �����û���
					new IndexAdmin("mkx");
				}
			}
		});
		//ע��
		register.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				loginui.setVisible(false);
				// �����µ�ҳ�� �����û���
				new RegisterUI();
			}
		});
	}


	// ��������
	public static void main(String[] args) {
		LoginUI login = new LoginUI();
		login.loginUi();

	}

}
