package com.alg.scholarship.dao;

import java.util.List;
import java.util.Vector;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alg.scholarship.bean.ScholarshipType;
import com.alg.scholarship.bean.Student;
import com.alg.scholarship.bean.StudentRole;
import com.alg.scholarship.utils.JDBCUtils;

public class ScholarshipTypeDao {
	//jdbctemplate
	JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
		
	public Vector findAllScholarshipType() {
		Vector vlist= new Vector<>();
		List<ScholarshipType> list=jt.query("select * from scholarshipType ",new BeanPropertyRowMapper<ScholarshipType> (ScholarshipType.class) );
		for(ScholarshipType scholarship:list){
			Vector v=new Vector();
			v.add(scholarship.getScholarship_id());
			v.add(scholarship.getScholarship_type()==1 ?"国家级" : "校级");
			v.add(scholarship.getScholarship_name());
			v.add(scholarship.getScholarship_brief());
			v.add(scholarship.getScholarship_remarks());
			vlist.add(v);
		}
	return vlist;
}
	public int delScholarshipTypeById(int scholarship_id) {
		return jt.update(" delete from scholarshipType where scholarship_id = ? ",scholarship_id);
	}

	/*
	 * 根据id查询ScholarshipType信息
	 */
	public ScholarshipType findAllScholarshipTypeById(int scholarship_id) {
		return jt.queryForObject(" select * from scholarshipType where scholarship_id = ?", new BeanPropertyRowMapper<ScholarshipType> (ScholarshipType.class),scholarship_id);
	}
	//添加
	public Boolean addScholarshipType(ScholarshipType scholarshipType) {
		int update = jt.update("insert into scholarshiptype(scholarship_id,scholarship_name,scholarship_type,scholarship_brief,scholarship_remarks) values (?,?,?,?,?)",
				scholarshipType.getScholarship_id(),scholarshipType.getScholarship_name(),scholarshipType.getScholarship_type(),scholarshipType.getScholarship_brief(),scholarshipType.getScholarship_remarks());		        
		return update>0 ? true : false;
	}
	
	// 修改执行
		public int updateScholarshipTypeById(ScholarshipType scholarshipType) {
			int update = jt
					.update("update scholarship.scholarshiptype set scholarship_name=?,scholarship_type=?,scholarship_brief=?,scholarship_remarks=? where scholarship_id=?;",
							scholarshipType.getScholarship_name(),scholarshipType.getScholarship_type(),
							scholarshipType.getScholarship_brief(),scholarshipType.getScholarship_remarks(),
							scholarshipType.getScholarship_id());
			return update;
		}

	}