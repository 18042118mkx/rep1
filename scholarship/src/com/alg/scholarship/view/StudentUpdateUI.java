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
		// 为type赋值
		StudentDao studentDao = new StudentDao();
		// 根据id查询信息
		student = studentDao.findStudentById(studentid);
		// 初始化
		init();
	}

	// 类中声明用到的组件
	// 初始化字体
	Font f = new Font("楷体", Font.BOLD, 19);
	// 初始化对象
	JLabel idla = new JLabel("id:");
	JLabel usernamela = new JLabel("用户名:");
	JLabel creditla = new JLabel("学分:");
	JLabel gradela = new JLabel("成绩:");
	JLabel statela = new JLabel("状态:");

	JTextField id = new JTextField();
	JTextField username = new JTextField();
	JTextField credit = new JTextField();
	JTextField grade = new JTextField();
	JRadioButton radioButton1 = new JRadioButton("成功");
	JRadioButton radioButton2 = new JRadioButton("失败");

	// 按钮组
	ButtonGroup btButtonGroup = new ButtonGroup();
	JButton addStudentButton = new JButton("修改");

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
		// 学分
		creditla.setBounds(100, 120, 100, 30);
		creditla.setFont(f);
		// 成绩
		gradela.setBounds(100, 170, 100, 30);
		gradela.setFont(f);
		// 状态
		statela.setBounds(100, 220, 100, 30);
		statela.setFont(f);

		// 输入框 //设置回显
		// id
		id.setBounds(230, 20, 240, 30);
		id.setFont(f);
		id.setText(String.valueOf(student.getUserId()));
		// 用户名
		username.setBounds(230, 70, 240, 30);
		username.setFont(f);
		username.setText(student.getUserName());
		// 学分
		credit.setBounds(230, 120, 240, 30);
		credit.setFont(f);
		credit.setText(String.valueOf(student.getCredit()));
		// 成绩
		grade.setBounds(230, 220, 240, 30);
		grade.setFont(f);
		grade.setText(String.valueOf(student.getGrade()));
		// 状态
		radioButton1.setBounds(230, 170, 80, 30);
		radioButton2.setBounds(330, 170, 80, 30);
		
		// 按钮
		addStudentButton.setBounds(170, 290, 180, 50);
		addStudentButton.setFont(f);
		// 设置 默认
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

		// 添加事件
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
				// 封装信息数据
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

				// 修改
				StudentDao studentDao = new StudentDao();
				int i1 = studentDao.updateStudentById(student);
				if (i1 == 1) {
					// 页面转换
					index.setVisible(false);
					// 构建新的页面
					new StudentSeletUI("mkx");
				}

			}
		});
	}
}
