package com.alg.scholarship.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.alg.scholarship.bean.Scholarship;
import com.alg.scholarship.dao.ScholarshipDao;

public class ScholarshipUpdateUI extends IndexAdmin {
	// scholarship
	Scholarship scholarship;

	public ScholarshipUpdateUI(String name, int scholarshipid) {
		super(name);
		// Ϊtype��ֵ
		ScholarshipDao scholarshipDao = new ScholarshipDao();
		// ����id��ѯ��Ϣ
		scholarship = scholarshipDao.findScholarshipById(scholarshipid);
		// ��ʼ��
		init();
	}

	// ���������õ������
	// ��ʼ������
	Font f = new Font("����", Font.BOLD, 19);
	// ��ʼ������
	JLabel idla = new JLabel("��ѧ��id:");
	JLabel namela = new JLabel("��ѧ������:");
	JLabel amountla = new JLabel("���:");
	JLabel typela = new JLabel("��ѧ������:");
	JLabel quotala = new JLabel("����:");
	JLabel declareNumla = new JLabel("�걨����:");
	JLabel successfulNumla = new JLabel("�ɹ�����:");

	JTextField id = new JTextField();
	JTextField name = new JTextField();
	JTextField amount = new JTextField();
	JRadioButton radioButton1 = new JRadioButton("���Ҽ�");
	JRadioButton radioButton2 = new JRadioButton("У��");
	JTextField quota = new JTextField();
	JTextField declareNum = new JTextField();
	JTextField successfulNum = new JTextField();

	// ��ť��
	ButtonGroup btButtonGroup = new ButtonGroup();
	JButton addScholarshipButton = new JButton("�޸�");

	private void init() {
		// ��ť��
		ButtonGroup btButtonGroup = new ButtonGroup();
		btButtonGroup.add(radioButton1);
		btButtonGroup.add(radioButton2);
		// id
		idla.setBounds(80, 20, 120, 30);
		idla.setFont(f);
		// ����
		namela.setBounds(80, 70, 120, 30);
		namela.setFont(f);
		// ���
		amountla.setBounds(80, 120, 120, 30);
		amountla.setFont(f);
		// ����
		typela.setBounds(80, 170, 120, 30);
		typela.setFont(f);
		// ����
		quotala.setBounds(80, 220, 120, 30);
		quotala.setFont(f);
		// �걨����
		declareNumla.setBounds(80, 270, 120, 30);
		declareNumla.setFont(f);
		// �ɹ�����
		successfulNumla.setBounds(80, 320, 120, 30);
		successfulNumla.setFont(f);

		// ����� //���û���
		// id
		id.setBounds(230, 20, 240, 30);
		id.setFont(f);
		id.setText(String.valueOf(scholarship. getScholarshipId()));
		// ����
		name.setBounds(230, 70, 240, 30);
		name.setFont(f);
		name.setText(scholarship.getScholarshipName());
		// ���
		amount.setBounds(230, 120, 240, 30);
		amount.setFont(f);
		amount.setText(String.valueOf(scholarship. getAmount()));
		// ����
		radioButton1.setBounds(230, 170, 100, 30);
		radioButton1.setFont(f);
		radioButton2.setBounds(350, 170, 100, 30);
		radioButton2.setFont(f);
		// ����
		quota.setBounds(230, 220, 240, 30);
		quota.setFont(f);
	    quota.setText(String.valueOf(scholarship. getQuota()));
		// �걨����
		declareNum.setBounds(230, 270, 240, 30);
		declareNum.setFont(f);
		declareNum.setText(String.valueOf(scholarship. getDeclareNum()));
		// �ɹ�����
		successfulNum.setBounds(230, 320, 240, 30);
		successfulNum.setFont(f);
		successfulNum.setText(String.valueOf(scholarship. getSuccessfulNum()));

		// ��ť
		addScholarshipButton.setBounds(170, 380, 180, 50);
		addScholarshipButton.setFont(f);
		// ���� Ĭ��
		radioButton1.setSelected(scholarship.getScholarshipType() == 1 ? true : false);
		radioButton2.setSelected(scholarship.getScholarshipType() == 0 ? true : false);

		index.add(idla);
		index.add(namela);
		index.add(amountla);
		index.add(typela);
		index.add(quotala);
		index.add(declareNumla);
		index.add(successfulNumla);

		index.add(id);
		index.add(name);
		index.add(amount);
		index.add(radioButton1);
		index.add(radioButton2);
		index.add(quota);
		index.add(declareNum);
		index.add(successfulNum);
		index.add(addScholarshipButton);

		// ����¼�
		addScholarshipButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String idText = id.getText();
				int i = Integer.parseInt(idText);
				String nameText = name.getText();
				String amountText = amount.getText();
				int a = Integer.parseInt(amountText);
				String quotaText = quota.getText();
				int m = Integer.parseInt(quotaText);
				String declareNumText = declareNum.getText();
				int c = Integer.parseInt(declareNumText);
				String successfulNumText = successfulNum.getText();
				int d = Integer.parseInt(successfulNumText);
				// ��װ��Ϣ����
				scholarship.setScholarshipId(i);
				scholarship.setScholarshipName(nameText);
				scholarship.setAmount(a);
				scholarship.setQuota(m);
				scholarship.setDeclareNum(c);
				scholarship.setSuccessfulNum(d);
				if (radioButton1.isSelected()) {
					scholarship.setScholarshipType(1);
				}
				if (radioButton2.isSelected()) {
					scholarship.setScholarshipType(2);
				}


				// �޸�
				ScholarshipDao scholarshipDao = new ScholarshipDao();
				int i1 = scholarshipDao.updateScholarshipById(scholarship);
				if (i1 == 1) {
					// ҳ��ת��
					index.setVisible(false);
					// �����µ�ҳ��
					new ScholarshipSeletUI("mkx");
				}

			}
		});
	}
}
