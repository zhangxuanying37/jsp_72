package com.zxy.dao;

import java.util.List;

import com.zxy.pojo.Order;
import com.zxy.utils.PageUtils;

public interface OrderDao {
public int addOrderInfo(Order order);
public int delOrderInfo(String orderid);
public int editOrderInfo(Order order);
public Order SelectById(int ids);
public List<Order> selectOrderInfo();
public List<Order> findOrderInfoByPage(PageUtils<Order> pageUtils);
public Long countRows();//获得总记录数
public int addOrder(Order order);
public List<Order> findOrderInfoByPage(PageUtils<Order> pageUtils,
		String itemname);
}
