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
	
	<title>使用XMLHttpRequest发起Ajax异步请求</title>
	
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
				//2.发送异步请求
				var xhr;
				if(window.XMLHttpRequest){
					xhr = new XMLHttpRequest();							//创建一个 XMLHTTPRequest 对象  用来发送异步请求
				}else{
					xhr = new AciveXObject("Microsoft.XMLHTTP");
				}
				//post请求的处理方式
				xhr.open("post","CheckNameAjaxServlet?name="+name);
				xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
				xhr.send("name="+name);
				//get 请求的处理方式
				/* 						
				xhr.open("get","CheckNameAjaxServlet?name="+name);		//打开一个新的链接
				xhr.send(null);												//将请求发送到服务器端
				 */
				//监听  创建对象的XMLHTTPRequest 对象
				xhr.onreadystatechange = function(){
					if(xhr.readyState == 4 && xhr.status == 200){
						console.log(xhr.responseText);
						console.log($("#msg"));
						$("#msg").text(xhr.responseText);
					}
				};
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
