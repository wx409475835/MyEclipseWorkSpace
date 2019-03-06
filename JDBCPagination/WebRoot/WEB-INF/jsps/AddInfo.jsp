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
    
    <title>所有信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		table{
			font-family: serif;
			text-align: center;
		}
		
		table tr,td{
			width: 80px;
			font-family: 微软雅黑;
			height: 30px;
		}
		
		th{
			width: 40px;
			height: 30px;
		}
		
		.div1{
			margin-top:30px;
			/* border: solid red 1px;	 */
		}
		
		a{
			color: gray;
			text-decoration:none; 
		}
		
		a:HOVER{
			color: red;
			text-decoration: underline;
		}
	</style>
  </head>
  
  <body>
  	<h1 style="position:relative; color:blue; margin-top: 30px;" align="center">数据库分页技术的实现</h1>
    <div class="div1">
    	<form action="AddInfoAction.apex" method="post">
    		<table  align="center" border="1" bordercolor="1px"  cellpadding="0" cellspacing="0">
	   <!-- tr class="tr"><th>ID</th><td><input style="height: 30px" height="30px" type="text"/></td></tr> -->
	    		<tr><th>姓名</th><td><input style="height: 30px" height="30px" name="name" type="text"/></td></tr>
	    		<tr><td colspan="2"><input type="submit" value="提交"/></td></tr>
	    	</table>
    	</form>
    </div>
  </body>
</html>
