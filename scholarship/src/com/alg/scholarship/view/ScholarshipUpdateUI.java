package com.alg.scholarship.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.alg.scholarship.bean.Scholarship;
import com.alg.scholarship.dao.ScholarshipDao;

public class ScholarshipUpdateUI extends IndexAdmin {
	// scholarship
	Scholarship scholarship;

	public ScholarshipUpdateUI(String name, int scholarshipid) {
		super(name);
		// 为type赋值
		ScholarshipDao scholarshipDao = new ScholarshipDao();
		// 根据id查询信息
		scholarship = scholarshipDao.findScholarshipById(scholarshipid);
		// 初始化
		init();
	}

	// 类中声明用到的组件
	// 初始化字体
	Font f = new Font("楷体", Font.BOLD, 19);
	// 初始化对象
	JLabel idla = new JLabel("奖学金id:");
	JLabel namela = new JLabel("奖学金名称:");
	JLabel amountla = new JLabel("金额:");
	JLabel typela = new JLabel("奖学金类型:");
	JLabel quotala = new JLabel("名额:");
	JLabel declareNumla = new JLabel("申报人数:");
	JLabel successfulNumla = new JLabel("成功人数:");

	JTextField id = new JTextField();
	JTextField name = new JTextField();
	JTextField amount = new JTextField();
	JRadioButton radioButton1 = new JRadioButton("国家级");
	JRadioButton radioButton2 = new JRadioButton("校级");
	JTextField quota = new JTextField();
	JTextField declareNum = new JTextField();
	JTextField successfulNum = new JTextField();

	// 按钮组
	ButtonGroup btButtonGroup = new ButtonGroup();
	JButton addScholarshipButton = new JButton("修改");

	private void init() {
		// 按钮组
		ButtonGroup btButtonGroup = new ButtonGroup();
		btButtonGroup.add(radioButton1);
		btButtonGroup.add(radioButton2);
		// id
		idla.setBounds(80, 20, 120, 30);
		idla.setFont(f);
		// 名称
		namela.setBounds(80, 70, 120, 30);
		namela.setFont(f);
		// 金额
		amountla.setBounds(80, 120, 120, 30);
		amountla.setFont(f);
		// 类型
		typela.setBounds(80, 170, 120, 30);
		typela.setFont(f);
		// 名额
		quotala.setBounds(80, 220, 120, 30);
		quotala.setFont(f);
		// 申报人数
		declareNumla.setBounds(80, 270, 120, 30);
		declareNumla.setFont(f);
		// 成功人数
		successfulNumla.setBounds(80, 320, 120, 30);
		successfulNumla.setFont(f);

		// 输入框 //设置回显
		// id
		id.setBounds(230, 20, 240, 30);
		id.setFont(f);
		id.setText(String.valueOf(scholarship. getScholarshipId()));
		// 名称
		name.setBounds(230, 70, 240, 30);
		name.setFont(f);
		name.setText(scholarship.getScholarshipName());
		// 金额
		amount.setBounds(230, 120, 240, 30);
		amount.setFont(f);
		amount.setText(String.valueOf(scholarship. getAmount()));
		// 类型
		radioButton1.setBounds(230, 170, 100, 30);
		radioButton1.setFont(f);
		radioButton2.setBounds(350, 170, 100, 30);
		radioButton2.setFont(f);
		// 名额
		quota.setBounds(230, 220, 240, 30);
		quota.setFont(f);
	    quota.setText(String.valueOf(scholarship. getQuota()));
		// 申报人数
		declareNum.setBounds(230, 270, 240, 30);
		declareNum.setFont(f);
		declareNum.setText(String.valueOf(scholarship. getDeclareNum()));
		// 成功人数
		successfulNum.setBounds(230, 320, 240, 30);
		successfulNum.setFont(f);
		successfulNum.setText(String.valueOf(scholarship. getSuccessfulNum()));

		// 按钮
		addScholarshipButton.setBounds(170, 380, 180, 50);
		addScholarshipButton.setFont(f);
		// 设置 默认
		radioButton1.setSelected(scholarship.getScholarshipType() == 1 ? true : false);
		radioButton2.setSelected(scholarship.getScholarshipType() == 0 ? true : false);

		index.add(idla);
		index.add(namela);
		index.add(amountla);
		index.add(typela);
		index.add(quotala);
		index.add(declareNumla);
		index.add(successfulNumla);

		index.add(id);
		index.add(name);
		index.add(amount);
		index.add(radioButton1);
		index.add(radioButton2);
		index.add(quota);
		index.add(declareNum);
		index.add(successfulNum);
		index.add(addScholarshipButton);

		// 添加事件
		addScholarshipButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String idText = id.getText();
				int i = Integer.parseInt(idText);
				String nameText = name.getText();
				String amountText = amount.getText();
				int a = Integer.parseInt(amountText);
				String quotaText = quota.getText();
				int m = Integer.parseInt(quotaText);
				String declareNumText = declareNum.getText();
				int c = Integer.parseInt(declareNumText);
				String successfulNumText = successfulNum.getText();
				int d = Integer.parseInt(successfulNumText);
				// 封装信息数据
				scholarship.setScholarshipId(i);
				scholarship.setScholarshipName(nameText);
				scholarship.setAmount(a);
				scholarship.setQuota(m);
				scholarship.setDeclareNum(c);
				scholarship.setSuccessfulNum(d);
				if (radioButton1.isSelected()) {
					scholarship.setScholarshipType(1);
				}
				if (radioButton2.isSelected()) {
					scholarship.setScholarshipType(2);
				}


				// 修改
				ScholarshipDao scholarshipDao = new ScholarshipDao();
				int i1 = scholarshipDao.updateScholarshipById(scholarship);
				if (i1 == 1) {
					// 页面转换
					index.setVisible(false);
					// 构建新的页面
					new ScholarshipSeletUI("mkx");
				}

			}
		});
	}
}
