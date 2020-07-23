package com.alg.scholarship.dao;

import java.util.List;
import java.util.Vector;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alg.scholarship.bean.Classmanagement;
import com.alg.scholarship.utils.JDBCUtils;

public class ClassmanagementDao {
	//jdbctemplate
			JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
	public Vector findAllClassmanagement() {
		Vector vlist= new Vector<>();
		List<Classmanagement> list=jt.query("select * from classmanagement ",new BeanPropertyRowMapper<Classmanagement> (Classmanagement.class) );
		for(Classmanagement classmanagement:list){
			Vector v=new Vector();
			v.add(classmanagement.getId());
			v.add(classmanagement.getClassname());
			v.add(classmanagement.getNum());
			v.add(classmanagement.getState());
			v.add(classmanagement.getPrincipal());
			vlist.add(v);
		}
	return vlist;
	}
	public Boolean addClassmanagement(Classmanagement classmanagement) {
		int update=jt.update("insert into classmanagement(id,classname,num,state,principal) values (?,?,?,?,?)",
				classmanagement.getId(),classmanagement.getClassname(),classmanagement.getNum(),classmanagement.getState(),classmanagement.getPrincipal());
		return update>0 ? true : false;
	}

	

	//根据id获取信息
	public Classmanagement findClassmanagementById(int classmanagementid) {
		return jt.queryForObject("select * from classmanagement where id=?", new BeanPropertyRowMapper<Classmanagement>(Classmanagement.class),classmanagementid);
	}
	
	//修改执行
	public int updateClassmanagementById(Classmanagement classmanagement) {
		int update=jt.update("update scholarship.classmanagement set Classname=?,Num=?,State=?,Principal=? where id=?;",
				classmanagement.getClassname(),classmanagement.getNum(),classmanagement.getState(),classmanagement.getPrincipal(),classmanagement.getId());
		return update;
	}

	public int delclassmanagementById(int classmanagementid) {
		return jt.update("delete from classmanagement where id=?",classmanagementid);
	}
}
