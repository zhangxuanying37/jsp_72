package com.zxy.service;

import com.zxy.dao.UserDao;
import com.zxy.dao.UserDaoImpl;
import com.zxy.pojo.User;

public class UserServiceImpl implements UserService{
private UserDao userDao = new UserDaoImpl();

@Override
public User CheckLogin(String user, String pwd) {
	User user2 = userDao.CheckLogin(user, pwd);
	System.out.println(user+"   "+pwd);
	System.out.println("user="+user2);
	return user2;
}
}
