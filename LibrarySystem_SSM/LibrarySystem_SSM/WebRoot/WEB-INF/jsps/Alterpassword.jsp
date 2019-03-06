<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改用户名或密码</title>
    
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
    	function var_login(){
			alert("Alter username or password success!.");
		}
	</script>
	<style type="text/css">
		font{
			font-family:  Arial, Helvetica, sans-serif;
		}
	</style>
  </head>
  
  <body>
    <center>
    <br/><br/><br/><br/><br/>
	    <c:if test="${ sessionScope.Login!=null}">
	    	<form action="AlterPasswordAction.do"  method="post">
		    	<table >
			    	<tr><td><font color="blue" size="5"><b>用&nbsp;户&nbsp;名:</b></font></td><td><input type="text" onblur="return var_user(this)" name="username" value="${sessionScope.Login}" style="font-size:20px;width: 190px;height: 40px;background-color: transparent;"/></td></tr>
			    	<tr style="height: 20px;"></tr>
			    	<tr><td><font color="blue" size="5"><b>&nbsp;密&nbsp;&nbsp;&nbsp;码:</b></font></td><td><input type="password" id="pw1" onblur="return var_pass(this)" size="20" placeholder="请输入密码" style="font-size:20px;width: 190px;height: 40px;background-color: transparent;'"/></td></tr>
		    		<tr><td><font color="blue" size="5"><b>确认密码:</b></font></td><td><input type="password" id="pw2" onblur="return var_pass(this)" onkeyup="validate()" name="password" size="20" placeholder="确认密码" style="font-size:20px;width: 190px;height: 40px;background-color: transparent;'"/></td><td><span id="there"></span></td></tr>
		    		<tr style="height: 100px;">
		    			<td align="center" colspan="2" >
		    				<input type="submit" value="提交" onclick="var_login()" style="width: 110px;background-color: transparent;border-radius: 8px;height:40px;color:#9ACD32"/> &nbsp; &nbsp; &nbsp;
		    				<input type="submit" value="返回" formaction="QY.do" style="width: 110px;background-color: transparent;border-radius: 8px;height:40px;color:#1818D7"/>
		    			</td> 
		    		</tr>
		    	</table>
		    </form>
	    </c:if>
	    <c:if test="${sessionScope.Login ==null}">
	    	<jsp:forward page="Login.do"></jsp:forward>
	    </c:if>
    </center>
  </body>
</html>
