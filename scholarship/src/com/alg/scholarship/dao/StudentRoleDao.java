package com.alg.scholarship.dao;

import java.util.List;
import java.util.Vector;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alg.scholarship.bean.Announcement;
import com.alg.scholarship.bean.StudentRole;
import com.alg.scholarship.utils.JDBCUtils;

public class StudentRoleDao {
	//jdbctemplate
	JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
		
	public Vector findAllStudentRole() {
		Vector vlist= new Vector<>();
		List<StudentRole> list=jt.query("select * from studentRole  ",new BeanPropertyRowMapper<StudentRole> (StudentRole.class) );
		for(StudentRole studentrole:list){
			Vector v=new Vector();
			v.add(studentrole.getStudent_sno());
			v.add(studentrole.getStudent_name());
			v.add(studentrole.getStudent_major());
			v.add(studentrole.getStudent_achievement());
			v.add(studentrole.getStudent_ranking());
			v.add(studentrole.getStudent_grade());
			vlist.add(v);
		}
	return vlist;
}

	public int delStudentRoleById(int student_sno) {
		return jt.update(" delete from studentRole where student_sno = ? ",student_sno);
	}

	public boolean addStudentRole(StudentRole studentrole) {
		int update = jt.update("INSERT INTO `scholarship`.`studentrole`(`student_sno`, `Student_name`, `Student_major`, `Student_achievement`, `Student_ranking`, `Student_grade`) VALUES (?, ?, ?, ?, ?, ?);",
				studentrole.getStudent_sno(),studentrole.getStudent_name(),studentrole.getStudent_major(),studentrole.getStudent_achievement(),studentrole.getStudent_ranking(),studentrole.getStudent_grade());
		        
		return update>0 ? true : false;}
	/*
	 * 根据id查询StudentRole信息
	 */

	public StudentRole findAllStudentRoleById(int student_sno) {
		return jt.queryForObject(" select * from studentRole where student_sno = ?", new BeanPropertyRowMapper<StudentRole> (StudentRole.class),student_sno);
	}
//修改执行
	public int updateStudentRoleById(StudentRole studentrole) {
		int update = jt
				.update("update scholarship.studentrole set Student_name=?,Student_major=?,Student_achievement=?,Student_ranking=?,Student_grade=? where student_sno=?;",
						studentrole.getStudent_name(),studentrole.getStudent_major(),studentrole.getStudent_achievement(),studentrole.getStudent_ranking(),studentrole.getStudent_grade(),studentrole.getStudent_sno());
		return update;
	
	}
}


