package com.mkx.jdbc;

import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mysql.jdbc.Connection;

public class Mkx1Druid {
	public static void main(String[] args) throws Exception{
		Properties pro = new Properties();
		InputStream resourceAsStream = Mkx1Druid.class.getClassLoader().getResourceAsStream("resources/jdbc.properties2");
		pro.load(resourceAsStream);
		String property = pro.getProperty("name");
		String password = pro.getProperty("password");
		System.out.println(password);
		System.out.println(property);
		//数据库连接池对象
		DataSource datasource = DruidDataSourceFactory.createDataSource(pro);
		// 数据库连接
		System.out.println(datasource.getConnection());
		//获取连接
		java.sql.Connection connection = datasource.getConnection();
		System.out.println("获取的连接"+connection);
		//执行sql对象
		Statement createStatement =connection.createStatement();
		//声明sql
		String sql = "select * from person;";
		//执行查询
		ResultSet rs= createStatement.executeQuery(sql);
		//遍历结果
		while(rs.next()){
			String name=rs.getString("name");
			System.out.println(name);
		}
		//归还连接
		connection.close();

	}
}
