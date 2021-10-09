package com.zxy.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.zxy.service.OrderService;
import com.zxy.service.OrderServiceImpl;
@WebServlet("/addOrderServlet")//相当于url-patern的值，没有分号。不能与web.xml中的同一个配置信息同时存在。

public class AddOrderServlet extends HttpServlet{
	private OrderService orderService = new OrderServiceImpl();
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id = req.getParameter("id");
		String price = req.getParameter("price");
		String uid = req.getParameter("uid");
		String uname = req.getParameter("uname");
		String time = req.getParameter("time");
		String status = req.getParameter("status");
		String pic = req.getParameter("pic");
		int rows = orderService.addOrdersInfo(id, price, uid, uname, time, status,pic);
		if (rows>0) {
			HttpSession session = req.getSession();
			session.setAttribute("id",id );
			resp.sendRedirect("/jsp_72/queryOrderInfoServlet");
		}else {
			resp.sendRedirect("/jsp_72/queryOrderInfoServlet");
		}
} 
/*<servlet>
<servlet-name>AddOrderServlet</servlet-name>
<servlet-class>com.zxy.controller.AddOrderServlet</servlet-class>
</servlet>
<servlet-mapping>
<servlet-name>AddOrderServlet</servlet-name>
<url-pattern>/addOrderServlet</url-pattern>
</servlet-mapping>*/
@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
}
