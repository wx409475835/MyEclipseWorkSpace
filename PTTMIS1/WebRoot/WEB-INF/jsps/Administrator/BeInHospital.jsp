<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>办理住院手续</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
      <div>
      	<input placeholder="请输入病人ID" type="text"/>
      	<button type="button" >查询</button>
      </div>
      <hr>
      <div>
      	<form>
      		<table>
		    	<tr>
	    			<td>病人ID:<input type="text"/></td>
	    		</tr>
	    		<tr>
	    			<td>主治医生ID:<input type="text"/></td>
	    		</tr>
	    		<tr>
	    			<td>挂号:<input type="text"/></td>
	    		</tr>
	    		<tr>
	    			<td>房间号:<input type="text"/></td>
	    		</tr>
	    		<tr>
	    			<td><input type="submit" value="办理"/></td>
	    		</tr>
	    		<!-- <tr>
	    			<td><input type="text"/></td>
	    		</tr>
		    	<tr></tr>
		    	<tr></tr>
		    	<tr></tr>
		    	<tr></tr> -->
		    </table>
      	</form>
      </div>
  </body>
</html>
