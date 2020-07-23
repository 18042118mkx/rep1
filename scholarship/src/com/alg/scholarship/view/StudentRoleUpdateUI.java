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

public class StudentRoleUpdateUI extends IndexAdmin{
	// StudentRole
	StudentRole studentRole;

		public StudentRoleUpdateUI(String username, int studentRoleid) {
			super(username);
			// Ϊtype��ֵ
			StudentRoleDao studentRoleDao = new StudentRoleDao();
			// ����id��ѯ��Ϣ
			studentRole = studentRoleDao.findAllStudentRoleById(studentRoleid);
			// ��ʼ��
			init();
		}

		// ���������õ������
		// ��ʼ������
		Font f = new Font("����", Font.BOLD, 19);
		// ��ʼ������
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

		// ��ť��
		ButtonGroup btButtonGroup = new ButtonGroup();
		JButton addStudentRoleButton = new JButton("�޸�");

		private void init() {

			//ѧ��
			student_snola.setBounds(180, 20, 100, 30);
			student_snola.setFont(f);
			//����
			student_namela.setBounds(180, 70, 100, 30);
			student_namela.setFont(f);
			//רҵ
			student_majorla.setBounds(180, 120, 100, 30);
			student_majorla.setFont(f);
			//�ɼ�
			student_achievementla.setBounds(180, 170, 100, 30);
			student_achievementla.setFont(f);
			//����
			student_rankingla.setBounds(180, 220, 100, 30);
			student_rankingla.setFont(f);
			//�꼶
			student_gradela.setBounds(180, 270, 100, 30);
			student_gradela.setFont(f);

			// ����� //���û���
			student_sno.setBounds(250, 20, 200, 30);
			student_sno.setFont(f);
			student_sno.setText(String.valueOf( studentRole.getStudent_sno()));
			
			student_name.setBounds(250, 70, 200, 30);
			student_name.setFont(f);
			student_name.setText(studentRole.getStudent_name());
			
			student_major.setBounds(250, 120, 200, 30);
			student_major.setFont(f);
			student_major.setText(studentRole.getStudent_major());
			
			student_achievement.setBounds(250,170, 200, 30);
			student_achievement.setFont(f);
			student_achievement.setText(studentRole.getStudent_achievement());
			
			student_ranking.setBounds(250, 220, 200, 30);
			student_ranking.setFont(f);
			student_ranking.setText(studentRole.getStudent_ranking());
			
			student_grade.setBounds(250, 270, 200, 30);
			student_grade.setFont(f);
			student_grade.setText(studentRole.getStudent_grade());
			//��ť
			addStudentRoleButton.setBounds(220, 350, 200, 30);
			addStudentRoleButton.setFont(f);
			
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

			// ����¼�
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
					// ��װ��Ϣ����
					studentRole.setStudent_sno(s);
					studentRole.setStudent_name(student_nameText);
					studentRole.setStudent_major(student_majorText);
					studentRole.setStudent_achievement(student_achievementText);
					studentRole.setStudent_ranking(student_rankingText);
					studentRole.setStudent_grade(student_gradeText);

					// �޸�
					StudentRoleDao studentRoleDao=new StudentRoleDao();
					int i1 = studentRoleDao.updateStudentRoleById(studentRole);
					if (i1 == 1) {
						// ҳ��ת��
						index.setVisible(false);
						// �����µ�ҳ��
						new StudentRoleSelectUI("");
					}

				}
			});
		}
}
