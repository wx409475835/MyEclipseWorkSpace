<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查询结果页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <c:if test="${not empty book }">
  <table  class="table table-hover table-condensed">
		    <tr>
				<td align="center">
					<strong>ID</strong>
				</td>
				<td align="center">
					<strong>书名</strong>
				</td>
				<td align="center">
					<strong>作者</strong>
				</td>
				<td align="center">
					<strong>价格</strong>
				</td>
				<td align="center">
					<strong>数量</strong>
				</td>
				<td align="center">
					<strong>类别</strong>
				</td>
				<td align="center">
					<strong>出版社</strong>
				</td>
				<td align="center" >
					<strong>执行操作</strong>
				</td>
			</tr>
				<tr>
					<td>
						<c:out value="${book.bookId}" />
					</td>
					<td>
						<c:out value="${book.bookName}" />
					</td>
					<td>
						<c:out value="${book.writer}" />
					</td>
					<td>
						<c:out value="${book.price}" />
					</td>
					<td>
						<c:out value="${book.num}" />
					</td>
					<td>
						<c:out value="${book.bookDept}" />
					</td>
					<td>
						<c:out value="${book.bookAddress}" />
					</td>
					<td>
						<a href="stdelete?id=${book.bookId}" class="btn btn-danger">删除</a>
						<a href="pre?method=updateStudent&id=${book.bookId}" class="btn btn-primary">更新</a>
					</td>
				</tr>
	
		</table>
</c:if >
<c:if test="${empty book }">
        <center><font color="red" size="+1">对不起！没有该ID号对应的图书....</font></center>
</c:if>
		<hr>
		<a href="main.jsp" class="btn btn-success">返回主菜单</a>
		<hr>
  </body>
</html>
