package com.alg.scholarship.dao;

import java.util.List;
import java.util.Vector;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alg.scholarship.bean.DifficultStudents;
import com.alg.scholarship.bean.DifficultStudents;
import com.alg.scholarship.utils.JDBCUtils;

public class DifficultStudentsDao {
	//jdbctemplate
			JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
	public Vector findAllDifficultStudents() {
		Vector vlist= new Vector<>();
		List<DifficultStudents> list=jt.query("select * from difficultstudents ",new BeanPropertyRowMapper<DifficultStudents> (DifficultStudents.class) );
		for(DifficultStudents difficultStudents:list){
			Vector v=new Vector();
			v.add(difficultStudents.getId());
			v.add(difficultStudents.getUsername());
			v.add(difficultStudents.getClassname());
			v.add(difficultStudents.getTelephone());
			v.add(difficultStudents.getType());
			vlist.add(v);
		}
	return vlist;
	}
	
	public Boolean addDifficultStudents(DifficultStudents difficultstudents) {
		int update=jt.update("insert into difficultstudents(id,username,classname,telephone,type) values (?,?,?,?,?)",
				difficultstudents.getId(),difficultstudents.getUsername(),difficultstudents.getClassname(),difficultstudents.getTelephone(),difficultstudents.getType());
		return update>0 ? true : false;
	}

	

	//根据id获取信息
	public DifficultStudents findDifficultstudentsById(int difficultStudentsid) {
		return jt.queryForObject("select * from difficultstudents where id=?", new BeanPropertyRowMapper<DifficultStudents>(DifficultStudents.class),difficultStudentsid);
	}
	
	//修改执行
	public int updateDifficultstudentsById(DifficultStudents difficultstudents) {
		int update=jt.update("update scholarship.difficultstudents set Username=?,Classname=?,Telephone=?,Type=? where id=?;",
				difficultstudents.getUsername(),difficultstudents.getClassname(),difficultstudents.getTelephone(),difficultstudents.getType(),difficultstudents.getId());
		return update;
	}

	public int deldifficultStudentsById(int difficultStudentsid) {
		return jt.update("delete from difficultstudents where id=?",difficultStudentsid);
	}
}
