package com.zxy.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBUtils2 {
	static String dri = "com.mysql.jdbc.Driver";
	static String urlString = "jdbc:mysql://localhost:3306/mysql_33?characterEncoding=utf-8&useSSL=false";
	static String uString = "root";
	static String pwdString = "164271";
	//因为加载驱动只需要加载一次，所以放在静态代码块中
	static{
			try {
				Class.forName(dri);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	//获得连接的方法
	public static Connection getConnection(){
		Connection connection = null;
		try {
			 connection = DriverManager.getConnection(urlString, uString, pwdString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("创建连接失败："+e.getMessage());
			
		}
		return connection;
	}
	
	/**
	 * 关闭所有资源的方法
	 * @param rs 结果集
	 * @param ps  执行sql的对象
	 * @param conn 连接
	 */
	public static void close(ResultSet rs,PreparedStatement state,Connection conn){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println("关闭ResultSet失败："+e.getMessage());
			}
		}
		if(state != null){
			try {
				state.close();
			} catch (SQLException e) {
				System.out.println("关闭PreparedStatement失败："+e.getMessage());
			}
		}
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("关闭Connection失败："+e.getMessage());
			}
		}
	}
	
}

