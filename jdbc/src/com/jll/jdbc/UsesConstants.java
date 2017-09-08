package com.jll.jdbc;

import com.mysql.jdbc.Field;

public class UsesConstants {
	public static final String JDBC_MYSQL = "jdbc:mysql://";
	public static final String LOCAL_HOST = "127.0.0.1";
	public static final String MYSQL_CRT_USER = "root";
	public static final String MYSQL_NO_USE_SSL = "?characterEncoding=utf8&useSSL=true";
	
	public static final String INSERT = "INSERT into ";
	public static final String UPDATE = "UPDATE ";
	public static final String DELETE = "DELETE ";
	public static final String SELECT = "SELECT ";
	
	public static final int MYSQL_CRT_PORT=3306;
	
	public static final String getMySqlUrl(String dbname) {
		return JDBC_MYSQL + LOCAL_HOST + ":" + MYSQL_CRT_PORT +"/"+ dbname;
	}
	public static final String getMySqlUrlNoSsl(String dbname) {
		return getMySqlUrl(dbname)+ MYSQL_NO_USE_SSL;
	}
	public static final String getInsertSQL(String tbName,String filed,String valuse) {
		return INSERT + tbName + "("+filed+")values" + valuse;
	}
	public static final String getUpdateSQL(String tbName,String fileds,String valuse,String wheres) {
			return UPDATE +tbName + " set " + fileds + " = "+ valuse + " " + wheres;
	}
	
}
