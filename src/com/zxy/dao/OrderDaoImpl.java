package com.zxy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zxy.pojo.Order;
import com.zxy.utils.DBUtils;
import com.zxy.utils.DBUtils2;
import com.zxy.utils.PageUtils;

public class OrderDaoImpl implements OrderDao{
	
	@Override
	public int addOrderInfo(Order order) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		connection = DBUtils2.getConnection();
		String sql = "insert into orders1 values(?,?,?,?,?,?,?)";
		int rows = 0;
		try {
			statement = connection.prepareStatement(sql);
			statement.setObject(1,order.getId() );
			statement.setObject(2,order.getprice() );
			statement.setObject(3,order.getuid());
			statement.setObject(4,order.getuname() );
			statement.setObject(5,order.getTime() );
			statement.setObject(6,order.getStatus() );
			statement.setObject(7, order.getPic());
			 rows = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtils.close(null, statement, connection);
		}
		return rows;
	}

	@Override
	public int delOrderInfo(String orderid) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		connection = DBUtils2.getConnection();
		String sql = "delete from orders1 where id=?";
		
		int rows = 0;
		try {
			
			statement = connection.prepareStatement(sql);
			statement.setObject(1, orderid);
			rows = statement.executeUpdate();
			if (rows>0) {
				return rows;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtils2.close(resultSet, statement, connection);
		}
		
		return 0;
	}

	@Override
	public int editOrderInfo(Order order) {
		Connection connection=null;
		PreparedStatement preparedStatement = null;
		int rows=0;
		try {	
		connection = DBUtils2.getConnection();
		String sql = "update orders1 set price=?,uid=?,uname=?,time=?,status=?,pic=? where id=?";
			preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setObject(1, order.getprice());
			preparedStatement.setObject(2, order.getuid());
			preparedStatement.setObject(3,order.getuname());
			preparedStatement.setObject(4, order.getTime());
			preparedStatement.setObject(5,order.getStatus());
			preparedStatement.setObject(6, order.getPic());
			preparedStatement.setObject(7, order.getId());
			
			rows = preparedStatement.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rows;
	}

	@Override
	public Order SelectById(int ids) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		
		try {
		connection = DBUtils2.getConnection();
		String sql = "select * from orders1 where id = ? ";
		
			statement = connection.prepareStatement(sql);
			
			
			statement.setObject(1,ids);
			
			resultSet = statement.executeQuery();
			while(resultSet.next()){
			int id = resultSet.getInt("id");
			double price = resultSet.getDouble("price");
			int uid = resultSet.getInt("uid");
			String uname = resultSet.getString("uname");
			Date date = resultSet.getDate("time");
			String status = resultSet.getString("status");
			String pic = resultSet.getString("pic");
			Order order = new Order(id, price, uid, uname, date, status,pic);
			
			return order;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtils2.close(resultSet, statement, connection);
		}
		
		return null;
	
	}

	@Override
	public List<Order> selectOrderInfo() {
		
		
		return null;
	}

	@Override
	public List<Order> findOrderInfoByPage(PageUtils<Order> pageUtils) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		ResultSet resultSet = null;
		
		List<Order> orderList = new ArrayList<Order>();
		connection = DBUtils2.getConnection();
		String sql = "select * from orders1 limit ? , ?";
		
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setObject(1, pageUtils.getBeginRows());
			preparedStatement.setObject(2, pageUtils.getPageSize());
			
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				Order order = new Order(resultSet.getInt("id"),
						resultSet.getDouble("price"), 
						resultSet.getInt("uid"), 
						resultSet.getString("uname"), 
						resultSet.getDate("time"), 
						resultSet.getString("status") ,
						resultSet.getString("pic"));
				orderList.add(order);
				
			}
			
			return orderList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return orderList;
	}

	@Override
	public Long countRows() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		connection = DBUtils2.getConnection();
		String sql = "select count(1) from orders1";
		int rows = 0;
		try {
			statement = connection.prepareStatement(sql);
			 resultSet = statement.executeQuery();
			if (resultSet.next()) {
				return resultSet.getLong(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtils.close(null, statement, connection);
		}
		return null;
	}

	@Override
	public int addOrder(Order order) {
		Connection connection = null;
		PreparedStatement statement = null;
		connection = DBUtils2.getConnection();
		String sql = "insert into orders1 values(?,?,?,?,?,?,?)";
		int rows = 0;
		
		try {
			statement = connection.prepareStatement(sql);
			statement.setObject(1,order.getId() );
			statement.setObject(2,order.getprice() );
			statement.setObject(3,order.getuid());
			statement.setObject(4,order.getuname() );
			statement.setObject(5,order.getTime() );
			statement.setObject(6,order.getStatus() );
			statement.setObject(7, order.getPic());
			 rows = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtils.close(null, statement, connection);
		}
		return rows;
	}

	@Override
	public List<Order> findOrderInfoByPage(PageUtils<Order> pageUtils,
			String itemname) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement2 = null;
		ResultSet resultSet2 = null;
		List<Order> list = new ArrayList<Order>();
		Order order = null;
		connection = DBUtils2.getConnection();
		String sql = "select * from orders1 where uname like ? limit ?,?";
		String sql1 = "select count(1) from orders1 where uname like ?";
		Integer row = null;
		int rows = 0;
		try {
			preparedStatement2 = connection.prepareStatement(sql1);
			statement = connection.prepareStatement(sql);
			statement.setObject(1, "%"+itemname+"%");
			statement.setObject(2, pageUtils.getBeginRows());
			statement.setObject(3, pageUtils.getPageSize());
			 resultSet = statement.executeQuery();
			 preparedStatement2.setObject(1, "%"+itemname+"%");
			 resultSet2 = preparedStatement2.executeQuery();
			while(resultSet.next()) {
				int ids = resultSet.getInt("id");
				double price = resultSet.getDouble("price");
				int uid = resultSet.getInt("uid");
				String uname = resultSet.getString("uname");
				Date date = resultSet.getDate("time");
				String status = resultSet.getString("status");
				String pic = resultSet.getString("pic");
				order = new Order(ids, price, uid, uname, date, status, pic);
				list.add(order);
			}
			if (resultSet2.next()) {
				String rows1 = resultSet2.getString("count(1)");
				row = Integer.parseInt(rows1);
				System.out.println(row);
			}
			if (list!=null) {
				pageUtils.setCountRows(row);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtils.close(resultSet, statement, connection);
		}
		return null;
	}

	}

	
	

	

	
	

