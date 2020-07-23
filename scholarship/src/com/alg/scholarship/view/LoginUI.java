package com.alg.scholarship.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.alg.scholarship.bean.User;
import com.alg.scholarship.dao.UserDao;

public class LoginUI {
	// 类中声明用到的组件
	// 初始化字体
	Font d = new Font("楷体", Font.BOLD, 42);
	Font f = new Font("楷体", Font.BOLD, 25);
	// 初始化对象
	JFrame loginui = new JFrame("用户登录界面");
	JLabel system = new JLabel("困难生奖学金管理系统");
	JLabel usernamela = new JLabel("用户名:");
	JLabel passwordla = new JLabel("密码:");
	JLabel usertypela = new JLabel("角色:");

	JTextField username = new JTextField();
	JPasswordField password = new JPasswordField();
	JComboBox<String> usertype = new JComboBox<>(new String[] { "学生", "教师" });
	JButton login = new JButton("登录");
	JButton register = new JButton("注册");

	User user = new User();

	//构造
	public LoginUI() {
		super();
		loginUi();
	}

	private void loginUi() {
		// 设置x y w h
		loginui.setBounds(800, 310, 650, 500);
		// 设置退出
		loginui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		loginui.setVisible(true);
		// 绝对布局
		loginui.setLayout(null);
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
		usertype.setBounds(250, 270, 200, 30);
		usertype.setFont(f);
		// 按钮
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

		// 添加事件
		usertype.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox j = (JComboBox) e.getSource();
				if (j.getSelectedItem().equals("学生")) {
					user.setUserType(0);
				} else {
					user.setUserType(1);
				}
			}
		});
		// 登录
		login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 获取用户名密码
				String usernameText = username.getText();
				char[] p = password.getPassword();
				String passwordText = new String(p);
				// 判断
				if (usernameText.trim().equals("")) {
					// 提示
					 JOptionPane.showMessageDialog(null,"用户名不能为空");
				}
				// 存入到 user
				user.setUserName(usernameText);
				user.setPassWord(passwordText);
				// 根据 用户名密码 验证
				UserDao userDao = new UserDao();
				// 校验
				Boolean u = userDao.checkUser(user);
			    if (!u) {
//				if (u) {
					// 提示
					JOptionPane.showMessageDialog(null, "用户名或者密码错误");
					username.setText("");
					password.setText("");
				} else {
					// 设置页面隐藏
					loginui.setVisible(false);
					// 构建新的页面 传入用户名
					new IndexAdmin("mkx");
				}
			}
		});
		//注册
		register.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				loginui.setVisible(false);
				// 构建新的页面 传入用户名
				new RegisterUI();
			}
		});
	}


	// 程序的入口
	public static void main(String[] args) {
		LoginUI login = new LoginUI();
		login.loginUi();

	}

}
