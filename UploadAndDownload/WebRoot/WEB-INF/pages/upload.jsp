<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>上传文件</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		tr,td{
			font-family: '微软雅黑';
			font-size: 17px;
		}
	</style>
  </head>
  
  <body>
    <form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath }/UploadAction.apex">
    	<table frame="border" border="1" align="center">
    		<tr>
    			<td>上传用户:</td>
    			<td>
    			  <input name="username" type="text"/>
    			</td>
    		</tr>
    		<tr>
    			<td>上传文件:</td>
    			<td><input type="file" name="file"/></td>
    		</tr>
    		<tr>
    			<td>描述</td>
    			<td><textarea name="description" cols="60" rows="20"></textarea></td>
    		</tr>
    		<tr style="text-align: center;">
    			<td colspan="2">
    				<input type="submit" value="上传"/>
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
