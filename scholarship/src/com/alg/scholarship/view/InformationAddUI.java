package com.alg.scholarship.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javafx.scene.control.RadioButton;

import javax.swing.*;

import com.alg.scholarship.bean.Information;
import com.alg.scholarship.dao.InformationDao;

public class InformationAddUI extends IndexAdmin {
	// 类中声明用到的组件
	// 初始化字体
	Font f = new Font("楷体", Font.BOLD, 19);
	Information information = new Information();
	// 初始化对象
	JLabel idla = new JLabel("id:");
	JLabel usernamela = new JLabel("用户名:");
	JLabel passwordla = new JLabel("密码:");
	JLabel usertypela = new JLabel("用户类别:");
	JLabel telephonela = new JLabel("电话:");
	JLabel classnamela = new JLabel("班级:");
	JLabel addressla = new JLabel("地址:");
	JLabel teacherla = new JLabel("教师:");

	JTextField id = new JTextField();
	JTextField username = new JTextField();
	JTextField password = new JTextField();
	JRadioButton radioButton1 = new JRadioButton("学生");
	JRadioButton radioButton2 = new JRadioButton("教师");
	JTextField telephone = new JTextField();
	JTextField classname = new JTextField();
	JTextField address = new JTextField();
	JTextField teacher = new JTextField();

	// 按钮组
	ButtonGroup btButtonGroup = new ButtonGroup();
	JButton addInformationButton = new JButton("保存");

	public InformationAddUI(String username) {
		super(username);
		init();
	}

	private void init() {
		// 按钮组
		ButtonGroup btButtonGroup = new ButtonGroup();
		btButtonGroup.add(radioButton1);
		btButtonGroup.add(radioButton2);
		// id
		idla.setBounds(100, 20, 100, 30);
		idla.setFont(f);
		// 用户名
		usernamela.setBounds(100, 70, 100, 30);
		usernamela.setFont(f);
		// 密码
		passwordla.setBounds(100, 120, 100, 30);
		passwordla.setFont(f);
		// 用户类别
		usertypela.setBounds(100, 170, 100, 30);
		usertypela.setFont(f);
		// 电话
		telephonela.setBounds(100, 220, 100, 30);
		telephonela.setFont(f);
		// 班级
		classnamela.setBounds(100, 270, 100, 30);
		classnamela.setFont(f);
		// 地址
		addressla.setBounds(100, 320, 100, 30);
		addressla.setFont(f);
		// 教师
		teacherla.setBounds(100, 370, 100, 30);
		teacherla.setFont(f);

		// 输入框
		// id
		id.setBounds(230, 20, 240, 30);
		id.setFont(f);
		// 用户名
		username.setBounds(230, 70, 240, 30);
		username.setFont(f);
		// 密码
		password.setBounds(230, 120, 240, 30);
		password.setFont(f);
		// 用户类别
		radioButton1.setBounds(230, 170, 80, 30);
		radioButton2.setBounds(330, 170, 80, 30);
		// 电话
		telephone.setBounds(230, 220, 240, 30);
		telephone.setFont(f);
		// 班级
		classname.setBounds(230, 270, 240, 30);
		classname.setFont(f);
		// 地址
		address.setBounds(230, 320, 240, 30);
		address.setFont(f);
		// 教师
		teacher.setBounds(230, 370, 240, 30);
		teacher.setFont(f);
		// 按钮
		addInformationButton.setBounds(170, 420, 180, 50);
		addInformationButton.setFont(f);
		// 设置 默认
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

		// 添加事件
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
				// 封装信息数据
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

				// 添加
				InformationDao informationDao = new InformationDao();
				Boolean b = informationDao.addInformation(information);
				if (b) {
					// 页面转换
					index.setVisible(false);
					// 构建新的页面
					new InformationUI("mkx");
				}
			}
		});
	}
}
