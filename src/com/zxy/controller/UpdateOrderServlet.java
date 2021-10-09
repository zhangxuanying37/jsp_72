package com.zxy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zxy.service.OrderService;
import com.zxy.service.OrderServiceImpl;
@WebServlet("/updateOrderServlet")
public class UpdateOrderServlet extends HttpServlet{
	private OrderService orderService = new OrderServiceImpl();
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
	req.setCharacterEncoding("utf-8");
	String ids = req.getParameter("id");
	String price = req.getParameter("price");
	String uid = req.getParameter("uid");
	String uname = req.getParameter("uname");
	String date = req.getParameter("time");
	String status = req.getParameter("status");
	String pic = req.getParameter("pic");
	int rows = orderService.editOrderInfoById(ids,price,uid,uname,date,status,pic);
	if (rows>0) {
		req.getRequestDispatcher("/queryOrderInfoServlet").forward(req, resp);
	}else {
		resp.sendRedirect("/jsp_72/queryOrderInfoServlet");
	}
}
@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
}
