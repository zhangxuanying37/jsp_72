<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/jsp_72/jquery/jquery.datepick.css" type="text/css" />
<script type="text/javascript" src="/jsp_72/jquery/jquery-1.4.2.js"></script>
<script type="text/javascript" src="/jsp_72/jquery/jquery.datepick.js"></script>
<script type="text/javascript" src="/jsp_72/jquery/jquery.datepick-zh-CN.js"></script>
<script type="text/javascript">
$(function(){
	$("input[name='time']").datepick({dateFormat:'yy-mm-dd'});
})
</script>
<style>
input[type="text"],input[type="password"]{
width:150px;
}
</style>
</head>
<body>
<form action="/jsp_72/addOrderServlet" method="post">
<table border="1px solid grey" cellspacing = "1">
<tr align="center">
<td colspan="2">添加</td>
</tr>
<tr>
<td>商品编号</td>
<td ><input type="text" name = "id" /></td>
</tr>
<tr>
<td>商品状态</td>
<td ><input type="text" name = "status" /></td>
</tr>
<tr>
<td>用户名</td>
<td ><input type="text" name = "uname" /></td>
</tr>
<tr>
<td>用户编号</td>
<td ><input type="text" name = "uid" /></td>
</tr>
<tr>
<td>总价</td>
<td ><input type="text" name = "price" /></td>
</tr>
<!-- <tr>
<td>时间</td>
<td ><input type="text" name = "time" readonly="readonly"/></td>
</tr> -->
<tr align="center">
<td colspan="2"><input type = "submit" name="btn1"  value="登录"  /></td>
</tr>
</table>
</form>
</body>
</html>