package com.jll.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Homework {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		String database = "test";
		String url =UsesConstants.getMySqlUrlNoSsl(database);
		try {
			Connection con = DriverManager.getConnection(url, UsesConstants.MYSQL_CRT_USER, "0231625530");
			Statement statement = con.createStatement();
			String sql = "show tables";
			String dbName = "TestDb";
			String tbName = "userInfo";
			String dropDb = "drop database if exists "+dbName+";";
			String creatDb = "create database "+dbName+";";
			String createTable =
					"create table "
					+tbName
					+ "(user_id int primary key auto_increment,"
					+ "user_name varchar(20),"
					+ "user_age int )"
					+ "auto_increment=1";
			System.out.println( statement.executeUpdate(dropDb)>0?"删除数据库成功":"删除数据库失败");
			System.out.println("创建数据库:"+(statement.executeUpdate(creatDb)==1?"成功":"失败"));
			statement.close();
			con.close();
			con = DriverManager.getConnection(UsesConstants.getMySqlUrlNoSsl("testDb"), UsesConstants.MYSQL_CRT_USER, "0231625530");
			statement = con.createStatement();
			System.out.println("创建userInfo表");
			statement.executeUpdate(createTable);
			String insert = UsesConstants.getInsertSQL(tbName, "user_name,user_age", "('张三',35),('李四',21),('王五',22),('赵六',16)");
			System.out.println(insert);
			System.out.println( statement.executeUpdate(insert)>0?"插入成功":"插入失败");
			String up= UsesConstants.getUpdateSQL(tbName, "useR_age", "15","where user_name='张三'");
			System.out.println(up);
			System.out.println(statement.executeUpdate(up)>0?"修改成功":"修改失败");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getSQLState());
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
