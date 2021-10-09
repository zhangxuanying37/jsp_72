package com.zxy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zxy.pojo.Order;
import com.zxy.service.OrderService;
import com.zxy.service.OrderServiceImpl;
import com.zxy.utils.PageUtils;
@WebServlet("/queryOrderInfoServlet")
public class QueryOrderInfoServlet extends HttpServlet{
//创建Service层的对象
	private OrderService orderService = new OrderServiceImpl();
	@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
	//设置post请求的中文乱码
		req.setCharacterEncoding("utf-8");
		//获取请求参数，当前页码
		String page = req.getParameter("indexPage");
		//获取搜素框的值
		String itemname = req.getParameter("itemname");
		//调用service层
		PageUtils<Order> pageUtils = orderService.findOrderInfo(page);
		if (itemname != null) {
			
			PageUtils<Order> pageUtils2 = orderService.findOrderInfo(page,itemname);
			if (pageUtils2.getOrderList() != null) {
			req.setAttribute("pageBean", pageUtils2);
			
		}
		}
		else {
			req.setAttribute("pageBean", pageUtils);
		}
		
		//req.setAttribute("orderList", orderList);
		
		req.getRequestDispatcher("/showOrder.jsp").forward(req, resp);
}
@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
}
