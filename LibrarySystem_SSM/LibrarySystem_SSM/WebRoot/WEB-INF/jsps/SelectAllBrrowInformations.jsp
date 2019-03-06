<%@page import="org.omg.CORBA.PUBLIC_MEMBER"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查询所有借阅记录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<style type="text/css">
		table{
			text-align: center;
		}
		.d1{
			font-family:  Arial, Helvetica, sans-serif;
			color:#3D3D3D;
			font-size: 20px;
		}
		font{
			font-family:  Arial, Helvetica, sans-serif;
		}
		.tr{
			background: #E5E5E5;
		}
	</style>
	
  </head>
  
  <body>
    <c:if test="${ sessionScope.Login!=null}">
    	<table align="center" bgcolor="#FCFCFC" border="1px">
    		<tr class="tr">
    			<th colspan="3"><font class="d1"> 用户 信 息 </font></th>
    			<th colspan="6"><font class="d1"> 借 阅 信 息 </font></th>
    		</tr>
  			<tr style="height: 30px" class="tr">
	  			<th><strong><font class="d1">用户名ID</font></strong></th>
	  			<th><strong><font class="d1">用户名</font></strong></th>
  				<th><strong><font class="d1"> 身 份 </font></strong></th>
  				<th><strong><font class="d1">图书 Id</font></strong></th>
	    		<th><strong><font class="d1">图书名字</font></strong></th>
	    		<th><strong><font class="d1">图书类型</font></strong></th>
	    		<th><strong><font class="d1">图书价格</font></strong></th>
	    		<th><strong><font class="d1">图书数量</font></strong></th>
	    		<th><strong><font class="d1">出 版 社</font></strong></th>
  			</tr>
  			<c:forEach items="${ sessionScope.pu }" var="pu">
  				<tr>
  					<td><strong><font size="4">${pu.person_id}</font></strong></td>
  					<td><strong><font size="4">${pu.username}</font></strong></td>
	  				<c:if test="${pu.ident=='u' }">
	  					<td><strong><font size="4"><%="读者" %></font></strong></td>
	  				</c:if>
	  				<c:if test="${pu.ident=='a' }">
	  					<td><strong><font size="4"><%="管理员" %></font></strong></td>
	  				</c:if>
  					<td><strong><font size="4">${pu.book_id }</font></strong></td>
  					<td><strong><font size="4"><%="《" %>${pu.book_name }<%="》" %></font></strong></td>
  					<td><strong><font size="4">${pu.book_type }</font></strong></td>
  					<td><strong><font size="4">${pu.book_price }</font></strong></td>
  					<td><strong><font size="4">${pu.book_count }</font></strong></td>
  					<td><strong><font size="4">${pu.book_add }</font></strong></td>
  				</tr>
  			</c:forEach>
  		</table>
    </c:if>
    <c:if test="${sessionScope.Login ==null }">
    	<jsp:forward page="http://localhost:8888/LibrarySystem_SSM/Login.do"></jsp:forward>
    </c:if>
  </body>
</html>
