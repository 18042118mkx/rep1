package com.alg.scholarship.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.alg.scholarship.dao.AnnouncementDao;
import com.alg.scholarship.dao.StudentRoleDao;

public class StudentRoleSelectUI extends IndexAdmin{
	//声明对象
	private JTable  studentroleTable;
	Font f=new Font("楷体",Font.BOLD,20);
	Font m=new Font("楷体",Font.BOLD,16);
	JScrollPane jp = null;
	JButton addButton;
	JButton delButton;
	JButton updateButton;
	//sno
	int studentRoleid;
	public StudentRoleSelectUI(String username){
		super(username);
		init();
		StudentRoleaction(username);
	}
	private void StudentRoleaction(String username) {
		//添加
		addButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//页面转换
				index.setVisible(false);
				//构建新的页面
				new StudentRoleAddUI(username);
			}
		});
		//表格添加事件
		studentroleTable.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				//为sno赋值
				studentRoleid = (int) studentroleTable.getValueAt(studentroleTable.getSelectedRow(), 0);
				System.out.println(studentRoleid);
			}
		});
		//删除按钮添加事件
		delButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//页面转换
				if (studentRoleid == 0) {
					JOptionPane.showMessageDialog(null,"请选择要删除的记录! ! ! ");
				}else {
					//提示
					int mess = JOptionPane.showConfirmDialog(null,"确认要删除么? ","提示信息",JOptionPane.YES_NO_OPTION);
					//mess日确定1取消
					if (mess == 0) {
						StudentRoleDao studentRoleDao= new StudentRoleDao();
						int del = studentRoleDao.delStudentRoleById(studentRoleid); 
						if (del==1) {
							JOptionPane.showMessageDialog(null,"删除成功");
							//重新绘制页面表格标题
							Vector tt = new Vector<>();
							tt.add("学号");
							tt.add("姓名");
							tt.add("专业");
							tt.add("成绩");
							tt.add("排名");
							tt.add("年级");
							//数据
							Vector list = studentRoleDao.findAllStudentRole();
							JTable table = new JTable(list,tt);
							table.setFont(m);
							JScrollPane jptable = new JScrollPane(table);
							jptable.setBounds(50,80,550,300);
							//移除旧的组件
							index.remove(jp);
							//添加新组建
							index. add(jptable);
							//重新绘制
							index.repaint();
						}
					}	
				}
			}
		});
		//修改
		updateButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//页面转换
				if (studentRoleid == 0) {
					JOptionPane.showMessageDialog(null,"请选择要修改的记录! ! ! ");
				}else {
					index.setVisible(false);
					new StudentRoleUpdateUI(username,studentRoleid);
				} 
				
			}
			
		});
	}
		
	private void init(){
		//表格说明
		JLabel title = new JLabel("学生角色管理");
		title.setFont(f);
		title.setBounds(100,20,200,50);
		//添加
		addButton = new JButton("添加");
		addButton.setFont(f);
		addButton.setBounds(300, 30, 90, 30);
		//删除
		delButton = new JButton("删除");
		delButton.setFont(f);
		delButton.setBounds(400, 30, 90, 30);
		//修改
		updateButton = new JButton("修改");
		updateButton.setFont(f);
		updateButton.setBounds(500, 30, 90, 30);
		//表格标题
		Vector tt = new Vector<>();
		tt.add("学号");
		tt.add("姓名");
		tt.add("专业");
		tt.add("成绩");
		tt.add("排名");
		tt.add("年级");
		//数据
		StudentRoleDao studentRoleDao=new StudentRoleDao();
		Vector list=studentRoleDao.findAllStudentRole();
				
		System.out.println(list);
		studentroleTable=new JTable(list,tt);
		studentroleTable.setFont(m);
		jp = new JScrollPane(studentroleTable);
		jp.setBounds(50,80,550,300);
				
		index.add(title);
		index.add(jp);
		index.add(addButton);
		index.add(delButton);
		index.add(updateButton);
	}
	

}