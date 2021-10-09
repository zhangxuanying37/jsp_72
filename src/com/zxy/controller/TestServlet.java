package com.zxy.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zxy.pojo.Order;
@WebServlet("/testElServlet")
public class TestServlet extends HttpServlet{
	
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
	//基本数据类型
	String name = "小可";
	//准备对象类型的数据
	Order order = new Order(3,13,1,"张三",null,"未完成");
	Order order2 = new Order(3,13,1,"李四",null,"未完成");
	Order order3 = new Order(3,13,1,"王五",null,"未完成");
	List<Order> list = new ArrayList<Order>();
	list.add(order);
	list.add(order);
	list.add(order);
	Map<String, Order> map = new HashMap<String, Order>();
	map.put("order", order);
	map.put("order2", order2);
	map.put("order3", order3);
	//把数据保存到request作用域中
	req.setAttribute("user", name);
	req.setAttribute("order", order);
	req.setAttribute("list", list);
	req.setAttribute("map", map);
	//以请求转发的形式跳转页面
	req.getRequestDispatcher("/testEl.jsp").forward(req, resp);
}
@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
}
