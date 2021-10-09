package com.zxy.dao;

import com.zxy.pojo.User;



public interface UserDao {
	public User CheckLogin(String user,String pwd);
}
