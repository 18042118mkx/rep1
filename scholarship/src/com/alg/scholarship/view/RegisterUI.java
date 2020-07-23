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

	// 类中声明用到的组件
	// 初始化字体
	Font d = new Font("楷体", Font.BOLD, 42);
	Font f = new Font("楷体", Font.BOLD, 25);
	// 初始化对象
	JFrame registerui = new JFrame("用户注册界面");
	JLabel system = new JLabel("困难生奖学金管理系统");
	JLabel usernamela = new JLabel("用户名:");
	JLabel passwordla = new JLabel("密码:");
	JLabel usertypela = new JLabel("角色:");

	JTextField username = new JTextField();
	JPasswordField password = new JPasswordField();
	JRadioButton radioButton1=new JRadioButton("学生");
	JRadioButton radioButton2=new JRadioButton("教师");
	//按钮组
	ButtonGroup btButtonGroup;
	JButton register = new JButton("注册");

	User user = new User();

	private void registerUi() {
		// 设置x y w h
		registerui.setBounds(800, 310, 650, 500);
		// 设置退出
		registerui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		registerui.setVisible(true);
		// 绝对布局
		registerui.setLayout(null);
		// 系统名称
		system.setBounds(110, 65, 600, 40);
		system.setFont(d);
		// 用户名
		usernamela.setBounds(120, 150, 100, 30);
		usernamela.setFont(f);
		// 密码
		passwordla.setBounds(120, 210, 100, 30);
		passwordla.setFont(f);
		usertypela.setBounds(120, 270, 100, 30);
		usertypela.setFont(f);
		
		// 输入框
		username.setBounds(250, 150, 200, 30);
		username.setFont(f);
		password.setBounds(250, 210, 200, 30);
		password.setFont(f);
		radioButton1.setBounds(250, 270, 80, 30);
		radioButton2.setBounds(350, 270, 80, 30);
		// 按钮
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
		//用户类型
		btButtonGroup=new ButtonGroup();
		btButtonGroup.add(radioButton1);
		btButtonGroup.add(radioButton2);
		radioButton1.setSelected(true);
		
		// 登录
		register.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 获取用户名密码
				String usernameText = username.getText();
				char[] p = password.getPassword();
				String passwordText = new String(p);
				
				user.setUserName(usernameText);
				user.setPassWord(passwordText);
				//角色
				if(radioButton1.isSelected()){
					user.setUserType(0);
				}
				if(radioButton2.isSelected()){
					user.setUserType(1);
				}
				// 根据 用户名密码 验证
				UserDao userDao = new UserDao();
				//添加用户
				int i = userDao.saveUser(user);
				if(i==1){
					JOptionPane.showMessageDialog(null, "注册成功，请登录");
					new LoginUI();
				}
			}
		});
	}

	
}
