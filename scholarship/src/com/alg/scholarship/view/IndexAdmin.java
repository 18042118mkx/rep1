package com.alg.scholarship.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.sun.prism.j2d.print.J2DPrinter;

public class IndexAdmin {
	Font f = new Font("楷体", Font.BOLD, 20);
	Font m = new Font("楷体", Font.BOLD, 16);
	// 声明对象
	public JFrame index;
	private JMenuBar managerMenu;
	// 一级菜单
	private JMenu scholarshipMenu;
	private JMenu educationalMenu;
	private JMenu Management;
	// 二级菜单
	private JMenuItem administratorltem;
	private JMenuItem scholarshipltem;
	private JMenuItem studentItem;
	private JMenuItem studentroleltem;//学生角色
	private JMenuItem scholarshiptypeltem;//
	private JMenuItem announcementltem;//公告
	private JMenuItem DifficultStudents;
	private JMenuItem TypesOfStudentsWithDifficulties;
	private JMenuItem Classmanagement;

	public IndexAdmin(String username) {
		// 初始化页面
		indexadmin();
		// 框架初始化
		init(username);
		// 设置点击回调
		action(username);
	}

	private void action(String username) {
		administratorltem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 页面转换
				index.setVisible(false);
				// 构建新的页面
				new InformationUI(username);
			}
		});
		scholarshipltem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 页面转换
				index.setVisible(false);
				// 构建新的页面
				new ScholarshipSeletUI(username);
			}
		});
		studentItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 页面转换
				index.setVisible(false);
				// 构建新的页面
				new StudentSeletUI(username);
			}
		});
	studentroleltem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//页面转换
				index.setVisible(false);
				//构建新的页面
				new StudentRoleSelectUI(username);
			}
		});
	announcementltem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//页面转换
				index.setVisible(false);
				//构建新的页面
				new AnnouncementSelectUI(username);
			}
		});
		scholarshiptypeltem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//页面转换
				index.setVisible(false);
				//构建新的页面
				new ScholarshipTypeSelectUI(username);
			}
		});
DifficultStudents.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//页面转换
				index.setVisible(false);
				//构建新的页面
				new DifficultStudentsUI(username);
			}
		});
		TypesOfStudentsWithDifficulties.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//页面转换
				index.setVisible(false);
				//构建新的页面
				new TypesOfStudentsWithDifficultiesUI(username);
			}
		});
		Classmanagement.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//页面转换
				index.setVisible(false);
				//构建新的页面
				new ClassmanagementUI(username);
			}
		});
	}

	private void init(String username) {
		// index
		index = new JFrame("欢迎：" + username + "使用系统");
		// 设置x y w h
		index.setBounds(800, 310, 750, 580);
		// 设置退出
		index.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		index.setVisible(true);
		// 添加菜单
		index.setJMenuBar(managerMenu);
		index.setLayout(null);
	}

	// 设置 对象字符串 设置字体
	private void indexadmin() {
		managerMenu = new JMenuBar();
		// 菜单
		scholarshipMenu = new JMenu("奖学金查询模块");
		scholarshipMenu.setFont(f);
		educationalMenu=new JMenu("教务处模块");
		educationalMenu.setFont(f);
		Management=new JMenu("困难生信息模块");
		Management.setFont(f);
		// 子菜单
		administratorltem = new JMenuItem("管理员个人信息");
		administratorltem.setFont(m);
		scholarshipltem = new JMenuItem("奖学金管理");
		scholarshipltem.setFont(m);
		studentItem = new JMenuItem("学生管理");
		studentItem.setFont(m);
		studentroleltem=new JMenuItem("学生角色管理");
		studentroleltem.setFont(m);
		scholarshiptypeltem=new JMenuItem("奖学金类型管理");
		scholarshiptypeltem.setFont(m);
		announcementltem=new JMenuItem("公告信息管理");
		announcementltem.setFont(m);
		DifficultStudents=new JMenuItem("困难生管理");
		DifficultStudents.setFont(m);
		TypesOfStudentsWithDifficulties=new JMenuItem("困难生类别管理");
		TypesOfStudentsWithDifficulties.setFont(m);
		Classmanagement=new JMenuItem("班级管理");
		Classmanagement.setFont(m);

		// 添加菜单
		managerMenu.add(scholarshipMenu);
		scholarshipMenu.add(administratorltem);
		scholarshipMenu.add(scholarshipltem);
		scholarshipMenu.add(studentItem);
		managerMenu.add(educationalMenu);
		educationalMenu.add(studentroleltem);
		educationalMenu.add(scholarshiptypeltem);
		educationalMenu.add(announcementltem);
		managerMenu.add(Management);
		Management.add(DifficultStudents);
		Management.add(TypesOfStudentsWithDifficulties);
		Management.add(Classmanagement);
		
	}
}
