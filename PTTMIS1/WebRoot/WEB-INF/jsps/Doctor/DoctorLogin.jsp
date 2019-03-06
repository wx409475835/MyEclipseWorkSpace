	<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户登陆页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){	
			$("#username").blur(function(){
				//1.获得input输入框种输入的数值
				var ha_username = $("#username").val();
				console.log("ha_username:"+ha_username);
				//2.发送 Ajax 异步请求
				$.ajax({
					type:"post",
					url:"AdministratorLoginJudgeByNameAction.do",
					data:"username="+ha_username,
					success:function(result){
						//获得相应内容  result 拿到的是一个Json 字符串
						console.log("result:"+result);
						$("#uspan").text(result);
					}
				});
			});
			
			//设置标签浮动效果
			$("[name='ha_authority']").change(function(){
				var index = $("[name='ha_authority']").get(0).selectedIndex;
				console.log("index:"+index);
				if(index ==1){
					$("[name='account']").parent().parent().css("display","inline");
					$("[name='account']").parent().parent().slideDown(1000);
					$("[type='button']").css("display","none");
					$("[value='提交']").css("width","180px");
					$("[value='提交']").css("border-radius","5px").css("height","25px");
					$("form").prop("action","AdministratorLoginAction.do");
				}else{
					$("[name='account']").parent().parent().css("display","none");
					$("[type='button']").css("display","inline");
					$("[value='提交']").css("width","");
					$("[value='提交']").css("border-radius","0px").css("height","");
					$("form").prop("action","");
				}
			});
		});
	</script>
  </head>
  
  <body>
    <form method="post" action="doctor/DoctorLoginAction.do">
    	<table>
    		<tr>
    			<td>
    				身&nbsp;&nbsp;份:<select name="ha_authority">
    					<option selected="selected" value="医生">医生</option>
    					<option value="管理员">管理员</option>
    				</select>
    			</td>
    		</tr>
    		<tr>
    			<td>用户名:<input type="text" name="username" id="username"/>
    			&nbsp;<span id="uspan"></span></td>
    		</tr>
    		<tr style="display: none;">
    			<td>帐户名:<input type="text" name="account"/></td>
    		</tr>
    		<tr>
    			<td>密&nbsp;&nbsp;码:<input type="password" name="password"/></td>
    		</tr>
    		<tr height="60px;">
    			<td><input type="submit" value="提交" style="margin-right: 40px;margin-left: 23px;"/>
    			<button type="button">注册</button></td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
