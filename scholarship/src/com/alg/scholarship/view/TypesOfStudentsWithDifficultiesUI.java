package com.alg.scholarship.view;

import java.awt.Font;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import com.alg.scholarship.dao.TypesOfStudentsWithDifficultiesDao;


public class TypesOfStudentsWithDifficultiesUI extends IndexAdmin{
	public TypesOfStudentsWithDifficultiesUI(String username) {
			super(username);
			init();
			typesOfStudentsWithDifficultiesaction(username);
		}
	
		//声明对象
		private JTable typesOfStudentsWithDifficultiesTable;
		Font f=new Font("楷体",Font.BOLD,20);
		Font m=new Font("楷体", Font.BOLD,16);
		
		// 滚动面板 提取到类属性
		JScrollPane jp = null;

		JButton addButton;
		JButton delButton;
		JButton updateButton;
		// id
		int typesOfStudentsWithDifficultiesid;

		

		private void typesOfStudentsWithDifficultiesaction(String username) {
			// 添加按钮
			addButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// 页面转换
					index.setVisible(false);
					// 构建新的页面
					new TypesOfStudentsWithDifficultiesAddUI(username);
				}
			});
			// 表格添加事件
			typesOfStudentsWithDifficultiesTable.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					// 为id赋值
					typesOfStudentsWithDifficultiesid = (int) typesOfStudentsWithDifficultiesTable.getValueAt(
							typesOfStudentsWithDifficultiesTable.getSelectedRow(), 0);
					System.out.println(typesOfStudentsWithDifficultiesid);
				};
			});
			// 删除按钮
			delButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// 页面转换
					if (typesOfStudentsWithDifficultiesid == 0) {
						JOptionPane.showMessageDialog(null, "请选择要删除的记录！");
					} else {
						// 提示
						int mess = JOptionPane.showConfirmDialog(null, "确认要删除吗？",
								"提示信息", JOptionPane.YES_NO_OPTION);
						// mess 0确定 1取消
						if (mess == 0) {
							TypesOfStudentsWithDifficultiesDao typesOfStudentsWithDifficultiesDao = new TypesOfStudentsWithDifficultiesDao();
							int del = typesOfStudentsWithDifficultiesDao
									.deltypesOfStudentsWithDifficultiesById(typesOfStudentsWithDifficultiesid);
							if (del == 1) {
								JOptionPane.showMessageDialog(null, "删除成功");
								// 重新绘制页面 表格标题
								Vector tt = new Vector<>();
								tt.add("id");
								tt.add("类型");
								tt.add("健康情况");
								tt.add("家庭收入");
								tt.add("地区");
								

								// 数据
								Vector list = typesOfStudentsWithDifficultiesDao.findAllTypesOfStudentsWithDifficulties();

								JTable table = new JTable(list, tt);
								table.setFont(m);
								JScrollPane jptable = new JScrollPane(table);
								jptable.setBounds(50, 60, 650, 300);
								// 移除旧的组件
								index.remove(jp);
								// 添加新组件
								index.add(jptable);
								// 重新绘制
								index.repaint();
							}
						}
					}
				}
			});
			// 修改
			updateButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// 页面转换
					if (typesOfStudentsWithDifficultiesid == 0) {
						JOptionPane.showMessageDialog(null, "请选择要修改的记录！");
					} else {
						index.setVisible(false);
						new TypesOfStudentsWithDifficultiesUpdateUI(username,typesOfStudentsWithDifficultiesid);
					}
				}
			});
		}
		private void init(){
			        //表格说明
			        JLabel title = new JLabel("困难生类别管理");
					title.setFont(f);
					title.setBounds(200, 30, 200, 50);
					// 添加按钮
					addButton = new JButton("添加");
					addButton.setFont(f);
					addButton.setBounds(400, 30, 90, 30);
					// 删除按钮
					delButton = new JButton("删除");
					delButton.setFont(f);
					delButton.setBounds(500, 30, 90, 30);
					// 修改按钮
					updateButton = new JButton("修改");
					updateButton.setFont(f);
					updateButton.setBounds(600, 30, 90, 30);

					//表格标题
					Vector tt = new Vector<>();
					tt.add("id");
					tt.add("类型");
					tt.add("健康情况");
					tt.add("家庭总收入");
					tt.add("地区");
					//数据
					TypesOfStudentsWithDifficultiesDao typesOfStudentsWithDifficultiesDao=new TypesOfStudentsWithDifficultiesDao();
					Vector list=typesOfStudentsWithDifficultiesDao.findAllTypesOfStudentsWithDifficulties();
					
					System.out.println(list);
					typesOfStudentsWithDifficultiesTable=new JTable(list,tt);
					typesOfStudentsWithDifficultiesTable.setFont(m);
					jp = new JScrollPane(typesOfStudentsWithDifficultiesTable);
					jp.setBounds(50,80,550,300);
					
					index.add(title);
					index.add(jp);
					index.add(addButton);
					index.add(delButton);
					index.add(updateButton);
		}
		

	
}
