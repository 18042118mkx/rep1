package com.alg.scholarship.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.alg.scholarship.bean.ScholarshipType;
import com.alg.scholarship.bean.StudentRole;
import com.alg.scholarship.dao.ScholarshipTypeDao;
import com.alg.scholarship.dao.StudentRoleDao;

public class ScholarshipTypeUpdateUI extends IndexAdmin{
	//scholarshiptype
	ScholarshipType scholarshiptype;
	public ScholarshipTypeUpdateUI(String username, int scholarship_id) {
		super(username);
		//为scholarshiptype赋值
		ScholarshipTypeDao scholarshipTypeDao = new ScholarshipTypeDao();
		//根据id查询scholarshiptypeDao信息
		scholarshiptype = scholarshipTypeDao.findAllScholarshipTypeById(scholarship_id);
		//初始
		init();
	}
	//初始化字体
	Font f=new Font("楷体",Font.BOLD,19);
	ScholarshipType scholarshipType = new ScholarshipType();
	//初始化对象
	JLabel scholarship_idla=new JLabel("序列号:");
	JLabel scholarship_namela=new JLabel("奖学金名称:");
	JLabel scholarship_typela=new JLabel("奖学金类型:");
	JLabel scholarship_briefla=new JLabel("奖学金简介:");
	JLabel scholarship_remarksla=new JLabel("备注:");
	
	JTextField scholarship_id=new JTextField();
	JTextField scholarship_name=new JTextField();
	JTextField scholarship_brief=new JTextField();
	JTextField scholarship_remarks=new JTextField();
	JRadioButton radioButton1 = new JRadioButton("国家级");
	JRadioButton radioButton2 = new JRadioButton("校级");
	
	ButtonGroup btButtonGroup = new ButtonGroup();
	JButton addScholarshipTypeButton=new JButton("修改");
	
	private void init(){
		//按钮组
		ButtonGroup btButtonGroup = new ButtonGroup();
		btButtonGroup.add(radioButton1);
		btButtonGroup.add(radioButton2);
		//序列号
				scholarship_idla.setBounds(100, 30, 100, 30);
				scholarship_idla.setFont(f);
				//奖学金名称
				scholarship_namela.setBounds(100, 90, 130, 30);
				scholarship_namela.setFont(f);
				//奖学金类型
				scholarship_typela.setBounds(100, 150, 130, 30);
				scholarship_typela.setFont(f);
				//奖学金简介
				scholarship_briefla.setBounds(100, 210, 130, 30);
				scholarship_briefla.setFont(f);
				//备注
				scholarship_remarksla.setBounds(100, 270, 100, 30);
				scholarship_remarksla.setFont(f);
		//输入框
		scholarship_id.setBounds(250, 30, 200, 30);
		scholarship_id.setFont(f);
		scholarship_id.setText(String.valueOf(scholarshiptype.getScholarship_id()));
		scholarship_name.setBounds(250, 90, 200, 30);
		scholarship_name.setFont(f);
		scholarship_name.setText(scholarshiptype.getScholarship_name());
		radioButton1.setBounds(250, 150, 100, 30);
		radioButton1.setFont(f);
		radioButton2.setBounds(370, 150, 100, 30);
		radioButton2.setFont(f);
		scholarship_brief.setBounds(250, 210, 200, 30);
		scholarship_brief.setFont(f);
		scholarship_brief.setText(scholarshiptype.getScholarship_brief());		
		scholarship_remarks.setBounds(250, 270, 200, 30);
		scholarship_remarks.setFont(f);
		scholarship_remarks.setText(scholarshiptype.getScholarship_remarks());
		//按钮
		addScholarshipTypeButton.setBounds(200, 340, 200, 30);
		addScholarshipTypeButton.setFont(f);
		//设置 默认
		radioButton1.setSelected(scholarshiptype.getScholarship_type() == 1 ? true : false);
		radioButton2.setSelected(scholarshiptype.getScholarship_type() == 0 ? true : false);
		
		index.add(scholarship_idla);
		index.add(scholarship_namela);
		index.add(scholarship_briefla);
		index.add(scholarship_typela);
		index.add(scholarship_remarksla);

		index.add(scholarship_id);
		index.add(scholarship_name);
		index.add(scholarship_brief);
		index.add(scholarship_remarks);
		index.add(radioButton1);
		index.add(radioButton2);
		index.add(addScholarshipTypeButton);
		//添加事件
		addScholarshipTypeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String scholarship_idText = scholarship_id.getText();
				int i = Integer.parseInt(scholarship_idText);
				String scholarship_nameText = scholarship_name.getText();
				String scholarship_briefText = scholarship_brief.getText();
				String scholarship_remarksText = scholarship_remarks.getText();
				//封装信息数据
				scholarshipType.setScholarship_id(i);
				scholarshipType.setScholarship_name(scholarship_nameText);
				scholarshipType.setScholarship_brief(scholarship_briefText);
				scholarshipType.setScholarship_remarks(scholarship_remarksText);
				if (radioButton1.isSelected()) {
					scholarshipType.setScholarship_type(1);
				}
				if (radioButton2.isSelected()) {
					scholarshipType.setScholarship_type(2);
				}
				//修改
				ScholarshipTypeDao scholarshipTypeDao = new ScholarshipTypeDao();
				int  b = scholarshipTypeDao.updateScholarshipTypeById(scholarshipType);
				if(b==1) {
					//页面转换
					index.setVisible(false);
					//构建新页面
					new ScholarshipTypeSelectUI("");
				}
			}
		});
	}	

}
