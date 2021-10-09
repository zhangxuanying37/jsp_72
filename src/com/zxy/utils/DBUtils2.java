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
	//��Ϊ��������ֻ��Ҫ����һ�Σ����Է��ھ�̬�������
	static{
			try {
				Class.forName(dri);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	//������ӵķ���
	public static Connection getConnection(){
		Connection connection = null;
		try {
			 connection = DriverManager.getConnection(urlString, uString, pwdString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("��������ʧ�ܣ�"+e.getMessage());
			
		}
		return connection;
	}
	
	/**
	 * �ر�������Դ�ķ���
	 * @param rs �����
	 * @param ps  ִ��sql�Ķ���
	 * @param conn ����
	 */
	public static void close(ResultSet rs,PreparedStatement state,Connection conn){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println("�ر�ResultSetʧ�ܣ�"+e.getMessage());
			}
		}
		if(state != null){
			try {
				state.close();
			} catch (SQLException e) {
				System.out.println("�ر�PreparedStatementʧ�ܣ�"+e.getMessage());
			}
		}
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("�ر�Connectionʧ�ܣ�"+e.getMessage());
			}
		}
	}
	
}

