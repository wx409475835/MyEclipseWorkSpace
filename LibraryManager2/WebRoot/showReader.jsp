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
		<title>显示读者信息</title>

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
					<strong>ID</strong>
				</td>
				<td align="center">
					<strong>用户名</strong>
				</td>
				<td align="center">
					<strong>密码</strong>
				</td>
				<td align="center">
					<strong>邮箱</strong>
				</td>
				<td align="center">
					<strong>电话</strong>
				</td>
				<td align="center">
					<strong>登陆IP</strong>
				</td>
				
				<td align="center" >
					<strong>执行操作</strong>
				</td>
			</tr>
			<c:forEach items="${list}" var="user">
				<tr>
					<td>
						<c:out value="${user.id}" />
					</td>
					<td>
						<c:out value="${user.username}" />
					</td>
					<td>
						<c:out value="${user.password}" />
					</td>
					<td>
						<c:out value="${user.email}" />
					</td>
					<td>
						<c:out value="${user.phone}" />
					</td>
					<td>
						<c:out value="127.0.0.1" />
					</td>
					<td>
						<a href="stdelete?id=${user.id}" class="btn btn-danger">删除</a>
						<a href="pre?method=updateStudent&id=${user.id}" class="btn btn-primary">更新</a>
						<a href="pre?method=updateStudent&id=${user.id}" class="btn btn-inverse">禁用</a>
					</td>
				</tr>
			</c:forEach>
		</table>

		<hr>
		<a href="main.jsp" class="btn btn-success">返回主菜单</a>
		<hr>


	</body>
</html>
