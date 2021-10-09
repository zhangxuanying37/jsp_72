<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <c:if test="${name=='灵灵'}">
<h1>挺好！</h1>
</c:if>
<c:if test="${name=='小可'}">
<h1>cute</h1>
</c:if> 
<%-- 多分支if语句
 <c:choose>
<c:when test="${weather=='sunny'}">
<h1>go to park</h1>
</c:when>
<c:when test="${weather=='rainny'}">
<h1>go to bookstore</h1>
</c:when>
<c:otherwise>
<h1>go home</h1>
</c:otherwise>
</c:choose>
--%>
<span><input type="text" name = "now" value='<fmt:formatDate value="${now}" pattern="yyyy-MM-dd" />'/></span>
<div><input type="text" value='<fmt:formatNumber value="${number}" pattern="0.00"/>'/></div><!-- pattern="0.00"四舍五入，保留两位小数 -->
</body>
</html>