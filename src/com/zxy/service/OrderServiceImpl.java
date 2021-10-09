package com.zxy.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zxy.dao.OrderDao;
import com.zxy.dao.OrderDaoImpl;
import com.zxy.pojo.Order;
import com.zxy.utils.DBUtils2;
import com.zxy.utils.PageUtils;

public class OrderServiceImpl implements OrderService{
private OrderDao orderDao = new OrderDaoImpl();
	@Override
	public int addOrdersInfo(String id, String price, String uid,
			String uname, String time, String status,String pic) {
		
		int ids = 0;
		double tos = 0;
		int uuid = 0;
		int rows=0;
		Date date = null;
		if (id != null && id.length()>0) {
			 ids = Integer.parseInt(id);
		}
		if (price !=null && price.length()>0) {
			 tos = Double.parseDouble(price);
		}
		if (uid != null && uid.length()>0) {
			 uuid = Integer.parseInt(uid);
		}
		
		if (time !=null && time.length()>0) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				date = sdf.parse(time);
				Order order = new Order(ids, tos, uuid, uname, date, status);
			 rows = orderDao.addOrderInfo(order);
			return rows;
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return rows;
		
		
	}
	@Override
	public List<Order> findOrderInfo() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Order> list = new ArrayList<Order>();
		connection = DBUtils2.getConnection();
		String sql = "select * from orders1";
		
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				int id = resultSet.getInt("id");
				double price = resultSet.getDouble("price");
				int uid = resultSet.getInt("uid");
				String uname = resultSet.getString("uname");
				Date date = resultSet.getDate("time");
				String sta = resultSet.getString("status");
				String pic = resultSet.getString("pic");
				Order order = new Order(id, price, uid, uname, date, sta,pic);
				list.add(order);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtils2.close(resultSet, statement, connection);
		}
		
		return list;
		// TODO Auto-generated method stub
		
	}
	@Override
	public int delOrderInfoById(String orderId) {
		int rows = orderDao.delOrderInfo(orderId);
		return rows;
	}
	@Override
	public int editOrderInfoById(String id, String price, String uid,
		String uname, String time, String status,String pic) {
		Integer ids = null;
		Double prices = null;
		Integer uids = null;
		Date date = null;
		int result =0;
		if (id !=null &&id.length()>0) {
			ids= Integer.parseInt(id);
		}
		if (price !=null &&price.length()>0) {
			prices = Double.parseDouble(price);
			
		}
		if (uid !=null && uid.length()>0) {
			uids = Integer.parseInt(uid);
			
		}
		if (time !=null && time.length()>0) {
			
			try {
				SimpleDateFormat smat = new SimpleDateFormat("yyyy-MM-dd");
				date = smat.parse(time);
				
			
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		Order order = new Order(ids, prices, uids, uname, date, status,pic);
		System.out.println(order);
			
				 result = orderDao.editOrderInfo(order);
				
		return result;
	}
	@Override
	public Order SelectById(String ids) {
		int idd=0;
		if (ids !=null &&ids.length()>0) {
			 idd = Integer.parseInt(ids);
		}
		Order order = orderDao.SelectById(idd);
		return order;
	}
	@Override
	public PageUtils<Order> findOrderInfo(String page) {
		//默认首页，如果没传递页码，默认查询的就是第一页
		if (page == null || page.length()==0) {
			page="1";
		}
		//获取当前页码
		Integer indexPage = Integer.parseInt(page);
		PageUtils<Order> pageUtils = new PageUtils<Order>();
		//当前表的总记录数
		Long countRows = orderDao.countRows();
		//封装好PageUtils
		pageUtils.setPageSize(5);
		pageUtils.setIndexPage(indexPage);
		pageUtils.setCountRows(countRows);
		 List<Order> orderList =  orderDao.findOrderInfoByPage(pageUtils);
		pageUtils.setOrderList(orderList);
		return pageUtils;
	}
	@Override
	public int addOrder(Order order) {
		
		int rows = orderDao.addOrder(order);
		return rows;
	}
	@Override
	public PageUtils<Order> findOrderInfo(String page, String itemname) {
		//默认首页，如果没传递页码，默认查询的就是第一页
				if (page == null || page.length()==0) {
					page="1";
				}
				//获取当前页码
				Integer indexPage = Integer.parseInt(page);
				PageUtils<Order> pageUtils = new PageUtils<Order>();
				//当前表的总记录数
				Long countRows = orderDao.countRows();
				//封装好PageUtils
				pageUtils.setPageSize(5);
				pageUtils.setIndexPage(indexPage);
				pageUtils.setCountRows(countRows);
				 List<Order> orderList =  orderDao.findOrderInfoByPage(pageUtils,itemname);
				pageUtils.setOrderList(orderList);
				return pageUtils;
	}
	
	
}
