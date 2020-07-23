package com.alg.scholarship.dao;

import java.util.List;
import java.util.Vector;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alg.scholarship.bean.Information;
import com.alg.scholarship.bean.User;
import com.alg.scholarship.utils.JDBCUtils;

public class InformationDao {
	//jdbctemplate
		JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
		
		public Vector findAllInformation() {
			Vector vlist= new Vector<>();
			List<Information> list=jt.query("select * from user ",new BeanPropertyRowMapper<Information> (Information.class) );
			for(Information information:list){
				Vector v=new Vector();
				v.add(information.getUserId());
				v.add(information.getUserName());
				v.add(information.getPassWord());
				v.add(information.getUserType()==1?"学生":"教师");
				v.add(information.getTelephone());
				v.add(information.getClassName());
				v.add(information.getHomeAddress());
				v.add(information.getTeacher());
				
				
				vlist.add(v);
			}
		return vlist;
	}

		public Boolean addInformation(Information information) {
			int update=jt.update("insert into user(userid,username,password,usertype,telephone,classname,homeaddress,teacher) values (?,?,?,?,?,?,?,?)",
					information.getUserId(),information.getUserName(),information.getPassWord(),information.getUserType(),information.getTelephone(),information.getClassName(),information.getHomeAddress(),information.getTeacher());
			return update>0 ? true : false;
		}

		public int delInformationById(int informationid) {
					return jt.update("delete from user where userid=?",informationid);
		}

		//根据id获取信息
		public Information findInformationById(int informationid) {
			return jt.queryForObject("select * from user where userid=?", new BeanPropertyRowMapper<Information>(Information.class),informationid);
		}
		
		//修改执行
		public int updateInformationById(Information information) {
			int update=jt.update("update scholarship.user set username=?,password=?,usertype=?,telephone=?,classname=?,homeaddress=?,teacher=? where userid=?;",
					information.getUserName(),information.getPassWord(),information.getUserType(),information.getTelephone(),information.getClassName(),information.getHomeAddress(),information.getTeacher(),information.getUserId());
			return update;
		}

}
