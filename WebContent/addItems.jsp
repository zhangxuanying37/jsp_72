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
/*  width:400px; */
border:1px solid grey;; 
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
<form action="/jsp_72/addItemsServlet" method="post" enctype="multipart/form-data">
<table cellspacing="0" border="1px solid grey">
<tr><td colspan="2">添加订单信息</td></tr>

<tr>
<td>订单编号</td>
<td><input type="text" name="id" /></td>
</tr>
<tr>
<td>总价</td>
<td><input type="text" name="price" /></td>
</tr>
<tr>
<td>用户编号</td>
<td><input type="text" name="uid"/></td>
</tr>
<tr>
<td>用户名</td>
<td><input type="text" name="uname"/></td>
</tr>
<td>商品图片</td>
<td><input type="file" name="pic"/></td>
</tr>
<tr>
<td>时间</td>
<td><input type="text" name="time" readonly="readonly"/></td>
</tr>
<tr>
<td>状态</td>
<td><input type="text" name="status" /></td>
</tr>
<tr><td>产地：</td>
<td>省：<select name="province"></select>市：<select name="city"></select>具体地址：<input type="text" name="addrde" /><input type="hidden" name="addr" /></td></tr>
<tr><td colspan="2"><input type="submit" value="保存"/></td></tr>

</table>
</form>
</body>
</html>