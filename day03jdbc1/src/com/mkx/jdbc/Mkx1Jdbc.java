package com.mkx.jdbc;
import java.sql.*;

public class Mkx1Jdbc {
	public static void main(String[] args) throws Exception  {
			// 1. 加载数据库驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 2.通过DriverManager获取数据库连接
			String url = "jdbc:mysql://127.0.0.1:3306/swing";
			String username = "root";
			String password = "root";
			Connection connection = DriverManager.getConnection(url,username, password);
			// 3.通过Connection对象获取Statement对象
			Statement createStatement=connection.createStatement();
			// 4.使用Statement执行SQL语句
			String sql = "select * from person;";
			//
			ResultSet rs=createStatement.executeQuery(sql);
			//
			while(rs.next()){
				String name=rs.getString("name");
				System.out.println(name);
			}
			// 6.关闭连接，释放资源
			createStatement.close();
			connection.close();
		}
}

