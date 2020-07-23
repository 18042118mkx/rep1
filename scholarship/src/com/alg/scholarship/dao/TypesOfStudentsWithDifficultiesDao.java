package com.alg.scholarship.dao;

import java.util.List;
import java.util.Vector;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alg.scholarship.bean.TypesOfStudentsWithDifficulties;
import com.alg.scholarship.bean.TypesOfStudentsWithDifficulties;
import com.alg.scholarship.utils.JDBCUtils;

public class TypesOfStudentsWithDifficultiesDao {
	//jdbctemplate
	JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
public Vector findAllTypesOfStudentsWithDifficulties() {
Vector vlist= new Vector<>();
List<TypesOfStudentsWithDifficulties> list=jt.query("select * from typesofstudentswithdifficulties ",new BeanPropertyRowMapper<TypesOfStudentsWithDifficulties> (TypesOfStudentsWithDifficulties.class) );
for(TypesOfStudentsWithDifficulties typesOfStudentsWithDifficulties:list){
	Vector v=new Vector();
	v.add(typesOfStudentsWithDifficulties.getId());
	v.add(typesOfStudentsWithDifficulties.getType());
	v.add(typesOfStudentsWithDifficulties.getHealthy());
	v.add(typesOfStudentsWithDifficulties.getIncome());
	v.add(typesOfStudentsWithDifficulties.getRegion());
	vlist.add(v);
}
return vlist;
}

public Boolean addTypesOfStudentsWithDifficulties(TypesOfStudentsWithDifficulties typesOfStudentsWithDifficulties) {
	int update=jt.update("insert into typesOfStudentsWithDifficulties(id,type,healthy,income,region) values (?,?,?,?,?)",
			typesOfStudentsWithDifficulties.getId(),typesOfStudentsWithDifficulties.getType(),typesOfStudentsWithDifficulties.getHealthy(),typesOfStudentsWithDifficulties.getIncome(),typesOfStudentsWithDifficulties.getRegion());
	return update>0 ? true : false;
}



//根据id获取信息
public TypesOfStudentsWithDifficulties findTypesOfStudentsWithDifficultiesById(int typesOfStudentsWithDifficultiesid) {
	return jt.queryForObject("select * from typesOfStudentsWithDifficulties where id=?", new BeanPropertyRowMapper<TypesOfStudentsWithDifficulties>(TypesOfStudentsWithDifficulties.class),typesOfStudentsWithDifficultiesid);
}

//修改执行
public int updateTypesOfStudentsWithDifficultiesById(TypesOfStudentsWithDifficulties typesOfStudentsWithDifficulties) {
	int update=jt.update("update scholarship.typesOfStudentsWithDifficulties set Type=?,Healthy=?,Income=?,Region=? where id=?;",
			typesOfStudentsWithDifficulties.getType(),typesOfStudentsWithDifficulties.getHealthy(),typesOfStudentsWithDifficulties.getIncome(),typesOfStudentsWithDifficulties.getRegion(),typesOfStudentsWithDifficulties.getId());
	return update;
}

public int deltypesOfStudentsWithDifficultiesById(int typesOfStudentsWithDifficultiesid) {
	return jt.update("delete from typesOfStudentsWithDifficulties where id=?",typesOfStudentsWithDifficultiesid);
}
}
