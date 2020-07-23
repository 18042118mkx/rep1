package com.alg.scholarship.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import com.alg.scholarship.bean.User;
import com.alg.scholarship.utils.JDBCUtils;

public class UserDao {
	//jdbctemplate
	JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
	public Boolean checkUser(User user){
	try{
	User u= jt.queryForObject(
 	"select * from user where username = ? and password = ? ",
	new BeanPropertyRowMapper<>(User.class),
	user.getUserName(),user.getPassWord());
	}catch(Exception e){
		return false;
	}
	   return true;
   }
	
	//ÃÌº””√ªß
	public int saveUser(User user) {
		return jt.update("insert into user(username,password,usertype) values (?,?,?);",
				user.getUserName(),user.getPassWord(),user.getUserType());
	}
}
