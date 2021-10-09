package com.zxy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.zxy.dao.UserDao;
import com.zxy.dao.UserDaoImpl;
import com.zxy.pojo.User;
import com.zxy.service.UserService;
import com.zxy.service.UserServiceImpl;

/**
 * Servlet implementation class CheckLoginServlet
 */
public class CheckLoginServlet extends HttpServlet {
	private UserDao userDao = new UserDaoImpl(); 
	  @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
		  
		//处理post请求的方法
		  req.setCharacterEncoding("utf-8");
		  //接收客户端的请求参数
    	  String user = req.getParameter("user");
    	  String pwd = req.getParameter("pwd");
    	  //调用下一层处理该请求
    	 User user1 = userDao.CheckLogin(user,pwd);
    	  //根据返回结果，决定跳转页面
    	 if (user1 !=null) {
			HttpSession session = req.getSession();
			session.setAttribute("user", user);
			resp.sendRedirect("/jsp_72/queryOrderInfoServlet");
		}else {
			resp.sendRedirect("/jsp_72/login.jsp");
		}
    }
	  //处理get请求的方法
      @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	//接收客户端的请求参数
    	  doPost(req, resp);
    	  //调用下一层处理该请求
    	  
    	  //根据返回结果，决定跳转页面
    }  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
  
   

}
