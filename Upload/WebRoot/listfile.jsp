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
    
    <title>显示所有下载文件</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		a{
			color:blue;
			text-decoration: none;
		}
		a:HOVER {
			color:red;
			text-decoration: underline;
		}
		table{
			margin-left: 60px;
		}
	</style>
  </head>
  
  <body>
  	下载的文件有:<br/>
	<table>
		<tbody>
			<c:forEach items="${map }" var="entry">
				<tr><td>
					<!-- 有一个问题,如果文件名为中文了怎么办？  通过url地址栏传递参数不能为中文。所以我们需要件中文编码在通过地址发送给后台 -->
					<c:url var="url" value="/downloadservlet">
						<!-- 用来附带参数 -->
						<c:param name="filename" value="${entry.key }"/>
					</c:url> 
					<a href="${url }">${entry.value }</a>
				</td></tr>
			</c:forEach>
		</tbody>
	</table>
  </body>
</html>
