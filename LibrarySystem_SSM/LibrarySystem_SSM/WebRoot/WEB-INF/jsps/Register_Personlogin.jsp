<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>读者登陆注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
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
		
		function var_confirm(){
				var pw1=document.getElementById("pw1").value;
				var pw2=documemt.getElementById("pw2").value;
				if(pw1==pw2){
					document.getElementById("there").innerHTML="<font color='green' size='4'>两次密码相同</font>";
					documemt.getElementById("submit").disabled=false;
					return true;
				}else{
					document.getElementById("there").innerHTML="<font color='red' size='4'>两次密码不相同</font>";
    			//	document.getElementById("there").disabled=true;
    				return false;
				}
			}		
		
		function var_login(){
			alert("恭喜您,注册成功!\n赶快试试登陆吧.");
		}
		
		function validate(){
    		var pw1 = document.getElementById("pw1").value;
    		var pw2 = document.getElementById("pw2").value;
    		if(pw1==pw2){
    			document.getElementById("there").innerHTML="<br/><font color='green' size='4'>&nbsp;两次密码相同</font>";
    			document.getElementById("submit").disabled=false;
    		}
    		else{
    			document.getElementById("there").innerHTML="<br/><font color='red' size='4'>&nbsp;两次密码不相同</font>";
    			document.getElementById("tishi").disabled=true;
    		}
    	}
	</script>
	
	<style type="text/css">
		body{
			margin: 0;
			padding: 0;
			background-color: #f5f5f5;
		}
		span,table{
			text-align: center;
			font-family:  Arial, Helvetica, sans-serif;
		}
		.d1{
			font-family:  Arial, Helvetica, sans-serif;
			color:#3D3D3D;
			font-size: 20px;
		}
		font{
			font-family:  Arial, Helvetica, sans-serif;
		}
		.tr{
			background: #E5E5E5;
		}
	</style>

  </head>
  <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
  <body>
  	<div><center><font color="gold" size="6">Person Login Register</font></center></div>
  	<br/><br/>
    <div align="center">
	    <form action="RegisterAction.do" name="Register_person" method="post">
	    	<table >
		    	<tr><td><font color="red" size="5">用&nbsp;户&nbsp;名:</font></td><td>&nbsp;&nbsp;<input type="text" onblur="return var_user(this)" name="username" placeholder="please input your username" style="width: 190px;height: 40px;background-color: transparent;"/></td></tr>
		    	<tr style="height: 20px;"></tr>
		    	<tr><td><font color="red" size="5">密&nbsp;&nbsp;&nbsp;&nbsp;码:</font></td><td>&nbsp;&nbsp;<input type="password" id="pw1" onblur="return var_pass(this)" size="20" placeholder="please input your password" style="width: 190px;height: 40px;background-color: transparent;'"/></td></tr>
	    		<tr><td><font color="red" size="5">确认密码:</font></td><td>&nbsp;&nbsp;<input type="password" id="pw2" onblur="return var_pass(this)" onkeyup="validate()" name="password" size="20" placeholder="Confirm password " style="width: 190px;height: 40px;background-color: transparent;'"/></td><td><span id="there"></span></td></tr>
	    		<tr><td><font color="red" size="5">身&nbsp;&nbsp;&nbsp;&nbsp;份:</font></td>
	    		<td>
	    			&nbsp;&nbsp;<select name="identified" style="width: 190px;height: 40px;background-color: transparent;">
	    				<option value="u">读者
	    				<option value="a">管理员
	    			</select>
	    		</td></tr>
	    		<tr style="height: 100px;">
	    			<td align="center" colspan="2" >
	    				<input type="submit" value="注 册" style="width: 110px;background-color: transparent;border-radius: 8px;height:40px;color:#38B738" onclick="var_login()"/> &nbsp; &nbsp; &nbsp;
	    				<input type="reset" value="重 置" style="width: 110px;background-color: transparent;border-radius: 8px;height:40px;color:#1818D7" />
	    			</td>
	    		</tr>
	    	</table>
	    </form>

	</div>
  </body>
</html>
