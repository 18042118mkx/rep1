package com.alg.scholarship.view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import java.awt.event.ActionEvent;

import javax.swing.*;

import com.alg.scholarship.dao.AnnouncementDao;


public class AnnouncementSelectUI extends IndexAdmin{
	//声明对象
	private JTable  announcementTable;
	Font f=new Font("楷体",Font.BOLD,20);
	Font m=new Font("楷体", Font.BOLD,16);
	JScrollPane jp = null;
	JButton addButton;
	JButton delButton;
	JButton updateButton;
	//id
	int ann_id;
	public AnnouncementSelectUI(String username){
		super(username);
		init();
		Announcementaction(username);
	}
	private void Announcementaction(String username) {
		//添加
		addButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//页面转换
				index.setVisible(false);
				//构建新的页面
				new AnnouncementAddUI(username);
			}
		});
		//表格添加事件
		announcementTable.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				//为id赋值
				ann_id = (int) announcementTable.getValueAt(announcementTable.getSelectedRow(), 0);
				System.out.println(ann_id);
			}
		});
		//删除按钮添加事件
		delButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//页面转换
				if (ann_id == 0) {
					JOptionPane.showMessageDialog(null,"请选择要删除的记录! ! ! ");
				}else {
					//提示
					int mess = JOptionPane.showConfirmDialog(null,"确认要删除么? ","提示信息",JOptionPane.YES_NO_OPTION);
					//mess日确定1取消
					if (mess == 0) {
						AnnouncementDao announcementDao= new AnnouncementDao();
						int del = announcementDao.delAnnouncementById(ann_id); 
						if (del==1) {
							JOptionPane.showMessageDialog(null,"删除成功");
							//重新绘制页面表格标题
							Vector tt = new Vector<>();
							tt.add("序列号");
							tt.add("标题");
							tt.add("内容");
							tt.add("发布时间");
							tt.add("状态");
							//数据
							Vector list = announcementDao.findAllAnnouncement();
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
				if (ann_id == 0) {
					JOptionPane.showMessageDialog(null,"请选择要修改的记录! ! ! ");
				}else {
					index.setVisible(false);
					new AnnouncementUpdateUI(username,ann_id);
				} 
				
			}
			
		});
	}
	private void init(){

		//表格说明
		JLabel title = new JLabel("公告信息管理");
		title.setFont(f);
		title.setBounds(100, 20, 200, 50);
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
		tt.add("序列号");
		tt.add("标题");
		tt.add("内容");
		tt.add("发布时间");
		tt.add("状态");
		//数据
		AnnouncementDao announcementDao=new AnnouncementDao();
		Vector list=announcementDao.findAllAnnouncement();
				
		System.out.println(list);
		announcementTable=new JTable(list,tt);
		announcementTable.setFont(m);
		jp = new JScrollPane(announcementTable);
		jp.setBounds(50,80,550,300);
				
		index.add(title);
		index.add(jp);
		index.add(addButton);
		index.add(delButton);
		index.add(updateButton);
	}
	

}
