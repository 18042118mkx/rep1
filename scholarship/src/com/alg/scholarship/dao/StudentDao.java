package com.alg.scholarship.dao;

import java.util.List;
import java.util.Vector;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alg.scholarship.bean.Student;
import com.alg.scholarship.utils.JDBCUtils;

public class StudentDao {

	// jdbctemplate
	JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());

	// ��ȡȫ��ѧ����Ϣ
	public Vector findAllStudent() {
		Vector vlist = new Vector<>();
		List<Student> list = jt.query("select * from student ",
				new BeanPropertyRowMapper<Student>(Student.class));
		for (Student student : list) {
			Vector v = new Vector();
			v.add(student.getUserId());
			v.add(student.getUserName());
			v.add(student.getCredit());
			v.add(student.getGrade());
			v.add(student.getState() == 1 ? "�ɹ�" : "ʧ��");

			vlist.add(v);
		}
		return vlist;
	}

	public Boolean addStudent(Student student) {
		int update = jt
				.update("insert into student(userid,username,credit,grade,state) values (?,?,?,?,?)",
						student.getUserId(), student.getUserName(),
						student.getCredit(), student.getGrade(),
						student.getState());
		return update > 0 ? true : false;
	}

	public int delStudentById(int studentid) {
		return jt.update("delete from student where userid=?", studentid);
	}

	// ����id��ȡ��Ϣ
	public Student findStudentById(int studentid) {
		return jt.queryForObject("select * from student where userid=?",
				new BeanPropertyRowMapper<Student>(Student.class), studentid);
	}

	// �޸�ִ��
	public int updateStudentById(Student student) {
		int update = jt
				.update("update scholarship.student set username=?,credit=?,grade=?,state=? where userid=?;",
						student.getUserName(), student.getCredit(),
						student.getGrade(), student.getState(),
						student.getUserId());
		return update;
	}

}
