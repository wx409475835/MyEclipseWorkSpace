<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>下载界面</title>
    
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
		tr,td{
			font-family: '微软雅黑';
			font-size: 17px;
		}
	</style>
  </head>
  
  <body>
  	<table width="50%" frame="border" border="1" align="center">
  		<tr height="25px">
  			<td>文件名称</td>
  			<td>上传时间</td>
  			<td>上传人</td>
  			<td>操作</td>
  		</tr>
 			<c:forEach var="ls" items="${list }">
  				<tr height="25px">
	  				<td>${ls.filename}</td>
	  				<td>${ls.uptime}</td>
	  				<td>${ls.username}</td>
	  				<td>
	  					<a href="${pageContext.request.contextPath }/DownLoadAction.apex?id=${ls.id}">下载</a>&nbsp;
	  					<a href="${pageContext.request.contextPath }/UpdateAction.apex?id=${ls.id}">修改文件信息</a>&nbsp;
	  					<a href="#">删除文件</a>
	  				</td>
  				</tr>
  			</c:forEach>
  	</table>  
  </body>
</html>
