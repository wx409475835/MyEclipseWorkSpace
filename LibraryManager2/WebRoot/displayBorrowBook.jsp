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
		<title>显示已经借阅图书信息</title>

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
					<strong>读者姓名</strong>
				</td>
				<td align="center">
					<strong>借书时间</strong>
				</td>
				<td align="center">
					<strong>应还书时间</strong>
				</td>
				<td align="center" >
					<strong>执行操作</strong>
				</td>
			</tr>
			<c:forEach items="${list}" var="borrow">
				<tr>
					<td>
						<c:out value="${borrow.bookID}" />
					</td>
					<td>
						<c:out value="${borrow.bookName}" />
					</td>
					<td>
						<c:out value="${borrow.borrowDate}" />
					</td>
					<td>
						<c:out value="${borrow.readerName}" />
					</td>
					<td>
						<c:out value="${borrow.backDate}" />
					</td>
					
					<td>
						<a href="Reback?id=${borrow.bookID}" class="btn btn-primary">续借</a>
						<a href="BackBook?id=${borrow.bookID}" class="btn btn-danger">归还</a>
					</td>
				</tr>
			</c:forEach>
		</table>

		<hr>
		<a href="usermain.jsp" class="btn btn-success">返回主菜单</a>
		<hr>


	</body>
</html>
