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
	//��������
	private JTable  announcementTable;
	Font f=new Font("����",Font.BOLD,20);
	Font m=new Font("����", Font.BOLD,16);
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
		//���
		addButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//ҳ��ת��
				index.setVisible(false);
				//�����µ�ҳ��
				new AnnouncementAddUI(username);
			}
		});
		//�������¼�
		announcementTable.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				//Ϊid��ֵ
				ann_id = (int) announcementTable.getValueAt(announcementTable.getSelectedRow(), 0);
				System.out.println(ann_id);
			}
		});
		//ɾ����ť����¼�
		delButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//ҳ��ת��
				if (ann_id == 0) {
					JOptionPane.showMessageDialog(null,"��ѡ��Ҫɾ���ļ�¼! ! ! ");
				}else {
					//��ʾ
					int mess = JOptionPane.showConfirmDialog(null,"ȷ��Ҫɾ��ô? ","��ʾ��Ϣ",JOptionPane.YES_NO_OPTION);
					//mess��ȷ��1ȡ��
					if (mess == 0) {
						AnnouncementDao announcementDao= new AnnouncementDao();
						int del = announcementDao.delAnnouncementById(ann_id); 
						if (del==1) {
							JOptionPane.showMessageDialog(null,"ɾ���ɹ�");
							//���»���ҳ�������
							Vector tt = new Vector<>();
							tt.add("���к�");
							tt.add("����");
							tt.add("����");
							tt.add("����ʱ��");
							tt.add("״̬");
							//����
							Vector list = announcementDao.findAllAnnouncement();
							JTable table = new JTable(list,tt);
							table.setFont(m);
							JScrollPane jptable = new JScrollPane(table);
							jptable.setBounds(50,80,550,300);
							//�Ƴ��ɵ����
							index.remove(jp);
							//������齨
							index. add(jptable);
							//���»���
							index.repaint();
						}
					}	
				}
			}
		});
		//�޸�
		updateButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//ҳ��ת��
				if (ann_id == 0) {
					JOptionPane.showMessageDialog(null,"��ѡ��Ҫ�޸ĵļ�¼! ! ! ");
				}else {
					index.setVisible(false);
					new AnnouncementUpdateUI(username,ann_id);
				} 
				
			}
			
		});
	}
	private void init(){

		//���˵��
		JLabel title = new JLabel("������Ϣ����");
		title.setFont(f);
		title.setBounds(100, 20, 200, 50);
		//���
		addButton = new JButton("���");
		addButton.setFont(f);
		addButton.setBounds(300, 30, 90, 30);
		//ɾ��
		delButton = new JButton("ɾ��");
		delButton.setFont(f);
		delButton.setBounds(400, 30, 90, 30);
		//�޸�
		updateButton = new JButton("�޸�");
		updateButton.setFont(f);
		updateButton.setBounds(500, 30, 90, 30);
		//������
		Vector tt = new Vector<>();
		tt.add("���к�");
		tt.add("����");
		tt.add("����");
		tt.add("����ʱ��");
		tt.add("״̬");
		//����
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
