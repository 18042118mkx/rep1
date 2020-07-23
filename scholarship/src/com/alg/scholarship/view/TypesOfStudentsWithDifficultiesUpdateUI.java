package com.alg.scholarship.view;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


import com.alg.scholarship.bean.TypesOfStudentsWithDifficulties;
import com.alg.scholarship.dao.TypesOfStudentsWithDifficultiesDao;

public class TypesOfStudentsWithDifficultiesUpdateUI extends IndexAdmin{
	// student
	TypesOfStudentsWithDifficulties typesOfStudentsWithDifficulties;

		public TypesOfStudentsWithDifficultiesUpdateUI(String username, int typesOfStudentsWithDifficultiesid) {
				super(username);
				// 为type赋值
				TypesOfStudentsWithDifficultiesDao typesOfStudentsWithDifficultiesDao = new TypesOfStudentsWithDifficultiesDao();
				// 根据id查询信息
				typesOfStudentsWithDifficulties = typesOfStudentsWithDifficultiesDao.findTypesOfStudentsWithDifficultiesById(typesOfStudentsWithDifficultiesid);
				// 初始化
				init();
			}
		

		// 类中声明用到的组件
		// 初始化字体
		Font f = new Font("楷体", Font.BOLD, 19);
		// 初始化对象
		JLabel idla = new JLabel("id:");
		JLabel typela = new JLabel("类型:");
		JLabel healthyla = new JLabel("健康情况:");
		JLabel incomela = new JLabel("家庭收入:");
		JLabel regionla = new JLabel("地区:");

		JTextField id = new JTextField();
		JRadioButton radioButton1 = new JRadioButton("一般贫困");
		JRadioButton radioButton2 = new JRadioButton("特别贫困");
		JTextField healthy = new JTextField();
		JTextField income = new JTextField();
		JRadioButton radioButton3 = new JRadioButton("省内");
		JRadioButton radioButton4 = new JRadioButton("省外");

		// 按钮组
		ButtonGroup btButtonGroup = new ButtonGroup();
		JButton addStudentButton = new JButton("修改");

		private void init() {
			// 按钮组
			ButtonGroup btButtonGroup = new ButtonGroup();
			btButtonGroup.add(radioButton1);
			btButtonGroup.add(radioButton2);
			ButtonGroup btButtonGroup1 = new ButtonGroup();
			btButtonGroup1.add(radioButton3);
			btButtonGroup1.add(radioButton4);
			// id
			idla.setBounds(100, 20, 100, 30);
			idla.setFont(f);
			// 类型
			typela.setBounds(100, 70, 100, 30);
			typela.setFont(f);
			// 健康情况
			healthyla.setBounds(100, 120, 100, 30);
			healthyla.setFont(f);
			// 收入
			incomela.setBounds(100, 170, 130, 30);
			incomela.setFont(f);
			// 地区
			regionla.setBounds(100, 220, 100, 30);
			regionla.setFont(f);

			// 输入框 //设置回显
			// id
			id.setBounds(230, 20, 240, 30);
			id.setFont(f);
			id.setText(String.valueOf(typesOfStudentsWithDifficulties.getId()));
			// 类型
			radioButton1.setBounds(230, 70, 100, 30);
			radioButton2.setBounds(330, 70, 100, 30);
			
			// 健康情况
			healthy.setBounds(230, 120, 240, 30);
			healthy.setFont(f);
			healthy.setText(typesOfStudentsWithDifficulties.getHealthy());
			// 成绩
			income.setBounds(230, 170, 240, 30);
			income.setFont(f);
			income.setText(String.valueOf(typesOfStudentsWithDifficulties.getIncome()));
			// 状态
			radioButton3.setBounds(230, 220, 100, 30);
			radioButton4.setBounds(330, 220, 100, 30);
			
			// 按钮
			addStudentButton.setBounds(170, 290, 180, 50);
			addStudentButton.setFont(f);
			// 设置 默认
			radioButton1.setSelected(typesOfStudentsWithDifficulties.getType() == 1 ? true : false);
			radioButton2.setSelected(typesOfStudentsWithDifficulties.getType() == 0 ? true : false);
			radioButton3.setSelected(typesOfStudentsWithDifficulties.getType() == 1 ? true : false);
			radioButton4.setSelected(typesOfStudentsWithDifficulties.getType() == 0 ? true : false);

			index.add(idla);
			index.add(typela);
			index.add(healthyla);
			index.add(incomela);
			index.add(regionla);
			index.add(id);
			index.add(healthy);
			index.add(income);
			index.add(radioButton1);
			index.add(radioButton2);
			index.add(radioButton3);
			index.add(radioButton4);
			index.add(addStudentButton);

			// 添加事件
			addStudentButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					String idText = id.getText();
					int i = Integer.parseInt(idText);
					String healthyText = healthy.getText();
					String incomeText = income.getText();
					int m = Integer.parseInt(incomeText);

					// 封装信息数据
					typesOfStudentsWithDifficulties.setId(i);
					typesOfStudentsWithDifficulties.setHealthy(healthyText);
					typesOfStudentsWithDifficulties.setIncome(m);
					if (radioButton1.isSelected()) {
						typesOfStudentsWithDifficulties.setType(1);
					}
					if (radioButton2.isSelected()) {
						typesOfStudentsWithDifficulties.setType(2);
					}
					if (radioButton3.isSelected()) {
						typesOfStudentsWithDifficulties.setRegion(1);
					}
					if (radioButton4.isSelected()) {
						typesOfStudentsWithDifficulties.setRegion(2);
					}


					// 修改
					TypesOfStudentsWithDifficultiesDao typesOfStudentsWithDifficultiesDao = new TypesOfStudentsWithDifficultiesDao();
					int i1 = typesOfStudentsWithDifficultiesDao.updateTypesOfStudentsWithDifficultiesById(typesOfStudentsWithDifficulties);
					if (i1 == 1) {
						// 页面转换
						index.setVisible(false);
						// 构建新的页面
						new TypesOfStudentsWithDifficultiesUI("mkx");
					}

				}
			});
		}

}
