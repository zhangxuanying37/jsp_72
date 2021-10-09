package com.zxy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zxy.pojo.Order;
import com.zxy.service.OrderService;
import com.zxy.service.OrderServiceImpl;


@WebServlet("/queryEditServlet")
public class QueryEditServlet extends HttpServlet {
	private OrderService orderService = new OrderServiceImpl();
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
	req.setCharacterEncoding("utf-8");
	String ids = req.getParameter("id");
	Order order =null;
	order = orderService.SelectById(ids);
	req.setAttribute("order",order);
	
	if (order !=null) {
		req.getRequestDispatcher("/editOrder.jsp").forward(req, resp);
	}else {
		resp.sendRedirect("/jsp_72/editOrder.jsp");
	}
	
	
}
@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
}
