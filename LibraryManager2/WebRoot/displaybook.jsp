<%@ page language="java" import="java.util.*,com.dw.model.Book"
	pageEncoding="utf-8"%>
<%@ page import="com.dw.dao.impl.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>显示图书信息</title>

     <style type="text/css">
       input[type="text"]{
              height: auto;
	          margin-bottom: 15px;
	          padding: 3px 9px;
            }
     </style>
	</head>

	<body>

        <form action="searchById" method="post">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
            ID：<input type="text" name="searchId" placeholder="图书ID...">
         <i class="icon-search"></i>&nbsp;<button type="submit" class="btn btn-inverse"> 查找</button>
        </form>
		<table  class="table table-hover table-condensed">
		    <tr>
				<td align="center">
					<strong>图书ID</strong>
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
			<c:forEach items="${list}" var="book">
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
			</c:forEach>
		</table>

		<hr>
		<a href="main.jsp" class="btn btn-success">返回主菜单</a>
		<hr>


	</body>
</html>
