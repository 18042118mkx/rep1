package com.alg.scholarship.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.sun.prism.j2d.print.J2DPrinter;

public class IndexAdmin {
	Font f = new Font("����", Font.BOLD, 20);
	Font m = new Font("����", Font.BOLD, 16);
	// ��������
	public JFrame index;
	private JMenuBar managerMenu;
	// һ���˵�
	private JMenu scholarshipMenu;
	private JMenu educationalMenu;
	private JMenu Management;
	// �����˵�
	private JMenuItem administratorltem;
	private JMenuItem scholarshipltem;
	private JMenuItem studentItem;
	private JMenuItem studentroleltem;//ѧ����ɫ
	private JMenuItem scholarshiptypeltem;//
	private JMenuItem announcementltem;//����
	private JMenuItem DifficultStudents;
	private JMenuItem TypesOfStudentsWithDifficulties;
	private JMenuItem Classmanagement;

	public IndexAdmin(String username) {
		// ��ʼ��ҳ��
		indexadmin();
		// ��ܳ�ʼ��
		init(username);
		// ���õ���ص�
		action(username);
	}

	private void action(String username) {
		administratorltem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// ҳ��ת��
				index.setVisible(false);
				// �����µ�ҳ��
				new InformationUI(username);
			}
		});
		scholarshipltem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// ҳ��ת��
				index.setVisible(false);
				// �����µ�ҳ��
				new ScholarshipSeletUI(username);
			}
		});
		studentItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// ҳ��ת��
				index.setVisible(false);
				// �����µ�ҳ��
				new StudentSeletUI(username);
			}
		});
	studentroleltem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//ҳ��ת��
				index.setVisible(false);
				//�����µ�ҳ��
				new StudentRoleSelectUI(username);
			}
		});
	announcementltem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//ҳ��ת��
				index.setVisible(false);
				//�����µ�ҳ��
				new AnnouncementSelectUI(username);
			}
		});
		scholarshiptypeltem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//ҳ��ת��
				index.setVisible(false);
				//�����µ�ҳ��
				new ScholarshipTypeSelectUI(username);
			}
		});
DifficultStudents.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//ҳ��ת��
				index.setVisible(false);
				//�����µ�ҳ��
				new DifficultStudentsUI(username);
			}
		});
		TypesOfStudentsWithDifficulties.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//ҳ��ת��
				index.setVisible(false);
				//�����µ�ҳ��
				new TypesOfStudentsWithDifficultiesUI(username);
			}
		});
		Classmanagement.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//ҳ��ת��
				index.setVisible(false);
				//�����µ�ҳ��
				new ClassmanagementUI(username);
			}
		});
	}

	private void init(String username) {
		// index
		index = new JFrame("��ӭ��" + username + "ʹ��ϵͳ");
		// ����x y w h
		index.setBounds(800, 310, 750, 580);
		// �����˳�
		index.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		index.setVisible(true);
		// ��Ӳ˵�
		index.setJMenuBar(managerMenu);
		index.setLayout(null);
	}

	// ���� �����ַ��� ��������
	private void indexadmin() {
		managerMenu = new JMenuBar();
		// �˵�
		scholarshipMenu = new JMenu("��ѧ���ѯģ��");
		scholarshipMenu.setFont(f);
		educationalMenu=new JMenu("����ģ��");
		educationalMenu.setFont(f);
		Management=new JMenu("��������Ϣģ��");
		Management.setFont(f);
		// �Ӳ˵�
		administratorltem = new JMenuItem("����Ա������Ϣ");
		administratorltem.setFont(m);
		scholarshipltem = new JMenuItem("��ѧ�����");
		scholarshipltem.setFont(m);
		studentItem = new JMenuItem("ѧ������");
		studentItem.setFont(m);
		studentroleltem=new JMenuItem("ѧ����ɫ����");
		studentroleltem.setFont(m);
		scholarshiptypeltem=new JMenuItem("��ѧ�����͹���");
		scholarshiptypeltem.setFont(m);
		announcementltem=new JMenuItem("������Ϣ����");
		announcementltem.setFont(m);
		DifficultStudents=new JMenuItem("����������");
		DifficultStudents.setFont(m);
		TypesOfStudentsWithDifficulties=new JMenuItem("������������");
		TypesOfStudentsWithDifficulties.setFont(m);
		Classmanagement=new JMenuItem("�༶����");
		Classmanagement.setFont(m);

		// ��Ӳ˵�
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
