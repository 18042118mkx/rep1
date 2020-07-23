package com.alg.scholarship.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.alg.scholarship.bean.StudentRole;
import com.alg.scholarship.dao.StudentRoleDao;

public class StudentRoleAddUI extends IndexAdmin{
	//类中声明用到的组件
	//初始化字体
	Font f=new Font("楷体",Font.BOLD,19);
	StudentRole studentRole = new StudentRole();
	//初始化对象
	JLabel student_snola=new JLabel("学号:");
	JLabel student_namela=new JLabel("姓名:");
	JLabel student_majorla=new JLabel("专业:");
	JLabel student_achievementla=new JLabel("成绩:");
	JLabel student_rankingla=new JLabel("排名:");
	JLabel student_gradela=new JLabel("年级:");
	
	JTextField student_sno=new JTextField();
	JTextField student_name=new JTextField();
	JTextField student_major=new JTextField();
	JTextField student_achievement=new JTextField();
	JTextField student_ranking=new JTextField();
	JTextField student_grade=new JTextField();
	
	ButtonGroup btButtonGroup = new ButtonGroup();
	JButton addStudentRoleButton=new JButton("保存");
	
	public StudentRoleAddUI(String username){
		super(username);
		init();
	}
	private void init(){

		//学号
		student_snola.setBounds(90, 30, 100, 30);
		student_snola.setFont(f);
		//姓名
		student_namela.setBounds(90, 80, 100, 30);
		student_namela.setFont(f);
		//专业
		student_majorla.setBounds(90, 130, 100, 30);
		student_majorla.setFont(f);
		//成绩
		student_achievementla.setBounds(90, 180, 100, 30);
		student_achievementla.setFont(f);
		//排名
		student_rankingla.setBounds(90, 230, 100, 30);
		student_rankingla.setFont(f);
		//年级
		student_gradela.setBounds(90, 280, 100, 30);
		student_gradela.setFont(f);
		//输入框
		student_sno.setBounds(250, 30, 200, 30);
		student_sno.setFont(f);
		student_name.setBounds(250, 80, 200, 30);
		student_name.setFont(f);
		student_major.setBounds(250, 130, 200, 30);
		student_major.setFont(f);
		student_achievement.setBounds(250,180, 200, 30);
		student_achievement.setFont(f);
		student_ranking.setBounds(250, 230, 200, 30);
		student_ranking.setFont(f);
		student_grade.setBounds(250, 280, 200, 30);
		student_grade.setFont(f);
		//按钮
		addStudentRoleButton.setBounds(220, 350, 200, 30);
		addStudentRoleButton.setFont(f);
		//设置 默认
		index.add(student_snola);
		index.add(student_namela);
		index.add(student_majorla);
		index.add(student_achievementla);
		index.add(student_rankingla);
		index.add(student_gradela);
		
		index.add(student_sno);
		index.add(student_name);
		index.add(student_major);
		index.add(student_achievement);
		index.add(student_ranking);
		index.add(student_grade);
		index.add(addStudentRoleButton);
		
		//添加事件
		addStudentRoleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String student_snoText = student_sno.getText();
				int s = Integer.parseInt(student_snoText);
				String student_nameText = student_name.getText();
				String student_majorText = student_major.getText();
				String student_achievementText = student_achievement.getText();
				String student_rankingText = student_ranking.getText();
				String student_gradeText = student_grade.getText();
				//封装信息数据
				studentRole.setStudent_sno(s);
				studentRole.setStudent_name(student_nameText);
				studentRole.setStudent_major(student_majorText);
				studentRole.setStudent_achievement(student_achievementText);
				studentRole.setStudent_ranking(student_rankingText);
				studentRole.setStudent_grade(student_gradeText);
				//添加
				StudentRoleDao studentRoleDao = new StudentRoleDao();
				Boolean b = studentRoleDao.addStudentRole(studentRole);
				if(b) {
					//页面转换
					index.setVisible(false);
					//构建新页面
					new StudentRoleSelectUI("");
				}
			}
		});
	}
}



