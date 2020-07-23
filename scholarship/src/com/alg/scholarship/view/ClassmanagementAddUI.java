package com.alg.scholarship.view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.alg.scholarship.bean.Classmanagement;
import com.alg.scholarship.dao.ClassmanagementDao;

import javax.swing.*;



public class ClassmanagementAddUI extends IndexAdmin{
	public ClassmanagementAddUI(String username) {
		super(username);
		init();
	}

	// 类中声明用到的组件
			// 初始化字体
			Font f = new Font("楷体", Font.BOLD, 19);
			Classmanagement classmanagement=new Classmanagement();
			// 初始化对象
			JLabel idla = new JLabel("id:");
			JLabel classnamela = new JLabel("班级:");
			JLabel numla = new JLabel("人数:");
			JLabel statela = new JLabel("状态:");
			JLabel principalla = new JLabel("负责人:");
			

			JTextField id = new JTextField();
			JTextField classname = new JTextField();
			JTextField num= new JTextField();
			JRadioButton radioButton1 = new JRadioButton("成功");
			JRadioButton radioButton2 = new JRadioButton("失败");
			JTextField principal = new JTextField();
			

			// 按钮组
			ButtonGroup btButtonGroup = new ButtonGroup();
			JButton addStudentButton = new JButton("保存");


			private void init() {
				// 按钮组
				ButtonGroup btButtonGroup = new ButtonGroup();
				btButtonGroup.add(radioButton1);
				btButtonGroup.add(radioButton2);
				// id
				idla.setBounds(100, 20, 100, 30);
				idla.setFont(f);
				// 班级
				classnamela.setBounds(100, 70, 100, 30);
				classnamela.setFont(f);
				// 人数
				numla.setBounds(100, 120, 100, 30);
				numla.setFont(f);
				// 状态
				statela.setBounds(100, 170, 100, 30);
				statela.setFont(f);
				//负责人
				principalla.setBounds(100, 220, 100, 30);
				principalla.setFont(f);
				

				// 输入框
				// id
				id.setBounds(230, 20, 240, 30);
				id.setFont(f);
				// 班级
				classname.setBounds(230, 70, 240, 30);
				classname.setFont(f);
				// 人数
				num.setBounds(230, 120, 240, 30);
				num.setFont(f);
				// 状态
				radioButton1.setBounds(230, 170, 80, 30);
				radioButton2.setBounds(330, 170, 80, 30);
				// 负责人
				principal.setBounds(230, 220, 240, 30);
				principal.setFont(f);
				

				// 按钮
				addStudentButton.setBounds(170, 290, 180, 50);
				addStudentButton.setFont(f);
				// 设置 默认
				radioButton1.setSelected(true);

				index.add(idla);
				index.add(classnamela);
				index.add(numla);
				index.add(principalla);
				index.add(statela);
				index.add(id);
				index.add(classname);
				index.add(num);
				index.add(principal);
				index.add(radioButton1);
				index.add(radioButton2);
				
				index.add(addStudentButton);

				// 添加事件
				addStudentButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {

						String idText = id.getText();
						int i = Integer.parseInt(idText);
						String classnameText = classname.getText();
						String numText = num.getText();
						int n = Integer.parseInt(numText);
						String principalText = principal.getText();
	
						// 封装信息数据
						classmanagement.setId(i);
						classmanagement.setClassname(classnameText);
						classmanagement.setNum(n);
						classmanagement.setPrincipal(principalText);
						if (radioButton1.isSelected()) {
							classmanagement.setState(1);
						}
						if (radioButton2.isSelected()) {
							classmanagement.setState(2);
						}

						// 添加
						ClassmanagementDao classmanagementDao = new ClassmanagementDao();
						Boolean b = classmanagementDao.addClassmanagement(classmanagement);
						if (b) {
							// 页面转换
							index.setVisible(false);
							// 构建新的页面
							new ClassmanagementUI("mkx");
						}
					}
				});
			}

}
