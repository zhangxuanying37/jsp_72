package com.zxy.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.zxy.service.OrderService;
import com.zxy.service.OrderServiceImpl;
import com.zxy.utils.StringUtils;
@WebServlet("/editOrderInfoByIdServlet")
public class EditOrderInfoByIdServlet extends HttpServlet {
	private OrderService orderService = new OrderServiceImpl();
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
	req.setCharacterEncoding("utf-8");
	String id = req.getParameter("id"); 
	String price = req.getParameter("price"); 
	String uid = req.getParameter("uid"); 
	String uname = req.getParameter("uname"); 
	String time = req.getParameter("time"); 
	String status = req.getParameter("status");
	String pics=req.getParameter("pic");
	/*try {
		FileItemFactory factory = new DiskFileItemFactory();
	ServletFileUpload fileUpload = new ServletFileUpload(factory);
	List<FileItem> list = fileUpload.parseRequest(req);
	System.out.println("m1");
		if (list !=null && list.size()>0) {
			System.out.println("m2");
		for (FileItem fileItem : list) {
			if (!fileItem.isFormField()) {
				System.out.println("m3");
				pics = fileItem.getName();
				String newpic = StringUtils.subString(pics);
				File file = new File("C:\\Users\\Administrator\\Desktop\\img\\", newpic);
				fileItem.write(file);
			
		}
		}
	}*/
		

	
	int rows = orderService.editOrderInfoById(id,price,uid,uname,time,status,pics);
	System.out.println(rows);
	if (rows>0) {
		req.getRequestDispatcher("/queryOrderInfoServlet").forward(req, resp);
	}else{
		resp.sendRedirect("/jsp_72/queryOrderInfoServlet");
	}
	/*		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	*/
}
	

@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
}
