package com.mkx.jdbc;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import a.User;
import dao.UserDao;
import dao.UserDaoImpl;
public class Mkx1JdbcTemplate {

	public static void main(String[] args) {
		//调用方法   alt+shift+m 抽取方法
		//findAllUser();
		//findOneUser();
		//addUser();
		//updateUser();
		//deleteUser();
		deleteUser1();
	}
	
	//删除方法 根据姓名删除
	private static void deleteUser1() {
		JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
		int update = jt.update("delete from person where name=?","李四");
		System.out.println(update);
	}
	
	//删除方法 根据id删除
			private static void deleteUser() {
				JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
				int update = jt.update("delete from person where id=?",5);
				System.out.println(update);
			}
	
	//修改方法
		private static void updateUser() {
			JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
			int update = jt.update("update person set name=?,username=?,password=?,age=?,de=?,height=? where id=?","妲己","daji",753,15,"漂亮",45,3);
			System.out.println(update);
		}
	
	//添加方法
	private static void addUser() {
		JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
		String sql="insert into person(name,username,password,age,de,height) values (?,?,?,?,?,?)";
		int update = jt.update(sql,"亚索","tasuo",369,64,"厉害",74);
		System.out.println(update);
	}
	
	private static void findAllUser() {
		// 查询所有英雄
				UserDao ud = new UserDaoImpl();
				List<User> list=ud.findAllUser();
				for(User user:list){
					System.out.println(user);
				}
		}
		
		private static void findOneUser() {
			// 根据id查询单个英雄
			JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
			String sql="select * from person where id=1";
			List<User> list=jt.query(sql, new BeanPropertyRowMapper<User>(User.class));
			for(User user:list){
				System.out.println(user);
			}
	}

}
