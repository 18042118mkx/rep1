package com.alg.scholarship.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.alg.scholarship.bean.Classmanagement;
import com.alg.scholarship.dao.ClassmanagementDao;

public class ClassmanagementUpdateUI extends IndexAdmin{
	// student
	Classmanagement classmanagement;

		public ClassmanagementUpdateUI(String username, int classmanagementid) {
			super(username);
			// Ϊtype��ֵ
			ClassmanagementDao classmanagementDao = new ClassmanagementDao();
			// ����id��ѯ��Ϣ
			classmanagement = classmanagementDao.findClassmanagementById(classmanagementid);
			// ��ʼ��
			init();
		}

		// ���������õ������
		// ��ʼ������
		Font f = new Font("����", Font.BOLD, 19);
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
		JButton addStudentButton = new JButton("�޸�");

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

			// ����� //���û���
			// id
			id.setBounds(230, 20, 240, 30);
			id.setFont(f);
			id.setText(String.valueOf(classmanagement.getId()));
			//�༶
			classname.setBounds(230, 70, 240, 30);
			classname.setFont(f);
			classname.setText(classmanagement.getClassname());
			// ����
			num.setBounds(230, 120, 240, 30);
			num.setFont(f);
			num.setText(String.valueOf(classmanagement.getNum()));
			// ������
			principal.setBounds(230, 220, 240, 30);
			principal.setFont(f);
			principal.setText(classmanagement.getPrincipal());
			// ״̬
			radioButton1.setBounds(230, 170, 80, 30);
			radioButton2.setBounds(330, 170, 80, 30);
			
			// ��ť
			addStudentButton.setBounds(170, 290, 180, 50);
			addStudentButton.setFont(f);
			// ���� Ĭ��
			radioButton1.setSelected(classmanagement.getState() == 0 ? true : false);
			radioButton2.setSelected(classmanagement.getState() == 1 ? true : false);

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



					// �޸�
					ClassmanagementDao classmanagementDao = new ClassmanagementDao();
					int i1 = classmanagementDao.updateClassmanagementById(classmanagement);
					if (i1 == 1) {
						// ҳ��ת��
						index.setVisible(false);
						// �����µ�ҳ��
						new ClassmanagementUI("mkx");
					}

				}
			});
		}

}