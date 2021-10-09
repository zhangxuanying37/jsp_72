package com.zxy.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/testJSTLServlet")
public class TestJSTLServlet extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	req.setCharacterEncoding("utf-8");
	String name = "¡È¡È";
	String weather = "sunny";
	req.setAttribute("name", name);
	req.setAttribute("weather", weather);
	Date now = new Date();
	req.setAttribute("now", now);
	double number = 3.1448948;
	req.setAttribute("number", number);
	req.getRequestDispatcher("/testJSTL.jsp").forward(req, resp);
}
@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
}
