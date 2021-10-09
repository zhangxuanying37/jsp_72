package com.zxy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.zxy.service.OrderService;
import com.zxy.service.OrderServiceImpl;
@WebServlet("/delOrderInfoServlet")
public class DelOrderInfoServlet extends HttpServlet {
	private OrderService orderService = new OrderServiceImpl();
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
	
	req.setCharacterEncoding("utf-8");
	String orderId = req.getParameter("id");
	
	int rows = orderService.delOrderInfoById(orderId);
	if (rows>0) {
		resp.sendRedirect("/jsp_72/queryOrderInfoServlet");
	}else {
		req.getRequestDispatcher("/queryOrderInfoServlet");
	}
}
@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
}
