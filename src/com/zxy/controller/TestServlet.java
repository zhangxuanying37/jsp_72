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
	//������������
	String name = "С��";
	//׼���������͵�����
	Order order = new Order(3,13,1,"����",null,"δ���");
	Order order2 = new Order(3,13,1,"����",null,"δ���");
	Order order3 = new Order(3,13,1,"����",null,"δ���");
	List<Order> list = new ArrayList<Order>();
	list.add(order);
	list.add(order);
	list.add(order);
	Map<String, Order> map = new HashMap<String, Order>();
	map.put("order", order);
	map.put("order2", order2);
	map.put("order3", order3);
	//�����ݱ��浽request��������
	req.setAttribute("user", name);
	req.setAttribute("order", order);
	req.setAttribute("list", list);
	req.setAttribute("map", map);
	//������ת������ʽ��תҳ��
	req.getRequestDispatcher("/testEl.jsp").forward(req, resp);
}
@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
}
