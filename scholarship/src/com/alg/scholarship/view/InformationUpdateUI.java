package com.alg.scholarship.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.alg.scholarship.bean.Information;
import com.alg.scholarship.dao.InformationDao;

public class InformationUpdateUI extends IndexAdmin {
	// information
	Information information;

	public InformationUpdateUI(String username, int informationid) {
		super(username);
		// Ϊtype��ֵ
		InformationDao informationDao = new InformationDao();
		// ����id��ѯ��Ϣ
		information = informationDao.findInformationById(informationid);
		// ��ʼ��
		init();
	}

	// ���������õ������
	// ��ʼ������
	Font f = new Font("����", Font.BOLD, 19);
	// ��ʼ������
	JLabel idla = new JLabel("id:");
	JLabel usernamela = new JLabel("�û���:");
	JLabel passwordla = new JLabel("����:");
	JLabel usertypela = new JLabel("�û����:");
	JLabel telephonela = new JLabel("�绰:");
	JLabel classnamela = new JLabel("�༶:");
	JLabel addressla = new JLabel("��ַ:");
	JLabel teacherla = new JLabel("��ʦ:");

	JTextField id = new JTextField();
	JTextField username = new JTextField();
	JTextField password = new JTextField();
	JRadioButton radioButton1 = new JRadioButton("ѧ��");
	JRadioButton radioButton2 = new JRadioButton("��ʦ");
	JTextField telephone = new JTextField();
	JTextField classname = new JTextField();
	JTextField address = new JTextField();
	JTextField teacher = new JTextField();

	// ��ť��
	ButtonGroup btButtonGroup = new ButtonGroup();
	JButton addInformationButton = new JButton("�޸�");

	private void init() {
		// ��ť��
		ButtonGroup btButtonGroup = new ButtonGroup();
		btButtonGroup.add(radioButton1);
		btButtonGroup.add(radioButton2);
		// id
		idla.setBounds(100, 20, 100, 30);
		idla.setFont(f);
		// �û���
		usernamela.setBounds(100, 70, 100, 30);
		usernamela.setFont(f);
		// ����
		passwordla.setBounds(100, 120, 100, 30);
		passwordla.setFont(f);
		// �û����
		usertypela.setBounds(100, 170, 100, 30);
		usertypela.setFont(f);
		// �绰
		telephonela.setBounds(100, 220, 100, 30);
		telephonela.setFont(f);
		// �༶
		classnamela.setBounds(100, 270, 100, 30);
		classnamela.setFont(f);
		// ��ַ
		addressla.setBounds(100, 320, 100, 30);
		addressla.setFont(f);
		// ��ʦ
		teacherla.setBounds(100, 370, 100, 30);
		teacherla.setFont(f);

		// �����  //���û���
		// id
		id.setBounds(230, 20, 240, 30);
		id.setFont(f);
		id.setText(String.valueOf(information.getUserId()));
		// �û���
		username.setBounds(230, 70, 240, 30);
		username.setFont(f);
		username.setText(information.getUserName());
		// ����
		password.setBounds(230, 120, 240, 30);
		password.setFont(f);
		password.setText(information.getPassWord());
		// �û����
		radioButton1.setBounds(230, 170, 80, 30);
		radioButton1.setFont(f);
		radioButton2.setBounds(330, 170, 80, 30);
		radioButton2.setFont(f);
		// �绰
		telephone.setBounds(230, 220, 240, 30);
		telephone.setFont(f);
		telephone.setText(information.getTelephone());
		// �༶
		classname.setBounds(230, 270, 240, 30);
		classname.setFont(f);
		classname.setText(information.getClassName());
		// ��ַ
		address.setBounds(230, 320, 240, 30);
		address.setFont(f);
		address.setText(information.getHomeAddress());
		// ��ʦ
		teacher.setBounds(230, 370, 240, 30);
		teacher.setFont(f);
		teacher.setText(information.getTeacher());
		// ��ť
		addInformationButton.setBounds(170, 420, 180, 50);
		addInformationButton.setFont(f);
		// ���� Ĭ��
		radioButton1.setSelected(information.getUserType()==1 ? true:false);
		radioButton2.setSelected(information.getUserType()==0 ? true:false);

		index.add(idla);
		index.add(usernamela);
		index.add(passwordla);
		index.add(usertypela);
		index.add(telephonela);
		index.add(classnamela);
		index.add(addressla);
		index.add(teacherla);

		index.add(id);
		index.add(username);
		index.add(password);
		index.add(radioButton1);
		index.add(radioButton2);
		index.add(telephone);
		index.add(classname);
		index.add(address);
		index.add(teacher);
		index.add(addInformationButton);

		// ����¼�
		addInformationButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String idText = id.getText();
				int i = Integer.parseInt(idText);
				String usernameText = username.getText();
				String passwordText = password.getText();
				String addressText = address.getText();
				String classnameText = classname.getText();
				String telephoneText = telephone.getText();
				String teacherText = teacher.getText();
				// ��װ��Ϣ����
				information.setUserId(i);
				information.setUserName(usernameText);
				information.setPassWord(passwordText);
				information.setHomeAddress(addressText);
				information.setClassName(classnameText);
				information.setTelephone(telephoneText);
				information.setTeacher(teacherText);
				if (radioButton1.isSelected()) {
					information.setUserType(1);
				}
				if (radioButton2.isSelected()) {
					information.setUserType(2);
				}

				// �޸�
				InformationDao informationDao = new InformationDao();
				int i1= informationDao.updateInformationById(information);
				if (i1==1) {
					// ҳ��ת��
					index.setVisible(false);
					// �����µ�ҳ��
					new InformationUI("mkx");
				}
				
			}
		});
	}
}
