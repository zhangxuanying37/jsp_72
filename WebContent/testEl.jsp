<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="com.zxy.pojo.Order"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3><%=request.getAttribute("user")%></h3>
  <h3>你好!${user}</h3>
  <hr/>
<h3><%=((Order)request.getAttribute("order")).getId() %></h3>
<h3>商品编号：${order.id}</h3>
<hr/>
<h3>总价：<%=((Order)((List)request.getAttribute("list")).get(1)).getprice() %></h3>
<h3>总价：${list[1].total_price}</h3>
<hr/>
<h3>你好！<%=((Order)((Map)request.getAttribute("map")).get("order")).getuname() %></h3>
<h3>你好！${map["order"].user_name }</h3>
</body>
</html>