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
		  
		//����post����ķ���
		  req.setCharacterEncoding("utf-8");
		  //���տͻ��˵��������
    	  String user = req.getParameter("user");
    	  String pwd = req.getParameter("pwd");
    	  //������һ�㴦�������
    	 User user1 = userDao.CheckLogin(user,pwd);
    	  //���ݷ��ؽ����������תҳ��
    	 if (user1 !=null) {
			HttpSession session = req.getSession();
			session.setAttribute("user", user);
			resp.sendRedirect("/jsp_72/queryOrderInfoServlet");
		}else {
			resp.sendRedirect("/jsp_72/login.jsp");
		}
    }
	  //����get����ķ���
      @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	//���տͻ��˵��������
    	  doPost(req, resp);
    	  //������һ�㴦�������
    	  
    	  //���ݷ��ؽ����������תҳ��
    }  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
  
   

}
