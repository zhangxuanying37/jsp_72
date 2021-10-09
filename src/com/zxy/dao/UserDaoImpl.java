package com.zxy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zxy.pojo.User;
import com.zxy.utils.DBUtils;
public class UserDaoImpl implements UserDao{

	@Override
	public User CheckLogin(String user, String pwd) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rSet = null;
		User user3 = null;
		
		try {
		connection = DBUtils.getConnection();
		
		String sqlString = "select * from user where username = ? and userpwd = ? ";
			statement = connection.prepareStatement(sqlString);
			statement.setObject(1, user);
			statement.setObject(2, pwd);
			rSet = statement.executeQuery();
			
			while(rSet.next()){
				int id = rSet.getInt("id");
				String name = rSet.getString("username");
				String pwds = rSet.getString("userpwd");
				 user3 = new User(id,name , pwds);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally{
			DBUtils.close(rSet, statement, connection);
		}
		
		return user3;
	
	}

	

	

}
