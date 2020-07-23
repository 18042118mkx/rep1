package com.alg.scholarship.view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.alg.scholarship.bean.Classmanagement;
import com.alg.scholarship.dao.ClassmanagementDao;

import javax.swing.*;



public class ClassmanagementAddUI extends IndexAdmin{
	public ClassmanagementAddUI(String username) {
		super(username);
		init();
	}

	// ���������õ������
			// ��ʼ������
			Font f = new Font("����", Font.BOLD, 19);
			Classmanagement classmanagement=new Classmanagement();
			// ��ʼ������
			JLabel idla = new JLabel("id:");
			JLabel classnamela = new JLabel("�༶:");
			JLabel numla = new JLabel("����:");
			JLabel statela = new JLabel("״̬:");
			JLabel principalla = new JLabel("������:");
			

			JTextField id = new JTextField();
			JTextField classname = new JTextField();
			JTextField num= new JTextField();
			JRadioButton radioButton1 = new JRadioButton("�ɹ�");
			JRadioButton radioButton2 = new JRadioButton("ʧ��");
			JTextField principal = new JTextField();
			

			// ��ť��
			ButtonGroup btButtonGroup = new ButtonGroup();
			JButton addStudentButton = new JButton("����");


			private void init() {
				// ��ť��
				ButtonGroup btButtonGroup = new ButtonGroup();
				btButtonGroup.add(radioButton1);
				btButtonGroup.add(radioButton2);
				// id
				idla.setBounds(100, 20, 100, 30);
				idla.setFont(f);
				// �༶
				classnamela.setBounds(100, 70, 100, 30);
				classnamela.setFont(f);
				// ����
				numla.setBounds(100, 120, 100, 30);
				numla.setFont(f);
				// ״̬
				statela.setBounds(100, 170, 100, 30);
				statela.setFont(f);
				//������
				principalla.setBounds(100, 220, 100, 30);
				principalla.setFont(f);
				

				// �����
				// id
				id.setBounds(230, 20, 240, 30);
				id.setFont(f);
				// �༶
				classname.setBounds(230, 70, 240, 30);
				classname.setFont(f);
				// ����
				num.setBounds(230, 120, 240, 30);
				num.setFont(f);
				// ״̬
				radioButton1.setBounds(230, 170, 80, 30);
				radioButton2.setBounds(330, 170, 80, 30);
				// ������
				principal.setBounds(230, 220, 240, 30);
				principal.setFont(f);
				

				// ��ť
				addStudentButton.setBounds(170, 290, 180, 50);
				addStudentButton.setFont(f);
				// ���� Ĭ��
				radioButton1.setSelected(true);

				index.add(idla);
				index.add(classnamela);
				index.add(numla);
				index.add(principalla);
				index.add(statela);
				index.add(id);
				index.add(classname);
				index.add(num);
				index.add(principal);
				index.add(radioButton1);
				index.add(radioButton2);
				
				index.add(addStudentButton);

				// ����¼�
				addStudentButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {

						String idText = id.getText();
						int i = Integer.parseInt(idText);
						String classnameText = classname.getText();
						String numText = num.getText();
						int n = Integer.parseInt(numText);
						String principalText = principal.getText();
	
						// ��װ��Ϣ����
						classmanagement.setId(i);
						classmanagement.setClassname(classnameText);
						classmanagement.setNum(n);
						classmanagement.setPrincipal(principalText);
						if (radioButton1.isSelected()) {
							classmanagement.setState(1);
						}
						if (radioButton2.isSelected()) {
							classmanagement.setState(2);
						}

						// ���
						ClassmanagementDao classmanagementDao = new ClassmanagementDao();
						Boolean b = classmanagementDao.addClassmanagement(classmanagement);
						if (b) {
							// ҳ��ת��
							index.setVisible(false);
							// �����µ�ҳ��
							new ClassmanagementUI("mkx");
						}
					}
				});
			}

}
