<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>读者信息注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script type="text/javascript">
     	function var_null(thisform){
			with(thisform){
				if(value==""||value==null){
					alert("该输入框不能为空!");
					return false;
				}
			}
		}
     
     	function var_age(thisform){
     		with(thisform){
     			var en=document.getElementById("age").value;
	     		if(isNaN(en)){
	     			alert("请输入正确的年龄格式！");
	     		}
     		}
     	}
     	
     	function var_phone(thisform){
     		with(thisform){
     			var aa=document.getElementById("phone").value;
     			if(isNaN(aa)){
     				alert("请输入正确的手机号格式！");
     			}
     		}
     	}
     	
     	function var_Requerd(){
     		var name=document.getElementById("name").value;
     		var age=document.getElementById("age").value;
     		var sex=document.getElementById("sex").value;
     		var wx=document.getElementByI("wx").value;
     		var com=document.getElementById("com").value;
     		var phone=document.getElementById("phone").value;
     		var add=document.getElementById("add").value;
     		if(name==null||age==null||sex==null||wx==null||com==null||phone==null||add==null){
     			alert("请填写必填输入框！");
     		}
     	}
     </script>
	
	<script type="text/javascript" src=""></script>
		<style type="text/css">
		span {
			color: red;
		}

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
		inpput,table{
			font-family: Arial, Helvetica, sans-serif;
			
		}
		.d1{
			font-family:  Arial, Helvetica, sans-serif;
			color:#3D3D3D;
			font-size: 20px;
		}
		input,font{
			font-family:  Arial, Helvetica, sans-serif;
		}
		.tr{
			background: #E5E5E5;
		}
		</style>

  </head>
  <br/><br/><br/><br/><br/><br/><br/><br/>
  <body>
  	 <center><font color="red" size="6">Library Person Register</font></center>
  	 <br/>
  	 <div>
     <form action="http://localhost:8888/LibrarySystem_SSM/RegisterPersonAction.do" method="post" name="Register">
     	<table align="center" style="width: 315px;height: 100px;">
     		<tr>
     			<td><strong><font color="blue" size="5">姓&nbsp;&nbsp;&nbsp;&nbsp;名:</font></strong></td><td><input type="text" id="name" onblur="return var_null(this)" name="person_name" style="width: 210px;height: 35px;" placeholder="请输入姓名"/></td>
     		</tr>
     		<tr>
     			<td><strong><font color="blue" size="5">年&nbsp;&nbsp;&nbsp;&nbsp;龄:</font></strong></td><td><input type="text" id="age" onblur="return var_null(this) & var_age(this)" name="person_age" style="width: 210px;height: 35px;" placeholder="请输入年龄"/></td>
     		</tr>
     		<tr>
     			<td><strong><font color="blue" size="5">性&nbsp;&nbsp;&nbsp;&nbsp;别:</font></strong></td><td><input id="sex" onblur="return var_null(this)" style="width: 30px;height: 20px;" name="person_sex" type="radio" checked="checked" value="男"/><font color="green" size="4"><strong>男</strong></font>
     			&nbsp;&nbsp;&nbsp;&nbsp;<input id="sex" style="width: 20px;height: 20px;" name="person_sex" type="radio" value="女"/><font color="green" size="4"><strong>女</strong></font></td>
     		</tr>
     		<tr>
     			<td><strong><font color="blue" size="5">微&nbsp;&nbsp;&nbsp;&nbsp;信:</font></strong></td><td><input id="wx" onblur="return var_null(this)" style="width: 210px;height: 35px;" name="person_we" type="text" placeholder="请输入微信"/></td>
     		</tr>
     		<tr>
     			<td><strong><font color="blue" size="5">邮&nbsp;&nbsp;&nbsp;&nbsp;箱:</font></strong></td><td><input id="com" onblur="return var_null(this)" style="width: 210px;height: 35px;" name="person_com" type="email" placeholder="请输入邮箱"/></td>
     		</tr>
     		<tr>
     			<td><strong><font color="blue" size="5">手&nbsp;机&nbsp;号:</font></strong></td><td><input id="phone" onblur="return var_null(this) & var_phone(this)" style="width: 210px;height: 35px;" name="person_mobile" type="text" placeholder="请输入手机号"/></td>
     		</tr>
     		<tr>
     			<td><strong><font color="blue" size="5">地&nbsp;&nbsp;&nbsp;&nbsp;址:</font></strong></td><td><input id="add" onblur="return var_null(this)" style="width: 210px;height: 30px;" name="person_add" type="text" placeholder="请输入地址"/></td>
     		</tr>
     		<tr style="height: 120px;">
	     		<td align="center" colspan="2">
	     			<input type="submit" value="提交" style="width: 110px;background-color:transparent; border-radius: 8px;height:40px;color:#38B738;" onclick="var_Requerd()"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	     			<input type="submit" value="返回" style="width:110px;background-color:transparent;border-radius: 8px;height:40px;color:#1818D7;"  formaction="http://localhost:8888/LibrarySystem_SSM/Login.do"/>
	     		</td>
     		</tr>
     	</table>
     	
     </form>
     </div>
  </body>
</html>
