<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
td{
width:200px;
border:1px solid grey;
}
tr{
text-align:center;
}
</style>
<link rel="stylesheet" href="/jsp_72/jquery/jquery.datepick.css" type="text/css" />
<script type="text/javascript" src="/jsp_72/jquery/jquery-1.4.2.js"></script>
<script type="text/javascript" src="/jsp_72/jquery/jquery.datepick.js"></script>
<script type="text/javascript" src="/jsp_72/jquery/jquery.datepick-zh-CN.js"></script>
<script>$(function(){
	$("input[name='time']").datepick({dateFormat:'yy-mm-dd'});
})
</script>
</head>
<body>
<%--enctype="multipart/form-data" --%>
<form action="/jsp_72/editOrderInfoByIdServlet" method="post" >
<table cellspacing="0" border="1px solid grey">
<tr><td colspan="2">编辑订单信息</td></tr>

<tr>
<td>订单编号</td>
<td><input type="text" name="id" value="${order.id}"/></td>
</tr>
<tr>
<td>总价</td>
<td><input type="text" name="price" value="${order.price }"/></td>
</tr>
<tr>
<td>用户编号</td>
<td><input type="text" name="uid" value="${order.uid }"/></td>
</tr>
<tr>
<td>用户名</td>
<td><input type="text" name="uname" value="${ order.uname}"/></td>
</tr>
<tr>
<td>时间</td>
<td><input type="text" name="time" value="${order.time }" readonly="readonly"/></td>
</tr>
<tr>
<td>状态</td>
<td><input type="text" name="status" value="${order.status }"/></td>
</tr>
<tr>
<td>商品图片</td>
<td><input type="file" name="pic" src="${order.pic }" /></td>
</tr>
<tr><td colspan="2"><input type="submit" value="保存"/></td></tr>
</table>
</form>
</body>
</html>