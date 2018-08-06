package com.yjy.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnDB {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://112.126.74.165:3306/stitp?user=root&password=thwl&useUnicode=true&characterEncoding=utf-8";
	private static Connection conn;
	@SuppressWarnings("unused")
	private static String  uname = "root";
	@SuppressWarnings("unused")
	private static String pwd = "thwl";
	//加载数据库驱动
	static{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//获取数据库的连接
	private static Connection getConnection() throws SQLException{
		Connection connection = null;
		connection = DriverManager.getConnection(url);
		return connection;
	}
	
	//执行数据库查询操作
	public ResultSet doQuery(String sql) throws SQLException{
		if( conn == null){
			conn = getConnection();
		}
		if( conn.isClosed() == true){
			conn = getConnection();
		}
		Statement st = conn.createStatement();
		if(st.isClosed() == true){
			st.getConnection();
		}
		ResultSet rs = st.executeQuery(sql);
		//close(conn);
		return rs;
	}
	
	//执行数据库更新操作
	public boolean doUpdate(String sql) throws SQLException{
		boolean isUpdate = false;
		if( conn == null){
			conn = getConnection();
		}
		if( conn.isClosed() == true){
			conn = getConnection();
		}
		Statement st = conn.createStatement();
		int result = -1;
		if( st != null){
			if(st.isClosed() == true){
				st = conn.createStatement();
			}
			result = st.executeUpdate(sql);
		}
		if( result > 0){
			isUpdate = true;
		}
		close(conn);
		return isUpdate;
	}
	
	//关闭数据库连接
	public void close(Connection conn) throws SQLException{
		conn.clearWarnings();
		if( conn!= null){
			conn.close();
		}
	}
}
