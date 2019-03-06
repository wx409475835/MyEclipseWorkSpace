<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>上传页面</title>
  </head>
  
  <body style="text-align: center;">
  	<form action="${pageContext.request.contextPath }/UpfileServlet" method="post" enctype="multipart/form-data">
    <table align="center" border="1" width="40%">
    	<tr>
    		<td>上传用户:</td>
    		<td><input type="text" name="username"/></td>
    	</tr>
    	<tr>
    		<td>上传文件:</td>
    		<td><input type="file" name="file"/></td>
    	</tr>
    	<tr>
    		<td>文件描述</td>
    		<td><textarea cols="70" rows="20"></textarea></td>
    	</tr>
    	<tr>
    		<td align="center" colspan="2">
    			<input type="submit" value="上传"/>
    		</td>
    	</tr>
    </table>
	</form>
  </body>
</html>
