<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>序言</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  	<style type="text/css">
  		font{
			font-family:  Arial, Helvetica, sans-serif;
		}
  	</style>
  </head>
  <body>
	<c:if test="${ sessionScope.Login!=null}">
	    <br/><br/><br/><br/><br/><br/>
    		<center>
   				<font size="5" color="green"><p><b>欢迎来到图书管理系统</b></p></font>
   				<font size="5" color="green"><p><b>在这里你可以借阅各种书籍,遨游在只是的海洋</b></p></font>
   				<font size="5" color="green"><p><b>你曾打开窗户，让我向外面的世界张望；你还用生硬</b></p></font>
   				<font size="5" color="green"><p><b>的手拍打掉我从乡里带来的一身黄土，把你充满碳烟味的标志印</b></p></font>
   				<font size="5" color="green"><p><b>烙在我的身上，老实说，你也没有能拍打净我身上的黄土；但我</b></p></font>
   				<font size="5" color="green"><p><b>的身上确是烙下了你的印记！</b></p></font>
   			</center> 		
	 </c:if>
	 <c:if test="${sessionScope.Login ==null }">
	    <jsp:forward page="Login.do"></jsp:forward>
	 </c:if>
  </body>
</html>
