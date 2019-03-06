<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>页头</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body style="text-align: center;">
  	<br/>
   	<h1>Web文件上传与下载</h1>
   	<table align="center">
   		<tr>
   			<td>
   				<a href="${pageContext.request.contextPath }/upload.apex" target="main">上传文件</a>
   			</td>
   			<td>
   				<a href="${pageContext.request.contextPath }/listfileAction.apex" target="main">下载文件</a>
   			</td>
   		</tr>
   	</table>
  </body>
</html>
