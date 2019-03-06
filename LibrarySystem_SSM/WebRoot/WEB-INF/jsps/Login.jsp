<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>图书管理系统登陆页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		body {
				margin: 0;
				padding: 0;
				background-color: #f5f5f5;
			}
		table { /* max-width: 100%; */
				background-color: transparent;
				border-collapse: collapse;
				border-spacing: 0;
			  }
	</style>
	<script type="text/javascript">
		function var_pass(thisform){
			with(thisform){
				if(value==""||value==null){
					alert("Password 不能为空!");
					return false;
				}
			}
		}
		function var_user(thisform){
			with(thisform){
				if(value==""||value==null){
					alert("Username 不能为空!");
					return false;
				}
			}
		}
	</script>
	<script type="text/javascript" src="js/login.js"></script>
		 <style type="text/css">
			table{
				text-align: center;
			}
			.d1{
				font-family:  Arial, Helvetica, sans-serif;
				color:#A9A9A9;
			}
			a,span,input,font{
				font-family:  Arial, Helvetica, sans-serif;
			}
			.tr{
				background: #E5E5E5;
			}
			a{
				color:#8B7500;
				text-decoration: none;
				cursor:hand;
			}
			a:hover{
				color:#9B30FF;
				text-decoration:underline;
			}
	}
	</style>
  </head>
  <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
  <body>
  	<center>
  		<div>
  		<img alt="图书" src="images/Library.jpg" style="background: none">
  		</div>
  	</center><br/><br/>
  	<div align="center">
	    <form action="LoginAction.do" name="myForm" method="post">
	    	<table>
	    		
	    		<tr><td><font color="red" size="5"><b>身&nbsp;&nbsp;&nbsp;份:</b></font></td>
	    		<td>
	    			<select name="identified" style="width: 190px;height: 40px;background-color: transparent;">
	    				<option value="u">读者
	    				<option value="a">管理员
	    			</select>
	    		</td></tr>
	    		<tr style="height: 20px;"></tr>
		    	<tr><td><font color="red" size="5"><b>用户名:</b></font></td><td><input type="text" id="username" onblur="return var_user(this)" name="username" placeholder="please input username" style="width: 190px;height: 40px;background-color: transparent;"/></td></tr>
		    	<tr style="height: 20px;"></tr>
		    	<tr><td><font color="red" size="5"><b>密&nbsp;&nbsp;&nbsp;码:</b></font></td><td><input type="password" onblur="return var_pass(this)" name="password" size="20" placeholder="please input password" style="width: 190px;height: 40px;background-color: transparent;'"/></td></tr>
	    		<tr style="height: 100px;">
	    			<td align="center" colspan="2" >
	    				<input type="submit" value="登陆" style="width: 110px;background-color: transparent;border-radius: 8px;height:40px;color: #6B8E23"/> &nbsp; &nbsp; &nbsp;
	    				<input type="submit" value="注册" formaction="${basePath}Register.do" style="width: 110px;background-color: transparent;border-radius: 8px;height:40px;color: #6959CD"/>
	    			</td>
	    		</tr>
	    	</table>
	    </form>
	</div>
  </body>
</html>
