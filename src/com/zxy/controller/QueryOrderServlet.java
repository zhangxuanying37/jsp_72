package com.zxy.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zxy.pojo.Order;
import com.zxy.service.OrderService;
import com.zxy.service.OrderServiceImpl;
@WebServlet("/queryOrderServlet")
public class QueryOrderServlet extends HttpServlet{
	private OrderService orderService = new OrderServiceImpl();
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
	req.setCharacterEncoding("utf-8");
	
	List<Order> list = new ArrayList<Order>();
	list = orderService.findOrderInfo();
	/*Order order = new Order(3,13,1,"张三",null,"未完成");
	Order order2 = new Order(3,13,1,"李四",null,"未完成");
	Order order3 = new Order(3,13,1,"王五",null,"未完成");
	List<Order> orderList = new ArrayList<Order>();
	orderList.add(order);
	orderList.add(order);
	orderList.add(order);*/
	
	req.setAttribute("orderList", list);
	req.getRequestDispatcher("/showOrder.jsp").forward(req, resp);
}
@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
}
