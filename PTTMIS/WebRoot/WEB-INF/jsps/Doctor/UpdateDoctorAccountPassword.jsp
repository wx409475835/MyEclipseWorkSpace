<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改登陆信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="icon" href="images/htmllogo.png">
	<link rel="stylesheet" type="text/css" href="css/cols-table.css">
 	<link rel="stylesheet" type="text/css" href="css/right_Index.css"> 
 	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
 	<script type="text/javascript" src="js/Doctor_home_refresh.js"></script>
 	<style type="text/css">
 		#password{
 			clear:both;
 			position:relative;
 			float:right;
 			margin-left:6px;
 			height: 40px;
 		}
 	</style>
 	<script type="text/javascript">
 		var boolean;
 		$(function(){
 			$("[name='confirmpassword']").mouseout(function(){
 				var password = $("[name='password']").val();
	 	        var confirmpassword = $("[name='confirmpassword']").val();
	 	        console.log("password:"+password);
	 	        console.log("Confirmpassword:"+confirmpassword);
	 	        if(password==confirmpassword){
	 	        	$("#password").prop("src","images/check.png");
	 	        	boolean=true;
	 	        }else{
	 	        	$("#password").prop("src","images/delete.png");
	 	        	boolean=false;
	 	        }
 			});
 			
 			$("[type='submit']").click(function(){
 				var password = $("[name='password']").val();
	 	        var confirmpassword = $("[name='confirmpassword']").val();
	 	        if((password==null||password=='')&&(confirmpassword==null||confirmpassword=='')){
	 	        	alert("请输入您想要修改的密码和确认密码!");
	 	        	boolean=false;
	 	        }
 			});
 			
 		});
 		function Check(){
 			if(boolean==false){
 				alert("两次密码输入不一致!");
 			}
 			return boolean;
 		}
 	</script>
 </head>
  
  <body>
  	<div class="addcount-div1">
  		<p>修改用户登陆信息/Update Doctor Account Informations</p>
  		<div class="Right_Index">
		  	<div id="div5"><img src="images/home.png" alt="homeLogo"/></div>
		  	<div id="div6"><img src="images/sign_out.png" alt="sign_out"/></div>
		  	<div id="div7"><img src="images/sign_in.png" alt="sign_in"/></div>
		  	<div id="div8"><img src="images/refresh.png" alt="refresh"/></div>
		</div>
  	</div>
     <div class="addcount-div2">
	    <form action="doctor/UpdateDoctorAccountPasswordAction.do" method="post" onsubmit="return Check()">
	    	<table>
	    		<tr><td>&nbsp;用&nbsp;户&nbsp;名&nbsp;<input class="addconut-input" type="text" value="${hl_username}" name="username"/></td></tr>
	    		<tr><td>&nbsp;&nbsp;密&nbsp;&nbsp;&nbsp;码&nbsp;&nbsp;<input class="addconut-input" name="password" type="password"/></td></tr>
	    		<tr><td>确认密码<input class="addconut-input" type="password" name="confirmpassword"/><img id="password"/></td></tr>
	    		<tr><td><input onclick="return Check()" class="submit" type="submit" value="确认修改"/></td></tr>
	    	</table>
	    </form>
	  </div>
  </body>
</html>
