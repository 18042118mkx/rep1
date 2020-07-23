package com.alg.scholarship.dao;

import java.util.List;
import java.util.Vector;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alg.scholarship.bean.Scholarship;
import com.alg.scholarship.utils.JDBCUtils;

public class ScholarshipDao {
	// jdbctemplate
	JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());

	public Vector findAllScholarship() {
		Vector vlist = new Vector<>();
		List<Scholarship> list = jt.query("select * from scholarshipmanage ",
				new BeanPropertyRowMapper<Scholarship>(Scholarship.class));
		for (Scholarship scholarship : list) {
			Vector v = new Vector();
			v.add(scholarship.getScholarshipId());
			v.add(scholarship.getScholarshipName());
			v.add(scholarship.getAmount());
			v.add(scholarship.getScholarshipType() == 1 ? "���Ҽ�" : "У��");
			v.add(scholarship.getQuota());
			v.add(scholarship.getDeclareNum());
			v.add(scholarship.getSuccessfulNum());

			vlist.add(v);
		}
		return vlist;
	}

	public Boolean addScholarship(Scholarship scholarship) {
		int update = jt
				.update("insert into scholarshipmanage(scholarshipId,scholarshipName,amount,scholarshipType,quota,declareNum,successfulNum) values (?,?,?,?,?,?,?)",
						scholarship.getScholarshipId(), scholarship.getScholarshipName(),
						scholarship.getAmount(), scholarship.getScholarshipType(),
						scholarship.getQuota(), scholarship.getDeclareNum(),
						scholarship.getSuccessfulNum());
		return update > 0 ? true : false;
	}

	public int delScholarshipById(int scholarshipid) {
		return jt.update("delete from scholarshipmanage where scholarshipId=?", scholarshipid);
	}

	// ����id��ȡ��Ϣ
	public Scholarship findScholarshipById(int scholarshipid) {
		return jt.queryForObject("select * from scholarshipmanage where scholarshipId=?",
				new BeanPropertyRowMapper<Scholarship>(Scholarship.class),
				scholarshipid);
	}

	// �޸�ִ��
	public int updateScholarshipById(Scholarship scholarship) {
		int update = jt
				.update("update scholarship.scholarshipmanage set scholarshipName=?,amount=?,scholarshipType=?,quota=?,declareNum=?,successfulNum=? where scholarshipId=?;",
						scholarship.getScholarshipName(),
						scholarship.getAmount(), scholarship.getScholarshipType(),
						scholarship.getQuota(), scholarship.getDeclareNum(),
						scholarship.getSuccessfulNum(),scholarship.getScholarshipId());
		return update;
	}

}
