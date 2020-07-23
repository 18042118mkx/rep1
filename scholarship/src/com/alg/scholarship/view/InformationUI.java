package com.alg.scholarship.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.*;

import com.alg.scholarship.dao.InformationDao;

public class InformationUI extends IndexAdmin {
	// 声明对象
	private JTable informationTable;
	Font f = new Font("楷体", Font.BOLD, 20);
	Font m = new Font("楷体", Font.BOLD, 16);

	// 滚动面板 提取到类属性
	JScrollPane jp = null;

	JButton addButton;
	JButton delButton;
	JButton updateButton;
	// id
	int informationid;

	public InformationUI(String username) {
		super(username);
		init();
		informationaction(username);
	}

	private void informationaction(String username) {
		// 添加按钮
		addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 页面转换
				index.setVisible(false);
				// 构建新的页面
				new InformationAddUI(username);
			}
		});
		// 表格添加事件
		informationTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// 为id赋值
				informationid = (int) informationTable.getValueAt(
						informationTable.getSelectedRow(), 0);
				System.out.println(informationid);
			};
		});
		// 删除按钮
		delButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 页面转换
				if (informationid == 0) {
					JOptionPane.showMessageDialog(null, "请选择要删除的记录！");
				} else {
					// 提示
					int mess = JOptionPane.showConfirmDialog(null, "确认要删除吗？",
							"提示信息", JOptionPane.YES_NO_OPTION);
					// mess 0确定 1取消
					if (mess == 0) {
						InformationDao informationDao = new InformationDao();
						int del = informationDao
								.delInformationById(informationid);
						if (del == 1) {
							JOptionPane.showMessageDialog(null, "删除成功");
							// 重新绘制页面 表格标题
							Vector tt = new Vector<>();
							tt.add("id");
							tt.add("用户名");
							tt.add("密码");
							tt.add("用户类型");
							tt.add("电话");
							tt.add("班级");
							tt.add("住址");
							tt.add("教师");

							// 数据
							Vector list = informationDao.findAllInformation();

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
				if (informationid == 0) {
					JOptionPane.showMessageDialog(null, "请选择要修改的记录！");
				} else {
					index.setVisible(false);
					new InformationUpdateUI(username,informationid);
				}
			}
		});
	}

	private void init() {
		// 表格说明
		JLabel title = new JLabel("管理员个人信息");
		title.setFont(f);
		title.setBounds(200, 20, 200, 50);
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
		// 表格标题
		Vector tt = new Vector<>();
		tt.add("id");
		tt.add("用户名");
		tt.add("密码");
		tt.add("用户类型");
		tt.add("电话");
		tt.add("班级");
		tt.add("住址");
		tt.add("教师");

		// 数据
		InformationDao informationDao = new InformationDao();
		Vector list = informationDao.findAllInformation();

		informationTable = new JTable(list, tt);
		informationTable.setFont(m);
		jp = new JScrollPane(informationTable);
		jp.setBounds(50, 60, 650, 300);

		index.add(title);
		index.add(jp);
		index.add(addButton);
		index.add(delButton);
		index.add(updateButton);
	}

}
