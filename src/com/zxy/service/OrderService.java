package com.zxy.service;

import java.util.List;

import com.zxy.pojo.Order;
import com.zxy.utils.PageUtils;

public interface OrderService {
public int addOrdersInfo(String id,String total_price,String user_id,String user_name,String time,String status,String pic);

public List<Order> findOrderInfo();

public int delOrderInfoById(String orderId);

public int editOrderInfoById(String id,String price,String uid,String uname,String time,String status,String pic);

public Order SelectById(String ids);

//public List<Order> findOrderInfo(String page);

public PageUtils<Order> findOrderInfo(String page);

public int addOrder(Order order);

public PageUtils<Order> findOrderInfo(String page, String itemname);

}


