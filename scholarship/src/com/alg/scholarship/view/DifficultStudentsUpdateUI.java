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
			// 为type赋值
			DifficultStudentsDao difficultStudentsDao = new DifficultStudentsDao();
			// 根据id查询信息
			difficultStudents = difficultStudentsDao.findDifficultstudentsById(difficultStudentsid);
			// 初始化
			init();
		}

		// 类中声明用到的组件
		// 初始化字体
		Font f = new Font("楷体", Font.BOLD, 19);
		// 初始化对象
		JLabel idla = new JLabel("id:");
		JLabel usernamela = new JLabel("用户名:");
		JLabel classnamela = new JLabel("班级:");
		JLabel telephonela = new JLabel("电话:");
		JLabel typela = new JLabel("困难生类别:");

		JTextField id = new JTextField();
		JTextField username = new JTextField();
		JTextField classname = new JTextField();
		JTextField telephone = new JTextField();
		JRadioButton radioButton1 = new JRadioButton("0");
		JRadioButton radioButton2 = new JRadioButton("1");

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
			classnamela.setBounds(100, 120, 100, 30);
			classnamela.setFont(f);
			// 成绩
			telephonela.setBounds(100, 170, 100, 30);
			telephonela.setFont(f);
			// 状态
			typela.setBounds(100, 220, 130, 30);
			typela.setFont(f);

			// 输入框 //设置回显
			// id
			id.setBounds(230, 20, 240, 30);
			id.setFont(f);
			id.setText(String.valueOf(difficultStudents.getId()));
			// 用户名
			username.setBounds(230, 70, 240, 30);
			username.setFont(f);
			username.setText(difficultStudents.getUsername());
			// 学分
			classname.setBounds(230, 120, 240, 30);
			classname.setFont(f);
			classname.setText(String.valueOf(difficultStudents.getClassname()));
			// 成绩
			telephone.setBounds(230, 170, 240, 30);
			telephone.setFont(f);
			telephone.setText(difficultStudents.getTelephone());
			// 状态
			radioButton1.setBounds(230, 220, 80, 30);
			radioButton2.setBounds(330, 220, 80, 30);
			
			// 按钮
			addStudentButton.setBounds(170, 290, 180, 50);
			addStudentButton.setFont(f);
			// 设置 默认
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

			// 添加事件
			addStudentButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					String idText = id.getText();
					int i = Integer.parseInt(idText);
					String usernameText = username.getText();
					String classnameText = classname.getText();
					String telephoneText = telephone.getText();

					// 封装信息数据
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


					// 修改
					DifficultStudentsDao difficultStudentsDao = new DifficultStudentsDao();
					int i1 = difficultStudentsDao.updateDifficultstudentsById(difficultStudents);
					if (i1 == 1) {
						// 页面转换
						index.setVisible(false);
						// 构建新的页面
						new DifficultStudentsUI("mkx");
					}

				}
			});
		}

}
