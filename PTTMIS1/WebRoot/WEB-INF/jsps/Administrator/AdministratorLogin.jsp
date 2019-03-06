<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登陆页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/login.css">
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){	
			var bool = 0;
			//设置标签浮动效果
			$("[name='ha_authority']").change(function(){
				var index = $("[name='ha_authority']").get(0).selectedIndex;
				console.log("index:"+index);
				if(index ==1){
					$("[name='account']").parent().parent().css("display","block");
					$("[name='account']").parent().parent().slideDown(1000);
					$("[type='button']").css("display","none");
					$("[value='登陆']").css("width","150px").css("margin-top","20px").css("margin-left","0px");
					$("[value='登陆']").css("border-radius","6px").css("height","25px");
					$("form").prop("action","AdministratorLoginAction.do");
					bool=1;
				}else{
					$("[name='account']").parent().parent().css("display","none");
					$("[type='button']").css("display","block");
					$("[value='登陆']").css("width","").css("margin-top","20px");
					$("[value='登陆']").css("border-radius","6px").css("height","25pxs").css("margin-left","15px");
					$("form").prop("action","");
					bool=0;
				}
			});
			
			$(".login-top-div").click(function(){
				window.location.href="AdministratorLogin.do";
			});
			
			
			$("#username").blur(function(){
				//1.获得input输入框种输入的数值
				var ha_username = $("#username").val();
				console.log("ha_username:"+ha_username);
				console.log("user-bool:"+bool);
				//2.发送 Ajax 异步请求
				if(bool==1){
					$.ajax({
						type:"post",
						url:"AdministratorLoginJudgeByNameAction.do",
						data:"username="+ha_username,
						success:function(result){
							//获得相应内容  result 拿到的是一个Json 字符串
							console.log("result:"+result);
							if(result=="用户名合法"){
								$("#uspan").prop("src","images/delete.png");
							}else{
								$("#uspan").prop("src","images/check.png");
							}
						}
					});
				}else{
					$.ajax({
						type:"post",
						url:"doctor/JudgeDoctorNameAction.do",
						data:"hd_name="+ha_username,
						success:function(result){
							//获得相应内容  result 拿到的是一个Json 字符串
							console.log("doctor-result:"+result);
							if(result=="姓名合法"){
								$("#uspan").prop("src","images/delete.png");
							}else{
								$("#uspan").prop("src","images/check.png");
							}
						}
					});
				}
			
			});
			
			$("[name='account']").blur(function(){
				//1.获得input输入框种输入的数值
				var account = $("[name='account']").val();
				console.log("account:"+account);
				//2.发送 Ajax 异步请求
				$.ajax({
					type:"post",
					url:"doctor/AdministratorLoginJudgeByAccountAction.do",
					data:"account="+account,
					success:function(result){
						//获得相应内容  result 拿到的是一个Json 字符串
						console.log("resultad:"+result);
						if(result=="账户名合法"){
							$("#uimg").prop("src","images/check.png");
						}else{
							$("#uimg").prop("src","images/delete.png");
						}
					}
				});
			});	
			
		
			
		});
	</script>
  </head>
  
  <body background="images/Login.jpg">
    <form method="post" action="doctor/DoctorLoginAction.do">
    	<div class="login-div">
    		<div class="login-top-div">南阳中心医院病人跟踪治疗信息管理系统</div>
    		<table>
	    		<tr id="tr1">
	    			<td>
	    				身份<select class="login-div-inp" name="ha_authority">
	    					<option selected="selected" value="医生">医务人员</option>
	    					<option value="管理员">管理员</option>
	    				</select>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>用户名<input class="login-div-inp" type="text" name="username" id="username"/></td><td style="width: 30px;margin-left: 0px;margin-top: 5px;"><img id="uspan"/></td>
	    		</tr>
	    		<tr style="display: none;">
	    			<td>帐户名<input class="login-div-inp" type="text" name="account"/></td><td style="width: 30px;margin-left: 0px;margin-top: 5px;"><img id="uimg"/></td>
	    		</tr>
	    		<tr>
	    			<td>密码<input class="login-div-inp" type="password" name="password"/></td>
	    		</tr>
	    		<tr class="submit-tr">
	    			<td><input style="color:" class="Login" type="submit" value="登陆" style="margin-right: 40px;margin-left: 23px;"/>
	    			<button class="Login" type="button" onclick="window.location.href='${basePath}doctor/RegisterDoctorAccount.do'">注册</button></td>
	    		</tr>
	    	</table>
    	</div>
    </form>
  </body>
</html>
