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
	//���������õ������
	//��ʼ������
	Font f=new Font("����",Font.BOLD,19);
	StudentRole studentRole = new StudentRole();
	//��ʼ������
	JLabel student_snola=new JLabel("ѧ��:");
	JLabel student_namela=new JLabel("����:");
	JLabel student_majorla=new JLabel("רҵ:");
	JLabel student_achievementla=new JLabel("�ɼ�:");
	JLabel student_rankingla=new JLabel("����:");
	JLabel student_gradela=new JLabel("�꼶:");
	
	JTextField student_sno=new JTextField();
	JTextField student_name=new JTextField();
	JTextField student_major=new JTextField();
	JTextField student_achievement=new JTextField();
	JTextField student_ranking=new JTextField();
	JTextField student_grade=new JTextField();
	
	ButtonGroup btButtonGroup = new ButtonGroup();
	JButton addStudentRoleButton=new JButton("����");
	
	public StudentRoleAddUI(String username){
		super(username);
		init();
	}
	private void init(){

		//ѧ��
		student_snola.setBounds(90, 30, 100, 30);
		student_snola.setFont(f);
		//����
		student_namela.setBounds(90, 80, 100, 30);
		student_namela.setFont(f);
		//רҵ
		student_majorla.setBounds(90, 130, 100, 30);
		student_majorla.setFont(f);
		//�ɼ�
		student_achievementla.setBounds(90, 180, 100, 30);
		student_achievementla.setFont(f);
		//����
		student_rankingla.setBounds(90, 230, 100, 30);
		student_rankingla.setFont(f);
		//�꼶
		student_gradela.setBounds(90, 280, 100, 30);
		student_gradela.setFont(f);
		//�����
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
		//��ť
		addStudentRoleButton.setBounds(220, 350, 200, 30);
		addStudentRoleButton.setFont(f);
		//���� Ĭ��
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
		
		//����¼�
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
				//��װ��Ϣ����
				studentRole.setStudent_sno(s);
				studentRole.setStudent_name(student_nameText);
				studentRole.setStudent_major(student_majorText);
				studentRole.setStudent_achievement(student_achievementText);
				studentRole.setStudent_ranking(student_rankingText);
				studentRole.setStudent_grade(student_gradeText);
				//���
				StudentRoleDao studentRoleDao = new StudentRoleDao();
				Boolean b = studentRoleDao.addStudentRole(studentRole);
				if(b) {
					//ҳ��ת��
					index.setVisible(false);
					//������ҳ��
					new StudentRoleSelectUI("");
				}
			}
		});
	}
}



