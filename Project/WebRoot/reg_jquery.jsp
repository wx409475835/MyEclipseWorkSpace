<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">
	
	<title>jQuery对Ajax的支持</title>
	
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!-- <link rel="stylesheet" type="text/css" href="styles.css">
		 -->
	<style type="text/css">
	 	span{
	 		font-size:16px;
	 		font-family: "arial, helvetica, sans-serif";
	 		color:block;
	 	}
	 </style>
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#name").blur(function(){
				//1.获得输入框中的文本的数值
				var name = $(this).val();
				console.log(name);
				//2.发送ajax异步请求 $.ajax()
				$.ajax({
					type:"post",
					url:"CheckNameAjaxServlet",
					data:"name="+name,
					success:function(result){
						$("#msg").text(result);
					}
				});
			});
		});
	</script>

</head>

<body>
	<form mathod="get" action="CheckNameAjaxServlet">
		<table>
		<tr>
			<td>Username</td>
			<td><input type="text" name="name" id="name" value=""/></td>
			<td><span id="msg"></span></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="name" id="name" value=""/></td>
			<span></span>
		</tr>
		<tr>
			<td>UserEmail</td>
			<td><input type="email" name="name" id="name" value=""/></td>
			<span></span>
		</tr>
		<tr>
			<td>UserBirthday</td>
			<td><input type="text" name="name" id="name" value=""/></td>
			<span></span>
		</tr>
	</table>
	<input type="submit" value="提交"/>
	</form>
</body>
</html>
