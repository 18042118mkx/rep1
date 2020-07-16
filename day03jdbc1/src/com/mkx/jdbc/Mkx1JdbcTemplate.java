package com.mkx.jdbc;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import a.User;
import dao.UserDao;
import dao.UserDaoImpl;
public class Mkx1JdbcTemplate {

	public static void main(String[] args) {
		//���÷���   alt+shift+m ��ȡ����
		//findAllUser();
		//findOneUser();
		//addUser();
		//updateUser();
		//deleteUser();
		deleteUser1();
	}
	
	//ɾ������ ��������ɾ��
	private static void deleteUser1() {
		JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
		int update = jt.update("delete from person where name=?","����");
		System.out.println(update);
	}
	
	//ɾ������ ����idɾ��
			private static void deleteUser() {
				JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
				int update = jt.update("delete from person where id=?",5);
				System.out.println(update);
			}
	
	//�޸ķ���
		private static void updateUser() {
			JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
			int update = jt.update("update person set name=?,username=?,password=?,age=?,de=?,height=? where id=?","槼�","daji",753,15,"Ư��",45,3);
			System.out.println(update);
		}
	
	//��ӷ���
	private static void addUser() {
		JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
		String sql="insert into person(name,username,password,age,de,height) values (?,?,?,?,?,?)";
		int update = jt.update(sql,"����","tasuo",369,64,"����",74);
		System.out.println(update);
	}
	
	private static void findAllUser() {
		// ��ѯ����Ӣ��
				UserDao ud = new UserDaoImpl();
				List<User> list=ud.findAllUser();
				for(User user:list){
					System.out.println(user);
				}
		}
		
		private static void findOneUser() {
			// ����id��ѯ����Ӣ��
			JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
			String sql="select * from person where id=1";
			List<User> list=jt.query(sql, new BeanPropertyRowMapper<User>(User.class));
			for(User user:list){
				System.out.println(user);
			}
	}

}
