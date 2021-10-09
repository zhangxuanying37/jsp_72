<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
input[type="text"],input[type="password"]{
width:150px;
}
td{
text-align:center;
}
</style>
</head>
<body>
<form action="/jsp_72/checkLoginServlet" method="post">
<table border="1px solid grey" cellspacing = "0">
<tr>
<td colspan="2"><font style="font-size:20px;color:#000">登录</font></td>
</tr>
<tr>
<td>用户名:</td>
<td class=".le"><input type="text" name = "user" /></td>
</tr>
<tr>
<td>密码:</td>
<td class=".le"><input type="password" name = "pwd" /></td>
</tr>
<tr>
<td>确认密码:</td>
<td class=".le"><input type="password" name = "repwd" /></td>
<tr>
<td colspan="2"><input type = "submit" name="btn1"  value="登录"  /></td>
</tr>
</table>
</form>
<script type="text/javascript">

</script>
</body>
</html>