<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 导入jspJSTL标准标签库 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>

th,td{
width:150px;
border:1px solid blue;
}
a{
cursor:pointer;
text-decoration:none;
margin:0px 5px;
}
</style>
<script type="text/javascript">
function delOrder(id){
	if(confirm("确定要删除吗？")){
		location.href = "/jsp_72/delOrderInfoServlet?id="+id;
	}
}
function ediOrder(uid){
	location.href="/jsp_72/queryEditServlet?id="+uid;
}
function addOrder(){
	location.href="/jsp_72/addItems.jsp";
}

</script>
</head>
<body>
<form action="/jsp_72/queryOrderInfoServlet" method="post">
<table  cellspacing="0" border="1px solid blue" width="400px">
<tr><td><input type="text" name="itemname" placeholder="请输入name值"/>&nbsp;&nbsp;<input type="submit" value="搜索" /></td></tr>
</table>
</form>
<form action="/jsp_72/queryOrderInfoServlet" method="post">

<table  cellspacing="0" border="1px solid blue">
<!-- <tr align="center">
<td colspan="7"><b><a href="#">查询</a></b></td>
</tr> -->
<tr>
<th>商品编号</th>
<th>总价</th>
<th>用户编号</th>
<th>用户名</th>
<th>时间</th>
<th>状态</th>
<th>图片路径</th>
<th>操作</th>
</tr>
<%-- c:forEach 标识的是JSTL标签库中的循环标签
var 需要遍历的集合，注意需要用${}抱起来 ${orderList}
items 给集合中的对象类型的元素起个别名 order
varStatus 标记当前获取的哪一 个元素 下标默认从零开始 --%>
<c:forEach items="${pageBean.orderList}" var="order" varStatus="vs" >
<tr align="center">
<%-- <td>${vs.index+1}</td> --%>
<td>${order.id}</td>
<td>${order.price}</td>
<td>${order.uid}</td>
<td>${order.uname}</td>
<td>${order.time}</td>
<td>${order.status}</td>
<td>${order.pic }</td>
<td>
<a href="#" onclick="delOrder('${order.id}')">删除</a>
<a href="#" onclick="ediOrder('${order.id}')">编辑</a>
<a href="#" onclick="addOrder()">添加</a>
</td>
</tr>
</c:forEach>
</table>
<center>
<c:if test="${pageBean.indexPage >1}">
<a href="/jsp_72/queryOrderInfoServlet?indexPage=1">首页</a>
<a href="/jsp_72/queryOrderInfoServlet?indexPage=${pageBean.indexPage-1}">上一页</a>
</c:if>
<c:if test="${pageBean.indexPage ==1}">
<a href="/jsp_72/queryOrderInfoServlet?indexPage=1">首页</a>
<a href="javascript:void(0)">上一页</a>
</c:if>
<!-- begin开始
end结束
step 每次加减的步长
var 给循环中的元素起一个别名 -->
  <c:forEach begin="1" end="${pageBean.totalPage }" step="1" var="i">
<c:if test="${pageBean.indexPage==i}">${i}/${pageBean.totalPage}</c:if>
</c:forEach> 
 <c:if test="${pageBean.indexPage<pageBean.totalPage}"> 
<a href="/jsp_72/queryOrderInfoServlet?indexPage=${pageBean.indexPage+1}">下一页</a>
<a href="/jsp_72/queryOrderInfoServlet?indexPage=${pageBean.totalPage }">尾页</a>
</c:if>
<c:if test="${pageBean.indexPage == pageBean.totalPage}"> 
<a href="javascript:void(0)">下一页</a>
<a href="javascript:void(0)}">尾页</a>
</c:if>
</center>
</form>
</body>
</html>