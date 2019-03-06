<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	
    <title>所有的用户</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		span{
			color: block;
			font-family: '微软雅黑';
			font-size: 17px;
		}
	</style>
  </head>
  
  <body>
  	<span>所有用户如下:</span><br/>
    <table style="margin-left: 30px;font-family: '微软雅黑';font-size: 16px;">
    	<c:forEach items="${applicationScope.map }" var="entry">
    		<tr>
    			<td>${entry.key }</td>
    			<td style="margin-left: 35px;">
    				<c:url var="url" value="/Servlet/KickServlet">
    					<c:param name="username" value="${entry.key }"></c:param>
    				</c:url>
    				<a href="${url }">踢除</a>
    			</td>
    		</tr>
    	</c:forEach>
    </table>
  </body>
</html>
