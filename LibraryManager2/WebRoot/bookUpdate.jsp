<%@ page language="java" import="java.util.*,com.dw.model.Book" pageEncoding="utf-8"%>
<%@ page import="com.dw.dao.BookDao"%>
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

		<title>更新图书信息</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/stupdate.js"></script>
	<style type="text/css">
	  span{color:red;}
	  .form-signin .form-signin-heading,.form-signin .checkbox {
	margin-bottom: 10px;
}
.form-signin input[type="text"],.form-signin input[type="password"] {
	font-size: 16px;
	height: auto;
	margin-bottom: 15px;
	padding: 7px 9px;
}
.form-signin {
	max-width: 550px;
	padding: 19px 29px 29px;
	margin:0 auto;
	background-color: #fff;
	border: 1px solid #e5e5e5;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
}
	</style>

	</head>
	<body>
		
		<form class="form-signin" action="login/stupdate" method="post" onSubmit="return checkstAge() && 
		checkstSex() && checkstTel() && checkstDept() && 
		checkstAddress() && checkstName()">
			ID号：
			<input type="text" name="BookId" value="${book.bookId }" readonly="readonly"  class="input" placeholder="编号不可更改">
			<br>
			书名：
			<input class="input" type="text" name="BookName" value="${book.bookName }" 
			onblur="checkstName()" onFocus="clearstName()" >
			<span id="stName1"></span>
			<br>
			作者：
			<!--  <input type="radio" name="stSex" value="男" onblur="checkstSex()"  ${student.stSex eq '男'?'checked':'' }>男
			<input type="radio" name="stSex" value="女" onblur="checkstSex()" ${student.stSex eq '女'?'checked':'' }>女
			-->
			<input class="input" type="text" name="writer" value="${book.writer}" onblur="checkstSex()">
			<span id="stSex1"></span>
			<br>
			价格：
			<input class="input" type="text" name="price" value="${book.price}" onblur="checkstAge()" onFocus="clearstAge()" >
			<span id="stAge1"></span>
			<br>
			数量：
			<input class="input" type="text" name="num" value="${book.num}" onblur="checkstTel()" onFocus="clearstTel()" >
			<span id="stTel1"></span>
			<br>
			类别：
			<input class="input" type="text" name="BookDept" value="${book.bookDept }" onblur="checkstDept()" onFocus="clearstDept()" >
			<span id="stDept1"></span>
			<br>
			出版社：
			<input class="input" type="text" name="BookAddress" value="${book.bookAddress }" onblur="checkstAddress()" onFocus="clearstAddress()" >
			<span id="stAddress1"></span>
			<br>
			<input type="submit" value="提交" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="button" class="btn btn-success" onclick="window.location.href='main.jsp'"  value="返回"> 
		</form>
	</body>
</html>
