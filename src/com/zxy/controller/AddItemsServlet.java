package com.zxy.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.jasper.tagplugins.jstl.core.ForEach;

import com.zxy.pojo.Order;
import com.zxy.service.OrderService;
import com.zxy.service.OrderServiceImpl;
import com.zxy.utils.StringUtils;
@WebServlet("/addItemsServlet")
public class AddItemsServlet extends HttpServlet {
	private OrderService orderService = new OrderServiceImpl();
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		Order order = new Order();

		try {
			//�����ļ��ϴ��Ĺ�������
		FileItemFactory factory = new DiskFileItemFactory();
		//���ݹ������󴴽�ServletFileUpload����
		ServletFileUpload fileUpload = new ServletFileUpload(factory);
			//����ServletFileUpload
		List<FileItem> list = fileUpload.parseRequest(req);
			//���������õĶ���
		if (list !=null && list.size()>0) {
			for (FileItem fileItem : list) {
				if (fileItem.isFormField()) {
					//isFormField()�������������ֵΪtrue˵������ͨ����ֵ
					//�������ͨ�ı�
					
					if ("id".equals(fileItem.getFieldName())) {
						String id = fileItem.getString("utf-8");
						int ids = Integer.parseInt(id);
						order.setId(ids);
					}else if ("price".equals(fileItem.getFieldName())){
						String price = fileItem.getString("utf-8"); 
						double prices = Double.parseDouble(price);
						order.setprice(prices);
					}else if("uid".equals(fileItem.getFieldName())){
						String uid = fileItem.getString("utf-8"); 
						int uids = Integer.parseInt(uid);
						order.setuid(uids);
					}else if("uname".equals(fileItem.getFieldName())){
						String uname = fileItem.getString("utf-8"); 
						order.setuname(uname);
					}else if("time".equals(fileItem.getFieldName())) {
						String time = fileItem.getString("utf-8"); 
						
						
							SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
							Date date = format.parse(time);
							order.setTime(date);
							
						
					}else if ("status".equals(fileItem.getFieldName())) {
						String status = fileItem.getString("utf-8"); 
						order.setStatus(status);
					}
				}else {
//				fileItem.isFormField()����ֵΪfalse��˵�����ļ��ϴ�����ֵ
//					ʹ��fileItem.getName()����ѡ�е��ļ�����
					String pic = fileItem.getName();
					 
					order.setPic(pic);
					//�������ļ�����
					String newPicname = StringUtils.subString(pic);
					File file = new File("C:\\Users\\Administrator\\Desktop\\img\\",newPicname);
				//ִ���ļ��ϴ�
					fileItem.write(file);
				}
			}
			}
		int rows = orderService.addOrder(order);
		if (rows>0) {
			resp.sendRedirect("/jsp_72/queryOrderInfoServlet");
		}else {
			resp.sendRedirect("/jsp_72/addItems.jsp");
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}
@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
}
