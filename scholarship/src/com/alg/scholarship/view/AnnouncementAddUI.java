package com.alg.scholarship.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.alg.scholarship.bean.Announcement;
import com.alg.scholarship.dao.AnnouncementDao;
import com.alg.scholarship.dao.InformationDao;

public class AnnouncementAddUI extends IndexAdmin{
	
	//���������õ������
	//��ʼ������
	Font f=new Font("����",Font.BOLD,19);
	Announcement announcement = new Announcement();
	//��ʼ������
	JLabel ann_idla=new JLabel("���к�:");
	JLabel ann_tilela=new JLabel("����:");
	JLabel ann_contentla=new JLabel("����:");
	JLabel ann_datela=new JLabel("����ʱ��:");
	JLabel ann_statela=new JLabel("״̬:");
	
	JTextField ann_id=new JTextField();
	JTextField ann_tile=new JTextField();
	JTextField ann_content=new JTextField();
	JTextField ann_date=new JTextField();
	JRadioButton radioButton1 = new JRadioButton("�ѷ���");
	JRadioButton radioButton2 = new JRadioButton("δ����");
	
	ButtonGroup btButtonGroup = new ButtonGroup();
	JButton addAnnouncementButton=new JButton("����");
	
	public AnnouncementAddUI(String username){
		super(username);
		init();
	}
	private void init(){
		//��ť��
		ButtonGroup btButtonGroup = new ButtonGroup();
		btButtonGroup.add(radioButton1);
		btButtonGroup.add(radioButton2);
		//���к�
		ann_idla.setBounds(100, 30, 100, 30);
		ann_idla.setFont(f);
		//����
		ann_tilela.setBounds(100, 90, 100, 30);
		ann_tilela.setFont(f);
		//����
		ann_contentla.setBounds(100, 150, 100, 30);
		ann_contentla.setFont(f);
		//����ʱ��
		ann_datela.setBounds(100, 210, 100, 30);
		ann_datela.setFont(f);
		//״̬
		ann_statela.setBounds(100, 270, 100, 30);
		ann_statela.setFont(f);
		//�����
		ann_id.setBounds(250, 30, 200, 30);
		ann_id.setFont(f);
		ann_tile.setBounds(250, 90, 200, 30);
		ann_tile.setFont(f);
		ann_content.setBounds(250, 150, 200, 30);
		ann_content.setFont(f);
		ann_date.setBounds(250, 210, 200, 30);
		ann_date.setFont(f);
		//��ť
		radioButton1.setBounds(250, 270, 100, 30);
		radioButton1.setFont(f);
		radioButton2.setBounds(370, 270, 100, 30);
		radioButton2.setFont(f);

		addAnnouncementButton.setBounds(200, 340, 200, 30);
		addAnnouncementButton.setFont(f);
		//���� Ĭ��
		radioButton1.setSelected(true);
		
		index.add(ann_idla);
		index.add(ann_tilela);
		index.add(ann_contentla);
		index.add(ann_datela);
		index.add(ann_statela);
		
		index.add(ann_id);
		index.add(ann_tile);
		index.add(ann_content);
		index.add(ann_date);
		index.add(radioButton1);
		index.add(radioButton2);
		index.add(addAnnouncementButton);
		
		//����¼�
		addAnnouncementButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String ann_idText = ann_id.getText();
				String ann_tileText = ann_tile.getText();
				String ann_contentText = ann_content.getText();
				String ann_dateText = ann_date.getText();
				//��װannouncement��������
				//announcement.setAnn_id(ann_idText);
				announcement.setAnn_tile(ann_tileText);
				announcement.setAnn_content(ann_contentText);
				announcement.setAnn_date(ann_dateText);
				if (radioButton1.isSelected()) {
					announcement.setAnn_state(1);
				}
				if (radioButton2.isSelected()) {
					announcement.setAnn_state(2);
				}
				//���
				AnnouncementDao announcementdao = new AnnouncementDao();
				Boolean b =  announcementdao.addAnnouncement(announcement);
				if(b) {
					//ҳ��ת��
					index.setVisible(false);
					System.out.println("������Ϣ");
					//������ҳ��
					new AnnouncementSelectUI("");
				}
			}
		});
	}
}
